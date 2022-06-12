package Leetcode;
import java.util.*;
public class Test8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int profit=Integer.parseInt(sc.nextLine());
        int total=0;
        if(profit>100000){
            total+=(profit-100000)*0.01;
        }
        if(profit>=60000 && profit<100000){
            total+=(profit-60000)*0.04;
        }
        if(profit>=40000 && profit<60000){
            total+=(profit-40000)*0.03;
        }
        if(profit>=20000 && profit<40000){
            total+=(profit-20000)*0.05;
        }
        if(profit>=10000 && profit<20000){
            total+=(profit-10)*0.04;
        }
        if(profit<10000){
            total+=profit*0.05;
        }
        System.out.println(total+profit);
    }
}
