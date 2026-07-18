class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int index, int delta) {
            index++; 
            while (index <= n) {
                bit[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {

        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pos[nums1[i]];
        }

        Fenwick bit = new Fenwick(n);

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int left = bit.query(arr[i] - 1);

            long right = (n - 1 - arr[i]) - (i - left);

            ans += (long) left * right;

            bit.update(arr[i], 1);
        }

        return ans;
    }
}