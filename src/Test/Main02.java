package Test;

import java.util.*;
import java.lang.*;
public class Main02 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int a=Integer.parseInt(line[0]);
        int b=Integer.parseInt(line[1]);
        int c=Integer.parseInt(line[2]);
        int d=Integer.parseInt(line[3]);
        int e=Integer.parseInt(line[4]);
        int f=Integer.parseInt(line[5]);
        int g=Integer.parseInt(line[6]);
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>(Comparator.reverseOrder());
        map.put(e,a);
        map.put(f,b);
        map.put(g,c);
        int res=0;
        while(d>0){
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                while(d>0 && entry.getValue()!=0){
                    map.put(entry.getKey(),entry.getValue()-1);
                    res+=entry.getKey();
                    d--;
                }
            }
        }
        System.out.println(res);
    }
}