package TTT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test16 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            //如果身高相同按照排名正序排序
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            //如果身高不同，按照身高逆序排序
            else{
                return b[0]-a[0];
            }
        });
        //根据people的第二个属性插入对应的位置
        List<int[]> list=new ArrayList<>();
        for(int[] p:people){
            list.add(p[1],p);
        }
        return list.toArray(new int[0][]);
    }
}
//[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
