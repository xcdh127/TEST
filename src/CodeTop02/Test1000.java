package CodeTop02;

public class Test1000 {
    public static void main(String[] args) {
        String target = "shein";
        char[] nums = new char[]{'c', 's', 'c', 'h', 'e', 'i', 'n'};
        int[] arr = matchWord1(target, nums);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] matchWord(String targetWord, char[] inputArray) {
        int lenT = targetWord.length();
        int lenA = inputArray.length;
        int indexT = 0;
        int indexA = 0;
        int start = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (targetWord.charAt(0) == inputArray[i]) {
                start = i;
                break;
            }
        }
        while (indexA < lenA && indexT < lenT) {
            if (targetWord.charAt(indexT) == inputArray[indexA]) {
                indexA++;
                indexT++;
            } else {
                indexA++;
            }
            if (lenT == indexT) {
                return new int[]{start, indexA - 1};
            }
        }
        return new int[0];
    }

    public static int[] matchWord1(String targetWord, char[] inputArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            sb.append(inputArray[i]);
        }

        for (int i = 0; i < sb.length(); i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                StringBuilder temp = new StringBuilder(sb);
                String substring = temp.substring(i, j + 1);
                if (substring.charAt(0) == targetWord.charAt(0) && targetWord.length() == get(substring, targetWord)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int get(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
