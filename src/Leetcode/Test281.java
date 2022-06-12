package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。
图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。
每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。
给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。
*/
/*输入：n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
输出：true
解释：存在由顶点 0 到顶点 2 的路径:
- 0 → 1 → 2
- 0 → 2

输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
输出：false
解释：不存在由顶点 0 到顶点 5 的路径.
*/
public class Test281 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i <n; i++) {
            map.put(i,new ArrayList<>());
        }
        //建立邻接表
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        if(source==destination){
            return true;
        }

        boolean[] isUsed=new boolean[n];
        boolean flag = dfs(map, isUsed, source, destination);
        return flag;
    }

    public boolean dfs(Map<Integer,List<Integer>> map,boolean[] isUsed,int source,int destination){

        //如果源地址通往的目的地址包含了结果地址，返回true
        if (map.get(source).contains(destination)){
            return true;
        }
        //如果不包含，且没有访问过
        if (!isUsed[source]){
            //标记为访问过
            isUsed[source]=true;
            //获取所有的目的地址
            for (int i = 0; i < map.get(source).size(); i++) {
                //判断目的地址是否访问过，并且深度优先搜索这些地址，是否包含结果地址，若包含返回true
                if (dfs(map,isUsed,map.get(source).get(i),destination)){
                    return true;
                }
            }
        }
        //不包含，返回false
        return false;
    }
}


/*class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i,new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        if(source==destination){
            return true;
        }
        boolean used[]  = new boolean[n];
        return dfs(map,used,source,destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, boolean used[], int source, int destination){
        if(map.get(source).contains(destination)){
            return true;
        }
        if(!used[source]){
            used[source] = true;
            for (int i = 0; i < map.get(source).size(); i++) {
                    if(dfs(map,used,map.get(source).get(i),destination)){
                        return true;
                    }
            }
        }
        return false;
    }
}
*/
