package tengxun;
import java.util.*;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String s=sc.nextLine();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int countLeft=0;
            for(int left=0;left<i;left++){
                if(s.charAt(left)=='0'){
                    countLeft+=left+1;
                }
            }
            int countRight=0;
            for(int right=i;right<n;right++){
                if(s.charAt(right)=='1'){
                    countRight+=right+1;
                }
            }
            min=Math.min(min,Math.abs(countLeft-countRight));
        }
        System.out.println(min);
    }
}
