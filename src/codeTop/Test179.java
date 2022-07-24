package codeTop;
/*给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
示例 1：
输入：nums = [10,2]
输出："210"
示例2：
输入：nums = [3,30,34,5,9]
输出："9534330"
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 109
*/
public class Test179 {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String[] str=new String[n];
        for (int i = 0; i < n; i++) {
            str[i]=String.valueOf(nums[i]);
        }
        //快速排序
        quickSort(str,0,n-1);
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //将结果都拼接在字符串中
        for (String s :str) {
            sb.append(s);
        }
        //当字符串的长度大于1，并且字符串的首尾字符是'0'时，删除首位的字符'0'
        //确保输出的字符为0时，去掉前导0
        while (sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public void quickSort(String[] nums,int l,int r){
        //l大于r时
        if (l>r){
            return;
        }
        //i=l时
        int i=l;
        //j=r时
        int j=r;
        //p=l时
        int p=l;
        //当i<j时
        while (i<j){
            //j大于等于p时，j--
            while (i<j && (nums[j]+nums[p]).compareTo(nums[p]+nums[j])<=0){
                j--;
            }
            //i小于等于p时，i++
            while (i<j && (nums[i]+nums[p]).compareTo(nums[p]+nums[i])>=0){
                i++;
            }
            //交换i与j
            swap(nums,i,j);
        }
        //p=i时
        p=i;
        //交换数组中p与l位置的值
        swap(nums,p,l);
        //快速排序前半部分数组
        quickSort(nums,l,p-1);
        //快速排序后半部分数组
        quickSort(nums,p+1,r);
    }
    //交换数组中的两个元素
    public void swap(String[] str,int a,int b){
        String temp=str[a];
        str[a]=str[b];
        str[b]=temp;
    }
}
