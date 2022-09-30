package Prototype;

/**
 * @author zhp
 * @date 2022-08-21 20:31
 */

import java.io.Serializable;

/**
 * 作为深拷贝测试的内部类
 */
public class DeepCloneableTarget implements Cloneable, Serializable {
    public static final long serialVersionUID =1l;
    String cloneName ;
    String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //因为该类的属性，都是 String , 因此我们这里使用默认的 clone 完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
