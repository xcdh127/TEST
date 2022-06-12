package Test;

import java.util.*;
public class Main09{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int h=sc.nextInt();
            int[][] pos=new int[n][2];
            for(int i=0;i<n;i++){
                pos[i]=new int[]{i+1,sc.nextInt()};
            }
            for(int i=0;i<n;i++){
                int j=i-1;
                for(;j>=0;j--){
                    int k=(pos[i][1]-h)/(j+2);
                    int high=k*i+h;
                    if(high>=pos[j][1]){
                        break;
                    }
                }
                System.out.println(j+1);
            }
        }

    }
}