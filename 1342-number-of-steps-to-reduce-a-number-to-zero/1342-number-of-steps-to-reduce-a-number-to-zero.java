class Solution {
    public int numberOfSteps(int num) {
        if(num ==0){
            return 0;
        }
        int count = 0;
        while(num!=1){
            if(num%2 ==1){
                num = oddSequence(num);
                count++;
            }
            else if(num%2 ==0){
                num = evenSequence(num);
                count++;
            }
        }
        
        return count+1;
    }    
    public int oddSequence(int num){
        return num-1;
    }
    public int evenSequence(int num){
        return num/2;
    }
}