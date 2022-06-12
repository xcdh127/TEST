package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*请你设计一个日志系统，可以流式接收消息以及它的时间戳。
每条 不重复 的消息最多只能每 10 秒打印一次。也就是说，
如果在时间戳 t 打印某条消息，那么相同内容的消
息直到时间戳变为 t + 10 之前都不会被打印。
所有消息都按时间顺序发送。多条消息可能到达同一时间戳。
实现 Logger 类：
Logger() 初始化 logger 对象
bool shouldPrintMessage(int timestamp, string message)
如果这条消息 message 在给定的时间戳 timestamp 应该被打印出来，
、则返回 true ，否则请返回 false 。
*/
class Logger {
    //存放所有的消息以及消息发出的时间
    Map<String,Integer> map;
    public Logger() {
        map=new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        //如果消息是第一次出现，此时消息是可以出现的，并且将时间戳添加进去
        if (!map.containsKey(message)){
            map.put(message,timestamp);
            return true;
        }
        //如果消息之前已经出现过一次，那么比较当前时间戳是不是大于之前时间+10
        else{
            int prevTime=map.get(message);
            //如果当前时间没有比上一次时间多出10秒钟就返回false
            if (timestamp-prevTime<10){
                return false;
            }
            //此时说明发送第二条消息已经是10秒之后了，修好时间戳，并且输出true
            map.put(message,timestamp);
            return true;
        }
    }
}
