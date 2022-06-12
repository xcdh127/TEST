package weizhongyinhang;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
//        StringBuilder sb=new StringBuilder();
////        char[] chars=new char[1000000];
////        int i=0;
//        if(num==0){
//
//            System.out.println(0);
//            return;
//        }
//        else{
//            while(num!=0){
//                int yushu=num%16;
//                if(yushu>=0 && yushu<10){
//                    sb.append((char)(yushu-'0'));
//
//                }
//                else{
//                    sb.append((char)(yushu+'A'-10));
//                }
//                num/=16;
//            }
//        }
//        String number=sb.toString();
        int count=0;
        String number=Integer.toHexString(num);
        for(int i=0;i<number.length();i++){
            if(Character.isLetter(number.charAt(i))){
                count++;
            }
        }
        System.out.println(count);

    }
}
