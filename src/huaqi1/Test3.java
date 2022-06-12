package huaqi1;

public class Test3 {
    public static void main(String[] args) {
        int[] nums1=new int[]{1};
        int m=1;
        int[] nums2=new int[]{};
        int n=0;
        System.out.println(merge(nums1, m, nums2, n));

    }

    public static String merge(int[] nums1,int m,int[] nums2,int n){
        int[] arr=new int[m+n];
        int i=0;
        int j=0;
        int cur;
        while(i<m || j<n){
            if(i==m){
                cur=nums2[j++];
            }
            else if(j==n){
                cur=nums1[i++];
            }
            else if(nums1[i]<=nums2[j]){
                cur=nums1[i++];
            }
            else {
                cur=nums2[j++];
            }
            arr[i+j-1]=cur;
        }
        StringBuilder sb=new StringBuilder();
        for(int k=0;k!=m+n;k++){
            nums1[k]=arr[k];
            sb.append(nums1[k]);
        }
        return sb.toString();
    }
}
