package Leetcode;
import java.util.*;
public class Test7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(reverseWords(s));

    }
        public static String reverseWords(String s) {

            String[] str=s.split(" ");
            StringBuilder res=new StringBuilder();
            for(int i=0;i<str.length;i++){
                StringBuilder sb=new StringBuilder();
                sb.append(str[i]);
                res.append(sb.reverse()+" ");
            }
            return res.toString();
        }
}
