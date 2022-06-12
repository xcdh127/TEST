package TTT;
class SumThrerad extends Thread{
    int sum;
    int i;
    public SumThrerad(int i){
        this.i=i;

    }
    public void run(){
        for(int j=0;j<i;j++){
            sum+=j;
        }
    }
}
public class B1 {
    public static void main(String[] args) throws InterruptedException {
        SumThrerad t1=new SumThrerad(10);
        System.out.println(t1.sum);
        t1.start();
        t1.join();
        System.out.println(t1.sum);

    }
}
