package aop.aspect;

import aop.util.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @author luffy
 * @date 2021/11/19
 * TransactionAspect
 */
@Component
@Aspect
public class TransactionAspect {

    @Around("@annotation(aop.aspect.Transactional)")
    public Object doWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = JdbcUtils.getConnection();
        // 开启事务
        connection.setAutoCommit(false);
        try {
            Object retVal = joinPoint.proceed();
            // 方法执行成功，提交事务
            connection.commit();
            return retVal;
        } catch (Throwable e) {
            // 方法出现异常，回滚事务
            connection.rollback();
            throw e;
        } finally {
            // 最后关闭连接，释放资源
            JdbcUtils.remove();
        }
    }
}
