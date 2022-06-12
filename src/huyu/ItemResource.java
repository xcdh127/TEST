package huyu;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ItemResource {
    private Lock lock = new ReentrantLock();
    private int id;

    private String itemEffect;

    public Map<Integer,String> map;

    public Map<Integer,String> getEffercts(){
        lock.lock();
        try {
            String[] line1=itemEffect.split(",");
            for(int i=0;i<line1.length;i++){
                String[] line2=line1[i].split("_");
                map.put(Integer.parseInt(line2[0]),line2[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            return map;
        }
    }

}
