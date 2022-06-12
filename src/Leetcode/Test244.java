package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。
如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。*/
public class Test244 {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i]==1) {
                list.add(i);
            }
        }
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i+1)-list.get(i)-1<k){
                return false;
            }
        }
        return true;
    }
}
