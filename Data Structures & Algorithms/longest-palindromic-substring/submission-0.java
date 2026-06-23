class Solution {
    public String longestPalindrome(String s) {
        int residx=0;
        int reslen=0;

        for(int i=0;i<s.length();i++){
            //odd
            int l=i;
            int r=i;

            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
               
                if(r-l+1>reslen){
                    residx=l;
                    reslen=r-l+1;
                }
                 l--;//position
                r++;//

            }

            //even
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
               
                if(r-l+1>reslen){
                    residx=l;
                    reslen=r-l+1;
                }
                 l--;//position
                r++;//

            }
        }

        return s.substring(residx,residx+reslen);
        
    }
}
