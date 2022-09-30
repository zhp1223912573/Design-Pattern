package Proxy.动态代理.jdk;

/**
 * @author zhp
 * @date 2022-08-22 14:46
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teacher() {
        System.out.println("老师教授课程");
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name+",Hello!");
    }
}
