package JianZHiOffer;
/*在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
示例 1：
输入：nums = [3,4,3,3]
输出：4
示例 2：
输入：nums = [9,1,7,9,7,9,7]
输出：1
限制：
1 <= nums.length <= 10000
1 <= nums[i] < 2^31
*/
public class Test59 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 3, 1, 1}));
    }

    public static int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                arr[i] += (num >> i) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            arr[i] %= 3;
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= arr[i];
        }
        return res;
    }
}
/*class Solution {
    public int singleNumber(int[] nums) {
    	int[] arr=new int[32];
    	for(int num : nums){
    		for(int i=0;i<32;i++){
    			arr[i]+=(num>>i)&1;
    		}
    	}

    	for(int i=0;i<32;i++){
    		arr[i]%=3;
    	}

    	int res=0;

    	for(int i=31;i>=0;i--){

    		res<<=1;
    		res|=arr[i]&1;
    	}
    	return res;
    }
}*/