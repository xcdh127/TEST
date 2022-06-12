package Shiyuangufen;

import java.io.FileWriter;
import java.io.IOException;

public class Exam {
    String str=new String("tarena");
    char[] ch={'a','b','c'};
    public static void main(String[] args) throws Exception {

        Exam ex=new Exam();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);



    }
    public void change(String str,char[] ch){
        str="test ok";
        ch[0]='g';
    }
}
