class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Result positive hoga ya negative?
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // long mein convert karo
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        // Largest possible multiple find karo
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // temp ko double karte jao
            while (a >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            // Subtract
            a = a - temp;

            // Quotient mein add
            quotient = quotient + multiple;
        }

        // Sign apply karo
        if (negative) {
            quotient = -quotient;
        }

        // Integer range check
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}