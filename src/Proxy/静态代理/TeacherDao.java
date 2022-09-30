package Proxy.静态代理;

/**
 * @author zhp
 * @date 2022-08-22 14:32
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("教师讲课");
    }
}
