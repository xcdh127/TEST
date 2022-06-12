package Leetcode;
/*欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
勇者背包内共有编号为 0 ~ 4 的五种食材，其中 materials[j] 表示第 j 种食材的数量。
通过这些食材可以制作若干料理，cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量，
而 attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y。
在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
*/
/*输入：materials = [3,2,4,1,2]
cookbooks = [[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]
attribute = [[3,2],[2,4],[7,6]]
limit = 5

输出：7

解释：
食材数量可以满足以下两种方案：
方案一：制作料理 0 和料理 1，可获得饱腹感 2+4、美味度 3+2
方案二：仅制作料理 2， 可饱腹感为 6、美味度为 7
因此在满足饱腹感的要求下，可获得最高美味度 7
*/
public class Test259 {
    int n;
    int max;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        n=cookbooks.length;
        max=-1;
        //从id为0的位置开始搜索，初始容量为0
        dfs(materials,cookbooks,attribute,limit,0,0);
        return max;
    }

    private void dfs(int[] materials,int[][] cookbooks,int[][] attribute,int limit,int capcity,int id){
        //饱食度小于等于0时，记录美味度的最大值
        if (limit<=0){
            max=Math.max(max,capcity);
        }
        //当所有的食材都遍历完毕，直接返回
        if (id==n){
            return;
        }
//        不选取当前元素，对下一个位置进行搜索
        dfs(materials,cookbooks,attribute,limit,capcity,id+1);

//        选取当前元素
        int m=materials.length;
//        对数组的深度拷贝
        int[] clone=materials.clone();
        for (int i = 0; i < m; i++) {
            //食材不够时，直接返回
            if (clone[i]<cookbooks[id][i]){
                return;
            }
        //当食材够用时，将当前食材减掉当前食物需要的食材数量
            clone[i]-=cookbooks[id][i];
        }
        //将此时的饱食感- 当前食物的饱食感
        limit-=attribute[id][1];
        //累加所选食物的美味度
        capcity+=attribute[id][0];
        //对下一个位置进行搜索
        dfs(clone,cookbooks,attribute,limit,capcity,id+1);
    }
}

/*class Solution {

  int n, max;

  public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
    n = cookbooks.length;
    max = -1;
    dfs(materials, cookbooks, attribute, limit, 0, 0);
    return max;
  }

  private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int capcity, int id) {
    if (limit <= 0) {
      max = Math.max(max, capcity);
    }
    if (id == n) return;
    //第一个分支为不考虑当前 id 的元素
    dfs(materials, cookbooks, attribute, limit, capcity, id + 1);
    int m = materials.length;
    int[] clone = materials.clone();
    for (int i = 0; i < m; i++) {
      //食材不够
      if (clone[i] < cookbooks[id][i]) return;
      clone[i] -= cookbooks[id][i];
    }
    limit -= attribute[id][1];
    capcity += attribute[id][0];
    //第二个分支为考虑当前 id 的元素
    dfs(clone, cookbooks, attribute, limit, capcity, id + 1);
  }
}
*/