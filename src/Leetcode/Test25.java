package Leetcode;
/*中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
*/
public class Test25 {
    public boolean isStrobogrammatic(String s) {
        //字符串的长度
        int n=s.length();
        //字符串开始位置
        int start=0;
        //字符串结尾位置
        int end=n-1;
        //如果字符串的长度等于1，那么如果这个字符是0,1,8那么就返回true
        if(s.length()==1){
            if(s.charAt(0)=='0' || s.charAt(0)=='1' ||
            s.charAt(0)=='8'){
                return true;
            }
            //否则就返回false
            else{
                return false;
            }
        }
        //逐位判断当前字符串是不是180度对称字符串
        while(start<end){
            //如果某一位字符不是对应的180度对称字符就返回false
            if(!isHeFa(s,start,end)){
                return false;
            }
            //判断下一对位置
            start++;
            end--;
        }
        //字符串的长度是偶数时，直接返回true
        if (s.length()%2==0){
                return true;
        }
        //如果字符串长度是奇数，那么要判断中间位置是不是对称字符
        //如果是对称字符就返回true
        if (s.length()%2==1 && (s.charAt(start)=='0'
                || s.charAt(start)=='1'
                || s.charAt(start)=='8')){
            return true;
        }
        //否则返回false
        return false;
    }

    public boolean isHeFa(String s,int a,int b){
        //判断两个指针指向的字符是不是180度对称的字符
        //1<->1   6<->9  9<->6  8<->8 0<->0 其他都不是180度对称字符
        return s.charAt(a)=='1' && s.charAt(b)=='1' ||
                s.charAt(a)=='6' && s.charAt(b)=='9' ||
                s.charAt(a)=='9' && s.charAt(b)=='6' ||
                s.charAt(a)=='8' && s.charAt(b)=='8' ||
                s.charAt(a)=='0' && s.charAt(b)=='0';
    }
}
