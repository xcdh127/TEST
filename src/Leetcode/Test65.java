package Leetcode;

import java.util.*;

/*有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。
主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
*/
public class Test65 {

    public int halfQuestions(int[] questions) {
        //2N道题目
        int N=questions.length;
        //N位扣友
        int n=N/2;
        //为所有的问题对象数组，以便进行排序
        Question[] question=new Question[N];
        //map用于问题出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(questions[i],map.getOrDefault(questions[i],0)+1);
        }
        //指向对象数组的下标
        int index=0;
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            //记录当前数组出现的次数
            int geShu=entry.getValue();
            //有多个对象存在，所以为每一个问题都创建一个对象放进对象数组中
            for (int i = 0; i < geShu; i++) {
                question[index++]=new Question(entry.getKey(),entry.getValue());
            }
        }
        //将question数组进行排序(按照出现次数进行排序)
        Arrays.sort(question,(a,b)->(compare(a,b)));
        //统计不同问题出现的种类数
        int count=0;
        //set集合用于去除重复类型
        Set<Integer> set=new HashSet<>();
        for (int i = question.length-1; i >=0 ; i--) {
            //如果当前没有这个种类放进来，种类数+1
            if (!set.contains(question[i].kind)){
                count++;
                set.add(question[i].kind);
            }
            //将此时的扣友的数量-1
            n--;
            //当扣友的数量减少为0，退出循环
            if (n==0){
                break;
            }
        }
        //返回统计的最少的种类数
        return count;
    }
    //自定义排序
    public int compare(Question question1,Question question2){
        //按照当前问题出现次数排序
        int count1=question1.count;
        int count2=question2.count;
        return count1-count2;
    }
}
//自定义问题类
class Question{
    //问题的种类
    int kind;
    //这种问题的数量
    int count;
    Question(int kind,int count){
        this.kind=kind;
        this.count=count;
    }
}
