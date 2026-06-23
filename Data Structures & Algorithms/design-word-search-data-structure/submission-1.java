class WordDictionary {
    class TrieNode{
        TrieNode[] children;///[]
        boolean word;

        public TrieNode(){
            children=new TrieNode[26];//new TrieNode[26]
            word=false;//=false
        }
    }

     private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
       TrieNode curr=root;
       for(char c:word.toCharArray()){//.tochararray
        if(curr.children[c-'a']==null){//.children[c-'a']
            curr.children[c-'a']=new TrieNode();//new TrieNode()
        }
        curr=curr.children[c-'a'];
       }
       curr.word=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);//return
    }

    private boolean dfs(String word,int j,TrieNode root){
        TrieNode curr=root;

        for(int i=j;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:curr.children){
                    if(child!=null&&dfs(word,i+1,child)){
                        return true;
                    }
                }
                return false;// placement
            }else{
                if(curr.children[c-'a']==null){
                    return false;
                }else{
                    curr=curr.children[c-'a'];
                }
            }
           
        }
         return curr.word;
    }
}
