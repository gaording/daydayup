package crazyjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-28 10:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-28 gaorunding v1.0.0 修改原因
 */
public class Gobang {
    //定义棋盘大小
    private static int BOARD_SIZE = 15;
    //定义一个二维数组来充当棋盘
    private String[][] board;

    public void initBoard() {
        //初始化棋盘数组
        board = new String[BOARD_SIZE][BOARD_SIZE];
        //把每个元素赋为"+"，用于在控制台画出棋盘
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "+";
            }
        }
    }

    //在控制台输出棋盘
    public void pringBoard() {
        //打印每个数组元素
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        var gb = new Gobang();
        gb.initBoard();
        gb.pringBoard();
        var br = new BufferedReader(new InputStreamReader(System.in));
        String inputstr = null;
        while ((inputstr = br.readLine()) != null) {
            if (inputstr.trim().equals("")) {
                continue;
            }
            String[] postrArr = inputstr.split(",");
            var xPos = Integer.valueOf(postrArr[0]);
            var yPos = Integer.valueOf(postrArr[1]);
            gb.board[xPos - 1][yPos - 1] = "⭕️";
            gb.pringBoard();
            System.out.println("请输入下棋坐标，以x,y的格式");
        }
    }
}
