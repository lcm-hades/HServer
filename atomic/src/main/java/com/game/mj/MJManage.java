package com.game.mj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MJManage {

    /**
     * 1  -  9     1-9条
     * 11 - 19     1-9筒
     * 21 - 29     1-9万
     * 31 - 34     东南西北风
     * 35 - 37     中发白
     */

    // 所有的牌
    private List<Integer> totalPaiList = new ArrayList<Integer>();

    // 玩家列表
    private List<Player> players = new ArrayList<Player>();

    /**
     * 初始化牌
     */

    private void initPai(){
        totalPaiList.clear();
        for (int i = 1; i <= 37; i++) {
            if (i % 10 == 0) {
                continue;
            }
            for (int j = 0; j < 4; j++) {
                totalPaiList.add(i);
            }
        }
    }
    /**
     * 洗牌
     */
    public void xiPai(){
        initPai();
        Collections.shuffle(totalPaiList);
    }


    /**
     * 发牌
     * 玩家手牌、牌墙
     */
    public void faPai(){
        players.clear();
        for (int i=0; i < 4; i++){
            Player pl = new Player();
            for (int j=0; j < 13; j++){
                int code = totalPaiList.get(0);
                pl.faPai(code);
                totalPaiList.remove(0);
            }
            pl.zlPai();
            players.add(pl);
        }
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

    /**
     * 显示所有牌
     */

    public void showPai(){
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<totalPaiList.size(); i++){
            sb.append(ParseMJ.code2Name(totalPaiList.get(i))).append(" - ");
        }
        System.out.println(sb.toString());
    }

    /**
     * 显示所有player手牌
     */

    public void showAllHandPai(){
        for (int i=0; i<players.size(); i++){
            System.out.println("play"+i);
            players.get(i).showHandPai();
        }
    }


}
