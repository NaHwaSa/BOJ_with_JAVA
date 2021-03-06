import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp1 = st.nextToken();
			String tmp2 = st.nextToken();
			while (st.hasMoreTokens())
				bw.write(st.nextToken() + " ");
			bw.write(tmp1 + " " + tmp2 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
