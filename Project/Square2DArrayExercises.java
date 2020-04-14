public class Square2DArrayExercises
{
    private int[][] grid;
    private int height;
    private int width;
    
    public Square2DArrayExercises (int N) {
        if(N <= 1 || N % 2 == 1) {
            N = 8;
        }
        grid = new int[N][N];
        height = N;
        width = N;
    }

    public boolean exists(int row, int col) {
        return (row >= 0 && row < height) && 
               (col >= 0 && col < width) ;
    }
    
    public int quadrant(int row, int col){
        int middleRow = height / 2;
        int middleCol = width / 2;
        int initial, quadrant;
        if(width < middleCol){
            initial = 1;
        } else {
            initial = 2;
        }
        if(height < middleRow){
            quadrant = initial;
        } else {
            quadrant = initial + 2;
        }
        return 0;
    }
    
    public int size(int q){
        return height / 2;
    }
    
    public void rotate(int rotationCount){
        int temp = grid[0][0];
        grid[0][0] = grid[height - 1][0];
        grid[height - 1][0] = grid[height - 1][width - 1];
        grid[height - 1][width - 1] = grid[0][width - 1];
        grid[0][width - 1] = grid[0][0];
    }
    
    public int section(int row, int col){
        int section = 0;
        int initial = 0;
        if(width <= 2){
            initial = 1;
        } else if(width <= 5){
            initial = 2;
        } else {
            initial = 3;
        }
        if(height <= 2){
            section = initial;
        } else if(width <= 5){
            section = initial + 3;
        } else {
            section = initial + 6;
        }
        return section;
    }
    
    public int fill(int row, int col){
        
        return 0;
    }
    
    public int sumBoundaries(){
        
        return 0;
    }
    
    public int countBoundaries(){
        
        return 0;
    }
    
    public int sumLeftToRightDiagonal(){
        
        return 0;
    }
    
    public int sumRightToLeftDiagonal(){
        
        return 0;
    }
    
    public int Diagonal(boolean left){
        
        return 0;
    }
    
    
}
