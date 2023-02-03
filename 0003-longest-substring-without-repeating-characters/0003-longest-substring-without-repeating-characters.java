class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        슬라이딩 윈도우를 사용하여
        */
        int i =0;
        int j =0;
        int max =0;
        
        HashSet<Character> hash= new HashSet();
        while(j<s.length()){
            if(!hash.contains(s.charAt(j))){
                hash.add(s.charAt(j));
                j++;
                max = Math.max(hash.size(),max);
            }
            else{
                hash.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}