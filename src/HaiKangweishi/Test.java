package HaiKangweishi;

import javafx.collections.transformation.SortedList;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int i=0;
        while (i<5){
            switch (i){
                case 0:
                case 3:i=i+2;
                case 1:
                case 2:i=i+3;
                default:i=i+5;
            }
        }
        System.out.println(i);
        byte b=127;
        b++;
        System.out.println(b);
    }

//    List list=new SortedList();
















































}
