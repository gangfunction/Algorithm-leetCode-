class Solution {

    public String reverseVowels(String s) {
        
        Stack<Character> stack = new Stack<>();
                char[] charArray = s.toCharArray();
        for(int i =0 ; i<s.length(); i++){
            char part=charArray[i];
            switch(part){
                case 'a': case 'e': case 'i': case 'o': case 'u': case 'A': case 'E': case 'I': case 'O': case 'U':
                    stack.push(part);
            }
        }
    

        for(int i = 0 ; i<s.length(); i++){
            char part = charArray[i];
            switch(part){
                case 'a': case 'e': case 'i': case 'o': case 'u': case 'A': case 'E': case 'I': case 'O': case 'U':

                 char answer =  stack.pop();
                    charArray[i]= answer;
            }
        }
        String reversed = new String(charArray);
        
        return reversed;
    }
}