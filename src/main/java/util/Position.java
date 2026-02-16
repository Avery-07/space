package util;

public class Position {
    public double X,Y;

    public Position(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position temp) {
            return X == temp.X && Y == temp.Y;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "(" + X + "," + Y + ")";
    }
}
