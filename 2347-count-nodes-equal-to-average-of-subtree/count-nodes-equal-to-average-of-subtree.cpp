/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
   int ans=0;
  
  pair<int,int>solve(TreeNode*root){
     if(root==NULL){
        return {0,0};
     }
     
     pair<int,int> left=solve(root->left);
     pair<int,int> right=solve(root->right);

     int sum=left.first+right.first;
     int cou=left.second+right.second;
     int s=sum+root->val;
     int c=cou+1;

     if(s/c==root->val){
        ans++;
     }
     return {s,c};
    
   }
    int averageOfSubtree(TreeNode* root) {
        
        solve(root);
        
       return ans;

    }
};