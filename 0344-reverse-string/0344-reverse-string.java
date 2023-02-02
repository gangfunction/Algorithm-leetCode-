class Solution {
    public void reverseString(char[] s) {
        int a = s.length;
        char[] c = new char[a];
        int j =0;
        for(int i =s.length-1 ;i>0; i--){
            c[j] = s[i];
            j++;
        }
        c[s.length-1]= s[0];
        for(int i =0; i<s.length; i++)
        {
            s[i]=c[i];
        }
        
    }
}