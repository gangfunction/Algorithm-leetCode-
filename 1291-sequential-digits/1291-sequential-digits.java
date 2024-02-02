class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) { // 첫 자리 숫자
            int num = i;
            int nextDigit = i;

            while (num <= high && nextDigit <= 9) {
                if (num >= low) {
                    result.add(num);
                }

                nextDigit++;
                num = num * 10 + nextDigit;
            }
        }
        Collections.sort(result);

        return result;
    }

}