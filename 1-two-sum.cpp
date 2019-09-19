#include<iostream>
#include<map>
#include<vector>
using namespace std;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> hashmap;
        vector<int> result;
        for(int i = 0; i < nums.size(); i++)
        {
            if(hashmap.count(nums[i]) == 0)
            {
                hashmap[nums[i]] = i;
            }
            else{
                if(2*nums[i]==target){
                    result.push_back(hashmap[nums[i]]);
                    result.push_back(i);
                    return result;
                }
            }
        }
        for(map<int, int>::iterator iter = hashmap.begin(); iter != hashmap.end(); iter++)
        {
            if(hashmap.count(target - iter->first) > 0 && iter->first*2 != target)
            {
                result.push_back(iter->second);
                result.push_back(hashmap[target-iter->first]);
                break;
            }
        }
        return result;
    }
};