import java.util.ArrayList;
/*
Humans Pyramids with Extension
by:Isabella Rolfe 09/22/19
 */
public class humanpyramidsetc {
    public static double personsweight=200;
    public static double[][] values;
    public static double weightOnBackOf(int row, int col){
        values=new double[row+1][col+1];
        //setting all to null so it can check in elseif statements
        for(int x=0;x<row;x++){
            for(int y=0;y<col;y++){
                values[row][col]=0;
            }
        }
        //weightofbackof is the wrapper method
        return Shorten(row, col, values);
    }

    public static double Shorten(int row, int col, double[][]values){
        if(row==0 && col==0){
            return 0;
        }
        else {
            //accounts for the most left
            if(col==0){
                if(values[row][col]!=0) {
                    return values[row][col];
                }
                else {
                    Double x = ((Shorten(row - 1, col, values) / 2.0) + (personsweight / 2.0));
                    values[row][col] = x;
                    return x;
                }
            }
            //accounts for the most right
            else if(col==row){
                if(values[row][col]!=0) {
                    return values[row][col];
                }
                else {
                    Double x = ((Shorten(row - 1, col - 1,values) / 2.0) + (personsweight / 2.0));
                    values[row][col] = x;
                    return x;
                }
            }
            else{
                if(values[row][col]!=0) {
                    return values[row][col];
                }
                else {
                    Double y = (Shorten(row - 1, col - 1, values) / 2.0 + personsweight / 2.0 + weightOnBackOf(row - 1, col) / 2.0 + personsweight / 2.0);
                    values[row][col] = y;
                    return y;
                }
            }
        }
    }

    public static void main(String[] args) {
        double fullweight;
        fullweight=(weightOnBackOf(4,2));
        System.out.println(fullweight);
    }
}
