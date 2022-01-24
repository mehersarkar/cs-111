public class Sierpinski {
    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        // formula= length*sqrt(3)/2
        double h = (length * Math.sqrt(3)) / 2.0;
        return h;
    }
     // method to draw a filled triangle (pointed downwards) with bottom vertex
     // x,y

    public static void filledTriangle(double x, double y, double length) {
          // finding height
          double h = height(length);
          // filling triangle as a polygon
          // passing x, x-length/2, x+length/2 as x coordinates
          // and y, y+h, y+h as y coordinates
          StdDraw.filledPolygon(new double[] { x, x - (length / 2.0), x + (length / 2.0) }, new double[] { y, y + h, y + h });
    }
    
    public static void sierpinski(int n, double x, double y, double length) {
        // checking if n is above 0 (base condition)

        if (n > 0) {
            // drawing a filled triangle with x, y as bottom coordinate, length
            // as side length
            filledTriangle(x, y, length);
            // drawing the triangle(s) on the top
            sierpinski(n - 1, x, y + height(length), length / 2);
            // drawing the triangle(s) on the left side
            sierpinski(n - 1, x - (length / 2.0), y, length / 2);
            // drawing the triangle(s) on the right side
            sierpinski(n - 1, x + (length / 2.0), y, length / 2);

        }
    }
    public static void main(String[] args) {
        // parsing first command line argument as integer, if you dont provide
           // the value while running the program, this program will cause
           // exception.
           int n = Integer.parseInt(args[0]);
           // length of the outline triangle
           double length = 1;
           // finding height
           double h = height(length);
           // drawing a triangle (pointed upwards) to represent the outline.
           StdDraw.polygon(new double[] { 0, length / 2, length }, new double[] {0, h, 0 });
           // drawing n level sierpinski triangle(s) with length / 2, 0 as x,y
           // coordinates and length / 2 as initial side length
           sierpinski(n, length / 2, 0, length / 2);
    }

}




