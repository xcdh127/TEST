package Qushikeji;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int index=s.indexOf(":");
        sb.append(s.substring(0,index+1));
        sb.append("//");
        index++;
        while (index<n && s.charAt(index)=='/' || s.charAt(index)=='\\'){
            index++;
        }
        sb.append(s.substring(index+1,n));
        System.out.println(sb.toString());
    }
}
