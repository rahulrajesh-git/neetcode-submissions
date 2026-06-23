
class Solution {
    //bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);/// wordList

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);

        int steps=1;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                String word=q.poll();

                if(word.equals(endWord)){
                    return steps;
                }

                char[] arr = word.toCharArray();//

                for (int j = 0; j < arr.length; j++){//arr.length
                    char original=arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j]=c;
                        String newWord = new String(arr);//// otherwise char[] cannot be converted to String q.offer(arr);
                            
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    arr[j]=original;//
                }
                
            }
            steps++;//after ith loop
        }
      return 0;
    }
}