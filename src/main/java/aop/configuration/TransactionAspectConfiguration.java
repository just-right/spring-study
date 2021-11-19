package aop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author luffy
 * @date 2021/11/19
 * configuration
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aop")
public class TransactionAspectConfiguration {
}
