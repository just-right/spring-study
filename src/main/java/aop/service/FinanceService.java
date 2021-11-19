package aop.service;

import aop.aspect.Transactional;
import aop.dao.FinanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luffy
 * @date 2021/11/19
 * service
 */
@Service
public class FinanceService {

    @Autowired
    FinanceDao financeDao;

    @Transactional
    public void transfer(Long source, Long target, int money) {
        financeDao.subtractMoney(source, money);
        int i = 1 / 0;
        financeDao.addMoney(target, money);
    }
}
