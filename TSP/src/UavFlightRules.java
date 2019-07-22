import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class UavFlightRules {

    static int X = Tool.length;
    static int Y = Tool.length;
     // 在当前位置p处，下一次的位置(最多有8个位置),逆时针旋转
    public static ArrayList<Point> next(Point p) {
        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point(p);
        if ((p1.x = p.x - 1) >= 0 && (p1.y = p.y - 0) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x - 1) >= 0 && (p1.y = p.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 0) < X && (p1.y = p.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 1) < X && (p1.y = p.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 1) < X && (p1.y = p.y + 0) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 1) < X && (p1.y = p.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x - 0) >= 0 && (p1.y = p.y +1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x - 1) >= 0 && (p1.y = p.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }


    // 根据当前的这一步的所有下一步的选择数目进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size(); // 当前这一步o1的下一步的选择数目
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }
}
