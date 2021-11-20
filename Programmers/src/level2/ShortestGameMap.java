import java.util.*;

class Solution {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    public int solution(int[][] maps) {
        return bfs(maps, maps.length - 1, maps[0].length - 1);
    }
    
    private int bfs(int[][] maps, int targetX, int targetY) {
        Queue<Node> q = new LinkedList();
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        
        q.add(new Node(0, 0, 1));
        visit[0][0] = true;
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            
            int qx = n.x;
            int qy = n.y;
            int qd = n.distance;
            
            if (qx == targetX && qy == targetY) {
                return qd;
            }
            
            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                
                if (nx < 0 || ny < 0 || nx > targetX || ny > targetY) {
                    continue;
                }
                
                if (!visit[nx][ny] && maps[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, qd + 1));
                }
            }
        }
        
        return -1;
    }//bfs
    
    static class Node {
        int x;
        int y;
        int distance;
        
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
