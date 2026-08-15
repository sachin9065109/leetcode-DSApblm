class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> posA = new ArrayList<>();
        List<Integer> posB = new ArrayList<>();

        int n = s.length();

        for (int i = 0; i + a.length() <= n; i++) {
            if (s.startsWith(a, i)) {
                posA.add(i);
            }
        }

        for (int i = 0; i + b.length() <= n; i++) {
            if (s.startsWith(b, i)) {
                posB.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i : posA) {
            int left = i - k;
            int right = i + k;

            int idx = lowerBound(posB, left);

            if (idx < posB.size() && posB.get(idx) <= right) {
                ans.add(i);
            }
        }

        return ans;
    }

    private int lowerBound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}