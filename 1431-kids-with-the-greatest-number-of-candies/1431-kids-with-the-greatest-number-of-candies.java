class Solution {
    /*
    int[] candies
    candies[i] represents the number of candies ith kid has
    */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatNum = 1;
        for(int i  =0 ; i< candies.length; i++){
            if(greatNum <candies[i]){
                greatNum = candies[i];
            }
        }
        ArrayList answer = new ArrayList<>();
        for(int j = 0 ; j<candies.length; j++){
            if(greatNum <= candies[j] + extraCandies){
                answer.add(true);
            }
            else{
                answer.add(false);
            }
        }
        return answer;
    }
}