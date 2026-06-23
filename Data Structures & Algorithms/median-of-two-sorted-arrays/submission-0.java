class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int m=nums1.length;
         int n=nums2.length;

         int total=m+n;
         int half=total/2;///total/2
         int l=0,r=m;
         

         while(l<=r){
            int i=(l+r)/2;
            int j=half-i;

            int nums1left=(i>0)?nums1[i-1]:Integer.MIN_VALUE;//(i>0) not nums1[i]>0
            int nums2left=(j>0)?nums2[j-1]:Integer.MIN_VALUE;
            int nums1right=(i<m)?nums1[i]:Integer.MAX_VALUE;
            int nums2right=(j<n)?nums2[j]:Integer.MAX_VALUE;

            if(nums1left<=nums2right&&nums2left<=nums1right){
                if((total%2)==1){
                    return Math.min(nums1right,nums2right);//right
                }else{
                    return (Math.max(nums1left,nums2left)+Math.min(nums1right,nums2right))/2.0;///)/2.0
                }
            }else if(nums1left>nums2right){
                r=i-1;
            }else{
                l=i+1;
            }
         }

         return 0;
    }
}
