class Solution {
    public int calculate(String s) {
        int operand = 0, result = 0, sign = 1;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                result += sign * operand;
                sign = (ch == '+') ? 1 : -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}