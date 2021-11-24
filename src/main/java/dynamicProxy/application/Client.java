package dynamicProxy.application;

import dynamicProxy.entity.Player;
import dynamicProxy.proxy.PartnerPlatform;
import dynamicProxy.service.Partner;

/**
 * @author luffy
 * @date 2021/11/24
 * 测试
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Player player = new Player("郝武辽");
        Partner partner = PartnerPlatform.getPartner(50);

        partner.receiveMoney(200);
        partner.playWith(player);
    }
}
