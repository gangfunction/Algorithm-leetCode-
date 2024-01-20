class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int max= Integer.MIN_VALUE;
        int count= 0;
        for(int i =0; i<k; i++){
            count += vowels.contains(s.charAt(i)) ? 1:0;
        }
        max = count;
        
       for(int i =k ; i<s.length(); i++){
          count+= vowels.contains(s.charAt(i)) ? 1:0;
          count-= vowels.contains(s.charAt(i-k)) ? 1:0;
          max = Math.max(max,count);
       }
        return max;
    }
}
