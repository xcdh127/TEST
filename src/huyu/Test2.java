package huyu;

import java.util.Arrays;

public class Test2 {
    static int[] numArray={1,5,7,9,9,32,6,5,5,6,7,7};

    public static boolean isExistNum(int num){
        Arrays.sort(numArray);
       int n=numArray.length;
       int i=0;
       int j=n-1;
       while(i<=j){
           int m=(i+j)/2;
           if(numArray[m]<num){
               i=m+1;
           }
           else if(numArray[m]>num){
               j=m-1;
           }
           else{
               return true;
           }
       }
       return false;
    }


    public static void main(String[] args) {

        System.out.println(isExistNum(99));
    }
}
