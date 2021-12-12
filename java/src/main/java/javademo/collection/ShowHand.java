package javademo.collection;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description: 梭哈游戏
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-03 10:15
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-03 gaorunding v1.0.0 修改原因
 */
public class ShowHand {
    //玩家数
    private static final int PLAY_NUM = 5;
    //扑克牌花色和数值
    private String[] types = {"方块", "草花", "红心", "黑桃"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    //cards是一局游戏中剩下的扑克牌
    private List<String> cards = new LinkedList<>();
    //定义所有的玩家
    private String[] players = new String[PLAY_NUM];
    //所有玩家手上的扑克牌
    private List<String>[] playersCards = new List[PLAY_NUM];

    /**
     * 初始化扑克牌，放入52张牌
     * 并使用shuffle方法将它们按照随机顺序排列
     */
    public void initCards() {
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }
        //随机排列
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家，为每个玩家分派用户名
     *
     * @param names
     */
    public void initPlayer(String... names) {
        if (names.length > PLAY_NUM || names.length < 2) {
            throw new RuntimeException("玩家数量不对");
        }
        for (int i = 0; i < names.length; i++) {
            players[i] = names[i];
        }
    }

    /**
     * 初始化玩家手上的扑克牌，开始游戏时每个玩家手上的扑克牌为空
     * 程序使用一个长度为0的LinkedList来表示
     */
    public void initPlayCards() {
        for (int i = 0; i < players.length; i++) {
            if (StringUtils.isNotEmpty(players[i])) {
                playersCards[i] = new LinkedList<>();
            }
        }
    }

    /**
     * 输出全部扑克牌，无实际作用，仅用于测试
     */
    public void showAllCards() {
        cards.forEach(ele -> System.out.print(ele + "\t"));
    }

    /**
     * 派发扑克牌
     *
     * @param first
     */
    public void deliverCards(String first) {
        int firstPos = Arrays.asList(players).indexOf(first);
        for (int i = 0; i < players.length; i++) {
            if (players[firstPos] != null) {
                playersCards[firstPos].add(cards.remove(0));
            }
            firstPos = (firstPos + 1) % players.length;
        }
    }

    /**
     * 输出玩家手上的牌
     */
    public void showPlayerCards() {
        for (int i = 0; i < PLAY_NUM; i++) {
            //当该玩家不为空时
            if (players[i] != null) {
                System.out.println(players[i] + ":");
                playersCards[i].forEach(ele -> System.out.print(ele + "\t"));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        var sh = new ShowHand();
        sh.initPlayer("电脑玩家", "孙悟空");
        sh.initCards();
        sh.initPlayCards();
        //测试所有扑克牌
        sh.showAllCards();
        System.out.println("--------");
        sh.deliverCards("孙悟空");
        sh.showPlayerCards();
        /*
        游戏逻辑实现
         */
        sh.deliverCards("电脑玩家");
        sh.showPlayerCards();
    }

}
