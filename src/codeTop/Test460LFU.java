package codeTop;

import java.util.HashMap;
import java.util.Map;

public class Test460LFU {
}
class LFUCache {
    class Node {
        int key;
        int value;
        //使用频次，默认为1次
        int freq = 1;
        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //自定义双向链表
    class DoublyLinkedList {
        Node head;
        Node tail;

        public DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            //头节点后面接尾节点
            head.next = tail;
            //尾节点前面连接头节点
            tail.prev = head;
        }

        //删除node节点
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //在head节点后面，添加node节点
        void addNode(Node node) {
            //node节点的下一个节点连接head节点的下一个节点
            node.next = head.next;
            //head节点的前一个节点的前一个节点是node
            head.next.prev = node;
            //head节点的下一个节点是node
            head.next = node;
            //node节点的下一个节点是head
            node.prev = head;
        }
    }
    Map<Integer, Node> cache; // 存储缓存的内容
    Map<Integer, DoublyLinkedList> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    //从缓存中获取元素
    public int get(int key) {
        //从缓存中获取这个key对应的节点
        Node node = cache.get(key);
        //当节点为空时，返回-1
        if (node == null) {
            return -1;
        }
        //将当前访问的节点的频次+1，即将当前节点，放到频次+1后的双向链表中
        freqInc(node);
        //返回当前节点的值
        return node.value;
    }

    //向缓存中添加元素
    public void put(int key, int value) {
        //如果容量为0，直接返回
        if (capacity == 0) {
            return;
        }
        //从缓存中，获取当前key对应的节点
        Node node = cache.get(key);
        //如果缓存中原来就有node节点
        if (node != null) {
            //将node节点的值，更新为value
            node.value = value;
            //将当前访问的节点的频次+1，即将当前节点，放到频次+1后的双向链表中
            freqInc(node);
        }
        //如果缓存中不存在当前节点
        else {
            //当缓存容量满时
            if (size == capacity) {
                //获取访问次数最少的双向链表
                DoublyLinkedList minFreqLinkedList = freqMap.get(min);
                //从缓存中，删除这个节点对应的key
                cache.remove(minFreqLinkedList.tail.prev.key);
                //从最小访问次数的双向链表中删除当前节点
                minFreqLinkedList.removeNode(minFreqLinkedList.tail.prev); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                //缓存中的元素个数-1
                size--;
            }
            //创建新的节点
            Node newNode = new Node(key, value);
            //缓存中添加这个节点
            cache.put(key, newNode);
            //获取访问频次是1的双向链表
            DoublyLinkedList linkedList = freqMap.get(1);
            //双向链表为空
            if (linkedList == null) {
                //新建双向链表
                linkedList = new DoublyLinkedList();
                //将新的链表添加到频次map中
                freqMap.put(1, linkedList);
            }
            //将当前的节点添加到频次为1的双向链表当中
            linkedList.addNode(newNode);
            //缓存中的个数+1
            size++;
            //更新min值为1
            min = 1;
        }
    }

    //将当前访问的节点的频次+1，即将当前节点，放到频次+1后的双向链表中
    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        //获取此频次的双向链表
        DoublyLinkedList linkedList = freqMap.get(freq);
        //删除掉node节点
        linkedList.removeNode(node);
        //如果node节点的频次等于min，并且双向链表的头节点的next等于双向链表的尾节点
        if (freq == min && linkedList.head.next == linkedList.tail) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        //如果频次+1后的双向链表为空，就创建新的双向链表，并且添加到频次map中
        if (linkedList == null) {
            linkedList = new DoublyLinkedList();
            freqMap.put(freq + 1, linkedList);
        }
        //将当前节点添加到当前的频次链表中
        linkedList.addNode(node);
    }
}


