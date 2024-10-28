package hangman.utils;

import hangman.model.Session;

public class Messages {
	private final static String SEPARATOR = "=================";

	public static void starterMessage() {
		System.out.println( "Введите:\n" +
							"\"Д\" - Для начала игры!\n" +
							"\"В\" - Для выхода из игры!\n" +
							"\"С\" - Редактировать словарь!");
	}

	public static void midGameMessage() {
		System.out.println( "Введи предполагаемую букву!\n" +
				"\"0\" - Для выхода из игры!\n");
	}

	public static void hangmanHi() {
		System.out.println(
				"""
						╔═════════╗
						║         ║
						║        ☺╱
						║       ᨆ⎕
						║        ▏▏
						║       ╒═╕
						╚═════════════
				"""
		);
	}

	public static void hangman() {
		System.out.println(
				"""
						╔═════════╗
						║         ║
						║        ☹
						║       ᨆ⎕╮
						║        ▏▏
						║       ╒═╕
						╚═════════════
				"""
		);
	}

	public static void messageAlphabetLeft(Session session) {
		System.out.println("Оставшиеся буквы:");
		for (int i = 0; i < session.getAlphabet().size(); i++) {
			System.out.print(session.getAlphabet().get(i) + " ");
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void messageIncorrectCharInput() {
		System.out.println("Давай договоримся, что вводить можно только одну букву русского алфавита! :D");
	}

	public static void messageStateGuess(char[] guess, char[] answer) {
		System.out.println(SEPARATOR);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(guess[i] + "\t");
		}
		System.out.println();
	}

	public static void messageStateCount(byte attempts, byte maxAttempts) {
		System.out.println(SEPARATOR);
		System.out.println(attempts + " ПОПЫТКА ИЗ " + maxAttempts);
	}

	public static void messageStateImage(byte attempts) {
		System.out.println(SEPARATOR);
		switch (attempts) {
			case 0:
				System.out.println(
						"""
						
						
						
						
						
						
							══════════════
						"""
				);
				break;
			case 1:
				System.out.println(
						"""
							║
							║
							║
							║
							║
							║
							╚═════════════
						"""
				);
				break;
			case 2:
				System.out.println(
						"""
							╔═════════
							║
							║
							║
							║
							║
							╚═════════════
						"""
				);
				break;
			case 3:
				System.out.println(
						"""
							╔═════════╗
							║         ║
							║
							║
							║
							║
							╚═════════════
						"""
				);
				break;
			case 4:
				System.out.println(
						"""
							╔═════════╗
							║         ║
							║       \\☺╱
							║        ⎕
							║        ▏▏
							║       ╒═╕
							╚═════════════"""
				);
				break;
		}
	}

	public static void messageHangmanTemplate() {
		System.out.println(
	"""
	
	╔════════════════════════════╗  ╔═════════╗
	║                            ║  ║         ║
	║	╦╗ ║║ ╔ ╔═ ╔╗ ║║ ║║ ╔╗   ║  ║        ☺╱
	║	╠╣ ║║ ║ ╠═ ║║ ║║ ║║ ╠╣   ║  ║       ᨆ⎕
	║	╩╝ ╚╝ ╚ ╚═ ╝║ ╚╝ ╚╩ ║║   ║  ║        ▏▏
	║                            ║  ║       ╒═╕
	╚════════════════════════════╝  ╚═════════════"""
		);
	}

	public static void messageWinTemplate() {
		System.out.println(
				"""
─────────╔══╗╔══╗╔═══╗╔═══╗─╔══╗─╔══╗─────────
─────────║╔╗║║╔╗║║╔══╝║╔══╝─║╔╗║─║╔╗║─────────
─────────║║║║║║║║║╚══╗║╚══╗─║║║║─║╚╝║─────────
─────────║║║║║║║║║╔═╗║║╔══╝─║║║║─║╔╗║─────────
─────────║║║║║╚╝║║╚═╝║║╚══╗╔╝╚╝╚╗║║║║─────────
─────────╚╝╚╝╚══╝╚═══╝╚═══╝╚════╝╚╝╚╝─────────
    			"""
		);
	}

	public static void messageLostTemplate() {
		System.out.println(
				"""
					╔═════════╗
					║         ║
					║        ㋡
					║       ╭⎕╮
					║        ▏▏
					║
					╚═════════════
				"""
		);
	}
}

/*
	╔════════════════╗
	║                ║
	║                ∱
	║               ⬯
	║              ᨆ⎕╮
	║               ▏▏
	║              ⍑⍑⍑⍑
	╚════════════════════

╦╗ ║║ ╔ ╔═ ╔╗ ║║ ║║ ╔╗
╠╣ ║║ ║ ╠═ ║║ ║║ ║║ ╠╣
╩╝ ╚╝ ╚ ╚═ ╝║ ╚╝ ╚╩ ║║

████───█──█──████──███────██──█──█──█──█───████
█──██──█──█──█──█──█─────█─█──█──█──█──█───█──█
████───█─██──█─────███──█──█──█─██──█──█───████
█──██──██─█──█──█──█────█──█──██─█──█──█───█──█
████───█──█──████──███──█──█──█──█──█████──█──█

─────────████─────█──█────████────███──────██────█──█────█──█─────████─────────
─────────█──██────█──█────█──█────█───────█─█────█──█────█──█─────█──█─────────
─────────████─────█─██────█───────███────█──█────█─██────█──█─────████─────────
─────────█──██────██─█────█──█────█──────█──█────██─█────█──█─────█──█─────────
─────────████─────█──█────████────███────█──█────█──█────█████────█──█─────────

█████████████████████████████████████████████████████████████████████████████████
██████████────█████─██─████────████───██████──████─██─████─██─█████────██████████
██████████─██──████─██─████─██─████─███████─█─████─██─████─██─█████─██─██████████
██████████────█████─█──████─███████───████─██─████─█──████─██─█████────██████████
██████████─██──████──█─████─██─████─██████─██─████──█─████─██─█████─██─██████████
██████████────█████─██─████────████───████─██─████─██─████─────████─██─██████████
█████████████████████████████████████████████████████████████████████████████████
*/
