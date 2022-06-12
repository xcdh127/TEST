import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int minDif=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int i=2;
        for(;i<=n;i++){
            if(isSuShu(i) && isSuShu(n-i)){
                if(Math.abs(2*i-n)<minDif){
                    minDif=Math.abs(2*i-n);
                    left=i;
                    right=n-i;
                }
            }
        }
        if(left==0 && right==0){
            System.out.println(0);
            return;
        }
        System.out.println(left+" "+right);

    }
    public static boolean isSuShu(int n){
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}