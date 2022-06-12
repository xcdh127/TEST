package Leetcode;

import java.util.List;
/*给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
ruleKey == "type" 且 ruleValue == typei 。
ruleKey == "color" 且 ruleValue == colori 。
ruleKey == "name" 且 ruleValue == namei 。
统计并返回 匹配检索规则的物品数量 。
*/
/*
输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],
["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
输出：1
解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
*/
public class Test135 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        //统计符合要求的字符串
        int count=0;
        //遍历所有的物品
        for (List<String> item:items) {
            //当ruleKey等于type  并且  ruleValue等于typei时，将符合条件的物品数+1
            if (ruleKey.equals("type") && ruleValue.equals(item.get(0))){
                count++;
            }
            //当ruleKey等于color  并且  ruleValue等于typei时，将符合条件的物品数+1
            else if (ruleKey.equals("color") && ruleValue.equals(item.get(1))){
                count++;
            }
            //当ruleKey等于name  并且  ruleValue等于typei时，将符合条件的物品数+1
            else if (ruleKey.equals("name") && ruleValue.equals(item.get(2))){
                count++;
            }
        }
        //返回最后符合要求的物品的数量
        return count;
    }
}
