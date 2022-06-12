import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        while(sc.hasNext()){
            int n=Integer.parseInt(sc.nextLine());
            int[] arr=new int[n];
            String[] line=sc.nextLine().split(" ");
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(line[i]);
            }
            int nengLiang=0;
            int maxValue=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]){
                        nengLiang++;
                    }
                    else if(arr[j]>arr[i]){
                        nengLiang--;
                    }

                }
                maxValue=Math.max(maxValue,nengLiang);
            }
            System.out.println(maxValue+" "+nengLiang);
        }
    }

}
