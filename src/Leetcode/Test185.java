package Leetcode;
/*实验室里正在进行一项实验。为了确保数据的准确性，同时使用 两个 传感器来采集数据。
您将获得2个数组 sensor1 and sensor2，其中 sensor1[i] 和 sensor2[i] 分别是两个传感器对第 i 个数据点采集到的数据。
但是，这种类型的传感器有可能存在缺陷，它会导致 某一个 数据点采集的数据（掉落值）被丢弃。
数据被丢弃后，所有在其右侧的数据点采集的数据，都会被向左移动一个位置，
最后一个数据点采集的数据会被一些随机值替换。可以保证此随机值不等于掉落值。
举个例子, 如果正确的数据是 [1,2,3,4,5] ， 此时 3 被丢弃了,
传感器会返回 [1,2,4,5,7] (最后的位置可以是任何值, 不仅仅是 7).
可以确定的是，最多有一个 传感器有缺陷。请返回这个有缺陷的传感器的编号 （1 或 2）。
如果任一传感器 没有缺陷 ，或者 无法 确定有缺陷的传感器，则返回 -1 。
*/
/*输入：sensor1 = [2,3,4,5], sensor2 = [2,1,3,4]
输出：1
解释：传感器 2 返回了所有正确的数据.
传感器2对第二个数据点采集的数据，被传感器1丢弃了，传感器1返回的最后一个数据被替换为 5 。
*/
public class Test185 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        //记录结果
        int res=-1;
        //比较两个数组的指针
        int index=0;
        //遍历两个数组，当遇到不相等的数字时跳出循环（数组的最后一位不需要进行比较）
        for ( ;index < sensor1.length-1; index++) {
            if (sensor1[index]!=sensor2[index]) break;
        }
        //如果此时指针的位置已经指向了数组的末尾，说明此时数组中是不存在换掉的数据的，将返回-1
        if (index==sensor1.length-1){
            return res;
        }
        //检查这个坏掉的传感器是不是传感器1
        boolean bad1=badSensor(sensor1,sensor2,index);
        //检查这个坏掉的传感器是不是传感器2
        boolean bad2=badSensor(sensor2,sensor1,index);
        //根据布尔值判断两个传感器那个坏掉了
        //就返回-1
        if (bad1 && bad2){
            return -1;
        }
        //如果是传感器1出现错误，就返回1
        else if (bad1){
            return 1;
        }
        //如果是传感器2出现错误就返回2
        return 2;
    }

    //判断当前是否存在坏掉的传感器
    //将前一个数组中元素与后一个数组中的当前指针后一个指针位置进行比较
    //如果不相等就返回false
    public boolean badSensor(int[] arr1,int[] arr2,int index){
        //从index位置开始检查两个数组相邻差一位置数字的值是否相等
        for (; index < arr2.length-1; index++) {
            //如果有两个位置上的数字对应不相等，就返回false
            if (arr1[index]!=arr2[index+1])return false;
        }
        //如果所有位置上的数字都对应相等就返回true
        return true;
    }
}

/*class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int rst = -1;
        int index = 0;
        for ( ; index < sensor1.length - 1; index++) {
            if (sensor1[index] != sensor2[index]) break;
        }
        // System.out.println(index + " " + sensor1.length);
        if (index == sensor1.length - 1) return rst;
        boolean bad1 = badS(sensor1, sensor2, index);
        boolean bad2 = badS(sensor2, sensor1, index);

        if (bad1 && bad2) {
            rst = -1;
        } else if (bad1) {
            rst = 1;
        } else if (bad2) {
            rst = 2;
        }

        return rst;
    }

    public boolean badS(int[] sensor1, int[] sensor2, int index) {
        for (; index < sensor2.length - 1; index++) {
            if (sensor1[index] != sensor2[index + 1]) return false;
        }
        return true;
    }
}
*/
