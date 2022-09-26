package codetophuawei;

/*单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
words.length == indices.length
助记字符串 s 以 '#' 字符结尾
对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
示例 1：
输入：words = ["time", "me", "bell"]
输出：10
解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
示例 2：
输入：words = ["t"]
输出：2
解释：一组有效编码为 s = "t#" 和 indices = [0] 。
提示：
1 <= words.length <= 2000
1 <= words[i].length <= 7
words[i] 仅由小写字母组成
*/
public class Test820 {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        TrieNode root = trie.buildTrie(words);
        int[] total = new int[]{0};
        trie.recur(root, 1, total);
        return total[0];
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode buildTrie(String[] words) {
        //遍历每一个单词
        for (String str : words) {
            TrieNode cur = root;
            char[] ch = str.toCharArray();
            for (int i = ch.length - 1; i >= 0; i--) {
                if (cur.children[ch[i] - 'a'] == null) {
                    cur.children[ch[i] - 'a'] = new TrieNode();
                }
                cur = cur.children[ch[i] - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }

    public int recur(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            //当有子节点时，就不是叶子节点
            if (child != null) {
                isLeaf = false;
                //编码的长度+1
                recur(child, length + 1, total);
            }
        }
        //如果当前节点时叶子节点，累加上当前的长度
        if (isLeaf) {
            total[0] += length;
        }
        //返回总长度
        return total[0];
    }
}


/*
class TrieNode {

    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode buildTrie(String[] words) {
        for (String str : words) {
            TrieNode cur = root;
            char[] ch = str.toCharArray();
            for (int i = ch.length - 1; i >= 0; i--) {
                if (cur.children[ch[i] - 'a'] == null) {
                    cur.children[ch[i] - 'a'] = new TrieNode();
                }
                cur = cur.children[ch[i] - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }

    public int recur(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                recur(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
        return total[0];
    }
}


class Solution100 {
    public int minimumLengthEncoding(String[] words) {

        Trie trie = new Trie();
        TrieNode root = trie.buildTrie(words);
        int[] total = {0};
        //将根节点算做一个节点
        trie.recur(root, 1, total);
        return total[0];
    }
}*/
