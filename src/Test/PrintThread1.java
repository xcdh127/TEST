package Test;

import java.util.LinkedList;
/*
* 使用synchronized + wait + notifyAll实现多个线程交替打印0-100数字
* */
class PrintThread1 implements Runnable {
    //各线程共同抢占的锁
    private static final Object LOCK = new Object();
    // 计数，同时确定线程是否要加入等待队列，还是可以直接去资源队列里面去获取数据进行打印
    private static int count = 0;
    //存放数字的队列
    private LinkedList<Integer> queue;
    //线程编号
    private Integer threadNo;
    //构造方法
    public PrintThread1(LinkedList<Integer> queue, Integer threadNo) {
        this.queue = queue;
        this.threadNo = threadNo;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<=100;i++){
            list.add(i);
        }
        //定义三个继承了Runnable的类，传进去共同的链表，以及各自的线程编号
        PrintThread1 p1=new PrintThread1(list,0);
        PrintThread1 p2=new PrintThread1(list,1);
        PrintThread1 p3=new PrintThread1(list,2);
        //将它们传进Thread类的构造函数，并且调用start()方法
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p2);
        Thread t3=new Thread(p3);
        t1.start();
        t2.start();
        t3.start();

    }
    //重写的run()方法
    @Override
    public void run() {
        //死循环
        while (true) {
            //进入同步代码块，抢占锁之后才能进入代码块
            synchronized (LOCK) {
                //当值不为当前余数时，当前线程进入阻塞状态
                while (count % 3 != this.threadNo) {
                    //当计数器大于101时，停止死循环
                    if (count >= 101) {
                        break;
                    }
                    //都在，调用wait()方法
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当计数器大于101时，停止死循环
                if (count >= 101) {
                    break;
                }
                //从链表中弹出一个数字
                Integer val = this.queue.poll();
                //抢到锁并且是当前编号的线程，打印出当前数字
                System.out.println("thread-" + this.threadNo + ":" + val);
                //计数器+1
                count++;
                //唤醒所有沉睡的线程
                LOCK.notifyAll();
            }
        }
    }
}