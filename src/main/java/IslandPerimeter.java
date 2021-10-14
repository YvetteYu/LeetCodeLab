public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int totalPerimete = 0;

        if (grid.length > 100) {
            throw new RuntimeException();
        }

        for (int k = 0; k < grid.length; k++) {
            int[] row = grid[k];

            if (row.length > 100) {
                throw new RuntimeException();
            }

            for (int i = 0; i < row.length; i++) {
                if (row[i] < 0 || row[i] > 1) {
                    throw new RuntimeException();
                } else if (row[i] == 0) {
                    continue;
                }

                //check neighbor
                int neighborCount = 0;

                // left
                if (i > 0 && row[i - 1] == 1) {
                    neighborCount++;
                }

                //right
                if (i < row.length - 1 && row[i + 1] == 1) {
                    neighborCount++;
                }

                // up
                if (k > 0 && grid[k - 1][i] == 1) {
                    neighborCount++;
                }

                // down
                if (k < grid.length - 1 && grid[k + 1][i] == 1) {
                    neighborCount++;
                }

                totalPerimete += 4 - neighborCount;

            }
        }
        return totalPerimete;
    }

    public static void main(String[] args) {
        IslandPerimeter task = new IslandPerimeter();
        int[][] input = {{0, 1, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 1}, {0, 1, 1, 0}};
        int islandPerimeter = task.islandPerimeter(input);
        System.out.println("islandPerimeter=" + islandPerimeter);
    }
}
