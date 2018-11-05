package com.game.mj;

public class ParseMJ {

    public static String code2Name(int code){
        String[] names = {"东风","南风", "西风", "北风", "红中", "发财", "白板"};
        int type = code / 10;
        int name = code % 10;
        if (type == 0){
            return String.format("%d条", name);
        }else if (type == 1)
            return String.format("%d筒", name);
        else if (type == 2)
            return String.format("%d万", name);
        else if (type == 3){
            return names[name - 1];
        }
        return "错误牌";
    }

    public static MJBean decodeMJ(int code){
        int type = code / 10;
        int name = code % 10;
        MJBean mjBean = new MJBean(type, name, code2Name(code));
        return mjBean;
    }
}
