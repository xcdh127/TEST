package HaiKangweishi;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        twoSum(arr,8);
    }

    public static void twoSum(int[] arr,int k){
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(k-arr[i])){
                System.out.println(k-arr[i]+" "+arr[i]);
                break;
            }
            map.put(arr[i],i);
        }
    }
}
