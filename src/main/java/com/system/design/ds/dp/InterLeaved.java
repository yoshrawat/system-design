package com.system.design.ds.dp;

public class InterLeaved {
    public static void main(String[] args) {
        test("XXY", "XXZ", "XXZXXY");
    }

    private static boolean test(String A, String B, String C) {
        int M = A.length();
        int N = B.length();
        int O = C.length();

        boolean[][] IL = new boolean[M + 1][N + 1];
        if( M +N != O){
            return false;
        }
        for (int i = 0; i <= M; ++i) {
            for (int j = 0; j <= N; ++j) {
                // two empty strings have an empty string
                // as interleaving
                if (i == 0 && j == 0)
                    IL[i][j] = true;

                    // A is empty
                else if (i == 0) {
                    if (B.charAt(j - 1) == C.charAt(j - 1))
                        IL[i][j] = IL[i][j - 1];
                }

                // B is empty
                else if (j == 0) {
                    if (A.charAt(i - 1) == C.charAt(i - 1))
                        IL[i][j] = IL[i - 1][j];
                }

                // Current character of C matches with current character of A,
                // but doesn't match with current character of B
                else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1))
                    IL[i][j] = IL[i - 1][j];

                    // Current character of C matches with current character of B,
                    // but doesn't match with current character of A
                else if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
                    IL[i][j] = IL[i][j - 1];

                    // Current character of C matches with that of both A and B
                else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
                    IL[i][j] = (IL[i - 1][j] || IL[i][j - 1]);
            }
        }
        return IL[M][N];
    }
}
