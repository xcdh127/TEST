package ZiJieTiaoDong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        String[] line2=sc.nextLine().split(" ");
        int n=line1.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(line1[i]);
            arr2[i]=Integer.parseInt(line2[i]);
        }
        Map<String,Integer> map=new HashMap<>();
        map.put("A",4);
        map.put("2",4);
        map.put("3",4);
        map.put("4",4);
        map.put("5",4);
        map.put("6",4);
        map.put("7",4);
        map.put("8",4);
        map.put("9",4);
        map.put("10",4);
        map.put("J",4);
        map.put("Q",4);
        map.put("K",4);
        for(int i=0;i<n;i++){
            map.put(line1[i],map.get(line1[i])-1);
            map.put(line2[i],map.get(line2[i])-1);
        }
        double sum1=0.0;
        double sum2=0.0;
        for(int i=0;i<n;i++){
            sum1+=arr1[i];
            sum2+=arr2[i];
        }
        double total=0.0;
        double shengli=0.0;
        String[] str=new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int i=0;i<13;i++){
            for(int j=0;j<13;j++){
                int oriA=map.get(str[i]);
                int oriB=map.get(str[j]);
                double a=sum1;
                double b=sum2;
                if(map.get(str[i])!=0){
                    map.put(str[i],map.get(str[i])-1);
                    a+=i+1;
                }
                else{
                    map.put(str[i],oriA);
                    break;
                }
                if(map.get(str[j])!=0){
                    map.put(str[j],map.get(str[j])-1);
                    b+=j+1;
                }
                else{
                    map.put(str[i],oriA);
                    break;
                }
                if(a>b){
                    shengli++;
                }
                total++;
                map.put(str[i],oriA);
                map.put(str[j],oriB);
            }
        }
        double res=shengli/total;
        System.out.println(String.format("%.4f",res));
}
}
