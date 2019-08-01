package com.el.jichu.algorithm.kruskal;

import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/8/1 10:19
 * @Version:V1.0
 * @Description:KruskalCase
 */
public class KruskalCase {
    //边的个数
    private int edgeNum;
    //顶点数组
    private char[]  vertexs;
    //邻接矩阵
    private  int[][] matrix;
    //使用INF表示两个顶点不能联通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.

        //创建KruskalCase 对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        //输出构建的
        kruskalCase.print();
        kruskalCase.kruskal();
    }

    //构造器
    public KruskalCase(char[] vertexs , int[][] matrix){
        int vlen = vertexs.length;

        //初始化顶点及边的个数
        //初始化顶点
        this.vertexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化边
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边的数
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 克鲁斯卡尔算法实现
     */
    public void kruskal(){
        //表示最后结果数组的索引
        int index = 0;
        //用于保存“已有最小生成树”中的每个顶点在最小生成树中的终点
        int[] ends =new int[edgeNum];
        //创建结果数组，保存最后的最小结果树
        EData[] rets = new EData[edgeNum];

        //获取图中所有边的集合
        EData[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共"+ edges.length); //12

        //按照边的权值大小进行排序
        sortEdges(edges);

        //遍历edges数组，将边添加到最小生成树中时，判断是准备加入的边是否形成回路，没有就加入到rets，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取到第i条边的第二个顶点
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有最小生成树的终点
            int m = getEnd(ends,p1);
            //获取p2这个顶点在已有最小生成树的终点
            int n = getEnd(ends,p2);

            //是否构成回路
            if(m!= n){
                //没有构成回路
                // 设置m 在"已有最小生成树"中的终点 <E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                ends[m] = n ;
                //有一条边加入到rets数组
                rets[index++] = edges[i];
            }
        }
        //<E,F> <C,D> <D,E> <B,F> <E,G> <A,B>。
        //统计并打印 "最小生成树", 输出  rets
        System.out.println("最下生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }


    //打印邻接矩阵
    public void print(){
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            //换行
            System.out.println();
        }
    }

    /**
     * 对边进行排序处理：冒泡排序
     * @param edges 边的集合
     */
    public void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1-i; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 获取顶点对应的下标
     * @param ch
     */
    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(ch == vertexs[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图的边，放到EData[] 数组中
     * 通过邻接矩阵获取
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j] !=INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 判断下标为i的顶点的终点，用于判断两个顶点的终点相同
     *
     * @param ends 数组就是记录了各个顶点对应的终点是哪个,ends 数组是在遍历过程中，逐步形成
     * @param i 表示传入的顶点对应的下标
     * @return 返回下标为i的顶点的终点的下标
     */
    public int getEnd(int[] ends, int i){
        while(ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

}

/**
 * 定义一个边的类
 */
class EData{
    //开始
    char start;
    //结束
    char end;
    //权值
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

