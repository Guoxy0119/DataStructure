package com.atguigu.huaweiQuestionBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 题目一：API请求日志去重分析 100分
 * 知识点：滑动窗口
 * 根制：15空间限制:256MB        限定语言： C(clang11),C++(clang++11),Javaljavac 1.8),Python3 (3.9),JavaScript Node (12.18.2),Go(1.14.4)
 * 描述：某微服务系统的日志监控平台需要分析API调用 记录。日志中包含大量重复的请求记录，为了优化存储和后续分析，需要对相邻的重复请求进行合并统
 * 具体规则如下：
 * 1.日志按时间顺序排列，每条记录包含请求路径和响应时间
 * 2.如果连续出现相同的请求路径，需要将这些记录合并为一条
 * 3.合并后的记录需要统计该路径连续出现的次数，并保留所有响应时间的平均值
 * 4.相同路径但被其他路径分隔的，视为不同的记录组，需要分别合并
 * 请实现一个函数，对给定的日志数据进行去重合并处理。
 * --------
 * 2、输入输出说明
 * <p>
 * 输入格式：
 * -String[] paths：请求路径数组，按时间顺序排列
 * -int[] responseTimes：对应的响应时间数组（毫秒）
 * <p>
 * 输出格式:
 * -返回一个二维数组 int[][].每个子数组包含三个元素
 * -[0]:该路径在输入数组中的首次出现索引
 * -[1]：该路径连续出现的次数
 * -[2]该组路径的平均响应时间（向下取整)
 * <p>
 * 数据规模:
 * - 0 ≤ paths.length ≤10^5
 * - 0 ≤ responseTimes .length ≤ 10^5
 * - paths.length== responseTimes.length
 * -1 ≤responseTimes[i]≤ 1^4
 * -路径长度不超过100个字符
 * <p>
 * 问题分析与实现思路
 * 该问题需要对相邻重复的请求路径进行合并处理，并统计起始索引、连续次数和平均响应时间。核心思路是遍历数组，识别连续相同路径的区间，然后计算每个区间的统计值。以下是具体实现步骤：
 * <p>
 * 初始化变量：
 * <p>
 * 使用start标记当前组的起始索引
 * 用currentPath记录当前组的路径
 * 用sum累计响应时间和，count统计出现次数
 * 遍历数组：
 * <p>
 * 当遇到不同路径或数组结尾时，结束当前组的统计
 * 计算当前组的平均响应时间（向下取整）
 * 将结果[start, count, average]加入结果集
 * 重置统计变量开始新组的记录
 * 边界处理：
 * <p>
 * 空输入直接返回空数组
 * 最后一组数据在遍历结束后处理
 */
public class API日志去重分析 {

    public static void main(String[] args) {

        String[] paths = {"asd", "sf", "asd"};
        int[] responseTimes = {12, 34, 45};

        int[][] ints = mergeLogs(paths, responseTimes);
        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] mergeLogs(String[] paths, int[] responseTimes) {

        if (paths == null || paths.length == 0) {
            return new int[0][];
        }

        List<int[]> result = new ArrayList<>();

        String curPath = paths[0];
        int curTime = responseTimes[0];
        int curCount = 1;
        int index = 0;
        for (int i = 1; i < paths.length; i++) {
            if (Objects.equals(paths[i], curPath)) {
                curTime = curTime + responseTimes[i];
                curCount++;
                continue;
            }

            result.add(new int[]{index, curCount, curTime / curCount});
            index = i;
            curPath = paths[i];
            curTime = responseTimes[i];
            curCount = 1;
        }

        // 添加最后一组
        result.add(new int[]{index, curCount, curTime / curCount});
        return result.toArray(new int[0][]);
    }


}



