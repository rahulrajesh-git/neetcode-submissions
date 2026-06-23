class PrefixTree {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children=new TrieNode[26];    //
            isEnd=false;
        }
    }
 
    private TrieNode root;  //

    public PrefixTree() {
         root=new TrieNode();   //
    }

    public void insert(String word) {
        TrieNode curr=root;           //

        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];   ///
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode node=traverse(word);
        return node!=null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix)!=null;
    }


    public TrieNode traverse(String str){
        TrieNode curr=root;
        for(char c:str.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null){
                return null;
            }
            curr=curr.children[idx];
        }
        return curr;
    }
}
