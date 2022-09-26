package codetophuawei;

import java.util.*;

/*给定一个字符串如“aaabbbccc” 和一个数字 k，
重新排序字符串，使得相同的字符距离至少为k,s = "aaabbbccc" k = 3 ， 输出 "abcabcabc"*/
public class Test358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(rearrangeString(s, 3));
    }


    public static String rearrangeString(String s, int k) {
        //相同的字符间隔小于等于1时，返回原字符串
        if (k <= 1) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //按照出现次数降序排序,大顶堆
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        //将最大堆放进键值对对象
        maxHeap.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        //当最大堆不为空时
        while (!maxHeap.isEmpty()) {
            //取出重复次数最多的字符
            Map.Entry<Character, Integer> curEntry = maxHeap.poll();
            //向字符串中拼接这个字符
            sb.append(curEntry.getKey());
            //当前字符还出现的个数-1
            curEntry.setValue(curEntry.getValue() - 1);
            //向队列中添加当前键值对
            queue.offer(curEntry);
            //当队列的大小等于k时，弹出堆顶元素，如果堆顶元素还有出现次数就放进大顶堆中
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                //如果这个字符的重复次数是大于0的，就将它放进大顶堆中
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
        }
        //最后拼接的字符串的长度是否等于原字符串的长度，如果不等于就返回空
        return sb.length() == s.length() ? sb.toString() : "";
    }
}


class Solution92 {
    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // 大顶堆
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Character c : s.toCharArray()) {
            // 遍历字符，统计字符的出现次数
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(map.entrySet()); // 装入大顶堆，按照字符重复次数作为比较
        StringBuilder sb = new StringBuilder(s.length());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        //当最大堆不为空时
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();    // 从大顶堆取出重复次数最多的字符
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1); // 用掉一个字符，次数减一
            queue.offer(currentEntry);  // 放入到queue中，因为k距离后还要用。
            if (queue.size() == k) {
                // queue的大小到达了k，也就是说我们已经越过了k个单位，在结果中应该要出现相同的字母了
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    // 该字符的重复次数大于 0，则添加入大顶堆中，要是0那还加它干嘛
                    maxHeap.add(entry);
                }
            }
        }
        // 退出 while 循环就是大顶堆已经没有元素了，如果此时 sb 的长度没有还原，说明还有元素挂在 queue 中
        // 即 queue.size() == k 这个条件没有完全满足，即存在一些字符无法间隔 k 个距离
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
