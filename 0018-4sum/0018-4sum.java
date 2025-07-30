class Solution {
    public List<List<Integer>> fourSum(int[] nums, int mainTarget) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                long target=(long)mainTarget-nums[i]-nums[j];
                int k=j+1;
                int l=n-1;
                twoSum(nums,ans,i,j,target,k,l);
            }
        }
        return ans;
    }
    public static void twoSum(int nums[],List<List<Integer>>ans,int i,int j,long target,int k,int l){
        while(k<l){
            if(nums[k]+nums[l]<target) k++;
            else if(nums[k]+nums[l]>target) l--;
            else{
                while(k<l && nums[k]==nums[k+1]) k++;
                while(k<l && nums[l]==nums[l-1]) l--;
                ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                k++;
                l--;
            }
        }
    }
}