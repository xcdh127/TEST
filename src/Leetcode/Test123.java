package Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
*/
/*输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
输出："Sao Paulo"
解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。
本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
*/
public class Test123 {
    public String destCity(List<List<String>> paths) {
        //统计每一个路径的出度
        Map<String,Integer> map=new HashMap<>();
        //遍历所有的路径
        for (List<String> list :paths) {
            //始发地没出现一次就+1
            map.put(list.get(0),map.getOrDefault(list.get(0),0)+1);
            //目的地出现只加入到mao，但是此时不进行+1
            map.put(list.get(1),map.getOrDefault(list.get(1),0));

        }
        //遍历map中的所有的键值对，当有出度为0的节点时，输出字符串，因为终点没有下一站
        for (Map.Entry<String, Integer> entry:map.entrySet()){
            if (entry.getValue()==0){
                return entry.getKey();
            }
        }
        return "";
    }

}
