package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。*/
public class Test26 {
    public boolean canPermutePalindrome(String s) {
        //（1）其余的字符的个数是偶数个
        //（2）全部的字符的个数是奇数个
        //因此本题目只需要统计奇数个字符出现的次数就可以了
        //当奇数字符个数大于1时，就不能够通过排列组合形成回文字符串了
        int n=s.length();
        //记录字符串中的字符，以及各字符出现的次数
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //记录奇数字符出现的次数
        int countOdd=0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue()%2==1){
                countOdd++;
            }
        }
        //当奇数字符出现的次数大于1时，直接返回false
        if(countOdd>1){
            return false;
        }
        //否则可以通过排列组和形成回文字符串
        return true;
    }

}
