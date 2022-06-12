package Leetcode;
/*给你一个由小写字母组成的字符串 s ，以及一个整数 k 。

首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数
（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。

例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：

转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
转换 #2：17 ➝ 1 + 7 ➝ 8
返回执行上述操作后得到的结果整数。

输入：s = "leetcode", k = 2
输出：6
解释：操作如下：
- 转化："leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
- 转换 #1：12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
- 转换 #2：33 ➝ 3 + 3 ➝ 6
因此，结果整数为 6 。

*/
public class Test149 {
    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(getLucky(s,2));
    }
    public static int getLucky(String s, int k) {
        int num=0;
        //拼接字符串
        StringBuilder sb=new StringBuilder(s);
        while (k>0){
            //记录此轮字符串的值
            num=0;
            StringBuilder cur=new StringBuilder();
            //遍历字符串
            for (int i = 0; i < sb.length(); i++) {
                //如果此时字符串是字母，将其值与'a'作差然后+1
                //然后拼接到字符串中
                if (Character.isLetter(sb.charAt(i))){
                    int n=sb.charAt(i)-'a'+1;
                    cur.append(n);
                    //如果字符大于9，此时将值按照每一位上的数字相加
                    while (n>0){
                        int yuShu=n%10;
                        num+=yuShu;
                        n/=10;
                    }
                }
                //如果此时字符串是数字，将其值与'0'作差
                //然后拼接字符串
                else if (Character.isDigit(sb.charAt(i))){
                    int n=sb.charAt(i)-'0';
                    cur.append(n);
                    //如果字符大于9，此时将值按照每一位上的数字相加
                    while (n>0){
                        int yuShu=n%10;
                        num+=yuShu;
                        n/=10;
                    }
                }
            }
            //将此轮得到的数字和转换成字符串，并将它传递给下一次要处理的字符串
            sb=new StringBuilder(String.valueOf(num));
            //将轮次-1
            k--;
        }
        //返回结果
        return num;
    }
}
