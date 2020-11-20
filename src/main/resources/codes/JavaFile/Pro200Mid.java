package LeetCode.M9Y20.D27;

/**
 * @author 魏荣轩
 * @date 2020/9/27 21:20
 */
public class Pro200Mid {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 输入:
     * [['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']]
     * 输出: 1
     * 示例 2:
     * 输入:
     * [['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']]
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     *
     * @param args
     */
    public static void main(String[] args){
        int n=20;
        System.out.println();
    }
    public static int numIslands(char[][] grid) {
        int islandNum = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    infect(i,j,grid);
                    islandNum ++;
                }
            }
        }
        return islandNum;
    }
    public static void infect(int i,int j,char[][] grid){
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j]=2;
        infect(i-1,j,grid);
        infect(i,j-1,grid);
        infect(i+1,j,grid);
        infect(i,j+1,grid);
    }
}
