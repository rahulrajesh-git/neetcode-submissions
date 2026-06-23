//cgpt 1d program
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // one way to make 0 (take nothing)

        for (int coin : coins) {
            for (int t = coin; t <= amount; t++) {
                dp[t] += dp[t - coin];//If I use this coin, then the remaining sum is t - coin
            }
        }

        return dp[amount];
    }
}