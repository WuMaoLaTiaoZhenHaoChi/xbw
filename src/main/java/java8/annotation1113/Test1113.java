package java8.annotation1113;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: 小霸王
 * @Date: 2019/11/13 9:22
 */
public class Test1113 {


    @Test
    public void test1(){
        Class<Test1113> clazz = Test1113.class;
        try {
            Method method = clazz.getMethod("myAnnotion1");
            MyAnnotation[] annotationsByType = method.getAnnotationsByType(MyAnnotation.class);
            for (MyAnnotation myAnnotation : annotationsByType)
                System.out.println(myAnnotation.value());

        } catch (NoSuchMethodException e) {
        }
    }

    @MyAnnotation(value = "Hello")
    @MyAnnotation(value = "World")
    public void myAnnotion1(){

    }

}
