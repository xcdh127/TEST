package MeiTuan2;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int m=Integer.parseInt(line[0]);
        int n=Integer.parseInt(line[1]);
        int[][] arr=new int[m][];
        for(int i=0; i<m;i++){
            String[] line1=sc.nextLine().split(" ");
            int num1=Integer.parseInt(line1[0]);
            int num2=Integer.parseInt(line1[1]);
            arr[i]=new int[]{num1,num2};
        }
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        int count=0;
        int prev=0;
        for(int i=0;i<m;i++){
            int num1=arr[i][0];
            int num2=arr[i][1];
            if(prev!=0){
                if(prev>=num1){
                    continue;
                }
            }
            prev=num1;
            if(num1<n && num2<n){
                count++;
            }
        }
        System.out.println(count);
    }
}
