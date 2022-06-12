package XieCheng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] arr=new int[n];
        String[] line=sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(line[i]);
        }
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<Integer> subset=new LinkedList<>();
        res=recur(res,arr,0,subset);
        int count=0;
        for(List<Integer> list:res){
            int mutil=1;
            if(list.size()==0){
                continue;
            }
            for(int num : list){
                mutil*=num;
            }
            for(int i=2;i<=Math.sqrt(mutil);i++){
                if(mutil%i==0){
                    while(mutil%i==0){
                        mutil=mutil/i;
                    }
                    count=(count+1)%1000000007;
                }
            }
            if(mutil!=1){
                count=(count+1)%1000000007;
            }
        }
        System.out.println(count);
    }
    public static boolean isZhiShu(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static List<List<Integer>> recur(List<List<Integer>> res,int[] arr, int index, LinkedList<Integer> subset){
        int n=arr.length;
        if(index==n){
            res.add(new LinkedList<>(subset));
        }
        else{
            recur(res,arr,index+1,subset);
            subset.add(arr[index]);
            recur(res,arr,index+1,subset);
            subset.removeLast();
        }
        return res;
    }
}
