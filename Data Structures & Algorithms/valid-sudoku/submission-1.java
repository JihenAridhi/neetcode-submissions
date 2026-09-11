class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowLength = new int[9]; // how many digits in each row
        int[] colLength = new int[9]; // how many digits in each column
        int[] boxLength = new int[9]; // how many digits in each box
        Map<Integer, Set<Character>> boxMap = new HashMap<>(); // box index to digits in that box
        Map<Integer, Set<Character>> rowMap = new HashMap<>(); // row index to digits in that row
        Map<Integer, Set<Character>> colMap =
            new HashMap<>(); // column index to digits in that column

        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>()); // initialize row map
            for (int j = 0; j < 9; j++) {
                colMap.putIfAbsent(j, new HashSet<>()); // initialize column map

                if (i % 3 == 0 && j % 3 == 0)
                    boxMap.put(3 * (i / 3) + (j / 3), new HashSet<>()); // initialize box map

                if (board[i][j] != '.') {
                    rowMap.get(i).add(board[i][j]); // add digit to row map
                    rowLength[i]++; // increment row length
                    colMap.get(j).add(board[i][j]); // add digit to column map
                    colLength[j]++; // increment column length
                    boxMap.get(3 * (i / 3) + (j / 3)).add(board[i][j]); // add digit to box map
                    boxLength[3 * (i / 3) + (j / 3)]++; // increment box length
                }

                if (j % 3 == 2 && i % 3 == 2
                        && boxMap.get(3 * (i / 3) + (j / 3)).size()
                            != boxLength[3 * (i / 3) + (j / 3)]
                    || i == 8 && colMap.get(j).size() != colLength[j]
                    || j == 8 && rowMap.get(i).size() != rowLength[i])
                    // if the size of the set is not equal to the length, then there are duplicates
                    return false;
            }
        }
        return true;
    }
}
