package Test;

public class MyTest2 {
    //定义flagA的初始值为true的目的是热让线程初始化时，并且抢到锁之后线程A执行
    public static Boolean flagA=true;
    public static Boolean flagB=false;
    public static Boolean flagC=false;

    public static void main(String[] args) {
        final Object lock=new Object();
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;){
                    //当线程A强到锁
                    synchronized (lock){
                        //并且flagA为true，那么此时A线程执行
                        if(flagA){
                            //输出字母A
                            System.out.println("A");
                            //更新所有的线程状态
                            flagA=false;
                            //下一步环形B线程
                            flagB=true;
                            flagC=false;
                            //当所有的状态位置位置都更新完毕之后就精所有其他的线程唤醒，去竞争锁
                            lock.notifyAll();
                            i++;
                        }
                        else{
                            try {
                                //否则就等待竞争到得到锁
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }
        });

        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;){
                    //当线程B竞争到锁时
                    synchronized (lock){
                        //并且flagB为true那么此时B线程执行
                        if(flagB){
                            //打印字母B
                            System.out.println("B");
                            //更新所有线程的状态
                            flagA=false;
                            flagB=false;
                            //下一步唤醒的是线程C
                            flagC=true;
                            //当所有的状态位置位置都更新完毕之后就精所有其他的线程唤醒，去竞争锁
                            lock.notifyAll();
                            i++;
                        }
                        else{
                            try {
                                //否则就等待竞争到得到锁
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }
        });

        Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;){
                    //当线程C竞争到锁时
                    synchronized (lock){
                        //并且flagC为true那么此时C线程执行
                        if(flagC){
                            System.out.println("C");
                            //下一次唤醒的是线程A
                            //更新所有的线程的状态
                            flagA=true;
                            flagB=false;
                            flagC=false;
                            //当所有的状态位置位置都更新完毕之后就精所有其他的线程唤醒，去竞争锁
                            lock.notifyAll();
                            i++;
                        }
                        else{
                            try {
                                //否则就等待竞争到得到锁
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
