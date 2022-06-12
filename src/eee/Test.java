package eee;

public class Test {
    public int add(int a,int b){
        try {
            return a+b;
        }
        catch (Exception e){
            System.out.println("catch");
        }
        finally {
            System.out.println("final");
        }
        return 0;
    }

    public static void main(String[] args) {
        Test t=new Test();
        System.out.println("和是："+t.add(9,34));
    }
}
