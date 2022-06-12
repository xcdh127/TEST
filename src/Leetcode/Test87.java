package Leetcode;
/*给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
返回重新排列后的字符串。
*/
public class Test87 {
    public String restoreString(String s, int[] indices) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        //先用一个字符占位
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        for (int i = 0; i < n; i++) {
            //使用在某个位置上设置某个字符的方法
            sb.setCharAt(indices[i],s.charAt(i));
        }
        //返回字符串
        return sb.toString();
    }
}
