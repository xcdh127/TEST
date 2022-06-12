package TTT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test6 {
/*给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。

对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。

在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。

实现 TopVotedCandidate 类：

TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
*/
    //记录投票时间和候选人的编号
    static List<int[]> list=new ArrayList<>();
    public Test6(int[] persons, int[] times) {
        //存放候选人编号以及投票数
        Map<Integer,Integer> map=new HashMap<>();
        //记录最大投票数
        int valMax=0;
        for(int i=0;i<persons.length;i++){
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);
            //更新最大投票数
            if(map.get(persons[i])>=valMax){
                valMax=map.get(persons[i]);
                list.add(new int[]{times[i],persons[i]});
            }
        }


    }

    public static int q(int t) {
        int l=0;
        int r=list.size()-1;
        int res=-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(list.get(m)[0]<=t){

                l=m;
                res=l;
            }
            else{
                r=m-1;
            }
        }
        return list.get(res)[0]<=t?list.get(res)[1]:0;
    }
}
