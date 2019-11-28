package entity;

import generator.IdGenerator;

import java.util.Objects;

public class Point implements IFigure{
    private long pointId;
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.pointId = IdGenerator.generateId(); //Можно ли без создания объекта?
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        Point point = (Point) o;
        return (point.getPointId() == this.pointId)
                && (Double.compare(point.getX(), this.x) == 0)
                && (Double.compare(point.getY(), this.y) == 0)
                && (Double.compare(point.getZ(), this.z) == 0);
    }

    @Override
    public int hashCode() {
        //Josh Bloch's recipe
        int result;
        result = (int) (pointId ^ (pointId >>> 32));
        result = (int) (31 * result + Double.doubleToLongBits(x));
        result = (int) (31 * result + Double.doubleToLongBits(y));
        result = (int) (31 * result + Double.doubleToLongBits(z));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointId=" + pointId +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public boolean equalsPoint(Point point) {
        if (point == null) {
            return false;
        }
        if (this == point) {
            return true;
        }
        return (Double.compare(point.getX(), this.x) == 0)
                && (Double.compare(point.getY(), this.y) == 0)
                && (Double.compare(point.getZ(), this.z) == 0);
    }
}
