package JianZHiOffer;

import java.util.HashMap;
import java.util.Map;

/*请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
数值（按顺序）可以分成以下几个部分：
若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格
小数（按顺序）可以分成以下几个部分：
（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：
（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分数值列举如下：
["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：
["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
示例 1：
输入：s = "0"
输出：true
示例 2：
输入：s = "e"
输出：false
示例 3：
输入：s = "."
输出：false
示例 4：
输入：s = "    .1  "
输出：true
提示：
1 <= s.length <= 20
s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
*/
public class Test20 {

    public boolean isNumber(String s) {
        Map[] state={
                new HashMap<Character,Integer>(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
                new HashMap<Character,Integer>(){{put('d',2);put('.',4);}},
                new HashMap<Character,Integer>(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
                new HashMap<Character,Integer>(){{put('d',3);put('e',5);put(' ',8);}},
                new HashMap<Character,Integer>(){{put('d',3);}},
                new HashMap<Character,Integer>(){{put('s',6);put('d',7);}},
                new HashMap<Character,Integer>(){{put('d',7);}},
                new HashMap<Character,Integer>(){{put('d',7);put(' ',8);}},
                new HashMap<Character,Integer>(){{put(' ',8);}},
        };
        char p=' ';
        int l=0;
        for ( char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                p='d';
            }
            else if (ch=='e' || ch=='E'){
                p='e';
            }
            else if (ch==' ' || ch=='.'){
                p=ch;
            }
            else if (ch=='+' || ch=='-'){
                p='s';
            }
            else {
                p='?';
            }

            if (!state[l].containsKey(p)){
                return false;
            }
            l=(int)(state[l].get(p));
        }
        return l==2 || l==3 || l==7 || l==8;
    }
}
/*class Solution {
    public boolean isNumber(String s) {
			Map[] state={
				new HashMap<Character,Integer>(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
		   	new HashMap<Character,Integer>(){{put('d',2);put('.',4);}},
			  new HashMap<Character,Integer>(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
				new HashMap<Character,Integer>(){{put('d',3);put('e',5);put(' ',8);}},
				new HashMap<Character,Integer>(){{put('d',3);}},
				new HashMap<Character,Integer>(){{put('s',6);put('d',7);}},
				new HashMap<Character,Integer>(){{put('d',7);}},
				new HashMap<Character,Integer>(){{put('d',7);put(' ',8);}},
        new HashMap<Character,Integer>(){{put(' ',8);}}
			};
			char p=' ';
			int l=0;
			for(char ch : s.toCharArray()){

				if(ch>='0' && ch<='9'){

					p='d';
				}
				else if(ch=='e' || ch=='E'){

					p='e';
				}
				else if(ch==' ' || ch=='.'){

					p=ch;
				}
				else if(ch=='+' || ch=='-'){

					p='s';
				}
				else{

					p='?';
				}

				if(!state[l].containsKey(p)){

					return false;
				}
				l=(int)state[l].get(p);

			}

			return l==2 || l==3 || l==7 || l==8;
    }
}*/
