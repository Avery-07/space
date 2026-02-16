package util;

public abstract class AdditionalMath {
    public static double DistanceBetween(Position A, Position B) {
        return Math.sqrt( Math.pow(A.X - B.X, 2) + Math.pow(A.Y - B.Y, 2));
    }
}
