package huyu1;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        int[] R=new int[]{1,2,1,3,2};
        int N=3;
        System.out.println(count(R, N));


    }
    public static int count (int[] R, int N) {
        // write code here
        Random r=new Random();
        int num = r.nextInt(100);

        return num;
    }
}
