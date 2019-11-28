package entity;

import generator.IdGenerator;

public class Tetrahedron implements IFigure{
    private long tetrahedronId;
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Tetrahedron(Point a, Point b, Point c, Point d) {
        this.tetrahedronId = IdGenerator.generateId();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public long getTetrahedronId() {
        return tetrahedronId;
    }

    public void setTetrahedronId(long tetrahedronId) {
        this.tetrahedronId = tetrahedronId;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Tetrahedron tetrahedron = (Tetrahedron) o;
        return (tetrahedron.getTetrahedronId() == this.tetrahedronId)
                && tetrahedron.getA().equals(this.a)
                && tetrahedron.getB().equals(this.b)
                && tetrahedron.getC().equals(this.c)
                && tetrahedron.getD().equals(this.d);
    }

    @Override
    public int hashCode() {
        //Josh Bloch's recipe
        int result;
        result = (int) (tetrahedronId ^ (tetrahedronId >>> 32));
        result = 31 * result + a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + d.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "tetrahedronId=" + tetrahedronId +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public boolean equalsTetrahedron(Tetrahedron tetrahedron) {
        if (tetrahedron == null) {
            return false;
        }
        if (this == tetrahedron) {
            return true;
        }
        return tetrahedron.getA().equals(this.a)
                && tetrahedron.getB().equals(this.b)
                && tetrahedron.getC().equals(this.c)
                && tetrahedron.getD().equals(this.d);
    }
}
