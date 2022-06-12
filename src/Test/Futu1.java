package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Futu1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int k=Integer.parseInt(line[1]);
        List<Integer> list=new ArrayList<>();
        String[] res=sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(res[i]));
        }
        int sum=0;
        for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    if(list.get(i)+list.get(j)==k){
                        list.remove(list.get(j));
                        sum++;
                    }
                }
            }
        System.out.println(sum);
    }
}
