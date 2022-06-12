package weizhongyinhang;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int k=Integer.parseInt(line[1]);
        String s=sc.nextLine();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                StringBuilder sb=new StringBuilder();
                sb.append(s.substring(i,j+1));
                int num=Integer.parseInt(sb.toString());
                if(num%k==0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
