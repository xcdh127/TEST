package Test;
public class Main04{

    public static void main(String[] args) {
        System.out.println(subStrHash("xmmhdakfursinye", 96, 45, 15, 21));
    }
    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int[] arr=new int[26];
        for(int i=0;i<26;i++){
            arr[i]=i+1;
        }
        int n=s.length();
        for(int i=0;i<=n-k;i++){
            long res=0;
            String subStr=s.substring(i,i+k);
            long mi=1;
            for(int j=0;j<k;j++){
                res=(res+((arr[subStr.charAt(j)-'a']*mi)%modulo))%modulo;
                mi=(mi*power)%modulo;
            }
            if(res==hashValue){
                return subStr;
            }
        }
        return "";
    }
}


