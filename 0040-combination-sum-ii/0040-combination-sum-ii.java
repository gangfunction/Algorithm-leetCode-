class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain == 0) { // 목표값에 도달한경우
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = start; i <= candidates.length-1; i++) {
            if(remain<candidates[i]) break;
            if(i>start && candidates[i] == candidates[i-1]) continue;
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remain - candidates[i], i+1);
            tempList.remove(tempList.size() - 1); 
        }
    }   
}
