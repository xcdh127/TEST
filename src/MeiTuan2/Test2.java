package MeiTuan2;

import java.util.Scanner;

public class Test2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n=Integer.parseInt(sc.nextLine());
            String[] line=sc.nextLine().split(" ");
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(line[i]);
            }
            int total=0;
            for(int i=0;i<n;i++) {
                int j = i;
                int mutil = 1;
                while (j < n) {
                    mutil *= arr[j];
                    if (mutil > 0) {
                        total++;
                    }
                    j++;
                }
            }
            System.out.println(total);
        }


}
