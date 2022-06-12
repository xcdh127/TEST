package Tesla;

import java.util.HashMap;
import java.util.Map;

class Test1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n=A.length;
        //记录窗口的最大长度
        int maxLen=0;
        //左窗口
        int i=0;
        //右窗口
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            map.put(A[j],map.getOrDefault(A[j],0)+1);
            while(map.size()>2){
                map.put(A[i],map.get(A[i])-1);
                //如果数字个数减为0，就删除键
                if(map.get(A[i])==0){
                    map.remove(A[i]);
                }
                i++;
            }
            maxLen=Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }
}
