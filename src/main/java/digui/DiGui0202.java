package digui;

/**
 * @Author: DuanTong
 * @Date: 2019/8/3 22:28
 */
public class DiGui0202 {

    public static void main(String[] args) {
       //System.out.println(gcd(10,5));
       hanNIO(5,"x","y","z");

    }


    /**
     * 递归最大公因数
     * @param a
     * @param b
     * @return
     */
    static int gcd(int a,int b){
        if (b == 0)
            return a;
        else
            return gcd(b,a % b);
    }

    /**
     * 汉诺塔
     * @param n
     * @param x
     * @param y
     * @param z
     */
    static void hanNIO(int n,String x,String y,String z){

        if (n == 1)
            System.out.println(x + ">>" + z);//直接x >> z
        else{
            hanNIO(n - 1,x,z,y);
            System.out.println(x + ">>" + z);
            hanNIO(n-1,y,x,z);
        }


    }

}
