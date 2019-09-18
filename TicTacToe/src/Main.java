import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[][] matrix = new char[3][3];
		addCharacters(matrix);

	}

	public static void printMatrix(char[][] val) {
		System.out.println("\t" + val[0][0] + "\t" + "|" + "\t" + val[0][1] + "\t" + "|" + "\t" + val[0][2] + "\t");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t" + val[1][0] + "\t" + "|" + "\t" + val[1][1] + "\t" + "|" + "\t" + val[1][2] + "\t");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t" + val[2][0] + "\t" + "|" + "\t" + val[2][1] + "\t" + "|" + "\t" + val[2][2] + "\t");

	}

	public static void addCharacters(char[][] val) {
		Scanner scan = new Scanner(System.in);

		char insertvalue;
		char othervalue;
		System.out.println("Enter your character: X or O");
		String character = scan.nextLine();
		scan.reset();
		if (character.charAt(0) == 'O') {
			insertvalue = 'O';
			othervalue = 'X';

		} else {
			insertvalue = 'X';
			othervalue = 'O';
		}
		printMatrix(val);
		while (boardNotFull(val)) {
			System.out.println("Its " + insertvalue + "'s turn");
			System.out.println();
			System.out.println("Enter the position numbers:");
			int b = scan.nextInt();
			scan.reset();
			int d = scan.nextInt();
			scan.reset();
			if (val[b][d] == 'O' || val[b][d] == 'X') {
				System.out.println("The position is already taken");
				System.out.println();
				System.out.println("Enter the new position numbers:");
				b = scan.nextInt();
				scan.reset();
				d = scan.nextInt();
				scan.reset();
			}
			val[b][d] = insertvalue;
			printMatrix(val);
			System.out.println();
			System.out.println();
			if ((hasSomeoneWon(val) == insertvalue || hasSomeoneWon(val) == othervalue)) {
				if (hasSomeoneWon(val) == insertvalue) {
					System.out.println(insertvalue + " won the game");
					break;

				} else {
					System.out.println(othervalue + " won the game");
					break;
				}

			}

			if (!boardNotFull(val)) {
				System.out.println("The board is full. Game ends in draw");
				break;
			}
			System.out.println("Its " + othervalue + "'s turn");
			System.out.println();
			System.out.println("Enter the position numbers:");
			int f = scan.nextInt();
			scan.reset();
			int g = scan.nextInt();
			scan.reset();
			if (val[f][g] == 'O' || val[f][g] == 'X') {
				System.out.println("The position is already taken");
				System.out.println();
				System.out.println("Enter the new position numbers:");
				f = scan.nextInt();
				scan.reset();
				g = scan.nextInt();
				scan.reset();
			}
			val[f][g] = othervalue;
			printMatrix(val);
			System.out.println();
			System.out.println();
			if ((hasSomeoneWon(val) == insertvalue || hasSomeoneWon(val) == othervalue)) {
				if (hasSomeoneWon(val) == insertvalue) {
					System.out.println(insertvalue + " won the game");
					break;
				} else {
					System.out.println(othervalue + " won the game");
					break;
				}

			}
		}

		scan.close();
	}

	
	private static boolean boardNotFull(char[][] val) {
		int a = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (val[i][j] == 'O' || val[i][j] == 'X') {
					a++;
				}
			}
		}

		if (a == 9) {
			return false;
		} else
			return true;

	}

	private static char hasSomeoneWon(char[][] val) {
		for (int i = 0; i < 3; i++) {
			if (val[i][0] == val[i][1] && val[i][1] == val[i][2]) {
				if (val[i][0] == 'O') {
					return 'O';
				} else if (val[i][0] == 'X') {

					return 'X';
				}
			} else if (val[0][i] == val[1][i] && val[1][i] == val[2][i]) {
				if (val[0][i] == 'O') {
					return 'O';
				} else if (val[0][i] == 'X') {
					return 'X';
				}

			}

			else if (i == 0) {
				if (val[0][i] == val[1][i + 1] && val[1][i + 1] == val[2][i + 2]) {
					if (val[1][i + 1] == 'O') {
						return 'O';
					} else if (val[1][i + 1] == 'X') {
						return 'X';
					}
				}

				else if (val[i + 2][0] == val[i + 1][1] && val[i + 1][1] == val[i][2]) {
					if (val[i + 2][0] == 'O') {
						return 'O';
					} else if (val[i + 2][0] == 'X') {
						return 'X';
					}
				}
			}
		}

		return ' ';

	}

}
