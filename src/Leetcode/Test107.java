package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*
在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，
判断这个机器人在完成移动后是否在 (0, 0) 处结束。
移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。
机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，
“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
*/
public class Test107 {
    public boolean judgeCircle(String moves) {
        //记录字符对应的坐标变化
        Map<Character,int[]> map=new HashMap<>();
        //将向右操作对应的坐标变化(0,1)记录在map中
        map.put('R',new int[]{0,1});
        //将向左操作对应的坐标变化(0,-1)记录到map中
        map.put('L',new int[]{0,-1});
        //将向上操作对应的坐标变化(-1,0)记录到map中
        map.put('U',new int[]{-1,0});
        //将向下操作对应的坐标变化(1,0)记录到map中
        map.put('D',new int[]{1,0});
        //初始坐标
        int[] init=new int[]{0,0};
        //遍历字符串，按照规则操作坐标
        for (int i = 0; i < moves.length(); i++) {
            //获得变化的坐标
            int[] change=map.get(moves.charAt(i));
            //取到行修改
            int row=change[0];
            //取得列修改
            int col=change[1];
            //修改坐标
            init[0]=init[0]+row;
            init[1]=init[1]+col;
        }
        //最后如果能够返回原点就返回true否则就返回false
        return  init[0]==0 && init[1]==0;
    }
}
