package codeTop;

import java.util.HashMap;
import java.util.Map;

/*请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]
解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
提示：
1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 105
最多调用 2 * 105 次 get 和 put
*/
public class Test146LRU {

}

class LRUCache {
    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer ,ListNode> map;
    public static final class ListNode{
        //键
        int key;
        //值
        int value;
        //前驱节点
        ListNode prev;
        //后继节点
        ListNode next;

        public ListNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new ListNode(-1,-1);
        tail=new ListNode(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        ListNode node=map.get(key);
        moveToTail(node,node.value);
        return node.value;

    }

    public void put(int key, int value) {
        //当key存在时
        if (map.containsKey(key)){
            ListNode node=map.get(key);
            moveToTail(node,value);
        }
        //key不存在时
        else {
            ListNode node =new ListNode(key,value);
            //如果容量大于最大值时,删掉头节点后的节点
            if (map.size()>=capacity){
                ListNode toBeDelete=head.next;
                deleteNode(toBeDelete);
                map.remove(toBeDelete.key);
            }
            insertToTail(node);
            map.put(key,node);
        }
    }
    public void deleteNode(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertToTail(ListNode node){
        tail.prev.next=node;
        node.prev=tail.prev;
        node.next=tail;
        tail.prev=node;
    }
    public void moveToTail(ListNode node,int newValue){
        deleteNode(node);
        node.value=newValue;
        insertToTail(node);
    }
}
