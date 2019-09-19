#include"math.h"

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
public:
    int reverse(int x) {
        int* nums = new int[10];
        for(int i = 0; i < 10; i++){
            nums[i] = 0;
        }
        int flag = 0;
        int index = 9;
        if(x < 0){
            x = -x;
            flag = 1;
        }
        while(x!=0){
            nums[index--] = x % 10;
            x = x / 10;
        }
        double result = 0;
        int firstnot0 = 10;
        for(int i = 0; i < 10; i++){
            if(nums[i]!=0){firstnot0 = i;break;}
        }
        
        double base = 1;
        for(int i = firstnot0; i < 10; i++){
            result += base * nums[i];
            base *= 10;
        }
        if(flag == 1)result = -result;
        if(result>=-pow(2,31) && result<=pow(2,31)-1)return result;
        else return 0;
    }
};