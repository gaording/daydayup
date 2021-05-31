package javademo.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-31 14:26
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-31 gaorunding v1.0.0 修改原因
 */
public class StudGame {
    @Getter
    private static List<Card> remainCards;
    private static Random random = new Random();

    static {
        remainCards = new ArrayList<>();
        remainCards.add(new Card(14, null));
        remainCards.add(new Card(15, null));
        for (int i = 1; i < 14; i++) {
            for (CardType value : CardType.values()) {
                remainCards.add(new Card(i, value));
            }
        }
    }

    @Setter
    @Getter
    private List<Gamer> gamers;

    public boolean licensing() {
        List<Gamer> collect = gamers.stream().filter(gamer -> !gamer.isGived()).collect(Collectors.toList());
        if (collect.size() == 0) {
            System.out.println("玩家全部放弃，game over");
            gamers.forEach(gamer -> {
                System.out.printf("玩家%d手里牌为%s,%n", gamer.getPosition(), gamer.getCards());
            });
            return true;
        }
        if (collect.size() == 1) {
            System.out.printf("由于其余玩家放弃，玩家%d获胜%n", collect.get(0).getPosition());
            gamers.forEach(gamer -> {
                System.out.printf("玩家%d手里牌为%s,%n", gamer.getPosition(), gamer.getCards());
            });
            return true;
        }
        if (remainCards.size() <= 0) {
            gamers.forEach(gamer -> {
                System.out.printf("牌已发完%n玩家%d手里牌为%s,%n", gamer.getPosition(), gamer.getCards());
            });
            return true;
        }
        if (remainCards.size() >= collect.size()) {
            collect.forEach(gamer -> {
                int randomCard = random.nextInt(remainCards.size());
                Card remove = remainCards.remove(randomCard);
                gamer.getCards().add(remove);
                System.out.printf("玩家%d获得%s%n", gamer.getPosition(), remove);
            });
        } else {
            collect.forEach(gamer -> {
                gamer.getCards().addAll(remainCards);
            });
        }
        return false;
    }
}

class GameRun {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            System.out.println("是否启动游戏？Y/N");
        } while (!"Y".equals(input = bufferedReader.readLine()) && !"N".equals(input));
        if (input.equals("N")) {
            return;
        }
        StudGame studGame = new StudGame();
        System.out.println("请输入玩家人数:");
        do {
            input = bufferedReader.readLine();
            Integer gameNumber;
            try {
                gameNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("请输入数字");
                continue;
            }
            List<Gamer> gamers = new ArrayList<>();
            for (int i = 1; i <= gameNumber; i++) {
                gamers.add(new Gamer(false, i, new ArrayList<>()));
            }
            studGame.setGamers(gamers);
            break;
        } while (true);
        do {
            System.out.println("开始发牌...");
            if (studGame.licensing()) {
                return;
            }
            for (Gamer gamer : studGame.getGamers()) {
                if (gamer.isGived()) {
                    continue;
                }
                do {
                    System.out.printf("玩家%d是否要放弃?Y/N\n", gamer.getPosition());
                } while (!"Y".equals((input = bufferedReader.readLine())) && !"N".equals(input));
                if ("Y".equals(input)) {
                    gamer.setGived(true);
                }
            }
            System.out.println("按任意键继续");
        } while (!"exit".equals(input = bufferedReader.readLine()));

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Gamer {
    private boolean gived;
    private int position;
    private List<Card> cards;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Card {
    private int number;
    private CardType cardType;

    @Override
    public String toString() {
        String showNumer = number + "";
        switch (number) {
            case 11:
                showNumer = "J";
                break;
            case 12:
                showNumer = "K";
                break;
            case 13:
                showNumer = "L";
                break;
            case 14:
                showNumer = "Small Joker";
                break;
            case 15:
                showNumer = "Big Joker";
                break;
            default:
                break;
        }
        return cardType == null ? "" : cardType.getName() + showNumer;
    }
}

enum CardType {
    SPADE("黑桃"), HEART("红心"), DIAMOND("方块"), CLUB("草花");

    CardType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
