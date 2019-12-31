package digui;

/**
 * @Author: DuanTong
 * @Date: 2019/8/4 16:27
 */
public class DiGui0203 {

    public static void main(String[] args) {
        System.out.println(f(-25));
    }


    /**
     * n的阶乘
     * @param n
     * @return
     */
    static int f(int n){
        if(n >= 0){
            if(n == 1)
                return 1;
            else{
                return n * f(n - 1);
            }
        }
        else{
            System.out.println("输入的数字不合法！");
            return 0;
        }
    }

}
