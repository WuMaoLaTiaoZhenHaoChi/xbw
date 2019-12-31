package mode.prototype.type2;

import java.io.Serializable;

/**
 * @Author: DuanTong
 * @Date: 2019/10/10 14:55
 */
public class ClonePrototype implements Serializable,Cloneable{


    private String cloneClass;
    private String name;

    public ClonePrototype(String cloneClass, String name) {
        this.cloneClass = cloneClass;
        this.name = name;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //没有引用对象直接使用父类clone就行
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
