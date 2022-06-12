
package Leetcode;

import java.util.Arrays;
/*请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，
其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
numberOfBoxesi 是类型 i 的箱子的数量。
numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
返回卡车可以装载 单元 的 最大 总数。
*/
public class Test69 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //按照可以盛放物品个数从达到小排序
        Arrays.sort(boxTypes,(a,b)->(b[1]-a[1]));
        //记录已存放的箱子树数
        int size=0;
        //记录总容量
        int rongLiang=0;
        //遍历所有的箱子
        l1:for (int[] box :boxTypes) {
            //当前箱子的个数
            int geShu=box[0];
            //当前箱子可容纳的个数
            int unit=box[1];
            //当前种类的箱子的个数大于0时
            while (geShu>0){
                //当车子还能容纳箱子时
                if (size<truckSize){
                    //箱子放进车子
                    size++;
                    //容量加上此箱子容量
                    rongLiang+=unit;
                    //此类箱子个数-1
                    geShu--;
                }
                //车子，满了直接停止循环
                else{
                    break l1;
                }
            }
        }
        //返回容量
        return rongLiang;
    }
}
