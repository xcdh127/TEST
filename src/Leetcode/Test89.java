package Leetcode;

import java.util.Arrays;

/*给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）
拼写出 words 中的某个『单词』（字符串），
那么我们就认为你掌握了这个单词。
注意：每次拼写（指拼写词汇表中的一个单词）时，
chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
*/
public class Test89 {

    public static void main(String[] args) {

        String[] str=new String[]{"cat","bt","hat","tree"};
        String s="atach";
        System.out.println(countCharacters(str, s));

    }
    public static int countCharacters(String[] words, String chars) {
        int[] arr=new int[26];
        //统计字符串chars中的各字符个数
        for (int i = 0; i < chars.length(); i++) {
            arr[chars.charAt(i)-'a']++;
        }
        int count=0;
        for (int i = 0; i < words.length; i++) {
            boolean flag=true;
            //赋值一份数组
            int[] copyOf = Arrays.copyOf(arr, arr.length);
            //遍历这个字符串
            for (int j = 0; j < words[i].length(); j++) {
                //当前字符位置上的个数-1
                copyOf[words[i].charAt(j)-'a']--;
            }
            //检测字典是否包含当前字符，如果不包含就返回false
            if (!contain(copyOf,words[i])){
                flag=false;
            }
            //当前字符可以拼写
            if (flag)
            count+=words[i].length();
        }
        //返回计数结果
        return count;
    }

    public static boolean contain(int[] arr,String s){
        int n=s.length();
        //遍历数组，如果某个字符个数小于等于0，说明没有这个单词
        for (int i = 0; i < n; i++) {
            //当前数组中的字符个数小于0时，返回false
            if (arr[s.charAt(i)-'a']<0){
                return false;
            }
        }
        //字典包含单词返回true
        return true;
    }
}


/*public int countCharacters(String[] words, String chars) {

        if(words==null) return 0;
        int length = 0;
        int[] dicts = new int[26];

        for(int i=0;i<chars.length();i++){
            dicts[chars.charAt(i)-'a'] += 1;
        }

        for(String word:words){
            boolean isContain = true;
            int[] count = new int[26];

            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(dicts[index]>0 && count[index]<dicts[index]){
                    count[index]+=1;
                }else{
                    isContain = false;
                    break;
                }
            }

            if(isContain) length+=word.length();

        }
        return length;
    }*/
