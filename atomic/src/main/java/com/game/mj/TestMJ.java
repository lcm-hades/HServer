package com.game.mj;

import java.io.IOException;
import java.util.Scanner;

public class TestMJ {
    public static void main(String[] args) throws IOException {
        MJManage mjManage = new MJManage();
        mjManage.xiPai();
        mjManage.showPai();
        mjManage.faPai();
        mjManage.showPai();
        mjManage.showAllHandPai();
        System.out.println("输入player index");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        int index = Integer.parseInt(read);

        System.out.println("输入出牌");
        Scanner scan1 = new Scanner(System.in);
        String read1 = scan1.nextLine();
        int code = Integer.parseInt(read1);

        System.out.println("输入吃牌开始index");
        Scanner scan2 = new Scanner(System.in);
        String read2 = scan2.nextLine();
        int pai_index = Integer.parseInt(read2);

        Player pl = mjManage.getPlayer(index);
        pl.chiPai(pai_index ,code);

//        System.out.println(read1);
    }
}
