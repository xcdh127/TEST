package Leetcode;

import java.util.Arrays;

/*给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，
并将其余的元素向右平移。
注意：请不要在超过该数组长度的位置写入元素。
要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
*/
/*输入：[1,0,2,3,0,4,5,0]
输出：null
解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]*/
public class Test184 {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        //定义指向原数组的指针
        int index=0;
        //拷贝一份原数组
        int[] copyOf = Arrays.copyOf(arr, n);
        //定义指新数组的指针
        int indexCopy=0;
        //当指针没有超出数组长度时
        while (index<n){
            //如果当前数字不是0时，指针向后移动，并且当前数字添加到原数组中
            if (index<n && copyOf[indexCopy]!=0){
                arr[index]=copyOf[indexCopy];
                indexCopy++;
                index++;
            }
            //如果当前数字是0时
            else {
                //将指向新数组的指针向后指向
                if (index<n)
                arr[index++]=0;
                if (index<n)
                arr[index++]=0;
                //将指向原数组中的指针先后移动一位
                indexCopy++;
            }
        }
    }
}
