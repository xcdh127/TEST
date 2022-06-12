package Huawei1;
import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] peopelsStr=sc.nextLine().split(" ");
        String[] projects=sc.nextLine().split(" ");
        System.out.println(Integer.parseInt(projects[0]));
    }
}
