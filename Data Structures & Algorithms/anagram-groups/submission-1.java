class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

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
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build unique key from frequency array
            StringBuilder key = new StringBuilder();
            for (int count : freq) {
                key.append('#').append(count);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(s);
        }

        return new ArrayList<>(map.values());
    }
}
*/