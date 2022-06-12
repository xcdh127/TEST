package Leetcode;
/*给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
*/
public class Test261 {
    public int countOdds(int low, int high) {
       if (low%2==1){
           --low;
       }
       if (high%2==1){
           ++high;
       }
       return (high-low)/2;
    }
}


/*class Solution {
    public int countOdds(int low, int high) {
        if(low % 2 == 1){
            --low;
        }
        if(high % 2 == 1){
            ++high;
        }
        return (high - low) / 2;
    }
}*/