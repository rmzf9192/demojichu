package com.el.jichu.datastructures.huffmancode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Roman.zhang
 * @Date: 2019/7/26 9:42
 * @Version:V1.0
 * @Description:HuffManCode
 */
public class HuffManCode {
    public static void main(String[] args) {
       /* String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40

        byte[] huffmanCodesBytes= huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes) + " 长度= " + huffmanCodesBytes.length);

        //测试一把byteToBitString方法
        System.out.println(byteToBitString(true,(byte)1));
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);

        System.out.println("原来的字符串=" + new String(sourceBytes)); // "i like like like java do you like a java"*/

       //测试压缩文件
        String srcFile = "F:\\study\\1.txt";
        String disFile = "F:\\study\\11.txt";
        zipFile(srcFile,disFile);
       /* String ditFile = "F:\\study\\3.txt";
        unZipFile(disFile,ditFile);*/
    }

    /**
     * 解压缩文件
     * @param zipFile
     * @param dstFile
     */
    private static void unZipFile(String zipFile,String dstFile){
        try(
                FileInputStream fis = new FileInputStream(zipFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                FileOutputStream fos = new FileOutputStream(dstFile);
                ){
            //读取byte数组
           byte[] bytes = (byte[]) ois.readObject();
           //读取赫夫曼编码
            Map<Byte,String> huffmanBytes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] decode = decode(huffmanBytes, bytes);
            fos.write(decode);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
//编写方法，将一个文件进行压缩
    /**
     *
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */
    public static void zipFile1(String srcFile, String dstFile) {

        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件的输入流
        FileInputStream is = null;
        try {
            //创建文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流, 存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把 赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes); //我们是把
            //这里我们以对象流的方式写入 赫夫曼编码，是为了以后我们恢复源文件时使用
            //注意一定要把赫夫曼编码 写入压缩文件
            oos.writeObject(huffmanCodes);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * 将一个文件进行压缩
     * @param srcFile 源文件
     * @param dstFile 新文件
     */
    private static void zipFile(String srcFile,String dstFile){

        try(
        //创建文件输入流
        FileInputStream fis = new FileInputStream(srcFile);
        //创建文件输出流
        FileOutputStream fos = new FileOutputStream(dstFile);
        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            byte [] b =new byte[fis.available()];
            //读取文件
            fis.read(b);

            //直接对源文件压缩
            byte[] huffManNode = huffmanZip(b);
            //把赫夫曼压缩后的文件写到新的文件中
            oos.writeObject(huffManNode);
            //将赫夫曼编码写到文件中。
            oos.writeObject(huffmanCodes);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static byte[] decode(Map<Byte,String> huffmanCode,byte[] huffmanBytes){
        //先得到赫夫曼对应的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转为二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是否是最后字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag,b));
        }

        //将字符串按照赫夫曼编码进行解码
        //把赫夫曼编码反向保存
        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry : huffmanCode.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }


        //创建list数组，存储解码后的字符串
        List<Byte> list = new ArrayList<>();

        //遍历二进制字符串
        for (int i = 0; i < stringBuilder.length(); ) {
            int count =1;
            boolean flag = true;
            Byte b =null;
            while(flag){
                //递增遍历每个key,i不动，count增加
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if(null == b){
                    //没有匹配到，需要增加
                    count++;
                }else{
                    //匹配到了
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }

        //list中存放着所有解码后的元素
        //把list元素放到byte数组中返回
        byte[] bytes = new byte[list.size()];

        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * 将一个byte 转成一个二进制的字符串, 如果看不懂，可以参考我讲的Java基础 二进制的原码，反码，补码
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b; //将 b 转成 int
        //如果是正数我们还存在补高位
        if(flag) {
            temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if(flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 根据byte数组，返回压缩后的赫夫曼编码
     * @param nodes 原始数组
     * @return 压缩后的赫夫曼编码
     */
    private static byte[] huffmanZip(byte[] nodes){
        List<Node> nodeList = getNodes(nodes);
        //根据nodeList创建赫夫曼树
        Node node = createHuffmanTree(nodeList);

        //根据赫夫曼树，生成对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(node);

        //根据赫夫曼编码及原始数据，生成对应的赫夫曼编码
        byte[] huffmanCodeBytes = zip(nodes, huffmanCodes);
        return huffmanCodeBytes;
    }
    /**
     * 将字符串对应的Byte数组，通过赫夫曼编码，压缩生成压缩后的编码
     * @param bytes 原始字符串对应的Byte数组
     * @param huffmanCode 赫夫曼编码
     * @return 压缩后的byte[]
     * 举例： String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返回的是 字符串 "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes  ，即 8位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] =  10101000(补码) => byte  [推导  10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCode){
        //利用赫夫曼编码，将bytes转为对应的编码；
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b:bytes){
            stringBuilder.append(huffmanCode.get(b));
        }
        System.out.println("将byte转为赫夫曼对应的编码："+stringBuilder);


        //计算转为赫夫曼编码的长度。
        int len;
        if(stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }

        //创建存储压缩后的赫夫曼编码
        byte[] huffmanCodeBytes = new byte[len];
        //数组下标
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte;
            //不够8位
            if(i+8>stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i,i+8);
            }
            //将strBytes，转为byte 存到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    //   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 为了调用方便，重载getCodes方法
     * @param root 根节点
     * @return 返回赫夫曼编码
     */
    private static Map<Byte,String> getCodes(Node root){
        if(null == root){
            return null;
        }
        //处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        //处理root的右子树
        getCodes(root.right,"1",stringBuilder);

        return huffmanCodes;
    }
    /**
     * 将传入的节点node的所有叶子节点的赫夫曼编码得到，并保存到stringBuilder
     * @param node 传入的几点
     * @param code 路径，左子节点：0，右子节点：1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder1
        stringBuilder1.append(code);
        if(null != node){
            //非叶子节点
            if(null == node.data){
                //递归处理
                //左递归
                getCodes(node.left,"0",stringBuilder1);
                //右递归
                getCodes(node.right,"1",stringBuilder1);
            }else{
                //叶子节点
                huffmanCodes.put(node.data,stringBuilder1.toString());
            }
        }
    }

    /**
     * 前序遍历
     */
    private static void preOrder(Node root){
        if(null != root){
            root.preOrder();
        }else{
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     *
     * @param bytes 接收字节数组
     * @return 返回List集合[[data=97,weight= 2],[data= 98,weight = 3]]
     */
    private static  List<Node> getNodes(byte[] bytes){
        //创建list集合
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历bytes ,记录每个字符出现的次数
        //创建map ，记录每个字符出现的次数
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        for(byte b:bytes){
            Integer count = map.get(b);
            if(null == count){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }

        //List<Map.Entry<Byte, Integer>> collect = map.entrySet().stream().collect(Collectors.toList());
        //遍历map集合，将值存到nodes集合中
        for(Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while(nodes.size() > 1){
            //排序，从小到大
            Collections.sort(nodes);

            //分别取出最小的两颗树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //创建根节点
            Node parent = new Node(null, left.weight + right.weight);

            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }

        //node的最后节点，就是赫夫曼树的根节点
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    //存放数据
    Byte data;
    //权值
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(null != this.left){
            this.left.preOrder();
        }
        if(null != this.right){
            this.right.preOrder();
        }
    }
}
