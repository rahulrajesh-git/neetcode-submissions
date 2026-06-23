class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt=0;
        int l=0,r=people.length-1;

        while(l<=r){
            int remain=limit-people[r];
            r--;
            cnt++;

            if(l<=r && people[l]<=remain){//edge case l<=r  bcz r--
                l++;
            }
        }
        return cnt;
    }
}