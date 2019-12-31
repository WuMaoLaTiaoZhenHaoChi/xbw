package duant.Enum;

/**
 * @Author: duant
 * @Date: 2019/12/31 14:06
 */
public enum EnumTest {
    ONE(1,"People 1"),TWO(2,"People 2"),THREE(3,"People 3"),FOUR(4,"People 4"),FIVE(5,"People 5");

    private Integer id;
    private String msg;

    EnumTest(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }
}
