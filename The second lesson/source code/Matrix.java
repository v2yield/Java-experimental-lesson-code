public class Matrix{
    int row;
    int col;
    boolean flag1;
    boolean flag2;
    double[][] data;
    public Matrix(int row, int col, double[][] data){
        if(row > 0 && col >0 ){
            this.row = row;
            this.col = col;
            this.data = new double[this.row][this.col];
            for(int i = 0; i <= row-1; i++){
                for(int j = 0; j <= col-1; j++){
                    this.data[i][j] = data[i][j];
                }
            }
            flag1 = true;
            flag2 = true;
        }else {
            this.row=0;
            this.col=0;
            this.data = null;
            flag1 = false;
            flag2 = false;
        }
    }
    public void setRow(int row){
        if( row > 0) {
            this.row = row;
            flag1 = true;
        }else {
            this.row = 0;
            flag1 = false;
        }
    }
    public void setCol(int col){
        if( col > 0) {
            this.col = col;
            flag2 = true;
        }else {
            this.col = 0;
            flag2 = false;
        }
    }
    public void setData(double[][] data){
        if(flag1 && flag2 && data != null ) {
            for (int i = 0; i <= data.length - 1; i++) {
                for (int j = 0; j <= data[0].length - 1; j++) {
                    this.data[i][j] = data[i][j];
                }
            }
        }else{
            this.data = null;
        }
    }
    public int getRow(){
        if( row > 0 ) {
            return row;
        }else{
            System.out.println("矩阵无行");
            return -1;
        }

    }
    public int getCol(){
        if(col > 0) {
            return col;
        }else{
            System.out.println("矩阵无列");
            return -1;
        }
    }
    public double[][] getData(){
        if( data != null) {
            return data;
        }else{
            System.out.println("矩阵无数据");
            return null;
        }
    }
    public static boolean equals(Matrix a, Matrix b){
        if(a.row == b.row && a.col == b.col){
            for(int i = 0; i <= a.row-1; i++){
                for(int j = 0; j<= a.col-1; j++){
                    if(a.data[i][j] != b.data[i][j]){
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        String str = "";
        str = str + "矩阵行为：" + this.row + '\n' +  "矩阵列为：" + this.col + '\n';
        for(int i = 0; i <= this.row-1; i++){
            for(int j = 0; j <= this.col-1; j++){
                if(i == 0 && j == 0) {
                    str += "⌜" + String.format("%6.2f", this.data[i][j]);
                }
                else if(i == 0 && j == this.col-1) {
                    str += String.format("%6.2f", this.data[i][j]) + " ⌝\n";
                }
                else if(i == this.row-1 && j == 0) {
                    str += "⌞" + String.format("%6.2f", this.data[i][j]);
                }
                else if(i == this.row-1 && j == this.col-1) {
                    str += String.format("%6.2f", this.data[i][j]) + " ⌟";
                }
                else if( i >0 && i < this.row-1 && j == 0 ) {
                    str += "|" + String.format("%6.2f", this.data[i][j]);
                }
                else if( i >0 && i < this.row-1 && j == this.col-1 ) {
                    str += String.format("%6.2f", this.data[i][j]) + " |\n";
                }else {
                    str += String.format("%6.2f", this.data[i][j]);
                }
            }
        }
        return str;
    }
    public static Matrix Add(Matrix a, Matrix b){
        double[][] tmp = new double[a.row][a.col];
        for(int i = 0; i <= a.row-1; i++){
            for(int j = 0; j <= a.col-1; j++){
                tmp[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return new Matrix(a.row, a.col, tmp);
    }
    public static Matrix Minus(Matrix a, Matrix b){
        double[][] tmp = new double[a.row][a.col];
        for(int i = 0; i <= a.row-1; i++){
            for(int j = 0; j <= a.col-1; j++){
                tmp[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return new Matrix(a.row, a.col, tmp);
    }
    public static void main(String args[]){
        int row = 3;
        int col = 4;
        double[][] data1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        double[][] data2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Matrix matrix1 = new Matrix(row,col,data1);
        Matrix matrix2 = new Matrix(row,col,data2);
        System.out.println("矩阵1：");
        System.out.println(matrix1.toString());
        System.out.println("\n矩阵2：");
        System.out.println(matrix2.toString());
        System.out.println("\n矩阵1与矩阵2相加：");
        System.out.println(Matrix.Add(matrix1,matrix2).toString());
        System.out.println("\n矩阵1与矩阵2相减：");
        System.out.println(Matrix.Minus(matrix1,matrix2).toString());
        if(Matrix.equals(matrix1,matrix2)){
            System.out.println("矩阵相等");
        }
        else{
            System.out.println("矩阵不相等");
        }
    }
}

