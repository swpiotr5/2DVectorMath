public class Polar2DAdapter implements IVector, IPolar2D{
    private Vector2D srcVector;
    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }
    @Override
    public double abs() {
        double result = this.srcVector.abs();
        return Math.round(result * 100.0) / 100.0;
    }
    @Override
    public double cdot(IVector param) {
        return this.srcVector.cdot(param);
    }
    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }
    @Override
    public double getAngle() {
        double x = srcVector.getComponents()[0];
        double y = srcVector.getComponents()[1];

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
