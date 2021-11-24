package dynamicProxy.service.impl;

import dynamicProxy.entity.Player;
import dynamicProxy.service.Partner;

/**
 * @author luffy
 * @date 2021/11/24
 * 个人陪玩
 */
public class IndividualPartner implements Partner {

    private String name;

    public IndividualPartner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void receiveMoney(int money) {
        System.out.println(name + "收到佣金：" + money + "元 ~ ");
    }

    @Override
    public void playWith(Player player) {
        System.out.println(name + "与" + player.getName() + "一起愉快地玩耍 ~ ");
    }
}
