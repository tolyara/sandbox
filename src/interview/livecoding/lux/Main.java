package interview.livecoding.lux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Point a = new Point(2, 4);  // 4.47
        Point b = new Point(-1, 1); // 1.41
        Point c = new Point(-5, -5);// 7.07
        Point d = new Point(2, -2); // 2.89

        List<Point> src = new ArrayList<>();
        src.add(a);
        src.add(b);
        src.add(c);
        src.add(d);

        List<Point> sorted = sort(src);
        System.out.println(sorted);
    }

    private static List<Point> sort(List<Point> src) {
        return src.stream().map(p -> new PointDistance(p)).sorted().map(pd -> pd.point).collect(Collectors.toList());
    }

}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}

class PointDistance implements Comparable<PointDistance> {

    Point point;
    double distance;

    public PointDistance(Point point) {
        this.point = point;
        distance = Math.sqrt(point.x * point.x + point.y * point.y);
    }

    @Override
    public int compareTo(PointDistance o) {
        double diff = this.distance - o.distance;
        if (diff == 0) return 0;
        return diff > 0 ? 1 : -1;
    }

}


