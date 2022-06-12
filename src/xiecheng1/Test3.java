package xiecheng1;
import java.util.*;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        int left=0;
        int right=ch.length-1;
        int count=0;
        while (left<right){
            while(left<right && ch[left]!=ch[left+1]) {
                left++;
            }
            while(left<right && ch[right]!=ch[right-1]){
                right--;
            }
            if(ch[left]!=ch[right]){
                swap(ch,left,right);
            }
            else{
                if(right!=ch.length-1){
                    swap(ch,right,right+1);
                }
                else if(left!=0){
                    swap(ch,left,left-1);
                }

            }
            count++;
        }
        System.out.println(count);
    }
    public static void swap(char[] ch,int a,int b){
        char temp=ch[a];
        ch[a]=ch[b];
        ch[b]=temp;
    }
}
