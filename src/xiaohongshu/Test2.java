package xiaohongshu;

import java.lang.reflect.Array;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int N=Integer.parseInt(line1[0]);
        int K=Integer.parseInt(line1[1]);
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<Integer> subset=new LinkedList<>();
        recur(res,subset,arr,0,K);
        int totalDif=Integer.MIN_VALUE;
        for(List<Integer> list:res){
            int dif=Integer.MAX_VALUE;
            Collections.sort(list);
            for(int i=1;i<list.size();i++){
                dif=Math.min(dif,list.get(i)-list.get(i-1));
            }
            totalDif=Math.max(totalDif,dif);
        }
        System.out.println(totalDif);

    }

    public static void recur(List<List<Integer>> res,LinkedList<Integer> subset,int[] arr, int index,int K){
        if(index==arr.length){
            return ;
        }
        if(subset.size()==K){
            res.add(new LinkedList<>(subset));
            return;
        }
        recur(res,subset,arr,index+1,K);
        subset.add(arr[index]);
        recur(res,subset,arr,index+1,K);
        subset.removeLast();
    }

}
