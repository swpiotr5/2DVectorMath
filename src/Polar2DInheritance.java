public class Polar2DInheritance extends Vector2D {
    public Polar2DInheritance(double x, double y){
        super(x, y);
    }
    public double getAngle() {
        double x = super.getComponents()[0];
        double y = super.getComponents()[1];

        if (x > 0) {
            if (y >= 0) {
                return Math.round(Math.toDegrees(Math.atan(y / x)) * 100.0) / 100.0; // Kąt w I ćwiartce
            } else {
                return Math.round((Math.toDegrees(2 * Math.PI + Math.atan(y / x)) * 100.0) / 100.0); // Kąt w IV ćwiartce
            }
        } else if (x < 0) {
            return Math.round((Math.toDegrees(Math.PI + Math.atan(y / x)) * 100.0) / 100.0); // Kąt w II ćwiartce
        } else {
            if (y > 0) {
                return Math.round((Math.toDegrees(Math.PI / 2) * 100.0) / 100.0); // Kąt na dodatniej półosi Y
            } else if (y < 0) {
                return Math.round((Math.toDegrees(3 * Math.PI / 2) * 100.0) / 100.0); // Kąt na ujemnej półosi Y
            } else {
                return 0.0; // Dla punktu (0, 0)
            }
        }
    }
}