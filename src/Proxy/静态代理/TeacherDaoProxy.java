package Proxy.静态代理;

/**
 * @author zhp
 * @date 2022-08-22 14:32
 */
public class TeacherDaoProxy implements ITeacherDao {
    //代理对象
    TeacherDao target ;

    public TeacherDaoProxy(TeacherDao target) {
        this.target = target;
    }


    @Override
    public void teach() {
        System.out.println("代理类");
        target.teach();
        System.out.println("停止代理");
    }
}
