package zhuowangshuma;

import java.util.ArrayList;
import java.util.List;

public class test6 {
    private static int sum=0;
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(6);
        list.forEach((s)->{
            sum+=cal(s);
        });
        System.out.println(sum);

    }

    public static int cal(int source){
        if(source<5){
            return source;
        }
        return cal(source-1)+cal(source-2);
    }
}
