package com.programmergirl.graph.dfs.applications;

public class MazeSolver {

    private int[][] map;
    private boolean[][] visited;
    private int startPositionRowIdx;
    private int startPositionColIdx;

    public MazeSolver(int[][] map, int startPositionRowIdx, int startPositionColIdx) {
        this.map = map;
        this.visited = new boolean[map.length][map.length];
        this.startPositionRowIdx = startPositionRowIdx;
        this.startPositionColIdx = startPositionColIdx;
    }

    public static void main(String[] args) {
        int[][] map = { { 1, 1, 1, 1, 1 }, { 1, 2, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 0, 3, 1 }, { 1, 1, 1, 1, 1 } };
        MazeSolver solver = new MazeSolver(map, 1, 1);
        solver.solveMaze();
    }

    public void solveMaze() {
        try {
            dfs(startPositionRowIdx, startPositionColIdx);
            System.out.println("No solution found");
        } catch (RuntimeException e) {
            System.out.println("Found a way out");
        }
    }

    private void dfs(int rowIdx, int colIdx) {
        System.out.println("Visiting i=" + rowIdx + ", j=" + colIdx);
        if (map[rowIdx][colIdx] == 3) {
            //found solution
            throw new RuntimeException();
        }
        if (visited[rowIdx][colIdx]) {
            return;
        } else if (rowIdx < 0 || rowIdx >= map.length - 1) {
            return;
        } else if (colIdx < 0 || colIdx >= map.length - 1) {
            return;
        }
        else if (map[rowIdx][colIdx] == 1) {
            //wall
            return;
        }
        else {
            visited[rowIdx][colIdx] = true;

            dfs(rowIdx + 1, colIdx); //going down
            dfs(rowIdx, colIdx + 1);  //going right
            dfs(rowIdx, colIdx - 1); //going left
            dfs(rowIdx - 1, colIdx);//going up
        }

    }

}
