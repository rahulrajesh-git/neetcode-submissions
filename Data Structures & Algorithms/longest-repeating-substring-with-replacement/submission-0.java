class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,maxfreq=0,maxlen=0;
        int[] count=new int[26];

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            count[c-'A']++;///
              maxfreq = Math.max(maxfreq, count[c - 'A']);///
            while((r-left+1)-maxfreq>k){
                count[s.charAt(left)-'A']--;
                left++;
            }

            maxlen=Math.max(maxlen,r-left+1);

        }
        return maxlen;
    }
}
