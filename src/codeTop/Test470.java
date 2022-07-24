package codeTop;

/*给定方法rand7可生成 [1,7] 范围内的均匀随机整数，试写一个方法rand10生成 [1,10] 范围内的均匀随机整数。
你只能调用rand7()且不能调用其他方法。请不要使用系统的Math.random()方法。
每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
示例 1:
输入: 1
输出: [2]
示例 2:
输入: 2
输出: [2,8]
示例 3:
输入: 3
输出: [3,8,10]
提示:
1 <= n <= 105
进阶:
rand7()调用次数的期望值是多少?
你能否尽量少调用 rand7() ?
*/
public class Test470 {
    public int rand7() {
        return 1;
    }

    public int rand10() {
        int row = 0;
        int col = 0;
        int index = 0;
        do {
            row = rand7();
            col = rand7();
            index = row + (col - 1) * 7;
        } while (index > 40);
        return 1 + (index - 1) % 10;
    }
}
/*
class Solution extends SolBase {
public int rand10() {
int row=0;
int col=0;
int index=0;
//当生成的数字大于40时，重新生成随机数字
do{
row=rand7();
col=rand7();
index=row+(col-1)*7;
}while(index>40);
return 1+(index-1)%10;
    }
}
*/