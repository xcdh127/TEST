package tengxun;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.nextLine();
        }
        List<Integer> list=new ArrayList<>();
        int len=str[0].length();
        for(int i=0;i<len;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(str[j].charAt(i));
            }
            while(sb.length()>0 && sb.charAt(0)=='0'){
                sb.deleteCharAt(0);
            }
            list.add(Integer.parseInt(sb.toString()));
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(i!=list.size()-1){
                System.out.print(list.get(i)+" ");
            }
            else{
                System.out.print(list.get(i));
            }

        }
    }
}
