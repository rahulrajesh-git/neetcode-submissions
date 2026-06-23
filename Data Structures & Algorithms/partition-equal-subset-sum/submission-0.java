class Solution {
    //hashSet
    public boolean canPartition(int[] nums) {
        int sum=0;

        for(int num:nums){
            sum+=num;
        }

        if(sum%2!=0){
            return false;
        }

        int target=sum/2;//// we can always make sum 0

        Set<Integer> dp=new HashSet<>();
        dp.add(0);

        for(int num:nums){
            Set<Integer> next=new HashSet<>();//
            for(int curr:dp){////
                int newSum=num+curr;
                if(newSum==target){////
                    return true;
                }

                next.add(curr);   //// don't take
                next.add(newSum);  //// take

            }
            dp=next;
        }

        return false;////
    }
}
