package Test;

import java.util.ArrayList;
import java.util.List;

public class TestT {
    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        List<?extends String> list2=new ArrayList<>();
        list2=list1;


    }
}
