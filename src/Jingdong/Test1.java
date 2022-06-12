package Jingdong;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        long a=Long.parseLong(line[0]);//坦克数
        long b=Long.parseLong(line[1]);//碉堡生命值
        long c=Long.parseLong(line[2]);//炸毁坦克的数量
        long d=Long.parseLong(line[3]);//碉堡数
        System.out.println(fun(a,b,c,d));
//        int recur=0;
//        long zongShengMing=b*d;
//        while(a>=0 && zongShengMing>0){
//            zongShengMing-=a;
//            if(zongShengMing%d==0){
//                a=a-(c*(zongShengMing/d));
//            }
//            else{
//                a=a-(c*((zongShengMing/d)+1));
//            }
//            recur++;
//        }
//        if(a>=0){
//            System.out.println(recur);
//        }
//        else{
//            System.out.println(-1);
//        }

    }

    public static int fun(long a,long b ,long c,long d){
        boolean flag=true;
        int res=0;
        long blood=b;
        while(a>0 && d>0){
            long a1=a-blood;
            if(a1>=0){
                d--;
                d-=(a-blood)/b;
                if(d<1){
                    res++;
                    break;
                }
            }
            blood=b-(a-blood)%b;
            a-=d*c;
            if(a<1){
                return -1;
            }
            res++;
        }
        return res;
    }
}
