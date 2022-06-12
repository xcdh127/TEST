package Leetcode;
/*给定一个数字 N，当它满足以下条件的时候返回 true：
原数字旋转 180° 以后可以得到新的数字。
如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
*/
public class Test268 {
    public static void main(String[] args) {
        System.out.println(confusingNumber(916));
    }
    public static boolean confusingNumber(int n) {
        String num=String.valueOf(n);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)=='2' || num.charAt(i)=='3' || num.charAt(i)=='4'|| num.charAt(i)=='5'
            || num.charAt(i)=='7'){
                return false;
            }
            if (num.charAt(i)=='6'){
                sb.append(9);
            }
            else if (num.charAt(i)=='9'){
                sb.append(6);
            }
            else sb.append(num.charAt(i));
        }
        return !sb.toString().equals(num);

    }
}
