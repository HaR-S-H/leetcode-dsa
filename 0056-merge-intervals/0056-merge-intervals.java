class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int left=0;
        int maxEnd=intervals[0][1];
        List<int[]>list=new ArrayList<>();
        for(int right=1;right<intervals.length;right++){
            if(intervals[right][0]<=maxEnd){
            maxEnd=Math.max(maxEnd,intervals[right][1]);
            }
            else{
                list.add(new int[]{intervals[left][0],maxEnd});
                left=right;
                maxEnd=intervals[right][1];
            }
            
        }
        list.add(new int[]{intervals[left][0],maxEnd});
        return list.toArray(new int[list.size()][]);
    }
}