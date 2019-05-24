package annotation;


import java.lang.annotation.*;


/**
 *  1.@interfaceS声明了一个注解，其中的每一个方法实际上是声明了一个配置参数，
 *  2.方法的名称就是配置参数的名称，返回值的类型就是参数的类型(返回值类型只能是Class, Enum, String ,基本类型)
 *  3.可以通过default来声明参数的默认值
 *
 */

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA {

    String getName();
    int getId() default 0;
    Class getC();

}
