package Test;

import java.util.*;
public class Main03 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String s=sc.nextLine();
        int res=0;
        int count=0;
        for(int i=0;i<n;i++){
            //如果是E
            if(s.charAt(i)=='E'){
                count+=1;
                res=Math.max(res,count);
            }
            //如果是F
            else{
                if(count>0){
                    count--;
                }
            }
        }
        System.out.println(res);
    }
}