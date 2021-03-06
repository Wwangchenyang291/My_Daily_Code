package Day07.fanshe.Review2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//通过反射获取公共的构造方法并创建对象
class Student {
    //成员变量：一个私有，一个默认，一个公共
    private String name;
    int age;
    public String address;

    //构造方法：一个私有，一个默认，两个公共
    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //成员方法：一个私有，四个公共
    private void function() {
        System.out.println("function");
    }

    public void method1() {
        System.out.println("method");
    }

    public void method2(String s) {
        System.out.println("method:" + s);
    }

    public String method3(String s, int i) {
        return s + "," + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student s=new Student();
        Class<? extends Student> aClass = s.getClass();
        Constructor<? extends Student> dc = aClass.getDeclaredConstructor(String.class);
        dc.setAccessible(true);//暴力反射
        Object o= dc.newInstance("老王");
        System.out.println(o);
    }
}
