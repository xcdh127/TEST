package JianZHiOffer;


import java.lang.String;
/*输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
示例 1:
输入: [10,2]
输出: "102"
示例 2:
输入: [3,30,34,5,9]
输出: "3033459"
提示:
0 < nums.length <= 100
说明:
输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
*/
public class Test45 {
    public String minNumber(int[] nums) {
        int n=nums.length;
        String[] str=new String[n];
        for (int i = 0; i < n; i++) {
            str[i]=String.valueOf(nums[i]);
        }
        quickSort(str,0,n-1);
        StringBuilder sb=new StringBuilder();
        for (String s :str) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void quickSort(String[] nums,int l,int r){
        if (l>=r)return;
        int p=l;
        int i=l;
        int j=r;
        while (i<j){
            //找到第一个（j+p）<(p+j)的j
            while (i<j && (nums[j]+nums[p]).compareTo(nums[p]+nums[j])>=0){
                j--;
            }
            //找到第一个（i+p）>(p+i)的i
            while (i<j && (nums[i]+nums[p]).compareTo(nums[p]+nums[i])<=0){
                i++;
            }
            //交换两者的位置
            swap(nums,i,j);
        }
        p=i;
        swap(nums,p,l);
        quickSort(nums,l,p-1);
        quickSort(nums,p+1,r);
    }

    public void swap(String[] str,int a,int b){
        String temp=str[a];
        str[a]=str[b];
        str[b]=temp;
    }
}



















