import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/*
Human Pyramids
by:Isabella Rolfe 09/22/19
 */
public class humanpyramids {
    public static double personsweight=200;
    public static double weightOnBackOf(int row, int col){
        if(row==0 && col==0){
            return 0;
        }
        else {
            //accounts for the most left
            if(col==0){
                return((weightOnBackOf(row-1,col)/2.0) +(personsweight/2.0));
            }
            //accounts for the most right
            else if(col==row){
                return((weightOnBackOf(row-1,col-1) /2.0)+(personsweight/2.0));
            }
            else{
                return(weightOnBackOf(row-1,col-1)/2.0+ personsweight/2.0 + weightOnBackOf(row-1, col)/2.0 + personsweight/2.0);
            }
        }
    }

    public static void main(String[] args) {
       double fullweight;
       fullweight=(weightOnBackOf(4,2));
       System.out.println(fullweight);
    }
}
