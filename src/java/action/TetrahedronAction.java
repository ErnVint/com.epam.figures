package action;

import entity.Point;
import entity.Tetrahedron;

public class TetrahedronAction {
    public static void main(String[] args) {
        TetrahedronAction tetrahedronAction = new TetrahedronAction();
        double y3 = 0.8660254037844386;
        System.out.println(y3);
        double y4 = 0.28867513459481287;
        System.out.println(y4);
        double z4 = 0.8164965809277259;
        System.out.println(z4);
        Tetrahedron tetrahedron2 = new Tetrahedron(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0.5, y3, 0), new Point(0.5, y4, z4));
        Tetrahedron tetrahedron = new Tetrahedron(new Point(1, 1, 1), new Point(-1, -1, 1), new Point(-1, 1, -1), new Point(1, -1, -1));
        double sideA = tetrahedronAction.calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getB());
        double sideB = tetrahedronAction.calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getC());
        double sideC = tetrahedronAction.calculateDistanceViaHypot(tetrahedron.getB(), tetrahedron.getC());
        double sideD = tetrahedronAction.calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getD());
        double sideE = tetrahedronAction.calculateDistanceViaHypot(tetrahedron.getB(), tetrahedron.getD());
        double sideF = tetrahedronAction.calculateDistanceViaHypot(tetrahedron.getC(), tetrahedron.getD());
        System.out.println(sideA);
        System.out.println(sideB);
        System.out.println(sideC);
        System.out.println(sideD);
        System.out.println(sideE);
        System.out.println(sideF);

    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double sideLength = calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getB());
        double volume = Math.pow(sideLength, 3) * Math.sqrt(2) / 12;
        return volume;
    }

    public double calculateSquare(Tetrahedron tetrahedron) {
        double sideLength = calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getB());
        double square = Math.pow(sideLength, 2) * Math.sqrt(3);
        return square;
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron) {
        double sideA = calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getB());
        double sideB = calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getC());
        double sideC = calculateDistanceViaHypot(tetrahedron.getB(), tetrahedron.getC());
        double sideD = calculateDistanceViaHypot(tetrahedron.getA(), tetrahedron.getD());
        double sideE = calculateDistanceViaHypot(tetrahedron.getB(), tetrahedron.getD());
        double sideF = calculateDistanceViaHypot(tetrahedron.getC(), tetrahedron.getD());
        return (sideA == sideB && sideB == sideC && sideC == sideD && sideD == sideE && sideE == sideF);
    }

    public double calculateDistanceViaHypot(Point firstPoint, Point secondPoint) {
        double distance = Math.hypot(Math.hypot(firstPoint.getX() - secondPoint.getX(),
                firstPoint.getY() - secondPoint.getY()), (firstPoint.getZ() - secondPoint.getZ()));
        distance = Math.abs(distance);
        return distance;
    }




}
