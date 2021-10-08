import java.util.*;

public class Programmers_weekly_Challenge9 {
    private static int n = 9;
    private static int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
    private static boolean[] visit = new boolean[n+1];
    public static void main(String[] args) {

        System.out.print(solution(n,wires));
    }

    private static int solution(int n, int[][] wires) {
        int answer = n;
        for(int i=0;i<wires.length;i++) {
            answer = Math.min(find(i),answer);
        }
        return answer;
    }

    private static int find(int idx) {
        Arrays.fill(visit,false);
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer>[] list = new ArrayList[n+1];

        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<wires.length;i++) {
            if(i!=idx) {
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }
        }

        visit[1]=true;
        queue.add(1);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i=0;i<list[cur].size();i++) {
                int next = list[cur].get(i);
                if(visit[next]) continue;
                visit[next]=true;
                queue.add(next);
            }
        }

        int cnt=0;
        for(boolean check:visit) {
            if(check) cnt++;
        }

        return Math.abs(cnt-Math.abs(cnt-n));

    }

}
