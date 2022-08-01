package codeTop;

public class Test208 {
}
class TrieNode{
    //子节点数组
    TrieNode[] children;
    //是否到达字母的末尾
    boolean isWord;

    public TrieNode(){
        children=new TrieNode[26];
    }
}
class Trie {
    //字典树的根节点
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }

    public void insert(String word) {
        //当前节点指向root节点
        TrieNode node=root;
        char[] chars=word.toCharArray();
        for (char ch :chars) {
            //如果没有这个子节点，新建节点
            if (node.children[ch-'a']==null){
                node.children[ch-'a']=new TrieNode();
            }
            //指向新建的节点
            node=node.children[ch-'a'];
        }
        //单词的末尾节点为true
        node.isWord=true;
    }

    public boolean search(String word) {
        //当前节点指向root节点
        TrieNode node=root;
        char[] chars=word.toCharArray();
        for (char ch :chars) {
            //如果没有这个子节点，返回false
            if (node.children[ch-'a']==null){
                return false;
            }
            //指向子节点
            node=node.children[ch-'a'];
        }
        //返回是否为单词的末尾
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        //当前节点指向root节点
        TrieNode node=root;
        char[] chars=prefix.toCharArray();
        for (char ch :chars) {
            //如果没有这个子节点，返回false
            if (node.children[ch-'a']==null){
                return false;
            }
            //指向子节点
            node=node.children[ch-'a'];
        }
        //返回true
        return true;
    }
}
