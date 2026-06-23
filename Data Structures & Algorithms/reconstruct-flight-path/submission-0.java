class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj=new HashMap<>();

        for(List<String> ticket:tickets){//List<String>
            adj.putIfAbsent(ticket.get(0),new ArrayList<>());//ticket.get(0)
        }

        tickets.sort((a,b)->a.get(1).compareTo(b.get(1)));//a.get(1).compareTo(b.get(1))  tickets.sort destination sort

        for(List<String> ticket:tickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> res=new ArrayList<>();
        res.add("JFK");//

        if(dfs("JFK",res,adj,tickets.size()+1)){//"JFK"   tickets.size()+1
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs(String src,List<String> res,Map<String,List<String>> adj,int targetlen){
        if(res.size()==targetlen){
            return true;
        }

        if(!adj.containsKey(src)){//containsKey
            return false;
        }

        List<String> temp=adj.get(src);//
        for(int i=0;i<temp.size();i++){
            String v=temp.get(i);
            adj.get(src).remove(i);// i not v
            res.add(v);

            if(dfs(v,res,adj,targetlen)){
                return true;
            }

            adj.get(src).add(i,v);///i index
            res.remove(res.size()-1);
        }
        return false;
    } 
}
