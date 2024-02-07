class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int gcdLength = gcd(len1, len2);

        String candidate = str1.substring(0, gcdLength);
        if (isDivisor(str1, candidate) && isDivisor(str2, candidate)) {
            return candidate;
        }

        return "";
    }

    private boolean isDivisor(String str, String candidate) {
        if (str.length() % candidate.length() != 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / candidate.length(); i++) {
            sb.append(candidate);
        }
        return sb.toString().equals(str);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}