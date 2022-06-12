package Leetcode;
/*给你一个坐标 coordinates ，
它是一个字符串，表示国际象棋棋盘中一个格子的坐标。
下图是国际象棋棋盘示意图。*/
public class Test92 {
    public boolean squareIsWhite(String coordinates) {
        //取出当前字符串
        char ch=coordinates.charAt(0);
        //取出当前数字
        int num=coordinates.charAt(1)-'0';
        //如果当前字符是a,c,e,g时
        if (ch=='a' || ch=='c' || ch=='e' || ch=='g'){
            //如果是第2 4 6 8块标志是黑色返回true
            if (num==2 || num==4 || num==6 || num==8){
                return true;
            }
            //否则返回false
            else {
                return false;
            }
        }
        //如果当前字符不是a c e g时
        else {
            //如果当前是2 4 6 8块标志是白色，返回false
            if (num==2 || num==4 || num==6 || num==8){
                return false;
            }
            //否则返回true
            else {
                return true;
            }
        }
    }
}
