import java.util.*;
import java.io.*;

public class BOJ_G4_17140 {

    private static int[][] arr = new int[201][201];
    private static int r,c,k;

    private static int row,col;

    private static class Pair {
        int val;
        int cnt;

        public Pair(int val,int cnt) {
            this.val=val;
            this.cnt=cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        row=col=3;

        for(int i=1;i<4;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<4;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(!checkArrVal()&&cnt++<100) {
            if(row>=col) Rcal();
            else Ccal();
        }

        System.out.println(cnt>100?-1:cnt);

    }

    private static void Ccal() {
        PriorityQueue<Pair>[] pq = new PriorityQueue[101];
        for(int i=1;i<101;i++) {
            pq[i] = new PriorityQueue<>((o1, o2) -> {
                if(o1.cnt==o2.cnt) return o1.val-o2.val;
                else return o1.cnt-o2.cnt;
            });
        }

        for(int i=1;i<=col;i++) {
            int[] tmp = new int[101];

            for(int j=1;j<=row;j++) {
                tmp[arr[j][i]]++; //개수 세기 (index=숫자, tmp[index]=갯수)
                arr[j][i]=0; //초기화
            }
            for(int idx=1;idx<101;idx++) {
                if(tmp[idx]!=0) {
                    pq[i].add(new Pair(idx,tmp[idx]));
                }
            }

            int idx=1;
            while(!pq[i].isEmpty()) {
                int val = pq[i].peek().val;
                int cnt = pq[i].peek().cnt;
                pq[i].poll();
                arr[idx++][i]=val;
                if(idx>100) break;
                arr[idx++][i]=cnt;
                if(idx>100) break;
            }

            row = Integer.max(row,idx);

        }

    }

    private static void Rcal() {

        PriorityQueue<Pair>[] pq = new PriorityQueue[101];
        for(int i=1;i<101;i++) {
            pq[i] = new PriorityQueue<>((o1, o2) -> {
                if(o1.cnt==o2.cnt) return o1.val-o2.val;
                else return o1.cnt-o2.cnt;
            });
        }

        for(int i=1;i<=row;i++) {
            int[] tmp = new int[101];

            for(int j=1;j<=col;j++) {
                tmp[arr[i][j]]++; //개수 세기 (index=숫자, tmp[index]=갯수)
                arr[i][j]=0; //초기화
            }
            for(int idx=1;idx<101;idx++) {
                if(tmp[idx]!=0) {
                    pq[i].add(new Pair(idx,tmp[idx]));
                }
            }

            int idx=1;
            while(!pq[i].isEmpty()) {
                int val = pq[i].peek().val;
                int cnt = pq[i].peek().cnt;
                pq[i].poll();
                arr[i][idx++]=val;
                if(idx>100) break;
                arr[i][idx++]=cnt;
                if(idx>100) break;
            }

            col = Integer.max(col,idx);

        }


    }

    private static boolean checkArrVal() {
        if (arr[r][c] == k) return true;
        else return false;
    }
}
