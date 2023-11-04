public class Polar2DAdapter implements IVector, IPolar2D{
    private Vector2D srcVector;
    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }
    @Override
    public double abs() {
        return this.srcVector.abs();
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
                return Math.atan(y / x); // Kąt w I ćwiartce
            } else {
                return 2 * Math.PI + Math.atan(y / x); // Kąt w IV ćwiartce
            }
        } else if (x < 0) {
            return Math.PI + Math.atan(y / x); // Kąt w II ćwiartce
        } else {
            if (y > 0) {
                return Math.PI / 2; // Kąt na dodatniej półosi Y
            } else if (y < 0) {
                return 3 * Math.PI / 2; // Kąt na ujemnej półosi Y
            } else {
                return 0; // Dla punktu (0, 0)
            }
        }
    }
}
