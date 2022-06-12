package shapi;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(func(8888));
    }
    public static int func(int x){
        int count=0;
        while(x>0){
            count++;
            x=x&(x-1);
        }
        return count;
    }
}
