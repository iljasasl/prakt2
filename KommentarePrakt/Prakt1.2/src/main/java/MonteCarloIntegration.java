public class MonteCarloIntegration {

    private static final int MAX_ITERATIONS = 100000;
    private static final double MIN_CHANGE = 1e-5;


    public static double function(double x) {
        //return x;
        return Math.sin(Math.PI * x);
    }

    private static boolean samplePoint(){
        double x = Math.random();
        double y = Math.random();

        return y <= function(x);
    }

    public static void main(String[] args) {

        double approxInt = 0;
        double change;
        int allPoints = 0;
        int pointsUnderCurve = 0;
        double newApproxInt;

        do {

            /**
             * Problem ist das manchmal vorallem am Anfang pointsUnderCurve und allPoints gleich sind und dadurch change > Min_Change
             * manchmal viel zu früh nicht zutrifft wodurch die schleife zu früh aufhört bevor eine sinvolle menge an durchläufen stattfinden
             */
            if (samplePoint())
                pointsUnderCurve++;

            allPoints++;

            newApproxInt = ((double) pointsUnderCurve / allPoints);

            change = Math.abs(approxInt - newApproxInt);

            System.out.printf("pointsunder %d%n", pointsUnderCurve);
            System.out.printf("allPoints %d%n", allPoints);

            approxInt = newApproxInt;

            System.out.printf("Iteration %d: %.5f (%f)%n", allPoints, approxInt, change);


        /**
         * ich habe einfach die while bisschen verändert und zwar das es mindestens 100 durchläufe gibt damit genug randomness entsteht wodurch die wahrscheinlich
         * das das komische verhalten auftritt stark gesenkt wird 
         */
        } while ((change > MIN_CHANGE || allPoints < 100) && allPoints < MAX_ITERATIONS);

    }
}
