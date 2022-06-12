import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner=new Scanner(System.in);
            int n=Integer.parseInt(scanner.nextLine());
            String s=scanner.nextLine();
            int i=0;
            while(i<n && s.charAt(i)!='M'){
                i++;
            }
            while(i<n && s.charAt(i)!='T'){
                i++;
            }
            i++;
            int j=n-1;
            while(j>0 && s.charAt(j)!='T') {
                j--;
            }
            while(j>0 && s.charAt(j)!='M'){
                j--;
            }
            j--;
            String res=s.substring(i,j+1);

        long end = System.currentTimeMillis();
            System.out.println(res+"运行了"+(end-start)+"毫秒");
    }

}