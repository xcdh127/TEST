package MeiTuan2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<m;i++){
            String[] line1=sc.nextLine().split(" ");
            int num=Integer.parseInt(line1[0]);
            int a=Integer.parseInt(line1[1]);
            int b=Integer.parseInt(line1[2]);
            if(b==0){
//                for(int i=0;){}
            }
        }
    }
}