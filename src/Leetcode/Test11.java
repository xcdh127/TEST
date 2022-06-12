package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。
其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并
且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，
CPU 可以完成一个任务，或者处于待命状态。
然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，
因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的 最短时间 。
*/
/*
主要思想是首先将剩余任务数量最多的任务先处理掉
* */
public class Test11 {
    public int leastInterval(char[] tasks, int n) {
        //统计所有的任务数和任务的出现次数
        Map<Character,Integer> map=new HashMap<>();
        for(char ch : tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //总任务数
        int size=map.size();
        //统计任务最早可以执行的时间
        List<Integer> nextValuelist=new ArrayList<>();
        //当前剩余任务数
        List<Integer> rest=new ArrayList<>();
        //当前任务最早执行的时间和剩余任务数的初值
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            //当前任务最近最早可以执行的时间
            nextValuelist.add(1);
            //当前种类的任务还剩余任务数量
            rest.add(entry.getValue());
        }
        int time=0;
        //遍历所有的任务数组
        for (int i = 0; i < tasks.length; i++) {
            time++;
            //获取最近的执行时间
            int minNextValid=Integer.MAX_VALUE;
            //遍历所有剩余的任务
            for(int j=0;j<rest.size();j++){
                //当前任务还没有执行完
                if (rest.get(j)!=0){
                    //获取下一个可以执行的最近的一个任务
                    minNextValid=Math.min(minNextValid,nextValuelist.get(j));
                }
            }
            //将最近可以执行的最小时间与当前时间进行对比,取出较大的时间作为最近的时间
            //主要作用时，跳过等待时间
            time=Math.max(time,minNextValid);
            //初始化任务的选择位置
            int best=-1;
            //遍历所有的任务
            for (int j = 0; j < size; j++) {
                //当前种类的任务还没有执行完毕，并且当前任务的最近可以执行时间是小于当前系统时间的
                if (rest.get(j)!=0 && nextValuelist.get(j)<=time){
                    //首先选择剩余的任务数较多的任务进行执行
                    //如果最佳任务的位置是-1，或者当前任务的剩余数量大于最佳位置的任务的数量时
                    //将更新最佳任务的位置
                    if(best==-1 || rest.get(j)>rest.get(best)){
                        best=j;
                    }
                }
            }
            //更新下一次可以执行的时间
            nextValuelist.set(best,time+n+1);
            //将当种类的剩余任任务数-1
            rest.set(best,rest.get(best)-1);
        }
        //返回能够完成所有任务的最短时间
        return time;
    }
}


/*class Solution {
    public int leastInterval(char[] tasks, int n) {

			//统计所有的任务和任务出现的次数
			Map<Character,Integer> map=new HashMap<Character,Integer>();
			for(char ch : tasks){
			map.put(ch,map.getOrDefault(ch,0)+1);
			}
			//总的任务数
			int size=map.size();
			//统计任务最早可以执行的时间
			List<Integer> nextValid=new ArrayList<Integer>();
			//统计当前剩余的任务数
			List<Integer> rest=new ArrayList<Integer>();


	    //为任务的最早执行时间和剩余任务数赋初值
			for(Map.Entry<Character,Integer> entry : map.entrySet()){
				nextValid.add(1);
				rest.add(entry.getValue());
			}

		  //当前时间
      int time=0;
     for(int i=0;i<tasks.length;i++){
		 time++;

			 //获取最近的有效时间
			 int minNextValid=Integer.MAX_VALUE;

			 //遍历当前所有任务，获取最近下一个有效时间
			 for(int j=0;j<size;j++){

				 //当前任务还没有执行完
				 if(rest.get(j)!=0){
				 //获取所有任务中最近的下一个有效时间
					 minNextValid=Math.min(minNextValid,nextValid.get(j));
				 }
			 }
			 //将当前时间和下一个最近时间比较,将最大的时间作为当前时间,以跳过当前空闲时间;
			 time=Math.max(time,minNextValid);

			 //初始化本次最佳选择是-1位置的任务
			 int best=-1;
			 for(int j=0;j<size;j++){

				 //当前任务不为空,并且这个任务的最近执行时间小于等于系统当前时间
				 if(rest.get(j)!=0 && nextValid.get(j)<=time){
				 //首先选择任务剩余数量最多的任务来解决
					 if(best==-1 || rest.get(j)>rest.get(best)){
						 best=j;
					 }
				 }
			 }
			 //更新当前任务下一次可以执行的时间
			 nextValid.set(best,time+n+1);
			//将刚刚执行的任务的剩余任务数-1;
       rest.set(best,rest.get(best)-1);
		 }
			return time;
    }
}*/