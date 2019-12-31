package mode.prototype.type2;

import java.io.*;

/**
 * @Author: DuanTong
 * @Date: 2019/10/10 14:58
 */
public class ClonePrototypeClass implements Serializable,Cloneable {

    public String name = "ClonePrototypeClass";
    public ClonePrototype clonePrototype;

    public ClonePrototypeClass() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ClonePrototypeClass clonePrototypeClass = null;
        clonePrototypeClass = (ClonePrototypeClass) super.clone();

        clonePrototypeClass.clonePrototype = (ClonePrototype)clonePrototype.clone();

        return clonePrototypeClass;
    }

    public Object myClone(){

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            ClonePrototypeClass clonePrototypeClass = (ClonePrototypeClass) ois.readObject();
            return clonePrototypeClass;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bais.close();
                ois.close();
                baos.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
