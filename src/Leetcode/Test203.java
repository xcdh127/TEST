package Leetcode;
/*整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
*/
/*[9,9,9,9,9,9,9,9,9,9]
1
[1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3]
516
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*[0]
23*/
public class Test203 {
    public static void main(String[] args) {
        int[] arr=new int[]{0};
        System.out.println(addToArrayForm(arr, 23));
    }
    public static List<Integer> addToArrayForm(int[] num, int k) {
        int n=num.length;
        //将数字转换从字符串
        String numStr=String.valueOf(k);
        //字符串转字符数组
        char[] ch=numStr.toCharArray();
        int[] arr=new int[ch.length];
        int m=arr.length;
        //字符数组转整数数组
        for (int i = 0; i < ch.length; i++) {
            arr[i]=ch[i]-'0';
        }
        //指向两个数组的末尾
        int index1=n-1;
        int index2=m-1;
        //取两个数组最长长度
        int max=Math.max(m,n);
        //结果为最长长度+1
        int[] res=new int[max+1];
        //指向求和数组的末尾位置
        int index3=max;
        //当没有指向任意数组首部时，对应位置相加填充到求和数组中
        while (index1>=0 && index2>=0){
            res[index3--]=num[index1]+arr[index2];
            index1--;
            index2--;
        }
        //当指针没有指向数组一首部时，将对应位置数字直接添进求和数组
        while (index1>=0){
            res[index3--]=num[index1--];
        }
        //当指针没有指向数组一首部时，将对应位置数字直接添进求和数组
        while (index2>=0){
            res[index3--]=arr[index2--];
        }
        //处理求和数组，进位求余
        for (int i = max; i >=1 ; i--) {
            res[i-1]+=res[i]/10;
            res[i]%=10;
        }
        //存放结果的数组，根据首位是否为0，添加结果
        List<Integer> list=new ArrayList<>();
        if (res[0]==0){
            for (int i = 1; i <= max; i++) {
                list.add(res[i]);
            }
        }
        else {
            for (int i = 0; i <= max; i++) {
                list.add(res[i]);
            }
        }
        //返回数组
        return list;
    }
}
