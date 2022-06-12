package Leetcode;
/*给定一个 n x n 的二进制矩阵 image ，先 水平 翻转图像，然后 反转 图像并返回 结果 。
水平翻转图片就是将图片的每一行都进行翻转，即逆序。
例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。
反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
例如，反转 [0,1,1] 的结果是 [1,0,0]。
*/

/*输入：image = [[1,1,0],[1,0,1],[0,0,0]]
输出：[[1,0,0],[0,1,0],[1,1,1]]
解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
*/
/*[[1,1,0],
   [1,0,1],
   [0,0,0]]*/
public class Test183 {
    public int[][] flipAndInvertImage(int[][] image) {
        //获取数组的长度
        int n=image.length;
        for (int i = 0; i < n; i++) {
            //将矩阵中的数字按照行反转
            swapArr(image,i);
        }
        //将矩阵中的数字反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //将数组中的数字反转
                if (image[i][j]==0){
                    image[i][j]=1;
                }
                else {
                    image[i][j]=0;
                }
            }
        }
        //返回修改后的矩阵
        return image;
    }

    public void swapArr(int[][] image,int index){
        //拿到矩阵的长度
        int n=image.length;
        //定义一个指针指向数组这一行的开头
        int i=0;
        //定义一个指针指向数组这一行的末尾
        int j=n-1;
        //当此行的两个指针没有相撞时，交换此行数字两个指针位置上的数字
        while (i<j){
            int temp=image[index][i];
            image[index][i]=image[index][j];
            image[index][j]=temp;
            //i指针向里指向
            i++;
            //j指针向外指向
            j--;
        }
    }
}
