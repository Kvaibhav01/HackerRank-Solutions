import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Point {
  public final int i;
  public final int j;
  public boolean visited;

  public Point(int i, int j) {
    this.i = i;
    this.j = j;
    visited = false;
  }

  public boolean connected(Point compare) {
    for (int i_a = -1; i_a <= 1; i_a++) {
      for(int j_a = -1; j_a <= 1; j_a++) {
        if( i + i_a == compare.i && j + j_a == compare.j) {
          return true;
        }
      }
    }
    return false;
  }

  public String toString() {
    return i + "," + j;
  }

}

public class Solution {

  public static int getPathLength(Collection<Point> points, Point startPoint) {
    startPoint.visited = true;
    int pathLength = 1;
    for(Point point : points ) {
      if (!point.visited && startPoint.connected(point)) {
        pathLength += getPathLength(points, point);
      }
    }
    return pathLength;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    Collection<Point> points = new ArrayList<Point>();
    int maxLength = 0;
    for(int grid_i=0; grid_i < n; grid_i++){
      for(int grid_j=0; grid_j < m; grid_j++){
        if (in.nextInt() != 0) {
          Point point = new Point(grid_i, grid_j);
          points.add(point);
        }
      }
    }

    for (Point point : points) {
      if (!point.visited) {
        int length = getPathLength(points,point);
        if (length > maxLength) {
          maxLength = length;
        }
      }
    }

    System.out.printf("%d\n", maxLength);
  }
}
