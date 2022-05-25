package com.el.jichu.algorithm.dynamic;

/**
 * @author Roman.zhang
 * @Date: 2019/7/31 11:10
 * @Version:V1.0
 * @Description:KnapsackProblem
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //物品重量
        int[] w = {1,4,3};
        //物品的价值
        int[] val = {1500,3000,2000};
        //背包的容量
        int m = 4;
        //物品个数
        int n = val.length;

        //创建二维数组
        //v[i][j]：表示前i个物品中能够装入到容量为j的背包中，最大的价值
        int[][] v = new int[n+1][m+1];
        //记录放入的商品
        int[][] path = new int[n+1][m+1];

        //初始化第一行，第一列
        for (int i = 0; i < v.length; i++) {
            //第一列为0
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            //第一行为0
            v[0][i] = 0;
        }

        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //因为我们的程序是从1开始，因此原来的公式w[i] 改为w[i-1]
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    //说明:
                    //因为我们的i 从1开始的， 因此公式需要调整成
                    //v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if-else来体现公式
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出看下v,看看目前情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j]+" \t");
            }
            System.out.println();
        }

        System.out.println("====================");

//        输出最后我们是放入的哪些商品
//        遍历path, 这样输出会把所有的放入情况都得到, 其实我们只需要最后的放入
		/*for(int i = 0; i < path.length; i++) {
			for(int j=0; j < path[i].length; j++) {
				if(path[i][j] == 1) {
					System.out.printf("第%d个商品放入到背包\n", i);
				}
			}
		}*/

        //动脑筋
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //从path的最后开始找
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }
    }
}
