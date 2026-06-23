class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket = new LinkedList[nums.length + 1];///<Integer>
        for(int key:map.keySet()){//keySet()
            int freq=map.get(key);
            //bucket[freq].add(key);
            if(bucket[freq] == null){
                bucket[freq] = new LinkedList<>();///
            }
            bucket[freq].add(key);
            
        }

        int[] res=new int[k];
        int cnt=0;

        for(int i=bucket.length-1;i>=0&&cnt<k;i--){
            if(bucket[i]!=null){
               for(int num:bucket[i]){
                if(cnt<k){//<k
                    res[cnt++]=num;
                }else{
                    break;
                }
               }
            }
        }
        return res;
    }
}
