package xiecheng1;
import java.util.*;
public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        List<List<String>> res=new ArrayList<>();
        LinkedList<String> subset=new LinkedList<>();
        char[] ch=s.toCharArray();
        int count=0;
        recur(res,subset,ch,0);
        for(List<String> list:res){
            StringBuilder sb=new StringBuilder();
            for(String str:list) {
                sb.append(str);
            }
            String numStr=sb.toString();
            if (numStr==null || numStr.equals("")){
                continue;
            }
            int num = Integer.parseInt(numStr);
            if (num % 9 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void recur(List<List<String>> res,LinkedList<String> subset,char[] ch,int index){
        if(index==ch.length){
            res.add(new LinkedList<String>(subset));
            return ;
        }
        //不放进去
        recur(res,subset,ch,index+1);
        //放进去
        subset.addLast(String.valueOf(ch[index]));
        recur(res,subset,ch,index+1);
        subset.removeLast();
    }
}
