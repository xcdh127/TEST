package Shiyuangufen;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        int[] arr={1,2,2,2,3,3,3,4};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr){
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()==entry.getValue()){
                if(max<entry.getKey()){
                    max=entry.getKey();
                }
            }
        }
        return max;
    }
}
