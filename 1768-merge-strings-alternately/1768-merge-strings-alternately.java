class Solution {
    public String mergeAlternately(String word1, String word2) {
        int maxLength=0;
        if(word1.length()>word2.length()){
            maxLength = word1.length();
        }
        else{
            maxLength = word2.length();
        }
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            try {
                answer.add(String.valueOf(arr1[i]));
            } catch (Exception ignored) {}
            try {
                answer.add(String.valueOf(arr2[i]));
            } catch (Exception ignored) {}
        }
        String realAnswer = "";
        for(String item: answer){
            realAnswer+= item;
        }
        return realAnswer;
        
    }
}