package com.game.mj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private int index;
    // 手里的牌
    private List<Integer> handPai = new ArrayList<Integer>();
    // 打出的牌
    private List<Integer> outPai = new ArrayList<Integer>();
    // 吃碰杠
    private List<Integer> pengPai = new ArrayList<Integer>();

    /**
     * 发牌
     * @param paiCode
     */
    public void faPai(int paiCode){
        handPai.add(paiCode);
    }

    /**
     * 手牌排序
     */
    public void zlPai(){
        Collections.sort(handPai);
    }
    /**
     * 出牌
     * @param index
     */
    public void chuPai(int index){
        int paiCode = handPai.get(index);
        outPai.add(paiCode);
        handPai.remove(index);
    }

    /**
     * 判断是否能吃
     * @param paiCode
     * @return
     */
    public boolean canChiPai(int paiCode){
        // 东南西北中发白不能吃
        if (paiCode > 30)
            return false;
        int handSize = handPai.size();
        if (handSize <= 4)
            return false;
        MJBean mjBean = ParseMJ.decodeMJ(paiCode);
        for (int i=0; i < handSize - 1; i++){
            MJBean mj = ParseMJ.decodeMJ(handPai.get(i));
            MJBean mj1 = ParseMJ.decodeMJ(handPai.get(i + 1));
            if (mj.getType() == mjBean.getType()
                    && mj1.getType() == mjBean.getType()){
                if ((mjBean.getValue() == mj.getValue() - 1 && mj.getValue()== mj1.getValue() - 1)
                        || (mj.getValue() == mjBean.getValue() - 1 && mjBean.getValue() == mj1.getValue() - 1)
                        || (mj.getValue() == mj1.getValue() - 1 && mj1.getValue() == mjBean.getValue() - 1)){
                    return true;
                }
            }
        }
        return false;
    }

    public void chiPai(int index, int code){
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(code);
        temp.add(handPai.get(index));
        temp.add(handPai.get(index + 1));
        Collections.sort(temp);
        pengPai.addAll(temp);

        handPai.remove(index);
        handPai.remove(index);
        System.out.println(pengPai.toString());
    }

    public boolean canPengPai(int paiCode){
        int handSize = handPai.size();

        if (handSize <= 4)
            return false;


        return true;
    }

    public void pengPai(int index){

    }

    public boolean canGangPai(int paiCode){
        return true;
    }

    public void gangPai(int index){

    }

    public boolean canHuPai(int paiCode){
        return true;
    }

    public void huPai(int paiCode){

    }

    public void showHandPai(){
        StringBuffer sb = new StringBuffer();
        for (int code:
             handPai) {
            sb.append(ParseMJ.code2Name(code)).append(" - ");
        }
        System.out.println(sb.toString());
    }
}
