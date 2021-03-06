package Leetcode;
/*环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
环线上的公交车都可以按顺时针和逆时针的方向行驶。
返回乘客从出发点 start 到目的地 destination 之间的最短距离。
*/
/*输入：distance = [1,2,3,4], start = 0, destination = 1
输出：1
解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
*/
public class Test231 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n=distance.length;
        int res1=0;
        int res2=0;
        //从start到destionation的距离
        for (int i = start; i !=destination ; i=(i+1)%n) {
            res1+=distance[i];
        }
        //从distionation到start的距离
        for (int i = destination; i !=start; i=(i+1)%n) {
            res2+=distance[i];
        }
        return Math.min(res1,res2);
    }
}

/*int distanceBetweenBusStops(int* distance, int distanceSize, int start, int destination){
	int res1 = 0, res2 = 0;

    for(int i=start; i != destination; i=(i+1)%distanceSize)	//start到destination的距离
        res1 += distance[i];
    for(int j=destination; j != start; j=(j+1)%distanceSize)	//destination到start的距离
        res2 += distance[j];

    return fmin(res1, res2);									//返回较小的距离
}
*/