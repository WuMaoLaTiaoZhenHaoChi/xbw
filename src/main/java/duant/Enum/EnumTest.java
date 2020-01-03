package duant.Enum;

import lombok.Getter;

/**
 * @Author: duant
 * @Date: 2019/12/31 14:06
 */
public enum EnumTest {
    ONE(1,"People 1"),TWO(2,"People 2"),THREE(3,"People 3"),FOUR(4,"People 4"),FIVE(5,"People 5");

    private int index;
    private String msg;

    EnumTest(int index, String msg) {
        this.index = index;
        this.msg = msg;
    }

    public int getIndex() {
        return index;
    }

    public String getMsg() {
        return msg;
    }

    public static EnumTest forEachEnum(int index){
        EnumTest[] enumTests = EnumTest.values();
        for (EnumTest enumTest : enumTests) {
            if (index == enumTest.getIndex()){
                return enumTest;
            }
        }
        return null;
    }

}
