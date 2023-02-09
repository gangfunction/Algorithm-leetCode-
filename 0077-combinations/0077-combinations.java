class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int numberMax;
    int countMax;

    
    public List<List<Integer>> combine(int n, int k) {
        this.numberMax = n;
        this.countMax = k;
        
        combination(1, new ArrayList<>());
        return result;
    }
    
    public void combination(int cur, List<Integer> list){
        if(list.size() == countMax){
            result.add(new ArrayList<>(list));
            return;    
        }
        
        for(int i = cur; i <= numberMax; i++){
            if(list.size() + numberMax - i + 1 < countMax)
                break;
            
            list.add(i);
            combination(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}