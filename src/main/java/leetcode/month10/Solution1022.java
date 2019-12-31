package leetcode.month10;

/**
 * @Author: DuanTong
 * @Date: 2019/10/22 15:23
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class Solution1022 {

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        Solution1022 s = new Solution1022();
        System.out.println(s.minPathSum(nums));
    }

    public int minPathSum(int[][] grid) {
        int x = grid.length,y = grid[0].length;
        for (int i = x - 1;i >= 0;i--){
            for (int j = y - 1;j >= 0;j--){
                if (i == x - 1 && j != y - 1)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == y - 1 && i != x - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (i != x - 1 && j != y - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
    //使用二维数组
/*    public int minPathSum(int[][] grid) {
        int x = grid.length,y = grid[0].length;
        int[][] nums = new int[x][y];
        for (int i = x - 1;i >= 0;i--){
            for (int j = y - 1;j >= 0;j--){
                if (i == x - 1 && j != y - 1)
                    nums[i][j] = grid[i][j] + nums[i][j + 1];
                else if (j == y - 1 && i != x - 1)
                    nums[i][j] = grid[i][j] + nums[i + 1][j];
                else if (i != x - 1 && j != y - 1)
                    nums[i][j] = grid[i][j] + Math.min(nums[i + 1][j],nums[i][j + 1]);
                else
                    nums[i][j] = grid[i][j];
            }
        }
        return nums[0][0];
    }*/

    /*public int minPathSum(int[][] grid) {
        return calculate(grid,0,0);
    }

    public int calculate(int[][] nums,int x,int y){
        if (x == nums.length || y == nums[0].length)
            return Integer.MAX_VALUE;
        if (x == nums.length - 1 && y == nums[0].length - 1)
            return nums[x][y];
        return nums[x][y] + Math.min(calculate(nums,x + 1,y),calculate(nums,x, y + 1));
    }*/
}
