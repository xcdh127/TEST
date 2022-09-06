package CodeTop02;

import java.util.HashMap;
import java.util.Map;

public class Test146 {
}

/*请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
则应该 逐出 最久未使用的关键字。
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
class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        //容量
        this.capacity = capacity;
        //头节点
        head = new ListNode(-1, -1);
        //尾节点
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //存在key值，获取节点
        ListNode node = map.get(key);
        //移动到双向链表的末尾
        moveToTail(node, node.value);
        //返回节点的值
        return node.value;
    }

    public void put(int key, int value) {
        //如果key值已经存在，将节点赋上新值移动到链表的末尾
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToTail(node, value);
        }
        //key值不存在，新建node节点
        else {
            ListNode node = new ListNode(key, value);
            //如果缓存容量大于最大值时
            if (map.size() >= capacity) {
                //取到最久未使用到的节点待删除
                ListNode toBeDelete = head.next;
                //删除待删除的节点
                deleteNode(toBeDelete);
                //将节点从map中删除
                map.remove(toBeDelete.key);
            }
            //将新节点插入到链表中
            insertToTail(node);
            //将节点放进map中
            map.put(key, node);
        }
    }

    //删除一个节点
    public void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //将节点插入到尾部
    public void insertToTail(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    //将链表移动到尾部
    public void moveToTail(ListNode node, int newValue) {
        //删除node节点
        deleteNode(node);
        //将node值更新为新值
        node.value = newValue;
        //将node节点插入到链表的尾部
        insertToTail(node);
    }

    private static final class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */