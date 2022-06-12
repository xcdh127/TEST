package Test;

import java.util.PriorityQueue;

public class Main10 {

    public static void main(String[] args) {
        int[] nums=new int[]{5,3,4,5};
        Solution.stoneGame(nums);
    }



}

 class Solution {
    public static boolean stoneGame(int[] piles) {
        int n=piles.length;
        int sumA=0;
        int sumB=0;
        PriorityQueue<Integer> maxHeap1=new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> maxHeap2=new PriorityQueue<>((a,b)->(b-a));
        for(int i=0;i<n/2;i++){
            maxHeap1.offer(piles[i]);
        }
        for(int j=n/2;j<n;j++){
            maxHeap2.offer(piles[j]);
        }
        boolean flag=true;
        while(!maxHeap1.isEmpty() && !maxHeap2.isEmpty()){
            int num1=maxHeap1.peek();
            int num2=maxHeap2.peek();
            if(num1>=num2 && flag){
                sumA+=maxHeap1.poll();
            }
            else if(num1>=num2 && !flag){
                sumB+=maxHeap1.poll();
            }
            else if(num1<num2 && flag){
                sumA+=maxHeap1.poll();
            }
            else if(num1<num2 && !flag){
                sumB+=maxHeap2.poll();
            }
        }
        return sumA>sumB+maxHeap2.poll();


    }
}