package com.game.mj;

public class MJBean {
    private int type;
    private int value;
    private String name;

    public MJBean(int type, int value, String name) {
        this.type = type;
        this.value = value;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MJBean{" +
                "type=" + type +
                ", value=" + value +
                ", name=" + name +
                '}';
    }
}
