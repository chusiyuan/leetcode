#include<iostream>
#include<map>
#include<vector>
using namespace std;

// https://leetcode-cn.com/problems/two-sum/

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