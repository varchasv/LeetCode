import java.util.*;

public class Permutations47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        check(nums,new ArrayList<Integer>(),result,visited);
        List<List<Integer>> l = new ArrayList<>();
        for(List<Integer> s : result){
            l.add(new ArrayList(s));
        }
        return l;
    }
    public void check(int[] nums,List<Integer> list ,Set<List<Integer>> result , boolean[] visited ){
        if(list.size()== nums.length){
            result.add( new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                check(nums,list,result,visited);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }
}
/*
        Permutations47 p = new Permutations47();
        int[] a = {1,1,2};
        System.out.println(p.permuteUnique(a));
*/
