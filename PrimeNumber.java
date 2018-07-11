//Program to find prime numbers from 1 to N.

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer number = Integer.valueOf(br.readLine());

		for (int i = 2; i <= number; i++) {
			boolean check = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					check = true;
					break;
				}
			}
			if (check == false) {
				System.out.print(i + " ");
			}
		}

	}
}
