import java.awt.Point;

class PointDistComparator implements Comparator<Point> {
    
    Point origin = new Point(0,0);
    
    public int compare(Point a, Point b) {
        double distA = Math.sqrt(Math.pow(Math.abs(a.x - origin.x), 2) + Math.pow(Math.abs(a.y - origin.y), 2));
        
        double distB = Math.sqrt(Math.pow(Math.abs(b.x - origin.x), 2) + Math.pow(Math.abs(b.y - origin.y), 2));
        
        return (distA - distB) > 0 ? -1 : 1;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new PointDistComparator());
        
        
        for(int i=0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pq.offer(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int [][]res = new int[k][2];
        for(int i = 0; i < k; i++)
        {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        
        return res;
    }
}