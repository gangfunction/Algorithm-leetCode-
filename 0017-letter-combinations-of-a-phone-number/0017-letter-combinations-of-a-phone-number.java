class Solution {
    /**
    
재귀 함수를 사용하여 문자열 조합을 생성하는데, 재귀 함수의 인자로는 다음과 같은 정보가 필요합니다:
현재 숫자 인덱스 (문자열의 위치)
현재까지 생성된 문자열 (부분 결과)
재귀 함수에서는 다음을 수행합니다:
현재 숫자에 해당하는 문자들을 가져옵니다.
이 문자들을 현재까지 생성된 문자열에 추가하면서 재귀적으로 다음 숫자로 진행합니다.
모든 숫자를 처리하고 문자열을 완성한 경우 결과 리스트에 추가합니다.
마지막으로, 재귀 함수를 호출하여 모든 가능한 문자열 조합을 생성하고 결과 리스트를 반환합니다.
이러한 접근 방법을 사용하여 자바로 문제를 풀 수 있을 것입니다. 필요한 함수 및 데이터 구조를 적절하게 사용하여 재귀적으로 문자열 조합을 생성하고 결과를 반환하면 됩니다.


    */
    public List<String> letterCombinations(String digits) {
        if(digits ==null || digits.isEmpty()){
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        dfs(result,0,new StringBuilder(),map,digits);
        return result;
    }
    public void dfs(List<String> result, int index, StringBuilder subResult,Map<Character, String> map,String digits){
        if(index == digits.length()){
            result.add(subResult.toString());
            return;
        }
        
        char currentDigit = digits.charAt(index);
        String letters = map.get(currentDigit);
        for(int i =0; i<letters.length();i++){
            subResult.append(letters.charAt(i));
            dfs(result, index+1, subResult, map, digits);
            subResult.deleteCharAt(subResult.length()-1);
        }
        
        
    }
}