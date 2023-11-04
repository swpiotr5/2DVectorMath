public class Vector3DInheritance extends Vector2D {
    private double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        return Math.sqrt(super.abs() * super.abs() + z * z);
    }

    @Override
    public double cdot(IVector param) {
        double[] components = super.getComponents();
        double[] components_3d = param.getComponents();
        return components[0]*components_3d[0]+components[1]*components_3d[1]+z*components_3d[2];
    }
    @Override
    public double[] getComponents() {
        double[] components2D = super.getComponents();
        double x = components2D[0];
        double y = components2D[1];
        return new double[]{x, y, z};
    }

    public Vector3DInheritance cross(IVector param) {
        double[] srcComponents = this.getComponents();
        double[] paramComponents = param.getComponents();
        double x1 = srcComponents[0];
        double y1 = srcComponents[1];
        double z1 = srcComponents[2];
        double x2 = paramComponents[0];
        double y2 = paramComponents[1];
        double z2 = paramComponents[2];

        double crossX = y1*z2 - z1*y2;
        double crossY = z1*x2 - x1*z2;
        double crossZ = x1*y2 - y1*x2;

        return new Vector3DInheritance(crossX, crossY, crossZ);
    }

    public IVector getSrcV(){
        return new Vector2D(this.getComponents()[0], this.getComponents()[1]);
    };
}