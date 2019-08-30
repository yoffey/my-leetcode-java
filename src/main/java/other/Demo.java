package other;
/**
 * description:
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-06-27 09:58
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        System.out.println(factorial(5));
        System.out.println(calculate(5));
    }

    private static int factorial(int n) {
        if (n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int calculate(int n) {
        // recursion
//        if (n == 1) {
//            return 1;
//        }
//        return n + calculate(n - 1);

        // for loop
//        int y = 0;
//        for (int i = 1; i <= n; i++) {
//            y += i;
//        }
//        return y;

        // qiuhe
        return n * (n + 1) / 2;
    }
}
