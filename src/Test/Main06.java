package Test;

public class Main06 {

    public static void main(String[] args) {
        System.out.println(multiply("9133", "0"));
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m=num1.length();
        int n=num2.length();
        int[] arr=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int a=num1.charAt(i)-'0';
                int b=num2.charAt(j)-'0';
                arr[i+j+1]+=a*b;
            }
        }
        for(int i=m+n-1;i>=1;i--){
            arr[i-1]+=arr[i]/10;
            arr[i]=arr[i]%10;
        }
        int k;
        if(arr[0]==0){
            k=1;
        }else{
            k=0;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=k;i<m+n;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
