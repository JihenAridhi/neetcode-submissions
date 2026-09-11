class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowLength = new int[9];
        int[] colLength = new int[9];
        int[] boxLength = new int[9];
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            for (int j = 0; j < 9; j++) {
                colMap.putIfAbsent(j, new HashSet<>());
                if (i % 3 == 0 && j % 3 == 0)
                    boxMap.put(3 * (i / 3) + (j / 3), new HashSet<>());

                if (board[i][j] != '.') {
                    rowMap.get(i).add(board[i][j]);
                    rowLength[i]++;
                    colMap.get(j).add(board[i][j]);
                    colLength[j]++;
                    boxMap.get(3 * (i / 3) + (j / 3)).add(board[i][j]);
                    boxLength[3 * (i / 3) + (j / 3)]++;
                }

                if (j % 3 == 2 && i % 3 == 2
                        && boxMap.get(3 * (i / 3) + (j / 3)).size()
                            != boxLength[3 * (i / 3) + (j / 3)]
                    || i == 8 && colMap.get(j).size() != colLength[j]
                    || j == 8 && rowMap.get(i).size() != rowLength[i])
                    return false;
            }
        }

        return true;
    }
}
