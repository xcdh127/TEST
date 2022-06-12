import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            StringBuilder sb=new StringBuilder();
            int len=s.length();
            if(len<8){
                sb.append(s);
                for(int i=0;i<8-len;i++){
                    sb.append("0");
                }
                System.out.println(sb.toString());
            }
            else{
                for(int i=0;i<len;i+=8){
                    sb=new StringBuilder();
                    sb.append(s.substring(i,Math.min(i+8,len)));
                    if(sb.length()==8){
                        System.out.println(sb.toString());
                    }
                    else{
                        int length=sb.length();
                        for(int j=0;j<8-length;j++){
                            sb.append("0");
                        }
                        System.out.println(sb.toString());
                    }
                }
            }
        }
    }
}