package MeiTuan2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        String[] line1=sc.nextLine().split(" ");
        int[] arr=new int[m];
        for(int i=0;i<m;i++){
            arr[i]=Integer.parseInt(line1[i])-1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<Map.Entry<Integer,Integer>>((a, b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            minHeap.offer(entry);
        }
        System.out.println(minHeap.peek().getValue());


    }
}
