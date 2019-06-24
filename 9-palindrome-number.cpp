// https://leetcode-cn.com/problems/palindrome-number/

class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0)return false;
        int* nums = new int[20];
        int end = 0;
        int index = 0;
        while(x!=0){
            nums[index++] = x % 10;
            x = x/10;
        }
        for(int i = 0; i < index/2; i++){
            if(nums[i] != nums[index-1-i])return false;
        }
        return true;
    }
};