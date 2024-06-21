package com.atguigu.leetcode.array.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class GroupingOfAllogramWords49 {

    public static void main(String[] args) {

        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(arr);
        System.out.println(lists);

    }

    //大佬一行写法
    public static List<List<String>> groupAnagrams(String[] strs) {
        // str -> split -> stream -> sort -> join
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> Stream.of(str.split("")).sorted().collect(Collectors.joining()))).values());


        // str -> intstream -> sort -> collect by StringBuilder
//        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());

    }


    //大佬简约写法
    public static List<List<String>> groupAnagrams3(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            // 返回 str 排序后的结果。
            // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
            char[] array = str.toCharArray();
            Arrays.sort(array);
            return new String(array);
        })).values());

    }

    //官方写法
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }


    //我的屎山写法
    public static List<List<String>> groupAnagrams1(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            StringBuilder key = new StringBuilder();
            List<String> strList = new ArrayList<>();

            String[] split = str.split("");
            Arrays.sort(split);
            for (String s : split) {
                key = key.append(s).append("-");
            }

            List<String> strings = map.get(key.toString());
            if (strings != null && strings.get(0) != null) {
                strList.addAll(strings);
            }
            strList.add(str);
            map.put(key.toString(), strList);

        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            List<String> value = stringListEntry.getValue();
            result.add(value);

        }

        return result;
    }

}
