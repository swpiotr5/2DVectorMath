public class Vector2D implements IVector{
    private double x;
    private double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public double abs() {
        double result = Math.sqrt(x * x + y * y);
        return Math.round(result * 100.0) / 100.0;
    }

    @Override
    public double cdot(IVector param) {
        return this.x * param.getComponents()[0] + this.y * param.getComponents()[1];
    }

    @Override
    public double[] getComponents() {
        return new double[]{x, y};
    }
}
