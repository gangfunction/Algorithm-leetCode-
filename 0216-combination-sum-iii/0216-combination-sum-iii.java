class Solution {
    /*
    backtracking?
    n is target
    only unique number is used [1,2,3,4,5,6,7,8,9]
    case is distinguished by valid and invalid.
    */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() > k) return; // 더 이상 탐색할 필요가 없는 경우
        else if (tempList.size() == k && remain == 0) {
            result.add(new ArrayList<>(tempList)); // 유효한 조합 찾음
        } else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(result, tempList, k, remain - i, i + 1); // 다음 숫자 탐색
                tempList.remove(tempList.size() - 1); // 백트래킹
            }
        }
    }
}