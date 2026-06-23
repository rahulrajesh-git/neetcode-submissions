class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies in left sorted half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } 
                // Target lies in right half
                else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {

                // Target lies in right sorted half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } 
                // Target lies in left half
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
