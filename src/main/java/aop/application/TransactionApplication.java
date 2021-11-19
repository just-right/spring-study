package aop.application;

import aop.configuration.TransactionAspectConfiguration;
import aop.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author luffy
 * @date 2021/11/19
 */
public class TransactionApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                TransactionAspectConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);
    }
}
