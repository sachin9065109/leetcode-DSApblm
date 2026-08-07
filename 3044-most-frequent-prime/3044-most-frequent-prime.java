class Solution {

    private final int[] dx = {-1,-1,-1,0,0,1,1,1};
    private final int[] dy = {-1,0,1,-1,1,-1,0,1};

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int d = 0; d < 8; d++) {

                    int x = i;
                    int y = j;
                    int num = 0;

                    while (x >= 0 && x < m && y >= 0 && y < n) {

                        num = num * 10 + mat[x][y];

                        if (num > 10 && isPrime(num)) {
                            freq.put(num, freq.getOrDefault(num, 0) + 1);
                        }

                        x += dx[d];
                        y += dy[d];
                    }
                }
            }
        }

        int ans = -1;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int prime = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq || (count == maxFreq && prime > ans)) {
                maxFreq = count;
                ans = prime;
            }
        }

        return ans;
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num % 2 == 0)
            return num == 2;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}