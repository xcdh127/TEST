package QI;

import java.util.HashSet;

class RestObject{
    public int x;
    public int y;
    public RestObject(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int hashCode(){
        return (int)System.nanoTime();
    }
    @Override
    public boolean equals(Object obj){
        return false;
    }
}
public class Test1 {
    public static void main(String[] args) {
        HashSet<RestObject> set=new HashSet<>();
        RestObject r1=new RestObject(3,3);
        RestObject r2=new RestObject(5,5);
        RestObject r3=new RestObject(3,3);
        set.add(r1);
        set.add(r2);
        set.add(r3);
        set.add(r1);
        System.out.println("size:"+set.size());

    }
}
