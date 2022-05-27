class Solution {

    private int[] mem;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount];
        this.coins = coins;
        return dp(amount);
    }

    private int dp(int amount) {
        if (amount == 0) {
            return 0;
        }
        int index = amount - 1;
        if (mem[index] == 0) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= amount) {
                    int nextValue = dp(amount - coin);
                    if (nextValue != -1) {
                        min = Math.min(min, nextValue + 1);
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                mem[index] = -1;
            } else {
                mem[index] = min;
            }
        }
        return mem[index];
    }
}
