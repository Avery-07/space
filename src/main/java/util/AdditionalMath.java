package util;

public abstract class AdditionalMath {
    public static double DistanceBetween(Position A, Position B) {
        return Math.sqrt( Math.pow(A.X - B.X, 2) + Math.pow(A.Y - B.Y, 2));
    }

    public static double round(double num) {
        return ((int) (num * 100)) / 100.00;
    }
}
