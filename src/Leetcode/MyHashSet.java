package Leetcode;

import java.util.Arrays;

/*不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
实现 MyHashSet 类：
void add(key) 向哈希集合中插入值 key 。
bool contains(key) 返回哈希集合中是否存在这个值 key 。
void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
*/
class MyHashSet {
    int[] arr;
    public MyHashSet() {
        //初始化一个数组
        arr=new int[1000009];
        //将数组填充-1
        Arrays.fill(arr,-1);
    }

    public void add(int key) {
        //将当前的值赋值在数组的key位置
        arr[key]=key;
    }

    public void remove(int key) {
        //将数组key位置的值赋值为-1，表示将这个值从数组中删除
        arr[key]=-1;
    }

    public boolean contains(int key) {
        //如果数组key位置值为-1，则表示这个值不存在于hash中
        if (arr[key]==-1){
            return false;
        }
        //否则这个key位置上有值，返回true
        else {
            return true;
        }
    }
}
