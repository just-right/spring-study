# spring-study
Spring日常学习

&emsp;&emsp;IOC 控制反转是一种思想，它的核心是将控制权转交出去。利用 IOC 思想，可以实现组件之间的解耦。IOC 的实现方式通常有依赖注入和依赖查找。

&emsp;&emsp;依赖注入:

- setter注入
- 构造器注入
- 参数注入
- 属性注入

&emsp;&emsp;自动注入注解:

- @Autowired 按类型注入/
- @Resource 按名称注入/
- @Inject 按类型注入/

**BeanFactory类继承关系图**

![BeanFactory类继承关系图.png](BeanFactory类继承关系图.png)

**ApplicationContext类(SpringFramework最核心接口)继承关系图**

![ApplicationContext类(SpringFramework最核心接口)继承关系图.png](ApplicationContext类(SpringFramework最核心接口)继承关系图.png)

- 基于xm配置的ClassPathXmlApplicationContext和FileSystemXmlApplicationContext
- 基于注解启动的AnnotationConfigApplicationContext


- 模块装配:自定义注解 + @Import 导入组件

>导入配置类、ImportSelector 的实现类
ImportBeanDefinitionRegistrar 的实现类或者普通类


- 模块装配/条件装配/SPI
