package TTT;

import java.util.PriorityQueue;

public class A {
    public static void main(String[] args) {
        int[][] A={{6,4}};
        int[][] B={{2,8}};
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->(b[0]-a[0]));
//        queue.offer(A);
//        queue.offer(B);
        System.out.println();
    }
}
