class Solution {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Point> queue = new LinkedList<Point>();
        boolean[][] visited = new boolean[n][m];
        int[][] dxy = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
        };

        int ans = 0;

        int i = 0, j = 0;
        while (true) {
            boolean foundEmpty = false;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        foundEmpty = true;
                        break;
                    }
                }
                if (foundEmpty) break;
            }
            if (!foundEmpty) break;

            queue.offer(new Point(i, j));
            if (grid[i][j] == '1') ans++;
            foundEmpty = false;

            System.out.printf("start=(%d, %d)\n", i, j);

            while (!queue.isEmpty()) {
                Point node = queue.poll();
                visited[node.x][node.y] = true;
                for (int idx = 0; idx < dxy.length; idx++) {
                    int dx = node.x + dxy[idx][0];
                    int dy = node.y + dxy[idx][1];
                    if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy]) {
                        if (grid[node.x][node.y] != grid[dx][dy]) {
                            i = dx;
                            j = dy;
                            foundEmpty = true;
                        }
                        else queue.offer(new Point(dx, dy));
                    }
                }
            }

        }

        return ans;
    }
}
