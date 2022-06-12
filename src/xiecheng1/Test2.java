package xiecheng1;
import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] line=sc.nextLine().split(" ");
        int[] arr=new int[line.length];
        for(int i=0;i<line.length;i++){
            arr[i]=Integer.parseInt(line[i]);
        }
        int count=0;
        char[] strArr=sc.nextLine().toCharArray();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j] && strArr[i]!=(strArr[j])){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
