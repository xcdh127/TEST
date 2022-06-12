package Test;

import java.util.*;
public class Main08{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int oneMonth=1;
            int twoMonth=0;
            int threeMonth=0;
            int addValue=0;
            for(int i=2;i<=n;i++){
                threeMonth+=twoMonth;
                twoMonth=oneMonth;
                oneMonth=addValue;
                addValue=twoMonth+threeMonth;
            }
            System.out.println(oneMonth+twoMonth+threeMonth);

        }
    }
}