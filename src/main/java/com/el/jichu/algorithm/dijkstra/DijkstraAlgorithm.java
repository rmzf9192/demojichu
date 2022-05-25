package com.el.jichu.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/8/1 11:34
 * @Version:V1.0
 * @Description:DijkstraAlgorithm
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
        //测试迪杰斯特拉算法
        graph.dsj(2);//C
        graph.showDijkstra();
    }
}

class Graph{
    //顶点数组
    private char[] vertexs;
    //邻接矩阵
    private int[][] matrix;
    //已经访问过的顶点集合
    private VisitedVertex vv;

    public Graph(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
    }

    /**
     * 显示结果
     */
    public void showDijkstra(){
        vv.show();
    }

    /**
     * 显示图
     */
    public void showGraph(){
        for (int[] link :
                matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 迪杰斯特拉算法实现
     * @param index
     */
    public void dsj(int index){
        vv = new VisitedVertex(vertexs.length,index);
        //更新index顶点到周围顶点的距离和前驱顶点
        update(index);
        for (int i = 1; i < vertexs.length; i++) {
            //选择并返回新的访问顶点
            index = vv.updateArr();
            //更新index顶点到周围顶点的距离和前驱顶点
            update(index);
        }
    }

    /**
     * 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
     * @param index
     */
    private void update(int index){
        int len = 0;
        //根据遍历我们的邻接矩阵的matrix[index]行
        for (int i = 0; i < matrix[index].length; i++) {
            //出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][i];
            if(!vv.in(i) && len < vv.getDis(i)){
                //更新i顶点的前驱为index顶点
                vv.updatePre(i,index);
                //更新出发顶点到j顶点的距离
                vv.updateDis(i,len);
            }
        }
    }
}

/**
 * 已访问顶点
 */
class VisitedVertex{
    //记录各个顶点是否被访问过，1：访问过，0：未访问过，会动态更新
    private int[] already_arr;
    //每个顶点的前一个顶点下标，会动态更新
    private int[] pre_visited;
    //记录出发顶点到各个顶点的距离，比如G为出发顶点，就会记录G到其它顶点的距离，会动态更新，求的最短距离就会存放到dis
    private int[] dis;

    /**
     * 构造器
     * @param length 顶点个数
     * @param index 顶点下标
     */
    public VisitedVertex(int length,int index){
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        //初始化数组
        Arrays.fill(dis,65535);
        //设置出发点被访问过
        this.already_arr[index] = 1;
        this.dis[index] = 0;
    }


    /**
     * 判读是否被访问过
     * @param index
     * @return true:visited,false no visited
     */
    public boolean in (int index){
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点距离
     * @param index
     * @param length
     */
    public void updateDis(int index,int length){
        dis[index] = length;
    }

    /**
     * 更新pre这个顶点的前驱顶点为index顶点
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param index
     * @return
     */
    public int getDis(int index){
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点， 比如这里的G 完后，就是 A点作为新的访问顶点(注意不是出发顶点)s
     * @return
     */
    public int updateArr(){
        int min = 65535,index =0 ;
        for (int i = 0; i < already_arr.length; i++) {
            if(already_arr[i] == 0 && dis[i] <min){
                min = dis[i];
                index = i;
            }
        }
        //更新index顶点被访问过
        already_arr[index]= 1;
        return index;
    }

    /**
     * 显示最后结果
     * 即将三个数组的情况输出
     */
    public void show(){
        System.out.println("=======");
        for (int i :
                already_arr) {
            System.out.print(i+" ");
        }

        System.out.println();
        for (int i:pre_visited
             ) {
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i :dis){
            System.out.print(i+ " ");
        }
        System.out.println();

        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

        int count = 0;

        for (int i :
                dis) {
            if (i != 65535) {
                System.out.print(vertex[count] +"("+i+")");
            }else{
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();
    }
}
