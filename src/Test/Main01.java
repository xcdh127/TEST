import java.util.*;
public class Main01{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int number=2;
        while(num>0){
            while(num>0 && isZhiShu(number) && num%number==0){
                num/=number;
                System.out.print(number+" ");
            }
            number++;
        }
    }

    public static boolean isZhiShu(int num){
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}