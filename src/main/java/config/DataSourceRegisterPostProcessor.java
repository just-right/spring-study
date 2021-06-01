package config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.sql.Driver;
import java.util.List;

/**
 * bean定义注册后置处理器
 *
 * @author luffy
 * @date 2021/05/31
 */
public class DataSourceRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(DruidDataSource.class)
                .addPropertyValue("url", environment.getProperty("jdbc.url"))
                .addPropertyValue("username", environment.getProperty("jdbc.username"))
                .addPropertyValue("password", environment.getProperty("jdbc.password"));
        // 根据当前classpath下的数据库连接驱动添加driverClassName-读取SPI文件配置
        /**
         * 可以是 接口/实现类
         * 注解/标注了注解等
         */
        List<String> driverClassNames = SpringFactoriesLoader.loadFactoryNames(Driver.class, this.getClass().getClassLoader());
        String driverClassName = null;
        for (String temp : driverClassNames) {
            try {
                //是否有对应驱动maven依赖
                Class.forName(temp);
                driverClassName = temp;
                break;
            } catch (ClassNotFoundException ignored) {
                // 加载失败，classpath下无当前驱动，继续下一个
            }
        }
        // 存在驱动，注册DataSource
        if (driverClassName != null) {
            builder.addPropertyValue("driverClassName", driverClassName);
            //注册bean定义
            registry.registerBeanDefinition("dataSource", builder.getBeanDefinition());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
