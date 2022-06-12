package dewu;
import java.util.*;
public class Test2 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          String[] line=sc.nextLine().split(",");
          String s1=line[0];
          String substring=s1.substring(1,s1.length());
        System.out.println(substring);
//[[0,0,1,1],[1,0,1,0],[0,0,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
//        int[][] arr=new int[4][4];
//        String[] line2=line1[0].split(",");
//        int start1=line2[0].lastIndexOf("[");
//        int end1=line2[0].lastIndexOf("]");
//        String[] sub1=line2[0].substring(start1+1,end1).split(",");
//        for(int i=0;i<4;i++){
//            arr[0][i]=Integer.parseInt(sub1[i]);
//        }
//        int start2=line2[1].lastIndexOf("[");
//        int end2=line2[1].lastIndexOf("]");
//        String[] sub2=line2[1].substring(start2+1,end2).split(",");
//        for(int i=0;i<4;i++){
//            arr[1][i]=Integer.parseInt(sub2[i]);
//        }
//        int start3=line2[2].lastIndexOf("[");
//        int end3=line2[2].lastIndexOf("]");
//        String[] sub3=line2[2].substring(start3+1,end3).split(",");
//        for(int i=0;i<4;i++){
//            arr[2][i]=Integer.parseInt(sub3[i]);
//        }
//        int start4=line2[3].lastIndexOf("[");
//        int end4=line2[3].lastIndexOf("]");
//        String[] sub4=line2[3].substring(start4+1,end4).split(",");
//        for(int i=0;i<4;i++){
//            arr[3][i]=Integer.parseInt(sub4[i]);
//        }
//
//        int[][] change=new int[3][2];
//        String[] line3=line1[1].split(",");
//        int start5=line3[0].lastIndexOf("[");
//        int end5=line3[0].lastIndexOf("]");
//        String[] sub5=line3[0].substring(start4+1,end4).split(",");
//        for(int i=0;i<2;i++){
//            change[0][i]=Integer.parseInt(sub5[i]);
//        }
//        int start6=line3[1].lastIndexOf("[");
//        int end6=line3[1].lastIndexOf("]");
//        String[] sub6=line3[1].substring(start4+1,end4).split(",");
//        for(int i=0;i<2;i++){
//            change[1][i]=Integer.parseInt(sub5[i]);
//        }
//        int start7=line3[2].lastIndexOf("[");
//        int end7=line3[2].lastIndexOf("]");
//        String[] sub7=line3[2].substring(start4+1,end4).split(",");
//        for(int i=0;i<2;i++){
//            change[2][i]=Integer.parseInt(sub5[i]);
//        }
//        int[][] arr=new int[][]{{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
//        int[][] change=new int[][]{{2,2},{3,3},{4,4}};
//        for(int i=0;i<3;i++){
//                change(arr,change[i][0]-1,change[i][1]-1);
//        }
//
//        for (int i = 0; i <4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//
//        }
//    }
//    public static void change(int[][] arr,int i,int j){
//        int m=arr.length;
//        int n=arr[0].length;
//        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
//        for(int[] dir: dirs){
//            int row=dir[0]+i;
//            int col=dir[1]+j;
//            if(row<0 || row>=m || col<0 || col>=n){
//                continue;
//            }
//            if(arr[row][col]==0){
//                arr[row][col]=1;
//            }
//            else{
//                arr[row][col]=0;
//            }
//        }
    }

}
