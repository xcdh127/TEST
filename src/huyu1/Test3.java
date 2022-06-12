package huyu1;
import java.util.*;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] line=sc.nextLine().split(" ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(line[i]);
        }
        System.out.println(minJump(arr));

    }
    public static int minJump(int[] jump) {

        int i=0;
        int n=jump.length,head=0;
        int[] d=new int[n];
        int[] q=new int[n];
        Arrays.fill(d, -1);
        int l=0,r=0;
        d[0]=0; q[r++]=0;
        while(l!=r) {
            i=q[l++];
            if(i+jump[i]>=n) break;
            if(d[i+jump[i]]==-1)
                d[q[r++]=i+jump[i]]=d[i]+1;
            for(;head<i;head++)
                if(d[head]==-1)
                    d[q[r++]=head]=d[i]+1;
        }

        return d[i]+1;
    }
}
