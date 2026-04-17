package com.atguigu.huaweiQuestionBank;

import java.util.*;


/**
 * 题目描述：有两名玩家甲和乙，他们玩一种“小猫钓鱼”扑克牌游戏。扑克牌为A、2、3、…J、Q、K，不考虑花色都用1-13来表示，然后给甲、乙两人各发n张牌，按给定顺序排成队列，这些牌背面朝上，正面朝下放置，队列的第一个元素是背面的第一张牌。
 * 游戏规则如下
 * 1.出牌与收牌
 * -初始出牌时，甲先出牌，打出的牌正面朝上放在桌面的最底部，然后乙出牌，正面朝上放在甲的牌张上面，然后甲乙轮流出牌，直到触发收牌或者任意一个玩家牌出完。
 * -如果玩家出牌后触发了收牌，则把收到的一摞牌作为整体翻面后，背面朝上正面朝下放到现有牌的底部，然后当前收牌的玩家继续出牌。
 * 2.收牌规则
 * -若当前打出的牌点数，与桌面上之前某张牌的点数相同，则触发收牌，收牌的范围是两张相同点数牌之间的所有牌（含这两张）。
 * -若当前打出的牌是J，并且此时桌面上已有至少一张牌（不含当前这张），则当前玩家触发收牌，收牌的范围是桌面上的所有牌。若桌面上原本没有牌，则J仅作为普通牌放到桌面上，不触发特殊效果。
 * 3.游戏结束条件
 * -若某位玩家在自己回合开始时已经没有牌可出，则游戏立即结束，如果此时对方还有余牌，则对方获胜，如果对方也无牌，则平局
 * -若在模拟过程中，出牌总次数超过一个上限（10000次）仍未结束，则认为游戏进入死循环，判定为平局。
 * <p>
 * 输入格式
 * 甲的初始牌队列和乙的初始牌队列，甲乙初始手牌数量相等，均为整数n（1≤n≤100）。
 * 输出格式
 * 一方获胜时，输出获胜方手中背面朝上最上方的那张牌的数值。若平局，如果桌面无牌则输出0，否则输出当前桌面上正面朝上的最上方的那张牌的数值
 * <p>
 * 问题分析
 * “小猫钓鱼”游戏模拟两名玩家轮流出牌的过程，需要处理出牌、收牌、游戏结束等逻辑。关键在于正确实现收牌规则（点数相同或出J牌）和游戏状态更新。
 * <p>
 * 算法设计
 * 数据结构选择：使用队列表示玩家手牌（先进先出），列表或数组表示桌面牌（便于查找和收牌）。
 * 游戏流程：
 * 轮流出牌，检查是否触发收牌。
 * 收牌后，将牌堆翻转并加入收牌玩家队列底部。
 * 检查游戏结束条件（无牌或超过轮次限制）。
 * 收牌规则：
 * 点数相同：收两张相同牌及之间的所有牌。
 * 出J牌：收桌面所有牌（需桌面至少一张牌）。
 * ————————————————
 * 版权声明：本文为CSDN博主「南山马客」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/Chennai585/article/details/160215404
 */
public class 小猫钓鱼纸牌游戏 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> aCards = new LinkedList<>();
        Queue<Integer> bCards = new LinkedList<>();
        String[] aInput = sc.nextLine().split(" ");
        String[] bInput = sc.nextLine().split(" ");
        for (String s : aInput) aCards.add(Integer.parseInt(s));
        for (String s : bInput) bCards.add(Integer.parseInt(s));

        List<Integer> table = new ArrayList<>();
        int maxSteps = 10000;
        int steps = 0;
        char currentPlayer = 'A';

        while (steps <= maxSteps) {
            if (aCards.isEmpty() || bCards.isEmpty()) break;
            steps++;
            if (currentPlayer == 'A') {
                int card = aCards.poll();
                table.add(card);
                if (card == 11 && table.size() > 1) {
                    Collections.reverse(table);
                    aCards.addAll(table);
                    table.clear();
                    currentPlayer = 'A';
                } else {
                    int found = -1;
                    for (int i = 0; i < table.size() - 1; i++) {
                        if (table.get(i) == card) {
                            found = i;
                            break;
                        }
                    }
                    if (found != -1) {
                        List<Integer> collected = table.subList(found, table.size());
                        Collections.reverse(collected);
                        aCards.addAll(collected);
                        table = table.subList(0, found);
                        currentPlayer = 'A';
                    } else {
                        currentPlayer = 'B';
                    }
                }
            } else {
                int card = bCards.poll();
                table.add(card);
                if (card == 11 && table.size() > 1) {
                    Collections.reverse(table);
                    bCards.addAll(table);
                    table.clear();
                    currentPlayer = 'B';
                } else {
                    int found = -1;
                    for (int i = 0; i < table.size() - 1; i++) {
                        if (table.get(i) == card) {
                            found = i;
                            break;
                        }
                    }
                    if (found != -1) {
                        List<Integer> collected = table.subList(found, table.size());
                        Collections.reverse(collected);
                        bCards.addAll(collected);
                        table = table.subList(0, found);
                        currentPlayer = 'B';
                    } else {
                        currentPlayer = 'A';
                    }
                }
            }
        }

        if (steps > maxSteps) {
            System.out.println(table.isEmpty() ? 0 : table.get(table.size() - 1));
        } else {
            if (aCards.isEmpty() && bCards.isEmpty()) {
                System.out.println(table.isEmpty() ? 0 : table.get(table.size() - 1));
            } else if (aCards.isEmpty()) {
                System.out.println(bCards.peek());
            } else {
                System.out.println(aCards.peek());
            }
        }
    }
}
