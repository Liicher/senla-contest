package hangman.model;

import hangman.utils.Messages;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleHangman {
	public void run() {
		Session session = new Session();
		// Делаем проверку на выигрыш или на проигрыш
		GAME: while (!session.checkWinnable(session) && session.checkAttempts()) {
			printState(session);            // Выводи основную информацию в консоль
			Messages.midGameMessage();

			char guess = inputLetter();     // Вводим символ
			// Проверка на соответствие введенного символа русскому алфавиту
			while (!session.checkPlayerGuessInput(guess) && !session.checkPlayerGuessInAlphabet(guess)) {
				if (session.checkExit(guess)) {
					break GAME;
				}
				Messages.messageIncorrectCharInput();
				Messages.messageAlphabetLeft(session);
				guess = inputLetter();      // Вводим символ
			}
			session = playerGuess(session, guess);
		}

		if (session.checkWinnable(session)) {
			Messages.messageWinTemplate();
		} else if (!session.checkAttempts()) {
			Messages.messageLostTemplate();
		}
	}

	private char inputLetter() {
		Scanner scanner = new Scanner(System.in);
		String guess = scanner.nextLine();
		// Делаем проверку на то, что введен один символ
		while (guess.length() > 1) {
			Messages.messageIncorrectCharInput();
			guess = scanner.nextLine();
		}

		return guess.toLowerCase(Locale.ROOT).charAt(0);
	}

	private Session playerGuess(Session session, char guess) {
		session.checkGuess(guess);
		return session;
	}

	private void printState(Session session) {
		Messages.messageStateCount(session.getAttempts(), session.getMaxAttempts());
		Messages.messageStateImage(session.getAttempts());
		Messages.messageStateGuess(session.getGuess(), session.getAnswer());
	}

	public void starter() {
		Messages.messageHangmanTemplate();
		Messages.starterMessage();

		char input = inputLetter();
		while (input != 'q' && input != 'в') {
			switch (input) {
				case 'y', 'д': run(); break;
				case 'q', 'в': System.exit(0);
				case 'd', 'с': break;
				default: break;
			}

			Messages.starterMessage();
			input = inputLetter();
		}
	}
}
