import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/*
Sierpinkskistriangle
by:Isabella Rolfe 09/22/19
 */
public class playSierpinskitriangle {
    public static void drawSierpinskiTriangle( double x, double y, double sideLength, int order){
        drawTriangle(x,y,sideLength);
        if(order>0){
            double newsidelength=sideLength/2;
            double smallheight=newsidelength/2*Math.sqrt(3.0);
            double topx=x+newsidelength/2;
            double topy=y+smallheight;
            double rightx=x+newsidelength;
            drawSierpinskiTriangle(x,y,newsidelength,order-1);
            drawSierpinskiTriangle(topx,topy,newsidelength,order-1);
            drawSierpinskiTriangle(rightx,y,newsidelength,order-1);
        }
    }

    public static void drawTriangle(double x, double y, double sidenlength){
        double rightcornorx=x+sidenlength;
        double height=sidenlength/2*Math.sqrt(3.0);
        double topx=x+(sidenlength/2);
        double topy=y+height;
        StdDraw.line(x, y, rightcornorx, y);
        StdDraw.line(rightcornorx, y, topx, topy);
        StdDraw.line(topx, topy, x, y);
    }

    public static void main(String[] args) {
        drawSierpinskiTriangle(.1,.2,.7,12);
    }
}
