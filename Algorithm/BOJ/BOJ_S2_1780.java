import java.util.*;
import java.io.*;

public class BOJ_S2_1780 {

    private static int[][] paper;
    private static int[] answer = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //입력
        paper = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0,N);
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]+"\n").append(answer[1]+"\n").append(answer[2]);
        System.out.print(sb);
    }

    /**
     *
     * @param row : 시작 행 번호
     * @param col : 시작 열 번호
     * @param len : 검사 길이
     */
    private static void recur(int row, int col, int len) {

        int num = paper[row][col];
        boolean check = true;

        //같은 숫자인지 판별
        check:
        for(int i=row;i<row+len;i++) {
            for(int j=col;j<col+len;j++) {
                if(num!=paper[i][j]){
                    check = false;
                    break check;
                }
            }
        }

        //같으면 해당 숫자 증가시키고 리턴
        if(check) {
            answer[num+1]++;
            return;
        }

        //다르면 9분할로 재귀
        recur(row, col, len/3);
        recur(row, col+len/3, len/3);
        recur(row, col+2*len/3, len/3);

        recur(row+len/3, col, len/3);
        recur(row+len/3, col+len/3, len/3);
        recur(row+len/3, col+2*len/3, len/3);

        recur(row+2*len/3, col, len/3);
        recur(row+2*len/3, col+len/3, len/3);
        recur(row+2*len/3, col+2*len/3, len/3);

    }

}
