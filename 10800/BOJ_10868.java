import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int init(int[] arr, int[] seg, int n, int s, int e) {
		return s==e?(seg[n]=arr[s]):(seg[n] = Math.min(init(arr,seg,n*2,s,(s+e)/2), init(arr,seg,n*2+1,(s+e)/2+1,e)));
	}
	
	private static int min(int[] seg, int n, int s, int e, int l, int r) {
		if (l>e || r<s) 	return Integer.MAX_VALUE;
		if (l<=s && e<=r) 	return seg[n];
		return Math.min(min(seg,n*2,s,(s+e)/2,l,r), min(seg,n*2+1,(s+e)/2+1,e,l,r));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		int[] arr = new int[N];
		int[] seg = new int[1<<(h+1)];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		init(arr, seg, 1, 0, N-1);
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			bw.write(min(seg, 1, 0, N-1, l, r) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
