//实现 int sqrt(int x) 函数。
//计算并返回 x 的平方根，其中 x 是非负整数。
//由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//        示例 1:
//        输入: 4
//        输出: 2
//        示例 2:
//        输入: 8
//        输出: 2
//        说明: 8 的平方根是 2.82842...,
//             由于返回类型是整数，小数部分将被舍去。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sqrtx
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Sqrtx {
    public int mySqrt(int x) {
        for (long i = 0; i <= x / 2; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) return (int) i;
        }
        return 1;
    }

//    public int mySqrt(int x) {
//        if (x < 2) return x;
//
//        long num;
//        int pivot, left = 2, right = x / 2;
//        while (left <= right) {
//            pivot = left + (right - left) / 2;
//            num = (long)pivot * pivot;
//            if (num > x) right = pivot - 1;
//            else if (num < x) left = pivot + 1;
//            else return pivot;
//        }
//
//        return right;
//    }

//    public int mySqrt(int x) {
//        if (x < 2) return x;
//
//        double x0 = x;
//        double x1 = (x0 + x / x0) / 2.0;
//        while (Math.abs(x0 - x1) >= 1) {
//            x0 = x1;
//            x1 = (x0 + x / x0) / 2.0;
//        }
//
//        return (int)x1;
//    }


}
