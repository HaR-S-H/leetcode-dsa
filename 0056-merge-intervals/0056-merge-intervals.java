class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int left=0;
        int maxEnd=intervals[0][1];
        for(int right=0;right<intervals.length;right++){
            if(intervals[right][0]>maxEnd){
                list.add(new int[]{intervals[left][0],maxEnd});
                maxEnd=intervals[right][1];
                left=right;
            }else{
                maxEnd=Math.max(maxEnd,intervals[right][1]);
            }
        }
        list.add(new int[]{intervals[left][0],maxEnd});
        int ans[][]=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }
}