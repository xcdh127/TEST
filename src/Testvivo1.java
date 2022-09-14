import java.util.*;

public class Testvivo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        int num = leftSeconds(arr);
        System.out.println(num);
    }

    public static int leftSeconds(int[] signal) {
        int n = signal.length;
        Map<String, Integer> map = new HashMap<>();
        map.put("1110111", 0);
        map.put("0010010", 1);
        map.put("1011101", 2);
        map.put("1011011", 3);
        map.put("0111010", 4);
        map.put("1101011", 5);
        map.put("1101111", 6);
        map.put("1010010", 7);
        map.put("1111111", 8);
        map.put("1111011", 9);
        map.put("1111110", 10);
        map.put("0101111", 11);
        map.put("1100101", 12);
        map.put("0011111", 13);
        map.put("1101101", 14);
        map.put("1101100", 15);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            String str0 = Integer.toBinaryString(signal[i]);
            String str1 = Integer.toBinaryString(signal[i + 1]);
            Integer num0 = map.get(str0);
            Integer num1 = map.get(str1);
            list.add(num0 * 10 + num1);
        }
        Collections.sort(list);
        return list.get(0);
    }
}
