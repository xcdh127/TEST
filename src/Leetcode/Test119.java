package Leetcode;
/*给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
*/
public class Test119 {
    public String generateTheString(int n) {
        StringBuilder sb=new StringBuilder();
        //当n为偶数时，输出n-1个a外加1个b
        if (n%2==0){
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        }
        //当n为奇数时，输出n个a
        else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        //输出字符串
        return sb.toString();
    }
}


/*class Solution {
public:
    string generateTheString(int n)
    {
        string str;
        if(n%2==0)//判断n是否是偶数，如果为偶数，则输出n-1个a与1个b即可满足条件
        {
            for(int i=1;i<=n-1;i++)
            {
                str+='a';
            }
            str+='b';
            return str;
        }
        else//如果n为奇数，则直接输出n次a即可
        {
            for(int i=1;i<=n;i++)
            {
                str+='a';
            }
            return str;
        }
    }
};
*/
