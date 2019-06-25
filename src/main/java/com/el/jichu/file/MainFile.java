package com.el.jichu.file;

import com.el.jichu.domain.FileInfo;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class MainFile {
    private static final String WRITE_FILE = "F:\\file\\bigdata.txt";

    //拆分文件的大小
    private static final Integer SPLIT_SIZE = 50000;

    //拆分文件后放到的位置
    private static final String SPLIT_LOCATION = "F:\\split";

    //拆分后文件的前缀
    private static final String PREFIX = "big_data";

    //拆分后文件的后缀
    private static final String SUPFIX = ".txt";
    //分割后文件的计数器
    private static int fileNum = 0;
    //最终存放文件的位置
    private static final String OUT_FILE = "F:\\result.txt";

    public static void main(String[] args) throws Exception {
        //writeFile();
        //拆分文件
        MainFile mainFile = new MainFile();
        //mainFile.splitFile("F:\\file\\bigdata.txt");
        //合并文件
        mainFile.mergeFile();
    }

    //向一个文档里写入数据
    public static void writeFile() throws Exception {
        //判断文件是否存在
        File file = new File(WRITE_FILE);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file, true);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < 5000000; i++) {
            bufferedWriter.write(i + "");
            bufferedWriter.newLine();

        }
        bufferedWriter.flush();
        fileWriter.flush();
        fileWriter.close();
    }

    //拆分文件
    public void splitFile(String fname) throws IOException {
        //暂时存储每一行数据
        String data;
        //读数据的计数器
        int count = 0;


        //使用set集合暂时待拆分的数据
        // SortedSet<Integer> set = new TreeSet<>();
        List<Integer> set = new ArrayList<>();
        //读入待拆分的数据
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fname))) {
            do {
                data = bufferedReader.readLine();
                if (data != null) {
                    set.add(Integer.valueOf(data));
                    count++;
                    if (count >= SPLIT_SIZE) {
                        System.out.println("文件分割++》");
                        writeFileData(SPLIT_LOCATION, set);
                        set.clear();
                        count = 0;
                    }
                } else if (!set.isEmpty()) {
                    writeFileData(SPLIT_LOCATION, set);
                    set.clear();
                    count = 0;
                }
            }

            while (data != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeFileData(String splitLocation, List<Integer> set) throws IOException {
        //先判断拆分后的文件夹是否存在，不存在的话，创建
        File file = new File(splitLocation);
        if (!file.exists()) {
            file.mkdirs();
        }
        fileNum++;
        //拼接生成文件的名字
        String fileName = splitLocation + System.getProperty("file.separator") + PREFIX + fileNum + SUPFIX;


        Iterator<Integer> iterator = set.iterator();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            while (iterator.hasNext()) {
                bufferedWriter.write(iterator.next() + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //合并文件
    public void mergeFile() throws IOException {
        //获取当前文件夹目录下的所有文件
        File[] files = new File(SPLIT_LOCATION).listFiles();
        List<FileInfo> list = new ArrayList<>();
        //初始化FileInfo的list信息（初始化出牌人信息）
        for (File file : files) {
            //初始化指针
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //初始化每个出牌人的信息
            FileInfo fileInfo = new FileInfo();
            fileInfo.setBufferedReader(bufferedReader);
            fileInfo.setFileName(file.getName());
            fileInfo.setCurrentNum(Integer.valueOf(bufferedReader.readLine()));
            list.add(fileInfo);
        }
        //开始出牌，
        Collections.sort(list);

        //归并到文件中
        BufferedWriter br = new BufferedWriter(new FileWriter(OUT_FILE));
        while (!list.isEmpty()) {
            //对第一组序列进行排序
            FileInfo fileInfo = list.get(0);

            System.out.println("=====>" + fileInfo.getFileName() + "->" + fileInfo.getCurrentNum());

            //把该轮最小的结果写到结果文件中
            br.write(fileInfo.getCurrentNum() + "\r\n");

            //读取下一个数据
            fileInfo.readNext();
            //在排序
            Collections.sort(list);

            //如果读取文件完毕，则退出
            if (fileInfo.getCurrentNum() == -1) {
                list.remove(fileInfo);
            }

        }
    }

}
