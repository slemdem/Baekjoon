import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] arr = new String[12];
		
		arr[1] = "12 1600";
		arr[2] = "11 894";
		arr[3] = "11 1327";
		arr[4] = "10 1311";
		arr[5] = "9 1004";
		arr[6] = "9 1178";
		arr[7] = "9 1357";
		arr[8] = "8 837";
		arr[9] = "7 1055";
		arr[10] = "6 556";
		arr[11] = "6 773";
		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		
		System.out.println(arr[i]);

	}

}
