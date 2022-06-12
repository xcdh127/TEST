package zhuowangshuma;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> arr=Arrays.asList(3,5,1,4,7,2,3);
        StringBuilder str=new StringBuilder();
        arr.stream().filter(t->t>3).forEach(s->{
            str.append(s);
        });
        System.out.println(str);
    }

}
