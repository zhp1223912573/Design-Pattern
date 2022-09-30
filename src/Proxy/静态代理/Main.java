package Proxy.静态代理;

/**
 * @author zhp
 * @date 2022-08-22 14:34
 */
public class Main {
    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();
        TeacherDaoProxy proxy = new TeacherDaoProxy(target);
        proxy.teach();

    }
}
