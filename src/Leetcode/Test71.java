package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
返回交换 任意 次之后 num 的 最大 可能值。*/
public class Test71 {
    public int largestInteger(int num) {
        //存放奇数的数组
        List<Integer> odd=new ArrayList<>();
        //存放偶数的数组
        List<Integer> even=new ArrayList<>();
        //拿到当前数字的字符串
        String numStr=String.valueOf(num);
        //临时记录这个数字
        int numTemp=num;
        //拿到当前数字的每一位
        while (numTemp>0){
            //取当前位置上的数字
            int yuShu=numTemp%10;
            //当余数是偶数时，将当前数字放进偶数数组中
            if (yuShu%2==0){
                even.add(yuShu);
            }
            //当余数是奇数时，将当前数字放进奇数数组中
            else {
                odd.add(yuShu);
            }
            //取数字的下一位
            numTemp/=10;
        }
        //对奇数数组排序
        Collections.sort(odd);
        //对偶数数组排序
        Collections.sort(even);
        //从大到小取奇数数组的值
        int indexOdd=odd.size()-1;
        //从大到小取偶数数组的值
        int indexEven=even.size()-1;
        //用于拼接字符串的sb
        StringBuilder sb=new StringBuilder();
        //遍历给定的字符串，按照当前字符串当前位置的奇偶性，放进当前奇数或者偶数的最大值
        for (int i = 0; i < numStr.length(); i++) {
            //如果当前位置上的数字是偶数时，将偶数数组中的最大值添加到sb
            if ((numStr.charAt(i)-'0')%2==0){
                sb.append(even.get(indexEven--));
            }
            //如果当前位置上的数字是奇数时，将奇数数组中的最大值添加到sb
            else {
                sb.append(odd.get(indexOdd--));
            }
        }
        //将字符串转成数字
        return Integer.parseInt(sb.toString());
    }
}
