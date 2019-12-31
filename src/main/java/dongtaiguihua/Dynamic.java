package dongtaiguihua;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 17:49
 */
public class Dynamic {

    public static void main(String[] args) {
        char[] chars1 = {'A','T','C','T','G','A','T'};
        char[] chars2 = {'T','G','C','A','T','A'};
        System.out.println(lsc(chars1,chars2));
    }

    public static int lsc(char[] chars1,char[] chars2){
        int len1 = chars1.length,len2 = chars2.length;
        int[][] retChars = new int[len1][len2];

        for (int i = 0;i < len1;i++){
            for (int j = 0;j < len2;j++){
                if (i != 0 && j != 0){
                    if (chars1[i] == chars2[j]){
                        retChars[i][j] = retChars[i - 1][j - 1] + 1;
                    }else {//不相等时候
                        retChars[i][j] = Math.max(retChars[i - 1][j],retChars[i][j - 1]);
                    }
                }else {
                    retChars[0][0] = 0;
                }

            }
        }
        return retChars[len1 - 1][len2 - 1];
    }

}
