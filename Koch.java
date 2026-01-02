/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
	
		if(n==0){
			StdDraw.line(x2, y2, x1, y1);
			return; 
		}
		// חלוקחת הקו לשלושה חלקים 
		double xp2 = x1 + (x2 - x1) / 3.0;
		double yp2 = y1 + (y2 - y1) / 3.0;
	
		double xp4 = x1 + 2.0 * (x2 - x1) / 3.0;
		double yp4 = y1 + 2.0 * (y2 - y1) / 3.0;

		double sqrt3 = Math.sqrt(3.0);
 	    double xp3 = 0.5 * (x1 + x2) - (sqrt3 / 6.0) * (y2 - y1);
    	double yp3 = 0.5 * (y1 + y2) + (sqrt3 / 6.0) * (x2 - x1);
		// רקורסיה 
		 curve(n - 1, x1, y1, xp2, yp2);     
   		 curve(n - 1, xp2, yp2, xp3, yp3); 
   		 curve(n - 1, xp3, yp3, xp4, yp4); 
   		 curve(n - 1, xp4, yp4, x2, y2);

		}


    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);


		double x1 = 0.1,  y1 = 0.75;  
        double x2 = 0.9,  y2 = 0.75;  
        double x3 = 0.5,  y3 = 0.05;  

        
        curve(n, x1, y1, x2, y2);
        
        curve(n, x2, y2, x3, y3);
		        
        curve(n, x3, y3, x1, y1);
	}
}
