package HuaWei;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int topN=Integer.parseInt(line1[0]);
        int M=Integer.parseInt(line1[1]);
        Set<String> set=new HashSet<>();
        Map<String,Integer> mapBiaoti=new HashMap<>();
        Map<String,Integer> mapZhengwen=new HashMap<>();
        Map<String,Integer> biaoTiIndex=new HashMap<>();
        Map<String,Integer> zhengWenIndex=new HashMap<>();
        for(int i=0;i<M;i++){
            String[] biaoTi=sc.nextLine().split(" ");
            String[] zhengWen=sc.nextLine().split(" ");
            for(int j=0;j<biaoTi.length;j++){
                biaoTiIndex.put(biaoTi[j],j);
                mapBiaoti.put(biaoTi[j],mapBiaoti.getOrDefault(biaoTi[j],0)+1);
                set.add(biaoTi[j]);
            }
            for(int k=0;k<zhengWen.length;k++) {
                zhengWenIndex.put(zhengWen[k],k);
                mapZhengwen.put(zhengWen[k], mapZhengwen.getOrDefault(zhengWen[k], 0) + 1);
                set.add(zhengWen[k]);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        Map<String,Integer> map=new HashMap<>();
        for(String str:set){
            map.put(str,mapBiaoti.getOrDefault(str,0)*3+mapZhengwen.getOrDefault(str,0));
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
                minHeap.offer(entry);
        }

        while(!minHeap.isEmpty()){
            if(minHeap.size()==1){
                System.out.print(minHeap.poll());
            }
            else{
                System.out.print(minHeap.poll()+" ");
            }
        }
    }

}
