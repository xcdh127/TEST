package weizhongyinhang;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int x=Integer.parseInt(line[1]);
        int y=Integer.parseInt(line[2]);
        String[] line1=sc.nextLine().split(" ");
//        int len=line1.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(line1[i]);
        }
        for(int i=0;i<n;i++){
            int j=i;
            while(j-x>=0) {
                if (arr[i] >= arr[j - x]) {
                    break;
                }
                j--;
            }
            j=i;
            while (j+y<=n-1){
                if(arr[i]>=arr[j+y]){
                    break;
                }
                j++;
            }
                System.out.println(i+1);
                return;
            }


    }
}
