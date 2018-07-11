//Hackerearth problem - Seating Arrangement

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer number = Integer.valueOf(br.readLine());

		int[] arr = new int[number];

		for (int i = 0; i < number; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		for (int i = 0; i < number; i++) {
			int seat = arr[i];
			switch (arr[i] % 12) {
			case 0:
				seat = arr[i] - 11;
				System.out.println(seat + " " + "WS");
				break;
			case 1:
				seat = arr[i] + 11;
				System.out.println(seat + " " + "WS");
				break;
			case 2:
				seat = arr[i] + 9;
				System.out.println(seat + " " + "MS");
				break;
			case 3:
				seat = arr[i] + 7;
				System.out.println(seat + " " + "AS");
				break;
			case 4:
				seat = arr[i] + 5;
				System.out.println(seat + " " + "AS");
				break;
			case 5:
				seat = arr[i] + 3;
				System.out.println(seat + " " + "MS");
				break;
			case 6:
				seat = arr[i] + 1;
				System.out.println(seat + " " + "WS");
				break;
			case 7:
				seat = arr[i] - 1;
				System.out.println(seat + " " + "WS");
				break;
			case 8:
				seat = arr[i] - 3;
				System.out.println(seat + " " + "MS");
				break;
			case 9:
				seat = arr[i] - 5;
				System.out.println(seat + " " + "AS");
				break;
			case 10:
				seat = arr[i] - 7;
				System.out.println(seat + " " + "AS");
				break;
			case 11:
				seat = arr[i] - 9;
				System.out.println(seat + " " + "MS");
				break;
			default:
				System.out.println();
			}
		}
	}
}
