class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));//(a,b)->

        List<int[]> output=new ArrayList<>();

        output.add(intervals[0]);

        for(int[] interval:intervals){
            int start=interval[0];
            int end=interval[1];

            int lastend=output.get(output.size()-1)[1];//[1]

            if(start<=lastend){
                output.get(output.size()-1)[1]=Math.max(end,lastend);//[1]
            }else{
                output.add(new int[]{start,end});
            }
        }

        return output.toArray(new int[output.size()-1][]);
    }
}
