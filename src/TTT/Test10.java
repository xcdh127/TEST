package TTT;
import java.util.*;
public class Test10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int N=Integer.parseInt(line1[0]);
        int K=Integer.parseInt(line1[1]);
        String[] line2=sc.nextLine().split(" ");
        int[] arr=new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(line2[i]);
        }
        int i=0;
        int count=0;
        int sum=0;
        for (int j = 0; j < N; j++) {
            sum+=arr[j];
            while(sum/(j-i+1)>=K){
                count++;
                sum-=arr[i];
                i++;
            }
        }
        System.out.println(count);
    }
}
