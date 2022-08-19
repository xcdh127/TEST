package Test_test;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            List<String> res = new ArrayList<>();
            char[] ch = str[i].toCharArray();
            recur(res, ch, 0);
            Collections.sort(res);
            int index = findIndex(res, str[i]);
            map.put(str[i], index);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }
            return a.getValue() - b.getValue();
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        for (Map.Entry<String, Integer> entry : queue) {
            System.out.print(entry.getKey() + " ");
        }
    }

    public static void recur(List<String> res, char[] str, int index) {
        if (index == str.length) {
            res.add(new String(str));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < str.length; i++) {
            if (set.contains(str[i])) {
                continue;
            }
            set.add(str[i]);
            swap(str, i, index);
            recur(res, str, index + 1);
            swap(str, i, index);
        }
    }

    public static void swap(char[] str, int a, int b) {
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }

    public static int findIndex(List<String> res, String s) {
        for (int i = 0; i < res.size(); i++) {
            if (s.equals(res.get(i))) {
                return i + 1;
            }
        }
        return -1;
    }
}
