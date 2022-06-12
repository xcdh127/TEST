package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test35 {
    public static void main(String[] args) {
        System.out.println(gcd(2, 3));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        //存放数组中出现的数字以及数字出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            //将字符出现次数存放进list数组中
            list.add(entry.getValue());
        }
        //看所有的字符出现次数是不是存在最大公约数，如果不存在，就不能分组
        for (int i = 0; i <list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (gcd(list.get(i),list.get(j))==1){
                    return false;
                }
            }
        }
        return true;
    }
    //求两个数字的最大公约数
    public static int gcd(int x, int y) {
        //当不为0时，用y对x取模->作为新的x
        //将原x作为y，直到x为0
        return x == 0 ? y : gcd(y % x, x);
    }

}
