package QI;

public class Test2 {
    public static void main(String[] args) {
        int[] refToArray={10,11};
        int var=1;
        refToArray[var-1]=var=2;
        System.out.println(refToArray[0]+" "+refToArray[1]);
    }
}
