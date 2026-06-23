class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> prereq=new HashMap<>();

        for(int[] pre:prerequisites){
            prereq.computeIfAbsent(pre[0],k->new ArrayList<>()).add(pre[1]);
        }

        List<Integer> output=new ArrayList<>();
        Set<Integer> visit=new HashSet<>();//
        Set<Integer> cycle=new HashSet<>();
        
        for(int course=0;course<numCourses;course++){
            if(!dfs(course,prereq,visit,cycle,output)){
                return new int[0];
            }
        }

        int[] results=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            results[i]=output.get(i);
        }
        return results;
    }

    private boolean dfs(int course,Map<Integer,List<Integer>> prereq,Set<Integer> visit,Set<Integer> cycle,List<Integer> output){
        if(cycle.contains(course)){
            return false;
        }

        if(visit.contains(course)){
            return true;
        }

        cycle.add(course);//

        List<Integer> list=prereq.get(course); //  prereq

        if(list!=null){
             for (int pre : list) {  /////
                if (!dfs(pre, prereq, visit, cycle, output)) {///
                    return false;  //
                }
            }
        }

        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true; 
    }
}
