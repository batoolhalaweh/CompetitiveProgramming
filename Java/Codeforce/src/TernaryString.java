import java.io.BufferedReader;
import java.io.IOException; import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TernaryString {
	public static void main(String[] args)  {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = fs.nextInt();
		for (int t = 0; t < tc; t++) {
			String s = fs.next();
			int one = -1, two = -1, three = -1;
			int ans = Integer.MAX_VALUE;
			for(int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				if(c == '1') one = i;
				else if(c == '2') two = i;
				else three = i;
				if(one == -1 || two == -1 || three == -1)
					continue;
				int r = Math.max(one, Math.max(two, three));
				int l = Math.min(one, Math.min(two, three));
				ans = Math.min(ans, r - l + 1);
			}
			System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
		}
	}
	static void ruffleSort(int[] a) {
		int n = a.length;
		Random r = new Random();
		for(int i = 0; i < a.length; ++i) {
			int oi = r.nextInt(n), t = a[i];
			a[i] = a[oi];
			a[oi] = t;
		}
		Arrays.sort(a);
	}
	static void sort(int[] a)   {
		ArrayList<Integer> l = new ArrayList<>();
		for(int i : a) l.add(i);
		Collections.sort(l);
		for(int i = 0; i < a.length; ++i) a[i] = l.get(i);
	}
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next()   {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; ++i)
				a[i] = nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}