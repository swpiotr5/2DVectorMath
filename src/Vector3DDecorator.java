public class Vector3DDecorator implements IVector{
    private IVector srcVector;
    private double z;
    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }
    @Override
    public double abs() {
        double abs2D = srcVector.abs();
        return Math.sqrt(abs2D * abs2D + z * z);
    }
    @Override
    public double cdot(IVector param) {
        double[] components = srcVector.getComponents();
        double[] components_3d = param.getComponents();
        return components[0]*components_3d[0]+components[1]*components_3d[1]+z*components_3d[2];
    }

    @Override
    public double[] getComponents() {
        double[] srcComponents = srcVector.getComponents();
        double x = srcComponents[0];
        double y = srcComponents[1];
        return new double[]{x, y, z};
    }
    public Vector3DDecorator cross(IVector param) {
        double[] srcComponents = srcVector.getComponents();
        double[] paramComponents = param.getComponents();
        double x1 = srcComponents[0];
        double y1 = srcComponents[1];
        double z1 = srcComponents[2];
        double x2 = paramComponents[0];
        double y2 = paramComponents[1];
        double z2 = paramComponents[2];

        // [x1,y1,z]
        // [x2,y2,z]

        double crossX = y1*z2 - z1*y2;
        double crossY = z1*x2 - x1*z2;
        double crossZ = x1*y2 - y1*x2;

        return new Vector3DDecorator(new Vector2D(crossX, crossY), crossZ);
    }

    public IVector getSrcV(){
        return srcVector;
    };
}
