package Leetcode;
/*指定年份 year 和月份 month，返回 该月天数 。*/
public class Test270 {
    public int numberOfDays(int year, int month) {
        int[] months=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int day=months[month-1];
        if (month==2 && year%4==0 &&(year%100!=0 || year%400==0)){
            day+=1;
        }
        return day;
    }
}

/*0==y%4 && (0!=y%100 || 0==y%400)*/