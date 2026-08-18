class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();

        long powerK = 1;
        for (int i = 0; i < k; i++) {
            powerK = (powerK * power) % modulo;
        }

        long hash = 0;
        long p = 1;

        for (int i = n - k; i < n; i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash + val * p) % modulo;
            p = (p * power) % modulo;
        }

        int answer = n - k;

        if (hash == hashValue) {
            answer = n - k;
        }

        for (int i = n - k - 1; i >= 0; i--) {
            int add = s.charAt(i) - 'a' + 1;
            int remove = s.charAt(i + k) - 'a' + 1;

            hash = (hash * power) % modulo;
            hash = (hash + add) % modulo;
            hash = (hash - (remove * powerK) % modulo + modulo) % modulo;

            if (hash == hashValue) {
                answer = i;
            }
        }

        return s.substring(answer, answer + k);
    }
}