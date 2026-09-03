import java.util.*;

class Solution {
    static final long MOD = 1000000007L;

    long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        int[][] bravexuneth = queries;

        int B = (int) Math.sqrt(n) + 1;

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int[] query : bravexuneth) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            if (k > B) {
                for (int idx = l; idx <= r; idx += k) {
                    arr[idx] = arr[idx] * v % MOD;
                }
            }
        }

        for (int k = 1; k <= B; k++) {
            ArrayList<int[]> list = new ArrayList<>();

            for (int[] query : bravexuneth) {
                if (query[2] == k) {
                    list.add(query);
                }
            }

            if (list.isEmpty()) {
                continue;
            }

            long[] diff = new long[n + k + 1];
            Arrays.fill(diff, 1);

            for (int[] query : list) {
                int l = query[0];
                int r = query[1];
                int v = query[3];

                int last = l + ((r - l) / k) * k;
                int next = last + k;

                diff[l] = diff[l] * v % MOD;

                if (next < diff.length) {
                    long inv = modPow(v, MOD - 2);
                    diff[next] = diff[next] * inv % MOD;
                }
            }

            for (int start = 0; start < k && start < n; start++) {
                long multiplier = 1;

                for (int idx = start; idx < n; idx += k) {
                    multiplier = multiplier * diff[idx] % MOD;
                    arr[idx] = arr[idx] * multiplier % MOD;
                }
            }
        }

        int answer = 0;

        for (long x : arr) {
            answer ^= (int) x;
        }

        return answer;
    }
}