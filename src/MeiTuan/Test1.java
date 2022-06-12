package MeiTuan;
import java.util.Arrays;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] line=sc.nextLine().split(" ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(line[i]);
        }
        int count=0;
        Arrays.sort(arr);
        int prev=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-prev<=1){
                count++;
            }
            else{
                prev=arr[i];
            }
        }
        System.out.println(n-count);
        }

}
