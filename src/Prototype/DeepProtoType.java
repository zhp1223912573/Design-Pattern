package Prototype;

import java.io.*;

/**
 * @author zhp
 * @date 2022-08-21 20:33
 */
public class DeepProtoType implements Serializable,Cloneable {

    public String name; //String 属性
    public DeepCloneableTarget deepCloneableTarget;// 引用类型

    public DeepProtoType() {
        super();
    }

    //1.重写clone方法实现深拷贝，需要对内部类进行重新创建
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //这里完成对基本数据类型(属性)和 String 的克隆
        Object deep = super.clone();
        //对引用类型的属性，进行单独处理
        DeepProtoType deepPrototype = (DeepProtoType) deep;
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget)deepCloneableTarget.clone();

        return deepPrototype;
    }

    //2.序列化反序列化实现深拷贝
    public Object deepClone(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try{
            bos =new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//将当前对象以对象流的形式输出

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Object copyObject = ois.readObject();
            return copyObject;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                bis.close();
                bos.close();
                ois.close();
                oos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            // 写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            // 分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            // 返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
