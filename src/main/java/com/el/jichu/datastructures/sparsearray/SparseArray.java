package com.el.jichu.datastructures.sparsearray;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 17:42
 * @Version:V1.0
 * @Description:SparseArray
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建原始数据
        int chessArr[][] = new int[11][10];

        chessArr[1][2]=1;
        chessArr[2][3]=2;
        chessArr[4][5]=2;

       /* for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                System.out.printf("%d\t",chessArr[i][j]);
            }
            System.out.println();
        }*/

        System.out.println("原始数组");
        for(int[] row:chessArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int length = chessArr[0].length;
        System.out.println("length:"+length);

        //2.将二维数组转为稀疏数组
        //第一步：先遍历数组，获取不为0的数据
        int sum=0;
        for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j <chessArr[0].length ; j++) {
                if(chessArr[i][j]!=0){
                 sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] spareArr = new int[sum+1][3];
        spareArr[0][0] = chessArr.length;
        spareArr[0][1] = chessArr[0].length;
        spareArr[0][2] = sum;
        //遍历二维数组，找到不为0的数据，并赋值给稀疏数组
        int count=0;
        for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j <chessArr[0].length ; j++) {
                if(chessArr[i][j]!=0){
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("稀疏数组····");
        //遍历对应的稀疏数组
        for (int i = 0; i < spareArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为原始数组
        //新建二维数组
        int[][] chessArr2 = new int[spareArr[0][0]][spareArr[0][1]];

        for (int i = 1; i < spareArr.length ; i++) {
            chessArr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }

        System.out.println();
        System.out.println("恢复之后的二维数组");

        for (int i = 0; i <chessArr2.length ; i++) {
            for (int j = 0; j < chessArr2[0].length; j++) {
                System.out.printf("%d\t",chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}
