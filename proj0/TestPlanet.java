public class TestPlanet {
    public static void main(String[] args){CheckPairForce();}
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }
    public static void CheckPairForce(){
        System.out.println("Checking PairForce...");

        Planet p1 = new Planet(1.0E12, 2.0E11, 3.0, 4.0, 2.0E30, "jupiter.gif");
        Planet p2 = new Planet(2.3E12, 9.5E11, 3.0, 4.0, 6.0E26, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 3.6E22, "calcForceExertedBy()", 0.1);

    }
}
