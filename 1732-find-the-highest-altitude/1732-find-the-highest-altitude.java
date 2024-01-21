class Solution {
    public int largestAltitude(int[] gain) {
        ArrayList<Integer> user = new ArrayList<>();
        int relativeAltitude=0;
        for(int i = 0 ; i<gain.length+1; i++){
           if(i == 0){
               user.add(0);
           } else{
            relativeAltitude = gain[i-1] + user.get(i-1);
            user.add(relativeAltitude);               
           }
            
        }
        int max =0;
        for(int i : user){
            max = Math.max(max,i);
        }
        return max;
    }
}