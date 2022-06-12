package Test;

import java.util.*;
public class Main05{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(";");
        int n=str.length;
        int row=0;
        int col=0;
        for(int i=0;i<n;i++){
            if(isValid(str[i])){
                int num;
                if(str[i].length()==2){
                     num=Integer.parseInt(str[i].substring(1,2));
                }else{
                    num=Integer.parseInt(str[i].substring(1,3));
                }

                if(str[i].charAt(0)=='A'){
                    row-=num;
                }
                else if(str[i].charAt(0)=='D'){
                    row+=num;
                }
                else if(str[i].charAt(0)=='W'){
                    col+=num;
                }
                else{
                    col-=num;
                }
            }
        }
        System.out.println(row+","+col);
    }
    public static boolean isValid(String s){
        if(s==null || s.length()==0 || s.length()>3){
            return false;
        }
        if(s.charAt(0)!='A' && s.charAt(0)!='D' && s.charAt(0)!='W' && s.charAt(0)!='S'){
            return false;
        }
        if(s.length()==2 && !Character.isDigit(s.charAt(1))){
            return false;
        }
        if(s.length()==3 && (!Character.isDigit(s.charAt(1)) || !Character.isDigit(s.charAt(2)))){
            return false;
        }
        return true;
    }
}
