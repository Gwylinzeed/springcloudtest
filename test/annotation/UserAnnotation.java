package annotation;

import org.apache.catalina.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
@TestA(getName = "TYPE", getC = UserAnnotation.class)  //使用了类注解（TYPE）
public class UserAnnotation {


    @TestA(getName = "FIELD", getId = 1, getC = String.class)//类成员注解(FIELD)
    private String str;

    @TestA(getName = "CONSTRUCTOR", getId = 2, getC = UserAnnotation.class)//构造方法注解(CONSTRUCTOR)
    public UserAnnotation() {
    }


    @TestA(getName = "METHOD", getId = 3, getC = int.class) //方法注解(METHOD)
    public int a() {
        return 100;
    }


    public static void main(String[] args) throws Exception {
        parseTypeAnnotation();
        parseMethodAnnotation();
        parseFieldAnnotation();
    }


    static void parseTypeAnnotation() throws ClassNotFoundException {
        System.out.println("------type ----");
        Class clazz = Class.forName("annotation.UserAnnotation");

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            TestA testA = (TestA) annotation;
            System.out.println("id:" + testA.getId() + ", name:" + testA.getName() + ", class:" + testA.getC());

        }
    }

    static void parseMethodAnnotation() throws ClassNotFoundException {

        System.out.println("-----method-----");
        Class clazz = Class.forName("annotation.UserAnnotation");
        Method[] methods = clazz.getMethods();
        boolean hasAnnotation = false;

        for (Method method: methods){
            hasAnnotation = method.isAnnotationPresent(TestA.class);
            if(hasAnnotation){
                System.out.println(method.getAnnotation(TestA.class));
            }
        }
    }


    static void parseFieldAnnotation() throws ClassNotFoundException {

        System.out.println("-----field-----");
        Class clazz = Class.forName("annotation.UserAnnotation");

        Field[] fields = clazz.getDeclaredFields();
        boolean hasAnnotation;

        for (Field field: fields){
            field.setAccessible(true);
            hasAnnotation = field.isAnnotationPresent(TestA.class);
            if(hasAnnotation){
                System.out.println(field.getAnnotation(TestA.class));
            }
        }
    }
}
