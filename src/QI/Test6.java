package QI;

public class Test6 {
    public static void main(String[] args) {
        try {
            double x=64.0;
            double y=0.0;
            System.out.println(x%y==x%y);
        }
        catch (Exception e){
            System.out.println("Exception");
        }
    }
}
