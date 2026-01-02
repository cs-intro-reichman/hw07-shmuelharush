/** Computes the binomial(n,k) function. */
public class Binomial { 
    public static void main(String[] args) {
        // מומלץ להשתמש ב-Long.parseLong במקום Integer אם הקלט מאוד גדול, 
        // אבל לארגומנטים n ו-k עצמם int זה מספיק.
        if (args.length >= 2) {
             System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        }
    }

    // Computes the Binomial function, basic version.
    // שיניתי ל-long כדי שיוכל להחזיר ערכים גדולים
    public static long binomial1(int n, int k) { 
        if (k == 0 || n == k) {
            return 1;
        }
        if (k > n || k < 0) {
            return 0;
        }
        return binomial1(n - 1, k - 1) + binomial1(n - 1, k);
    }
    
    // Computes the Binomial function, efficiently
    public static long binomial(int n, int k) {
        if (k > n || k < 0) return 0;
        if (k == 0 || n == k) return 1;

        // שימוש במערך מסוג long
        long[][] memo = new long[n + 1][k + 1];

        // מילוי המערך ב- -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return binomial(n, k, memo);
    }

    // פונקציית העזר משתמשת ב-long
    private static long binomial(int n, int k, long[][] memo) {
        // אם כבר חישבנו - החזר מהזיכרון
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        
        // מקרי בסיס
        if (k == 0 || n == k) {
            memo[n][k] = 1;
            return 1;
        }
        if (k > n || k < 0) {
            return 0;
        }

        // חישוב רקורסיבי ושמירה בזיכרון
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}