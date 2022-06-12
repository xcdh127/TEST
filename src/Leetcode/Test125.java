package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，
分别表示向北、向南、向东、向西移动一个单位。
你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，
请返回 true ；否则，返回 false 。
*/
public class Test125 {
    public static void main(String[] args) {
        String s="NEEEEEEEEEENNNNNNNNNNWWWWWWWWWW";
        System.out.println(isPathCrossing(s));
    }
    public static boolean isPathCrossing(String path) {
        //用set存放之前走过的坐标（row+col）
        int[] point=new int[]{0,0};
        Set<String> set=new HashSet<>();
        //将当前横坐标和纵坐标拼成字符串，放进set中
        //为了防止出现坐标不同而拼接字符串相同的情况
        //将横纵坐标前添加特殊符号分割
        set.add(""+":"+point[0]+":"+point[1]);
        for (int i = 0; i < path.length(); i++) {
            char ch=path.charAt(i);
            if (ch=='N'){
                point[0]+=1;
            }
            else if (ch=='S'){
                point[0]-=1;
            }
            else if (ch=='W'){
                point[1]-=1;
            }
            else {
                point[1]+=1;
            }
            //根据当前坐标形成字符串
            String newPoint=""+":"+point[0]+":"+point[1];
            //如果之前存在这个字符串就返回true,说明曾经来过
            if (set.contains(newPoint)){
                return true;
            }
            //否则将这个坐标放进set中
            else {
                set.add(newPoint);
            }
        }
        //遍历所有的字符都没有故地重游，返回false
        return false;
    }
}
