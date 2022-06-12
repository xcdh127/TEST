package ZiJieTiaoDong;
import java.text.DecimalFormat;
import java.util.*;
public class Test1 {
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
        double sum1=0.0;
        double sum2=0.0;
        for(int i=0;i<n;i++){
            sum1+=arr1[i];
            sum2+=arr2[i];
        }
        double total=0.0;
        double shengli=0.0;
        for(double i=1;i<=13;i++){
            for(double j=1;j<=13;j++){
                double a=sum1;
                double b=sum2;
                a+=i;
                b+=j;
                if(a>b){
                    shengli++;
                }
                total++;
            }
        }
       double res=shengli/total;
//        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(res);
    }
}
