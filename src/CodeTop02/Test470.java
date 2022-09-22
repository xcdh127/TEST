package CodeTop02;

public class Test470 {
    public int rand7() {
        return 0;
    }

    public int rand10() {
        int row, col, idx;
        do {
            //行
            row = rand7();
            //列
            col = rand7();
            //求得当前的数字是idx
            idx = col + (row - 1) * 7;
        }
        //当数字大于40时，继续运行
        while (idx > 40);
        //返回最终的结果
        return 1 + (idx - 1) % 10;
    }
}



