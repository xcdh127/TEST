package ZiJieTiaoDong;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int T=Integer.parseInt(line1[1]);
        String[] line2=sc.nextLine().split(" ");
        int[] arr1=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(line2[i]);
        }
        int maxNum=0;
        int[] sumArr=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=arr1[i];
            sumArr[i]=ans;
        }
        for(int i=0;i<n;i++){
            int number=0;
            for(int j=i+1;j<n;j++){
                int sum=sumArr[j]-sumArr[i];
                number++;
                if(sum>T){
                    number=number-1;
                    break;
                }
            }
            maxNum=Math.max(number,maxNum);
        }
        System.out.println(maxNum);
    }
}
