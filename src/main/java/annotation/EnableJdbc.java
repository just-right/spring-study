package annotation;

import config.JdbcConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author luffy
 * @date 2021/05/31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(JdbcConfiguration.class)
public @interface EnableJdbc {
}
