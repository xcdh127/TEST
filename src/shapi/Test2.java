package shapi;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(generate(4,1,3));

    }

        public static int generate(int numRows,int m,int n) {
            List<List<Integer>> res=new ArrayList<List<Integer>>();

            for(int i=0;i<numRows;i++){

                List<Integer> row=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){

                    //填充首尾的数字1
                    if(j==0 || i==j){
                        row.add(1);
                    }
                    else{
                        row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
                res.add(new ArrayList<Integer>(row));
            }
            List<Integer> list=res.get(res.size()-1);
            int sum=0;
            for(int i=0;i<list.size();i++){
                if(i>=m-1 && i<=n-1){
                    sum+=list.get(i);
                }
            }
            return sum;
        }
    }

