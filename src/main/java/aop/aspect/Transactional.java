package aop.aspect;

import java.lang.annotation.*;
/**
 * @author luffy
 * @date 2021/11/19
 * Transactional
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {
}
