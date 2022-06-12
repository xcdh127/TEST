package Leetcode;

import java.util.*;

/*给你一个不同学生的分数列表 items，其中 items[i] = [IDi, scorei]
表示 IDi 的学生的一科分数，你需要计算每个学生 最高的五科 成绩的 平均分。
返回答案 result 以数对数组形式给出，
其中 result[j] = [IDj, topFiveAveragej] 表示 IDj 的学生和他 最高的五科 成绩的 平均分。
result 需要按 IDj  递增的 顺序排列 。
学生 最高的五科 成绩的 平均分 的计算方法是将最高的五科分数相加，然后用 整数除法 除以 5 。
*/
public class Test66 {
    public int[][] highFive(int[][] items) {
        int n=items.length;
        //用map存放学生id以及成绩数组
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            //学生id
            int id=items[i][0];
            //分数
            int score=items[i][1];
            //如果这个学生已经创建，就拿出数组添加分数
            if (map.containsKey(id)){
                map.get(id).add(score);
            }
            //如果当前学生不存在，就将新建一个键值对，并放进分数
            else {
                map.put(id,new ArrayList<Integer>());
                map.get(id).add(score);
            }
        }
        //存放结果的数组
        List<int[]> res=new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            //学生id
            int id=entry.getKey();
            //分数条
            List<Integer> list=entry.getValue();
            //对分数条排序
            Collections.sort(list);
            //取后5条成绩求平均
            int avg=(list.get(list.size()-1)+list.get(list.size()-2)+list.get(list.size()-3)+
                    list.get(list.size()-4)+list.get(list.size()-5))/5;
            //以{学生id，平均分}的形式返回
            res.add(new int[]{id,avg});
        }
        //转成数组
        int[][] resArr=res.toArray(new int[res.size()][2]);
        //按照第一个字段排序
        Arrays.sort(resArr,(a,b)->(a[0]-b[0]));
        return resArr;
    }
}
