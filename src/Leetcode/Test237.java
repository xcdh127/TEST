package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test237 {
    public List<Integer> transformArray(int[] arr) {
        List<Integer> list=new ArrayList<>();
        if (arr.length<=2){
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        boolean out;
        while (true){
            out=true;
            int temp=arr[0];
            for (int i = 1; i < arr.length-1; i++) {
                //比两边都小
                if (arr[i]<temp && arr[i]<arr[i+1]){
                    temp=arr[i];
                    arr[i]++;
                    out=false;
                }
                //比两边都大
                else if (arr[i]>temp && arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i]--;
                    out=false;
                }
                //不是极值
                else {
                    temp=arr[i];
                }
            }
            //当无法修改时，跳出循环
            if (out){
                break;
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
/*class Solution {
    public List<Integer> transformArray(int[] arr) {
      List<Integer> list = new ArrayList<>(arr.length);
        if (arr.length <= 2) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        boolean out = true;
        while (1 == 1) {
            out = true;
            int temp = arr[0];
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < temp && arr[i] < arr[i + 1]) {
                    temp = arr[i];
                    arr[i]++;
                    out = false;
                } else if (arr[i] >temp && arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i]--;
                    out = false;
                }else{
                     temp = arr[i];
                }

            }
            if (out) {
                break;
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
*/