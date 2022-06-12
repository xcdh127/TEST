package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给定四个整数 row ,   cols ,  rCenter 和 cCenter 。
有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
返回矩阵中的所有单元格的坐标，
并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。
你可以按 任何 满足此条件的顺序返回答案。
单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。*/
public class Test54 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        //所有的坐标个数
        int n=rows*cols;
        //当前对象数数组下标
        int index=0;
        //创建对象数组
        Dist[] dists=new Dist[n];
        //遍历所有的坐标位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //将数组中的横坐标，纵坐标记录，以及到中心点的坐标放到对象数组当中
                dists[index++]=new Dist(i,j,Math.abs(rCenter-i)+Math.abs(cCenter-j));
            }
        }
        //对Dist数组自定义排序
        Arrays.sort(dists,(a,b)->(compare(a,b)));
        //结果数组，存放横纵坐标
        List<int[]> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //向结果数组中添加结果
            res.add(new int[]{dists[i].row,dists[i].col});
        }
        //返回数组
        return res.toArray(new int[0][]);
    }

    //自定义排序规则
    public int compare(Dist dist1,Dist dist2){
        int d1=dist1.dist;
        int d2=dist2.dist;
        //按照距离中心位置排序
        return d1-d2;
    }
}

class Dist{
    //当前位置的横坐标
    int row;
    //当前位置的纵坐标
    int col;
    //当前位置记录中心的U距离信息
    int dist;
    Dist(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}

