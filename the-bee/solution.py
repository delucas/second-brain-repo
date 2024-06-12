def the_bee(n):
    m = 2*n-1
    dp = [[0]*m for _ in range(m)]
    for i in range(n):
        dp[i][0] = dp[0][i] = 1
    for i in range(1, m):
        for j in range(1, m):
            if abs(i-j) < n:
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]
    return dp[m-1][m-1]