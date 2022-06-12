package Leetcode;

public class Test1 {
    public static void main(String[] args) {
        int[] score=new int[]{5,4,3,2,1};
        int temp=score[0];
        for(int index=1;index<5;index++){
            if(score[index]<temp){
                temp=score[index];
            }
        }
        System.out.println(temp);
    }
}
