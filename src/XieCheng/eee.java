package XieCheng;
import java.util.Scanner;

public class eee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int a=Integer.parseInt(line1[0]);
        int b=Integer.parseInt(line1[1]);
        String[] line2=sc.nextLine().split(" ");
        int c=Integer.parseInt(line2[0]);
        int d=Integer.parseInt(line2[1]);
        int e=Integer.parseInt(line2[2]);
        int start=c*10000+d*10+e;
        int end=start+1;
        while(true){
            if(isHuiWen(end) && isValid(end,line1[0].length(),line1[1].length(),line2[0].length(),a,b)){
                String endStr=String.valueOf(end);
                int num1=Integer.parseInt(endStr.substring(0,line2[0].length()));
                int num2=Integer.parseInt(endStr.substring(line2[0].length(),line2[0].length()+line2[1].length()));
                int num3=Integer.parseInt(endStr.substring(line2[0].length()+line2[1].length(),endStr.length()));
                System.out.println(num1+" "+num2+" "+num3);
                break;
            }
            end++;
        }
    }
    public static boolean isHuiWen(int num){
        String numStr=String.valueOf(num);
        int n=numStr.length();
        int i=0;
        int j=n-1;
        while(i<j){
            if(numStr.charAt(i)!=numStr.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isValid(int end,int lenA,int lenB,int lenC,int a,int b){
        int yuShu=end%10;
        if(yuShu>b){
            return false;
        }
        String numStr=String.valueOf(end);
        String sub=numStr.substring(lenC-1,numStr.length()-1);
        int num=Integer.parseInt(sub);
        if(num>a){
            return false;
        }
        return true;
    }

}