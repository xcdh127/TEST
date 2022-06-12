package Test;

import java.util.TreeMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class PrintThread2 implements Runnable {
    //创建一个可充入锁的实例
    private static final ReentrantLock lock = new ReentrantLock();
    //获取condition对象
    private static final Condition c = lock.newCondition();
    //作为计数，同时也作为资源；因为这道题目是自然数作为资源，所以正好可以公用；
    private static int count = 0;
    //线程的编号
    private Integer threadNo;

    public PrintThread2(Integer threadNo) {
        this.threadNo = threadNo;
    }

    public static void main(String[] args) {
        //创建三个继承了Runnable接口的类，并且将编号传进构造方法
        PrintThread2 p1=new PrintThread2(0);
        PrintThread2 p2=new PrintThread2(1);
        PrintThread2 p3=new PrintThread2(2);
        //创建3个Thread类实例
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p2);
        Thread t3=new Thread(p3);
        //调用他们的start()方法执行
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        //死循环
        while (true) {
            try {
                //上锁
                lock.lock();
                //当前线程编号与余数不相等时
                while (count % 3 != this.threadNo) {
                    //如果count值大于等于101，则跳出循环
                    if (count >= 101) {
                        break;
                    }
                    //否则就调用await()方法，将当前线程阻塞
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果count值大于等于101，则跳出循环
                if (count >= 101) {
                    break;
                }
                //打印当前线程号，以及当前数字
                System.out.println("thread-" + this.threadNo + ":" + count);
                //计数器+1
                count++;
                //唤醒所有其他沉睡中的线程
                c.signalAll();
            } finally {
                //解锁
                lock.unlock();

            }
        }
    }
}
