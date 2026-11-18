class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int up = 0, down = n - 1;
        while (up <= down) {
            int i = (up + down) / 2;
            if (matrix[i][m - 1] < target)
                up = i + 1;
            else if (matrix[i][0] > target)
                down = i - 1;
            else {
                int left = 0, right = m - 1;
                while (left <= right) {
                    int j = (left + right) / 2;
                    if (matrix[i][j] < target)
                        left = j + 1;
                    else if (matrix[i][j] > target)
                        right = j - 1;
                    else
                        return true;
                }
                return false;
            }
        }
        return false;
    }
}
