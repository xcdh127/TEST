package shapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test001 {
    public static void main(String[] args) {

        System.out.println(buildHouses(1));

    }

        public static int buildHouses(int n) {
            int[] queen=new int[n];
            Arrays.fill(queen,-1);
            //记录列上的房子
            Set<Integer> col=new HashSet<Integer>();
            //记录主对角线上的房子
            Set<Integer> duiJiao1=new HashSet<Integer>();
            //记录副对角线上的房子
            Set<Integer> duiJiao2=new HashSet<Integer>();
            return recur(queen,n,0,col,duiJiao1,duiJiao2);

        }
        public static int recur(int[] queen,int n,int row,Set<Integer> col,Set<Integer> duiJiao1,Set<Integer> duiJiao2){
            //形成一种建房方案
            if(n==row){
                return 1;
            }
            else{
                int count=0;
                for(int i=0;i<n;i++){
                    //此列已经建立房子，跳出
                    if(col.contains(i)){
                        continue;
                    }
                    int dif=row-i;
                    //主对角线上已经建立房子，跳出
                    if(duiJiao1.contains(dif)){
                        continue;
                    }
                    int sum=row+i;
                    //副对角线上已经建立房子，跳出
                    if(duiJiao2.contains(sum)){
                        continue;
                    }

                     //建立房子
                    queen[row]=i;
                    //此列建一个房子
                    col.add(i);
                    //主对角线添加这个房子
                    duiJiao1.add(dif);
                    //副对角线添加这个房子
                    duiJiao2.add(sum);
                    //判断下一行
                    count+=recur(queen,n,row+1,col,duiJiao1,duiJiao2);
                    //将刚刚建立的房子从所属的列删除
                    col.remove(i);
                    //将刚刚建立的房子从所属的主对角线删除
                    duiJiao1.remove(dif);
                    //将刚刚建立的房子从所属的副对角线删除
                    duiJiao2.remove(sum);
                }
                return count;
            }
        }
    }
