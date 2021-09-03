import java.util.*;
import java.io.*;

public class BOJ_S4_1620 {

    private static HashMap<Integer,String> poketmonKey;
    private static HashMap<String,Integer> poketmonName;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        poketmonKey = new HashMap<>();
        poketmonName= new HashMap<>();
        int index=1; // 키의 초기값

        //도감 채우기
        while(index<=N) {
            String name = br.readLine();
            poketmonKey.put(index,name);
            poketmonName.put(name,index++);
        }

        //정답 채우고 출력
        while(M>0) {
            M--;
            String str = br.readLine();
            if(str.charAt(0)-'0'>9) {
                find(str);
                continue;
            }
            find(Integer.parseInt(str));
        }
        System.out.println(sb);
    }

    private static void find(Integer num) {
        sb.append(poketmonKey.get(num)+"\n");
    }

    private static void find(String name) {
        sb.append(poketmonName.get(name)+"\n");
    }

}
