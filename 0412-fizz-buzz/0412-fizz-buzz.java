class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList list = new ArrayList();
        for(int i =1 ; i<n+1; i++){
            String a=judgement(i);
            list.add(a);
        }
        return list;
    }
    private String judgement(int n){
        if(canBeDivided(n,15)){
            return "FizzBuzz";
        }
        else if(canBeDivided(n,5)){
            return "Buzz";
        }
        else if(canBeDivided(n,3)){
            return "Fizz";
        }
        else{
            return Integer.toString(n);
        }
    }
    private boolean canBeDivided(double m, int n){
        double result = m/n;
        System.out.println(m);
        System.out.println(result);
        if (result <1){
            return false;
        }
        else{
            return result%1 == 0.0;        
        }
    }
}