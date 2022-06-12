package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*给定一个  无重复元素 的 有序 整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
并且不存在属于某个范围但不属于 nums 的数字 x 。
列表中的每个区间范围 [a,b] 应该按如下格式输出：
"a->b" ，如果 a != b
"a" ，如果 a == b
*/
/*输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
*/
public class Test225 {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(arr));
    }
    public static List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        int index=0;
        List<String> res=new ArrayList<>();
        while (index<n){
            //记录区间最小数
            int low=index;
            index++;
            while (index<n && nums[index]==nums[index-1]+1){
                index++;
            }
            //记录区间最大数
            int high=index-1;
            //拼接区间
            StringBuilder sb=new StringBuilder(Integer.toString(nums[low]));
            //两个数字不相等在拼接后面字符串
            if (low<high){
                sb.append("->");
                sb.append(Integer.toString(nums[high]));
            }
            //将区间拼接到结果中
            res.add(sb.toString());
        }
        //返回结果
        return res;
    }
}
/*class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
*/
