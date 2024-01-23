class Solution {
    /*
    operation이 안될때 false,
    언제 안되냐면, 서로 다른 알파벳이 존재하지 않을때.
    연산이 가능할려면 word1,과 word2, 의 길이가 같아야하고,
    서로 다른 글자의 갯수가 같아야한다.
    Hashmap으로  (값, 값의 갯수)를 추가해준다.
    
    그리고 다른글자의 갯수가 word1이 word 2를 포함해야한다.
    */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        
        char[] word1toChar = word1.toCharArray();
        char[] word2toChar = word2.toCharArray();
        
        Map<Character,Integer> mapWord1 = new HashMap<>();
        Map<Character, Integer> mapWord2 = new HashMap<>();
        
        for(int i =0; i<word1.length(); i++){
            if(mapWord1.containsKey(word1toChar[i])){
                mapWord1.put(word1toChar[i], mapWord1.get(word1toChar[i])+1);
            }else{
                mapWord1.put(word1toChar[i],1);
            }
        }
        for(int i =0; i<word2.length(); i++){
                        if(mapWord2.containsKey(word2toChar[i])){
                mapWord2.put(word2toChar[i], mapWord2.get(word2toChar[i])+1);
            }else{
                mapWord2.put(word2toChar[i],1);
            }
        }
        if (!mapWord1.keySet().equals(mapWord2.keySet())) {
            return false;
        }
        List<Integer> word1FrequencyList = new ArrayList<>(mapWord1.values());
        List<Integer> word2FrequencyList = new ArrayList<>(mapWord2.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
        return word1FrequencyList.equals(word2FrequencyList);
        
        
        

        
        
    }
}