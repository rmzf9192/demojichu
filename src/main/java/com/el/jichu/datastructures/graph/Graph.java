package com.el.jichu.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Roman.zhang
 * @Date: 2019/7/30 14:02
 * @Version:V1.0
 * @Description:Graph
 */
public class Graph {
    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的邻边矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;
    // 定义数组，记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {

        //测试一把图是否创建ok
        int n = 8;  //结点的个数
        //String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
//		graph.insertEdge(0, 1, 1); // A-B
//		graph.insertEdge(0, 2, 1); //
//		graph.insertEdge(1, 2, 1); //
//		graph.insertEdge(1, 3, 1); //
//		graph.insertEdge(1, 4, 1); //

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);



        //显示一把邻结矩阵
        graph.showGraph();

        //测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
//		System.out.println();
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]

    }

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    /**
     * 获得第一个节点对应的下标
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标，获取下一个邻接节点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 +1; i < vertexList.size(); i++) {
            if(edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i){
        //首先输出该节点
        System.out.print(getValueByIndex(i)+"->");
        //将该节点设置为已访问
        isVisited[i] = true;
        //获取i的节点的下一个邻接节点
        int firstNeighbor = getFirstNeighbor(i);
        while(-1!=firstNeighbor){
            if(!isVisited[firstNeighbor]){
                dfs(isVisited,firstNeighbor);
            }
            //节点已经被访问过
            firstNeighbor = getNextNeighbor(i,firstNeighbor);
        }
    }

    /**
     * 对dfs重载，遍历所有节点
     */
    public void dfs(){
        isVisited = new boolean[vertexList.size()];

        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 对节点进行广度优先遍历
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited,int i){
        //队列的头节点对应的下标
        Integer u;
        //邻接节点
        Integer w;
        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList<>();
        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记已访问
        isVisited[i] = true;
        //将节点加入到队列中
        queue.addLast(i);

        while(!queue.isEmpty()){
            //取出队列的头节点的下标
           u= (int) queue.removeFirst();
           //得到邻接节点
            w = getFirstNeighbor(u);
            while(-1 != w){
                if(!isVisited[w]){
                    //未被访问过
                    System.out.print(getValueByIndex(w)+"=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻结点
                //体现出我们的广度优先
                w= getNextNeighbor(u,w);
            }
        }
    }
    /**
     * 重载，遍历所有节点
     */
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
    /**
     * 返回节点个数
     * @return
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }
    /**
     * 显示图对应的矩阵
     */
    public void showGraph(){
        for(int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 得到边的数目
     * @return
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回节点对应的下标
     * @param i
     * @return
     */
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1与v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    /**
     * 插入节点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 点的下标，即第几个节点
     * @param v2 第二个节点
     * @param weight 表示
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}

