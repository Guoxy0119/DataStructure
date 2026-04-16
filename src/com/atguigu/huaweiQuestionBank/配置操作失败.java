package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 题目描述
 * 模拟一个系统的命令行配置，包含添加、修改、删除三项操作，详情如下：
 * • 添操作命令：add_rule rule_id=1 rule_index=18
 * • 修改操作命令：mod_rule rule_id=1 rule_index=100
 * • 删除操作命令：del_rule rule_id=1
 * 其中：add_rule、mod_rule、del_rule是操作关键字▲，rule_id和rule_index是属性关键字且属性取值范围为数字1- 9999 之间，操作、属性之间都用空格进行分割。
 * 1. 在进行所有操作时，如果缺少关键字，或者相应的 rule_id、rule_index的取值不符合要求，则操作失败。
 * 2. 在进行添加操作时，参数必须包含 rule_id 和rule_index,如果当前不存在，则添加成功，如果添加已经存在的 rule_id，则操作失败。
 * 3.在进行修改操作时，参数必须包含rule_id和rule_index，如果当前rule_id不存在，或前后rule_index没有变化，则操作失败。
 * 4. 在进行删除操作时，参数必须包含rule_id，如果当前rule_id不存在，则操作失败
 * 在进行批量操作时，一个命令失败后可以继续下一条命令的操作。现给有一组批量操作的字符串 √，包括不超过 1000 条连续的操作指令，格式为[cmd][cmd][cmd]，请将字符串解析后按照顺序进入你实现的系统，统计出配置失败的次数。
 * 输入描述
 * 输入命令以空格分割
 * 输出描述
 * 输出失败命令数量
 *
 *
 *例：
 * add_rule rule_id=1
 * mod_rule rule_id=1 rule_index=10
 * del_rule rule_id=1
 *  3
 * add操作不包含rule_index,添加失败，后续修改和删除操作，无对应rule_id数据，也会失败。
 *
 */
public class 配置操作失败 {


    // 判断字符串是否为 1~9999 的整数
    static boolean judegeNumber(String s) {
        if (s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 9999;
    }

    // 核心逻辑函数：计算错误命令数量
    static int calErrorCmdError(List<String> command) {
        int errorCount = 0;
        Map<String, String> ruleIndex = new HashMap<>(); // 存储 rule_id -> rule_index

        for (String line : command) {
            String[] cmd = line.split(" "); // 按空格拆分命令

            // 命令长度异常
            if (cmd.length != 2 && cmd.length != 3) {
                errorCount++;
                continue;
            }

            String operatorCmd = cmd[0];

            if (operatorCmd.equals("del_rule")) { // 删除规则
                if (cmd.length != 2) {
                    errorCount++;
                    continue;
                }

                String[] idPropertys = cmd[1].split("=");
                if (idPropertys.length != 2 || !idPropertys[0].equals("rule_id")) {
                    errorCount++;
                    continue;
                }

                String id = idPropertys[1];
                // 检查 id 是否有效且存在
                if (!judegeNumber(id) || !ruleIndex.containsKey(id)) {
                    errorCount++;
                    continue;
                }

                // 正常删除
                ruleIndex.remove(id);

            } else if (operatorCmd.equals("mod_rule") || operatorCmd.equals("add_rule")) { // 修改或添加规则
                if (cmd.length != 3) {
                    errorCount++;
                    continue;
                }

                String[] idPropertys = cmd[1].split("=");
                String[] indexPropertys = cmd[2].split("=");

                // 检查格式
                if (idPropertys.length != 2 || indexPropertys.length != 2
                        || !idPropertys[0].equals("rule_id") || !indexPropertys[0].equals("rule_index")) {
                    errorCount++;
                    continue;
                }

                String id = idPropertys[1];
                String index = indexPropertys[1];

                // 检查数字范围
                if (!judegeNumber(id) || !judegeNumber(index)) {
                    errorCount++;
                    continue;
                }

                if (operatorCmd.equals("mod_rule")) {
                    // 修改规则：不存在或值没变算错误
                    if (!ruleIndex.containsKey(id) || ruleIndex.get(id).equals(index)) {
                        errorCount++;
                        continue;
                    }
                    ruleIndex.put(id, index);
                } else {
                    // 添加规则：已存在算错误
                    if (ruleIndex.containsKey(id)) {
                        errorCount++;
                        continue;
                    }
                    ruleIndex.put(id, index);
                }

            } else {
                // 操作关键字不对
                errorCount++;
            }
        }

        return errorCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> cmd = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break; // 空行结束输入
            cmd.add(line);
        }

        int errorCount = calErrorCmdError(cmd);
        System.out.println(errorCount);
    }


}
