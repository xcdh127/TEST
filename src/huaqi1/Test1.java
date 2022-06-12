package huaqi1;

public class Test1 {
    public static void main(String[] args) {
        int n=10;
        int count=0;
        for(int i=0;i<=n;i++){
            for(int j=n;j>i;j--){
                count++;
            }

        }
        System.out.println(count);
    }
}
