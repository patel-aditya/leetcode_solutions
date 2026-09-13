class Solution {
    int res = 0;
    int n;

    void check(int[][] img1, int[][] img2, int rowShift, int colShift) {

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int r = i + rowShift;
                int c = j + colShift;

                if (r >= 0 && r < n && c >= 0 && c < n) {

                    if (img1[i][j] == 1 && img2[r][c] == 1) {
                        max++;
                    }
                }
            }
        }

        res = Math.max(res, max);
    }

    void helper(int[][] img1, int[][] img2, int rowShift, int colShift) {

        // All row shifts completed
        if (rowShift > n - 1)
            return;

        // Current row's columns completed
        if (colShift > n - 1) {
            helper(img1, img2, rowShift + 1, -(n - 1));
            return;
        }

        check(img1, img2, rowShift, colShift);

        // Next column shift
        helper(img1, img2, rowShift, colShift + 1);
    }

    public int largestOverlap(int[][] img1, int[][] img2) {

        n = img1.length;
        res = 0;

        // Start from -(n-1), not 0
        helper(img1, img2, -(n - 1), -(n - 1));

        return res;
    }
}