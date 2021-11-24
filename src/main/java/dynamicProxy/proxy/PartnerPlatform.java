package dynamicProxy.proxy;

import dynamicProxy.service.Partner;
import dynamicProxy.service.impl.IndividualPartner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luffy
 * @date 2021/11/24
 * 平台-代理
 */
public class PartnerPlatform {

    private static List<Partner> partners = new ArrayList<>();

    static {
        partners.add(new IndividualPartner("肖洁洁"));
        partners.add(new IndividualPartner("田苟"));
        partners.add(new IndividualPartner("高总裁"));
    }

    public static Partner getPartner(int money) {
        Partner partner = partners.remove(0);
        return (Partner) Proxy.newProxyInstance(partner.getClass().getClassLoader(), partner.getClass().getInterfaces(),
                new InvocationHandler() {
                    private int budget = money;
                    private boolean status = false;

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("receiveMoney")) {
                            int money = (int) args[0];
                            // 平台需要运营，抽成一半
                            args[0] = money / 2;
                            // 如果在付钱时没给够，则标记budget为异常值
                            this.status = money >= budget;
                        }
                        if (status) {
                            return method.invoke(partner, args);
                        }
                        return null;
                    }
                });
    }

}