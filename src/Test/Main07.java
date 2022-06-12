package Test;

import java.util.*;
public class Main07{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n==0)break;
            int count=0;
            int r=0;
            while(n!=0 && n!=1){
                if(n==2){
                    count++;
                    break;
                }
                count+=n/3;
                r=n%3;
                n=n/3+r;
            }
            System.out.println(count);
        }
    }
}
