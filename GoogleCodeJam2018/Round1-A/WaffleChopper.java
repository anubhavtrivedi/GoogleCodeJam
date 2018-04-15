import java.util.*;
import java.io.*;

public class WaffleChopper {
	public static void main(String[] args) {
		// usual problems
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		boolean res = false;
		int t = in.nextInt();
		int r, c, h, v;
		float div;
		String md, result;
		char[] row;
		int count = 0;
		for (int i = 1; i <= t; i++) {

			// changes
			r = in.nextInt();
			c = in.nextInt();
			h = in.nextInt();
			v = in.nextInt();
			in.nextLine();
			char[][] pie = new char[r][c];
			for (int j = 0; j < r; j++) {
				pie[j] = in.nextLine().toCharArray();
			}
			count = 0;
			div = (v + 1) * (h + 1);
			for (int k = 0; k < r; k++) {

				for (int j = 0; j < c; j++) {
					if (pie[k][j] == '@')
						count++;
				}
			}
			div = count / div;
			if (div % 1 > 0) {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
				continue;
			}
			int avg = (int) div;
			res = solve(r, c, h, v, pie, avg);
			if (res)
				System.out.println("Case #" + i + ": " + "POSSIBLE");
			else
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
		}

	}

	private static void getRect(char[][] pie, int[][] rect, int r, int c) {
		int count = 0;
		for (int i = 0; i < c; i++) {
			if (pie[0][i] == '@')
				count++;
			rect[0][i] = count;
		}

		for (int i = 1; i < r; i++) {
			count = 0;
			for (int j = 0; j < c; j++) {
				if (pie[i][j] == '@')
					count++;
				rect[i][j] = count + rect[i - 1][j];
			}
		}
	}

	private static boolean solve(int r, int c, int h, int v, char[][] pie, int avg) {
		int[] chipsRow = new int[r];
		boolean pos = true;
		int[] chipsCol = new int[c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (pie[i][j] == '@') {
					chipsRow[i]++;
					chipsCol[j]++;
				}
			}
		}
		for (int i = 1; i < r; i++) {
			chipsRow[i] += chipsRow[i - 1];
		}
		for (int i = 1; i < c; i++) {
			chipsCol[i] += chipsCol[i - 1];

		}
		// horizontal cuts
		int cut = avg * (v + 1), top = 0, ind = 0;
		int[] hcut = new int[h];
		while (h > 0) {
			pos = false;
			while (top < r) {
				if (chipsRow[top] == cut) {
					hcut[ind] = top;
					ind++;
					pos = true;
					break;
				}
				top++;
			}
			cut += cut;
			h--;
		}
		if (!pos) {

			return false;
		}

		cut = avg * (hcut.length + 1);
		// System.out.println(cut+" vcut");
		top = 0;
		ind = 0;
		int[] vcut = new int[v];
		while (v > 0) {
			pos = false;
			while (top < c) {
				if (chipsCol[top] == cut) {
					vcut[ind] = top;
					ind++;
					pos = true;
					break;
				}
				top++;
			}
			cut += cut;
			v--;
		}
		if (!pos) {
			return false;
		}

		// check each sub divided pie
		int[][] rect = new int[r][c];
		getRect(pie, rect, r, c);
		int count = 0;
		int ist, iend, jst, jend;
		for (int i = 0; i < vcut.length + 1; i++) {

			if (i == vcut.length) {
				ist = vcut[i - 1] + 1;
				iend = c - 1;
			} else {
				if (i == 0)
					ist = 0;
				else
					ist = vcut[i - 1] + 1;
				iend = vcut[i];
			}

			for (int j = 0; j < hcut.length + 1; j++) {
				if (j == hcut.length) {
					jst = hcut[j - 1] + 1;
					jend = r - 1;
				} else {
					if (j == 0)
						jst = 0;
					else
						jst = hcut[j - 1] + 1;
					jend = hcut[j];
				}
				count = 0;

				for (int k = ist; k <= iend; k++) {
					for (int l = jst; l <= jend; l++) {
						if (pie[l][k] == '@')
							count++;
					}
				}

				if (count != avg)
					return false;

			}

		}

		return true;
	}

}