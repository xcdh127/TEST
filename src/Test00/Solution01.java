package Test00;

import java.util.*;

public class Solution01 {

}
/*实现RandomizedSet 类：

RandomizedSet() 初始化 RandomizedSet 对象
bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
*/
//插入删除都是O(1)的结构
class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    //将数字作为键，在数组中的下标作为值存放到map中
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        //拿到map中val的下标
        int index=map.get(val);
        int lastpos=list.get(list.size()-1);
        map.put(lastpos,index);
        list.set(index,lastpos);
        //进行删除操作
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        int size=list.size();
        Random random=new Random();
        int nextInt=random.nextInt(size);
        return list.get(nextInt);
    }
    /*class RandomizedSet {

        Map<Integer,Integer> map;
        List<Integer> list;
        public RandomizedSet() {

            map=new HashMap<Integer,Integer>();
            list=new ArrayList<Integer>();
        }

        public boolean insert(int val) {

            if(map.containsKey(val)){
                return false;
            }

            map.put(val,list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {

            if(!map.containsKey(val)){
                return false;
            }

            int index=map.get(val);
            map.put(list.get(list.size()-1),index);
            list.set(index,list.get(list.size()-1));
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }

        public int getRandom() {

            Random random=new Random();
            int index=random.nextInt(list.size());
            return list.get(index);
        }*/
    }
