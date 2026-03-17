package util;

public abstract class AdditionalMath {
    public static double DistanceBetween(Position A, Position B) {
        return Math.sqrt( Math.pow(A.X - B.X, 2) + Math.pow(A.Y - B.Y, 2));
    }

    public static double round(double num) {
        return ((int) (num * 100)) / 100.0;
    }

    public static double DistanceToSpeed(double distance) {
        return (int) Math.pow(distance, 1.5) * 0.5;
    }
}
