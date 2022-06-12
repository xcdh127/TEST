package Leetcode;
/*小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
使用当前带宽下载插件
将带宽加倍（下载插件数量随之加倍）
请返回小扣完成下载 n 个插件最少需要多少分钟。
注意：实际的下载的插件数量可以超过 n 个
示例 1：
输入：n = 2
输出：2
解释：
以下两个方案，都能实现 2 分钟内下载 2 个插件
方案一：第一分钟带宽加倍，带宽可每分钟下载 2 个插件；第二分钟下载 2 个插件
方案二：第一分钟下载 1 个插件，第二分钟下载 1 个插件
示例 2：
输入：n = 4
输出：3
解释：
最少需要 3 分钟可完成 4 个插件的下载，以下是其中一种方案:
第一分钟带宽加倍，带宽可每分钟下载 2 个插件;
第二分钟下载 2 个插件;
第三分钟下载 2 个插件。
提示：
1 <= n <= 10^5
*/

/*贪心算法*/
public class Test290 {
    public int leastMinutes(int n) {
        int per=1;
        //记录操作次数
        int ans=0;
        while (n>0){
            //当前剩余插件数小于等于下载速度时才下载
            if (n<=per){
                ans+=1;
                n-=per;
            }
            //否则都进行速度的倍增操作
            else {
                ans+=1;
                //下载速度乘2倍
                per*=2;
            }
        }
        return ans;
    }
}


/*class Solution {
    public int leastMinutes(int n) {
        int per = 1;
        int ans = 0;
        while(n > 0){
            if(n <= per){
                ans += 1;
                n -= per;
            }else{
                ans += 1;
                per *= 2;
            }
        }
        return ans;
    }
}
*/
