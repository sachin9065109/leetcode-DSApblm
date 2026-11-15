class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        final long MOD = 1_000_000_007L;

        long x = 0;
        long aa = a;
        long bb = b;

        for (int i = n - 1; i >= 0; i--) {
            long bit = 1L << i;

            int ba = (int) ((a >> i) & 1);
            int bbBit = (int) ((b >> i) & 1);

            if (ba == bbBit) {
                if (ba == 0) {
                    x |= bit;
                }
            } else {
                if (aa < bb) {
                    if (ba == 0) {
                        x |= bit;
                    }
                } else {
                    if (bbBit == 0) {
                        x |= bit;
                    }
                }

                aa = a ^ x;
                bb = b ^ x;
            }
        }

        aa = a ^ x;
        bb = b ^ x;

        return (int) ((aa % MOD) * (bb % MOD) % MOD);
    }
}