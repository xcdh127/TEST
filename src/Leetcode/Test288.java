package Leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，
但 B 不能向 A 传信息）。
每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 )
经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
示例 1：
输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
输出：3
解释：信息从小 A 编号 0 处开始，经 3 轮传递，
到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
示例 2：
输入：n = 3, relation = [[0,2],[2,1]], k = 2
输出：0
解释：信息不能从小 A 处经过 2 轮传递到编号 2
限制：
2 <= n <= 10
1 <= k <= 5
1 <= relation.length <= 90, 且 relation[i].length == 2
0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
*/
public class Test288 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        //从rel[0]可以到达的所有目的地都放到list中
        for (int[] rel:relation) {
            map.get(rel[0]).add(rel[1]);
        }

        return dfs(map,n,0,k);

    }

    public int dfs(Map<Integer,List<Integer>> map,int n,int index,int k){
        //当k==0并且当前是最后一个小萌友时，形成一种传递方式
        if (k==0 && index==n-1){
            return 1;
        }
        //当k==0，这个小萌友不是目标，形不成一种方式
        if (k==0){
            return 0;
        }
        //记录方式数
        int count=0;
        //获取小朋友能够到达的所有小萌友
        List<Integer> list = map.get(index);
        for (int next :list) {
            //方式数累加
            //传递给下一个小萌友，并且k减一
            count+=dfs(map,n,next,k-1);
        }
        return count;
    }
}


/*class Solution {
 public int numWays(int n, int[][] relation, int k) {
        int row=relation.length;
        int c=relation[0].length;
        HashMap<Integer,ArrayList<Integer>> hashMap=new HashMap<>();
        for (int i = 0; i <row ; i++) {
           if (hashMap.containsKey(relation[i][0])){
               ArrayList<Integer> arrayList = hashMap.get(relation[i][0]);
               arrayList.add(relation[i][1]);
               hashMap.put(relation[i][0],new ArrayList<>(arrayList));
           }else {
               ArrayList<Integer> arrayList=new ArrayList<>();
               arrayList.add(relation[i][1]);
               hashMap.put(relation[i][0],new ArrayList<>(arrayList));
           }
        }
        return  numWayDfs(n, hashMap, k, 0);
    }

    public int numWayDfs(int n,HashMap<Integer,ArrayList<Integer>> hashMap,int k,int cur){
        //cur为当前节点的值。
        if (k==0&&cur==n-1){
            return 1;
        }
        if (k==0){
            return 0;
        }
        int res=0;
        ArrayList<Integer> arrayList = hashMap.get(cur);
        if (arrayList==null){
            return 0;
        }  //!!!这个if不可以少，为什么有这个，看我文字部分。
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            res+=numWayDfs(n,hashMap,k-1,arrayList.get(i));
        }
        return res;
    }
}
*/