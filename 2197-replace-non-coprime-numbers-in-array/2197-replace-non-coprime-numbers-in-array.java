class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            long curr = num;

            while (!stack.isEmpty()) {
                long top = stack.get(stack.size() - 1);
                long g = gcd(top, curr);

                if (g == 1) {
                    break;
                }

                stack.remove(stack.size() - 1);
                curr = (top / g) * curr;
            }

            stack.add((int) curr);
        }

        return stack;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}