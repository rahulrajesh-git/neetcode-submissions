class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int cnt=0;
            for(int j=i+1;j<temperatures.length;j++){
                cnt++;
                if(temperatures[j]>temperatures[i]){
                    res[i]=cnt;
                    break;
                }
            }
            if(res[i]==0){
                res[i]=0;
            }
        }
        return res;
    }
}
