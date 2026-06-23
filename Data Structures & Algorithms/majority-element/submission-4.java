class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, maxcnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int cur = nums[i];

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            if (map.get(cur) > maxcnt) {
                res = cur;
                maxcnt = map.get(cur);
            }
        }

        return res;
    }
}