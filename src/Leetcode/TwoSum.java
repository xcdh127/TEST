package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*设计一个接收整数流的数据结构，
该数据结构支持检查是否存在两数之和等于特定值。

实现 TwoSum 类：
TwoSum() 使用空数组初始化 TwoSum 对象
void add(int number) 向数据结构添加一个数 number
boolean find(int value) 寻找数据结构中是否存在一对整数，
使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
*/
public class TwoSum {
    //存放数字以及当前数字出现次数的map
    Map<Integer,Integer> map;
    public TwoSum() {
        //初始化这个map
        map=new HashMap<>();
    }
    public void add(int number) {
        //向map中添加一个数字number,将map中的number个数+1
        map.put(number,map.getOrDefault(number,0)+1);
    }
    /*
["TwoSum","add","add","add","find"]
     [[],[0],[-1],[1],[0]]*/
    public boolean find(int value) {
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            //当前map中的存在value-键值的数值
            //直接返回true
            //当num值等于目标值-当前键值对的键值
            int num=value-entry.getKey();
            //当值等于目标和-当前键值对的键值 等于当前键值
            if (num!=entry.getKey()){
                //如果map中有num时，就返回true
                if (map.containsKey(num)){
                    return true;
                }
            }
            else{
                //当前的entry的值大于1时，返回true
                //当存在至少两个值为value-当前键值对的键值时，返回true
                if(entry.getValue()>1){
                    return true;
                }
            }
        }
        //如果map中没有两个数字之和等于value就返回false
        return false;
    }
}



/*
class TwoSum {
    private HashMap<Integer, Integer> num_counts;


    public TwoSum() {
        this.num_counts = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        if (this.num_counts.containsKey(number))
            this.num_counts.replace(number, this.num_counts.get(number) + 1);
        else
            this.num_counts.put(number, 1);
    }


    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : this.num_counts.entrySet()) {
            int complement = value - entry.getKey();
            if (complement != entry.getKey()) {
                if (this.num_counts.containsKey(complement))
                    return true;
            } else {
                if (entry.getValue() > 1)
                    return true;
            }
        }
        return false;
    }
}
*/
