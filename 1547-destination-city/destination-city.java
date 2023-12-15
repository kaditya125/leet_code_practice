class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> outdegree = new HashMap<String, Integer>();
        for(List<String> x: paths)
            if(outdegree.containsKey(x.get(1)))
                outdegree.put(x.get(0), outdegree.get(x.get(1))+1);
            else
               outdegree.put(x.get(0), 1);
        
        for(List<String> x: paths)
               if(!outdegree.containsKey(x.get(0)))
                    return x.get(0);
               else if(!outdegree.containsKey(x.get(1)))
                    return x.get(1);
            
        return paths.get(0).get(0);

    }
}