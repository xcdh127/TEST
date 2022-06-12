package Leetcode;
/*给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：
选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
*/
public class Test84 {
    public boolean areAlmostEqual(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        //如果两个字符串不相等就直接返回false
        if (m!=n){
            return false;
        }
        //记录两个字符串不相同位置的字符数量
        int count=0;
        //记录两个字符串中出现字符的种类以及个数情况
        int[] arr=new int[26];
        for (int i = 0; i < m; i++) {
            //当统计s2时，将此位置的字符个数+1
            arr[s2.charAt(i)-'a']++;
            //当统计s1时，将此位置的字符个数-1
            arr[s1.charAt(i)-'a']--;
            //当此时两个字符串对应位置不相等时，记录不相等的字符串个数+1
            if (s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        //不同的字符数量小于等于2并且两个字符串字符的种类和个数都一样时返回true
        return count<=2 && allZero(arr);
    }
    //查看数组中的数字是否都是0
    public boolean allZero(int[] arr){
        for (int num :arr) {
            if (num!=0){
                return false;
            }
        }
        return true;
    }
}
