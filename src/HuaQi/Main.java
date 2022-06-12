package HuaQi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        //重复字符串的次数
        int beiShu=0;
        //放结果
        StringBuilder sb=new StringBuilder();

        List<String> charList=new LinkedList<>();
        List<Integer> numberList=new LinkedList<>();
//      Stack<Character> stack=new Stack<>();
        //当遇到左括号时
        for(int i=0;i<n;i++){
            //当遇到'['时
            if (s.charAt(i) == '[') {
                //将倍数放进栈中
                ((LinkedList<Integer>) numberList).addLast(beiShu);
                //将sb中已经存在的内容放进charList中
                ((LinkedList<String>) charList).addLast(sb.toString());
                //更新sb中的内容
                sb=new StringBuilder();
                //将倍数清零，此时说明要进入下一个重复次数的字符串统计当中
                beiShu=0;
            }
            //当遇到']'时
            else if(s.charAt(i)==']'){
                //此时要重复此时的字符串已经形成
                StringBuilder temp=new StringBuilder();
                //将此时charList中的字符串弹出来
                String tempStr=((LinkedList<String>) charList).pollLast();
                //弹出此时要重复的字符串的次数
                beiShu=((LinkedList<Integer>) numberList).pollLast();
                //将此时sb中的字符串重复beiShu次
                for(int j=0;j<beiShu;j++){
                    temp.append(sb);
                }
                //当前形成的字符串+重复次数后的字符串成为当前新的结果字符串
                sb=new StringBuilder(tempStr+temp);
            }
            //当遇到数字时，累加成完整的数字
            else if(Character.isDigit(s.charAt(i))){
                beiShu=beiShu*10+(s.charAt(i)-'0');
            }
            //当遇到'*'时，跳过不进行处理
            else if(s.charAt(i)=='*'){
                continue;
            }
            //当遇到字符时，向sb中添加当前的字符
            else {
                sb.append(s.charAt(i));
            }
        }
        //将最终的字符串输出
        System.out.println(sb.toString());
    }

//    public static int getNum(String s,int index){
//        int n=s.length();
//        StringBuilder sb=new StringBuilder();
//        while(index<n && Character.isDigit(s.charAt(index))){
//            index++;
//            sb.append(s.charAt(index));
//        }
//        return Integer.parseInt(sb.toString());
//    }
}