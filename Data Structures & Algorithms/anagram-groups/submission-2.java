class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();//

        for(String s:strs){
            char[] c=s.toCharArray();

            Arrays.sort(c);

            String key=new String(c);

            map.putIfAbsent(key,new ArrayList<>());///

            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());  ////
    }
}


/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26]; // for 'a' to 'z'

            // Count frequency
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build key from frequency array
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append(count[i]).append('#');
            }

            String key = keyBuilder.toString();

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
*/