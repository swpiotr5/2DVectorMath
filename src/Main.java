import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        // Tworzenie trzech przykładowych wektorów
        Vector2D vector1 = new Vector2D(5.0, 2.0);
        Vector2D vector2 = new Vector2D(1.0, 5.0);
        Vector2D vector3 = new Vector2D(2.0, 6.0);

        // Wyświetlanie współrzędnych w układach kartezjańskim
        System.out.println("Współrzędne kartezjańskie:");
        System.out.println("Vector1: " +  Arrays.toString(vector1.getComponents()));
        System.out.println("Vector2: " +  Arrays.toString(vector2.getComponents()));
        System.out.println("Vector3: " +  Arrays.toString(vector3.getComponents()));
        System.out.println();

        Polar2DAdapter vector1_adapt = new Polar2DAdapter(vector1);
        Polar2DAdapter vector2_adapt = new Polar2DAdapter(vector2);
        Polar2DAdapter vector3_adapt = new Polar2DAdapter(vector3);

        // Obliczanie współrzędnych biegunowych i ich wyświetlanie - adapter
        System.out.println("Współrzędne biegunowe - adapter:");
        System.out.println("Vector1 w biegunowych: (r=" + vector1_adapt.abs() + ", θ=" + vector1_adapt.getAngle() + ")");
        System.out.println("Vector2 w biegunowych: (r=" + vector2_adapt.abs() + ", θ=" + vector2_adapt.getAngle() + ")");
        System.out.println("Vector3 w biegunowych: (r=" + vector3_adapt.abs() + ", θ=" + vector3_adapt.getAngle() + ")");
        System.out.println();

        Polar2DInheritance vector1_inherit = new Polar2DInheritance(5.0, 2.0);
        Polar2DInheritance vector2_inherit = new Polar2DInheritance(1.0, 5.0);
        Polar2DInheritance vector3_inherit = new Polar2DInheritance(2.0, 6.0);

        // Obliczanie współrzędnych biegunowych i ich wyświetlanie - dziedziczenie
        System.out.println("Współrzędne biegunowe - dziedziczenie:");
        System.out.println("Vector1 w biegunowych: (r=" + vector1_inherit.abs() + ", θ=" + vector1_inherit.getAngle() + ")");
        System.out.println("Vector2 w biegunowych: (r=" + vector2_inherit.abs() + ", θ=" + vector2_inherit.getAngle() + ")");
        System.out.println("Vector3 w biegunowych: (r=" + vector3_inherit.abs() + ", θ=" + vector3_inherit.getAngle() + ")");
        System.out.println();

        // Obliczanie iloczynu skalarnego
        double dotProduct12 = vector1.cdot(vector2);
        double dotProduct13 = vector1.cdot(vector3);
        double dotProduct23 = vector2.cdot(vector3);

        // Wyświetlanie wyników iloczynu skalarnego
        System.out.println("Iloczyn skalarny Vector1 i Vector2: " + dotProduct12);
        System.out.println("Iloczyn skalarny Vector1 i Vector3: " + dotProduct13);
        System.out.println("Iloczyn skalarny Vector2 i Vector3: " + dotProduct23);
        System.out.println();

        //Obliczanie iloczynu wektorowego - dziedziczenie
        Vector3DInheritance vector1_3d_i = new Vector3DInheritance(5, 2, 0);
        Vector3DInheritance vector2_3d_i = new Vector3DInheritance(1, 5, 0);
        Vector3DInheritance vector3_3d_i = new Vector3DInheritance(2, 6, 0);

        Vector3DInheritance crossProduct12 = vector1_3d_i.cross(vector2_3d_i);
        Vector3DInheritance crossProduct13 = vector1_3d_i.cross(vector3_3d_i);
        Vector3DInheritance crossProduct23 = vector2_3d_i.cross(vector3_3d_i);
        Vector3DInheritance crossProduct21 = vector2_3d_i.cross(vector1_3d_i);
        Vector3DInheritance crossProduct31 = vector3_3d_i.cross(vector1_3d_i);
        Vector3DInheritance crossProduct32 = vector3_3d_i.cross(vector2_3d_i);

        System.out.println("Iloczyn wektorowy - dziedziczenie:");
        System.out.println("Iloczyn wektorowy Vector1 i Vector2: (" + Arrays.toString(crossProduct12.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector1 i Vector3: (" + Arrays.toString(crossProduct13.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector2 i Vector3: (" + Arrays.toString(crossProduct23.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector2 i Vector1: (" + Arrays.toString(crossProduct21.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector3 i Vector1: (" + Arrays.toString(crossProduct31.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector3 i Vector2: (" + Arrays.toString(crossProduct32.getComponents()) + ")");
        System.out.println();

        //Obliczanie iloczynu wektorowego - dekorator

        Vector3DDecorator vector1_3d_d = new Vector3DDecorator(vector1, 0);
        Vector3DDecorator vector2_3d_d = new Vector3DDecorator(vector2, 0);
        Vector3DDecorator vector3_3d_d = new Vector3DDecorator(vector3, 0);

        Vector3DDecorator crossProduct12d = vector1_3d_d.cross(vector2_3d_d);
        Vector3DDecorator crossProduct13d = vector1_3d_d.cross(vector3_3d_d);
        Vector3DDecorator crossProduct23d = vector2_3d_d.cross(vector3_3d_d);
        Vector3DDecorator crossProduct21d = vector2_3d_d.cross(vector1_3d_d);
        Vector3DDecorator crossProduct31d = vector3_3d_d.cross(vector1_3d_d);
        Vector3DDecorator crossProduct32d = vector3_3d_d.cross(vector2_3d_d);

        System.out.println("Iloczyn wektorowy - dekorator:");
        System.out.println("Iloczyn wektorowy Vector1 i Vector2: (" + Arrays.toString(crossProduct12d.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector1 i Vector3: (" + Arrays.toString(crossProduct13d.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector2 i Vector3: (" + Arrays.toString(crossProduct23d.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector2 i Vector1: (" + Arrays.toString(crossProduct21d.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector3 i Vector1: (" + Arrays.toString(crossProduct31d.getComponents()) + ")");
        System.out.println("Iloczyn wektorowy Vector3 i Vector2: (" + Arrays.toString(crossProduct32d.getComponents()) + ")");
        System.out.println();
    }
}

