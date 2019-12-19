package com.el.jichu.datastructures.recursion;

/**
 * @author Roman.zhang
 * @Date: 2019/7/15 15:37
 * @Version:V1.0
 * @Description:MiGong
 */
public class MiGong {
    public static void main(String[] args) {

        //使用二维数组创建地图
        int[][] map = new int[8][7];

        //上下至为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右至为1
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("输出地图情况");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯
        setWay(map,1,1);

        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
    private static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){ //代表没有走过
                //按照策略先下-》右-》上-》左
                //假设该点可以走通
                map[i][j] = 2;

                if(setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)) {
                    return true;
                }else if(setWay(map,i -1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }

    public static boolean setWay2(int[][] map, int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] ==0){
                map[i][j]=2;
                if(setWay2(map,i-1,j)){
                    return true;
                }else if(setWay2(map,i,j+1)){
                    return true;
                }else if(setWay2(map,i+1,j)){
                    return true;
                }else if(setWay2(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
