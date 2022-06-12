package Test;
import java.util.*;
public class FUtu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int[] arr=new int[N];
        int sum1=0;
        int sum2=0;
        arr[0]=d;
        for(int i=1;i<N;i++){
            arr[i]=(a*arr[i-1]*arr[i-1]+b*arr[i-1]+c)%1000000;
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            if(i%2==0){
                sum1+=arr[i];
            }
            else{
                sum2+=arr[i];
            }
        }
        System.out.println(-(sum1-sum2));
    }
}
