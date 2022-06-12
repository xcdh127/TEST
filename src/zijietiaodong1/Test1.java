package zijietiaodong1;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(foo());


    }
    public static int foo() {
        try {
            throw new RuntimeException("Error");
//            return 0;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }


}


