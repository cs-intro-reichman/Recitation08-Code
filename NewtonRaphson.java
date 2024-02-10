public class NewtonRaphson {
    /**
     * Finds a root of a polynomial. Uses the Newton-Raphson method.
     * @param p - a polynomial
     * @return the root of a polynomial. If no root is found, returns Nan.
     */
    public static double root(Polynomial p) {
        final int MAX_NUMBER_OF_ITERATIONS = 1000000;
        final double EPSILON = 0.0001;       
        if(p.degree() == 0) { //If the polynomial is constant, check if it’s 0.
            if (p.evaluate(0) == 0) {
                return 0;
            } else {
                return Double.NaN;
            }
        }
        double x = 1000; // Start the initial guess at 1000, arbitrary.
        Polynomial dp = p.derivative();
        //run Newton-Raphson's method a fixed amount of iterations.
        for (int i = 0; i < MAX_NUMBER_OF_ITERATIONS; i++) {
            if (Math.abs(p.evaluate(x)) < EPSILON){
                return x;
		}
            x = x - p.evaluate(x) / dp.evaluate(x);
        }
        return Double.NaN; // return NaN if no root was found.
    }
    public static void main(String[] args) {
        double[] d = {1,1,2,1};             // 1 + x + 2x^2 + x^3
        Polynomial p = new Polynomial(d);   // According to Wolfram Alpha has a root at -1.7549
        System.out.println(root(p));        // -1.7548832293321002
    }

}

