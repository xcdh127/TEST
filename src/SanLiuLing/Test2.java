package SanLiuLing;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int n1=Integer.parseInt(line1[0]);
        int n2=Integer.parseInt(line1[1]);
        int n3=Integer.parseInt(line1[2]);
        Set<String> zhuyu=new HashSet<>();
        Set<String> weiyu=new HashSet<>();
        Set<String> binyu=new HashSet<>();
        String[] line2=sc.nextLine().split(" ");
        String[] line3=sc.nextLine().split(" ");
        String[] line4=sc.nextLine().split(" ");
        for(int i=0;i<n1;i++){
            zhuyu.add(line2[i]);
        }
        for(int i=0;i<n2;i++){
            weiyu.add(line3[i]);
        }
        for(int i=0;i<n3;i++){
            binyu.add(line4[i]);
        }
        int m=Integer.parseInt(sc.nextLine());
        for(int i=0;i<m;i++){
            int zhuyuCount=0;
            int weiyuCount=0;
            int binyuCount=0;
            String[] strs=sc.nextLine().split(" ");
            for(String s : strs){
                if(zhuyu.contains(s)){
                    zhuyuCount++;
                }
                else if(weiyu.contains(s)){
                    weiyuCount++;
                }
                else if(binyu.contains(s)){
                    binyuCount++;
                }
            }
            if(zhuyuCount==0 || weiyuCount>1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
