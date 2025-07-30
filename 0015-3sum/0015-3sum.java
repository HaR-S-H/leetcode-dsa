class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            int j=i+1;
            int k=n-1;
            twoSum(nums,ans,target,j,k);
        }
        return ans;
    }
    public static void twoSum(int nums[],List<List<Integer>>ans,int target,int j,int k){
        while(j<k){
            if(nums[j]+nums[k]<target) j++;
            else if(nums[j]+nums[k]>target) k--;
            else{
                while(j<k && nums[j]==nums[j+1]) j++;
                while(j<k && nums[k]==nums[k-1]) k--;
                ans.add(Arrays.asList(-target,nums[j],nums[k]));
                j++;
                k--;
            }
        }
    }
}