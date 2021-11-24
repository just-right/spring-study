package dynamicProxy.service;

import dynamicProxy.entity.Player;

/**
 * @author luffy
 * @date 2021/11/24
 * 接口
 */
public interface Partner {
    void receiveMoney(int money);

    void playWith(Player player);
}
