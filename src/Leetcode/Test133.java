package Leetcode;
/*给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
*/
/*输入：time = "2?:?0"
输出："23:50"
解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。*/
public class Test133 {
    public String maximumTime(String time) {
        String[] str=time.split(":");
        StringBuilder sb=new StringBuilder();
        String hour=str[0];
        String minute=str[1];
        //处理小时，如果小时数都是？，就填充23
        if (hour.charAt(0)=='?' && hour.charAt(1)=='?'){
            sb.append("23");
        }
        //如果小时数第一个字符是？
        else if (hour.charAt(0)=='?'){
            //判断小时数末尾数字是否大于等于0，小于等于3，如果是就将第一位设置为2
            if (hour.charAt(1)>='0' && hour.charAt(1)<='3'){
                sb.append("2"+hour.charAt(1));
            }
            //否则设置为1
            else {
                sb.append("1"+hour.charAt(1));
            }
        }
        //如果小时数第2个字符是？
        else if (hour.charAt(1)=='?'){
            //判断小时数第一位是否大于等于0小于等于1，如果是，第二位设置为9
            if (hour.charAt(0)>='0' && hour.charAt(0)<'2'){
                sb.append(hour.charAt(0)+"9");
            }
            //否则设置为3
            else {
                sb.append(hour.charAt(0)+"3");
            }
        }
        //小时数都不为？，将原时间拼接
        else {
            sb.append(""+hour.charAt(0)+hour.charAt(1));
        }
        //加上时间点符号
        sb.append(":");
        //处理分钟，同理小时，不再赘述
        if (minute.charAt(0)=='?' && minute.charAt(1)=='?'){
            sb.append("59");
        }
        else if (minute.charAt(0)=='?'){
            sb.append("5"+minute.charAt(1));
        }
        else if(minute.charAt(1)=='?'){
            sb.append(minute.charAt(0)+"9");
        }
        else {
            sb.append(""+minute.charAt(0)+minute.charAt(1));
        }
        return sb.toString();
    }
}
