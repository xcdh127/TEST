package xiecheng1;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            for(int j=0;j<n*2;j++){
                System.out.print(".");
            }
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
//                sb.append();
            }

        }
    }
}
