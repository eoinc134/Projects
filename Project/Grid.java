public class Grid{
    private int[][] grid ;
    private int height;
    private int width;

    public Grid(int rows, int cols) {
        this.grid = new int[rows][cols] ;
        this.height = rows;
        this.width = cols;
    }

    public boolean exists(int row, int col) {
        return (row >= 0 && row < height) && 
               (col >= 0 && col < width) ;
    }
    
    public int getCell(int row, int col) {
        if(exists(row,col)) {
            return grid[row][col];
        }
        
        return 0;
    }
    
    public boolean onBoundary(int row, int col) {
        if(exists(row,col)) {
            if(row == 0 || row == height-1 || col == 0 || col == width-1) {
                return true ;
            }
        }
        return false;
    }
    
    public int sumRow(int row) {
        int sum = 0 ;
        if(exists(row,0)) { 
            for(int col=0 ; col < width ; col++) {
                sum = sum + grid[row][col] ; 
            }
        }
        return sum ;
    }
    
    public int sumColumn(int col) {
        int sum = 0 ;
        if(exists(0,col)) {
            for(int row = 0 ; row < height ; row++){
                sum = sum + grid[row][col] ; 
            }
        }
        return sum ;
    }
    
    public int sumUnion(int row, int col) {
        if(exists(row,col)) {
            return sumRow(row) + sumColumn(col);
        }
        return 0;
    }
    
    public int lastRowUsed() {
        int row;
        for(row = height-1 ; row >= 0 && sumRow(row) == 0; row--);
        return row ;
    }
    
    public int lastColumnUsed() {
        int col;
        for(col = width-1 ; col >= 0 && sumColumn(col) == 0; col--);
        return col ;
    }
    
    public int sumPortion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int t ;
        if(exists(row1,col1) && exists(row2,col2)) {
            if(row2 < row1) {
                t = row1 ;
                row1 = row2 ;
                row2 = t ;
            }
            if(col2 < col1) {
                t = col1 ;
                col1 = col2 ;
                col2 = t ;
            }
            for(int r = row1; r <= row2; r++) {
                for(int c = col1;  c <= col2; c++) {
                    sum = sum + grid[r][c] ;
                }
            }
        }
        return sum ;
    }
    
    public int neighbours(int row, int col) {
        int count = 0 ;
        for(int r = row-1; r <= row+1; r++) {
            for(int c = col-1 ; c <= col+1; c++) {
                if(exists(r,c)) {
                    if(grid[r][c] == -1) {
                        count++ ;
                    }
                }
            }
        }
        return count ;
    }
    
    
    public void Square2DArrayExercises (int N) {
        if(N <= 1 || N % 2 == 1) {            
            N = 8;
        }
        grid = new int[N][N];
        height = N;
        width = N;
    }
    
    public int quadrant(int row, int col){
        int quadrant = 0;
        
        int middleRow = height / 2;
        int middleCol = width / 2;
        
        if(exists(row, col)){
            if(row < middleRow){
                quadrant = 1;
                if(col > middleCol){
                    quadrant = 2; 
                }
            } else {
                quadrant = 3;
                if(col > middleCol){
                    quadrant = 4;
                }
            }
        }
        
        return quadrant;
    }
    
    public int size(int q){
        return height / 2;
    }
    
    public void rotate(int rotationCount){
        int temp;
        int lastRow = height - 1;
        int lastCol = width - 1;
        
        if(rotationCount != 0){
            rotationCount = rotationCount % 4;
            for(int i = rotationCount; i > 0; i--){
                temp = grid[0][0];
                grid[0][0] = grid[lastRow][0];
                grid[lastRow][0] = grid[lastRow][lastCol];
                grid[lastRow][lastCol] = grid[0][lastCol];
                grid[0][lastCol] = temp;
            }
        }
    }
    
    public int section(int row, int col){
        int offset = 0;
        int rowSection = (row / 3) + 1;
        int colSection = col / 3;
        
        if(colSection == 1){
            offset = 3;
        } else if(colSection == 2){
            offset = 6;
        }
        
        return rowSection + offset;
    }
}
