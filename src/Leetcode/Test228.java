package Leetcode;
/*给定已经按 升序 排列、由不同整数组成的数组 arr，
返回满足 arr[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。

 */
public class Test228 {
    public int fixedPoint(int[] arr) {
        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==i){
                return i;
            }
        }
        return index;
    }
}
