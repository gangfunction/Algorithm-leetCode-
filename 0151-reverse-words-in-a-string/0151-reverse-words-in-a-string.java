class Solution {
    public String reverseWords(String s) {
        //최소로 단어 하나가 있다. "s"
        // 단어를 역순으로 나열하는 것.
        
        String[] array = s.split("\\s+|,\\s*|\\.\\s*");
        if(array.length == 1){
            return s;
        }
        String answer ="";
        for(int i = array.length -1; i>=1; i--){
            answer += array[i] + " "; 
        }
        answer+= array[0];
        return answer.trim();
        
    }
}