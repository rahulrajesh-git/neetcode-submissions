class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb=new StringBuffer();
        for(String s:strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> res=new ArrayList<>();

        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++;

            res.add(str.substring(j,j+len));
            i=j+len;

        }
        return res;
    }
}
