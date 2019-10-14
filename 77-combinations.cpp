/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    vector<vector<int>> rst;
    vector<int> subrst;
    vector<vector<int>> combine(int n, int k) {
        subrst.resize(k);
        dfs(1, n, k);
        return rst;
    }
    void dfs(int i, int n, int k){
        while(i<=n){
            subrst[subrst.size()-k] = i++;
            if(k>1){
                dfs(i, n, k-1);
            }else{ 
                rst.push_back(subrst);
            }
        }
    }
};

int main()
{
    Solution sln;
    int n,k;
    cin>>n>>k;
    vector<vector<int>> result = sln.combine(n,k);
    for(int i=0; i < result.size(); i++)
    {
        for(int j = 0; j < k; j++)
            cout<<result[i][j]<<" ";
        cout<<endl;
    }
    return 0;
}