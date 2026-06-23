/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oldtonew=new HashMap<>();

        return dfs(node,oldtonew);
    }

    private Node dfs(Node node,Map<Node,Node> oldtonew){//Node
        if(node==null){//
            return null;
        }

        if(oldtonew.containsKey(node)){//only node
            return oldtonew.get(node);
        }

        Node copy=new Node(node.val);//val
        oldtonew.put(node,copy);////oldtonew.put//node and copy
        
        for(Node nei:node.neighbors){
            copy.neighbors.add(dfs(nei,oldtonew));
        }
        return copy;
    }
}