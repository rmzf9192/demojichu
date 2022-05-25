package com.el.jichu.algorithm.prim;

import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/8/1 9:05
 * @Version:V1.0
 * @Description:PrimAlgorithm
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph, 1);//
    }
}

/**
 * create min tree
 */
class MinTree{

    /**
     * 创建图的邻接矩阵
     * @param mGraph 图对象
     * @param verxs 图对应的节点数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph mGraph,int verxs,char[] data,int[][] weight){
        int i,j;
        for (i = 0; i < verxs; i++) {
            mGraph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }

        }
    }

    /**
     * 显示图的邻接矩阵
     */
    public void showGraph(MGraph graph){
        for (int[] link :
                graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 编写prim算法，生成最小树
     * @param graph 图对象
     * @param v 表示从图的第几个顶点开始“A->0,B->1”
     */
    public void prim(MGraph graph,int v){
        //记录节点是否被访问过
        int[] visited = new int[graph.verxs];

        //把当前顶点设置为访问过
        visited[v] = 1;

        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将minWeight设置为较大值，在后面遍历时，会被替换
        int minWeight = 10000;

        //根据普利姆算法知，根据verxs得到graph.verxs - 1条边
        for (int k = 1; k < graph.verxs; k++) {

            //确定每生成一个子图，和那个节点的距离最小
            for (int i = 0; i < graph.verxs; i++) {//i节点表示被访问过的节点

                for (int j = 0; j < graph.verxs; j++) {//j节点表示未访问过的节点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        //替换minWeight(寻找已经访问的节点与未被访问的节点的权值的最小边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到最小的一个边
            System.out.println("边<"+ graph.data[h1]+","+graph.data[h2]+"> 权值："+minWeight);
            //标记当前节点已经被访问过
            visited[h2] = 1;
            //将minWeight 恢复原值
            minWeight = 10000;
        }
    }
}

class MGraph{
    //表示图的节点个数
    int verxs;
    //存放节点数据
    char[] data;
    //存放边，即邻接矩阵
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
