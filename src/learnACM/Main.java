package learnACM;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);//定义Scanner，等待输入；
        int N = scanner.nextInt();//输入N；
        if (N < 10){
            System.out.println(N);
            return;//方法结束；
        }
        if(N>45){
            System.out.println(-1);
            return;
        }
        int nums = 0;//数；
        int digit = 0;//数位；
        for(int i=9;i>0;i--){
            if(i<=N){
                N-=i;
                nums+=(int)Math.pow(10,digit)*i;
                digit++;
            }
        }
        System.out.println(nums);
    }
}