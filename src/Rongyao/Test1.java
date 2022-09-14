package Rongyao;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 2) {
            System.out.println(4);
        }
        Random r = new Random();
        int i = r.nextInt(1000);
    }
}
