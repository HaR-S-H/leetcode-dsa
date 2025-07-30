class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>list=new ArrayList<>();
        // ans.add(new int[]{intervals[0][0],intervals[0][1]});
        int left=0;
        int maxEnd=intervals[0][1];
        for(int right=0;right<intervals.length;right++){
            if(intervals[right][0]<=maxEnd){
                maxEnd=Math.max(maxEnd,intervals[right][1]);
            }else{
                list.add(new int[]{intervals[left][0],maxEnd});
                maxEnd=intervals[right][1];
                left=right;
            }
        }
        list.add(new int[]{intervals[left][0],maxEnd});
        return list.toArray(new int[list.size()][]);
    }
}