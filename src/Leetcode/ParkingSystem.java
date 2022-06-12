package Leetcode;

import java.util.ArrayList;

/*请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，
每种尺寸分别有固定数目的车位。
请你实现 ParkingSystem 类：
ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
bool addCar(int carType) 检查是否有 carType 对应的停车位。 
carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。
一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，
请返回 false ，否则将该车停入车位并返回 true 。
*/
/*输入：
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
输出：
[null, true, true, false, false]
解释：
ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
*/
class ParkingSystem {
    //使用数组来存放撑场的大 中 小车辆停车位置
    int[] arr;
    public ParkingSystem(int big, int medium, int small) {
        arr=new int[3];
        //初始化值
        arr[0]=big;
        arr[1]=medium;
        arr[2]=small;
    }

    public boolean addCar(int carType) {
        //当数组中的当前种的车辆位置大于0时，可以停此类车辆
        //将车辆的个数-1，并且返回true
        if (arr[carType-1]>0){
            arr[carType-1]--;
            return true;
        }
        //否则听停车厂的此类型的车辆个数不足，返回false
        return false;
    }
}