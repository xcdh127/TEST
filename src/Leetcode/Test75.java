package Leetcode;
/*给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。*/
public class Test75 {
    public static void main(String[] args) {
        String s= "cxcaac";
        validPalindrome(s);
    }
    public static boolean validPalindrome(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        //如果字符串本身就是回文字符串
        if (isHuiWen(s,i,j)){
            return true;
        }
        //将标记为false，用于判断当前字符串是否删除过一个字符
        boolean flag=false;
        //当两个指针没有碰撞时
        while (i<j){
            //如果已经标记，就返回true
            if (flag)break;
            if (i<j && s.charAt(i)!=s.charAt(j)){
                //如果字符串本身不是回文字符串，那么继续判断[i+1,j]或者[i,j-1]是不是回文
                if (isHuiWen(s,i+1,j) || isHuiWen(s,i,j-1)){
                    return true;
                }
                //设置一个标记位，当去除字符串中的一个字符之后，就设置为true
                flag=true;
            }
            //头指针向后指向
            i++;
            //尾指针向前指向
            j--;
        }
        //如果最多修改一个字符不能构成回文字符串就
        return false;
    }
    //判断一个字符串是不是回文字符串
    public static boolean isHuiWen(String s,int start,int end){
        //当两个指针没有碰撞时
        while (start<end){
            //当两个指针指向的字符不相等时返回false
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            //将前面的指针向后移动一位
            start++;
            //将后面的指针向前移动一位
            end--;
        }
        //如果两个指针指向的字符相等，就返回true
        return true;
    }
}
