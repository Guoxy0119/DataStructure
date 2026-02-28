package com.atguigu.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NC37MergeIntervals {


    public static void main(String[] args) {

        ArrayList<Interval> intervals = new ArrayList<>();

        ArrayList<Interval> merge = merge(intervals);
        System.out.println(merge);

    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size()<=1){
            return  intervals;
        }

        ArrayList<Interval> result = new ArrayList<>();

        // 排序
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
//        Collections.sort(intervals, (v1, v2) ->v1.start - v2.start);

        // 放入第一个区间
        result.add(intervals.get(0));
        // 遍历，查看是否与末尾有重叠
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval lastRes = result.get(result.size() - 1);

            if (interval.start > lastRes.end) {
                result.add(new Interval(interval.start, interval.end));
            } else {
                if (interval.end > lastRes.end) {
                    result.remove(result.size() - 1);
                    result.add(new Interval(lastRes.start, interval.end));
                }
            }
        }
        return result;
    }


}


class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
