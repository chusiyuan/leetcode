#include"math.h"

// https://leetcode-cn.com/problems/reverse-integer/

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