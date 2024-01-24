class Solution {
    /**
    이걸 처음봤을때 어떻게 Stack으로 판단할것인가?
    LIFO? 5 10 -5 면 5랑 10은 다이를 깨도 상관없고, 10이랑 -5가 다이를깨면
    10이 살아남지.
    그러면 절대값이 큰게 살아남을테고.
    
    */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int num: asteroids){
            if(num>0 || stack.isEmpty()){
                stack.push(num);
            }
            else{
                while(true){
                    int topNum = stack.peek();
                    if(topNum <0){
                        stack.push(num);
                        break;
                    }
                    if(topNum==-num){
                        stack.pop();
                        break;
                    }
                    if(topNum>-num){
                        break;
                    }
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(num);
                        break;
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i= stack.size()-1 ; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
        
    }
}