package hangman.model;

import java.util.Arrays;
import java.util.List;

public class Session {
	private final InfoGenerator infoGenerator = new InfoGenerator();
	private final char[] answer = infoGenerator.getRandomWordFromDictionary();
	private final List<Character> alphabet = infoGenerator.createAlphabetList();
	private final byte maxAttempts = 5;

	private byte attempts = 0;
	private char[] guess = new char[answer.length];

	public Session() {
		Arrays.fill(guess, '*');
	}

	public void checkGuess(char c) {
		boolean flag = true;
		for (int i = 0; i < answer.length; i++) {
			if (c == answer[i]) {
				guess[i] = c;
				flag = false;
			}
		}

		if (flag) {
			setAttempts((byte) (getAttempts() + 1));
		}
		alphabet.set(alphabet.indexOf(c), '*');
	}

	public boolean checkPlayerGuessInAlphabet(char c) {
		return alphabet.contains(c);
	}

	public boolean checkPlayerGuessInput(char c) {
		for (char value : guess) {
			if (value == c) {
				return false;
			}
		}
		return alphabet.contains(c);
	}

	public boolean checkExit(char c) {
		return c == '0';
	}

	public boolean checkWinnable(Session session) {
		return Arrays.equals(session.getAnswer(), session.getGuess());
	}

	public boolean checkAttempts() {
		return attempts < maxAttempts;
	}

	public List<Character> getAlphabet() {
		return alphabet;
	}

	public void printAnswer() {
		System.out.println("Загаданное слово - " +  String.copyValueOf(answer));
	}

	public char[] getAnswer() {
		return answer;
	}

	public byte getAttempts() {
		return attempts;
	}

	public void setAttempts(byte attempts) {
		this.attempts = attempts;
	}

	public byte getMaxAttempts() {
		return maxAttempts;
	}

	public char[] getGuess() {
		return guess;
	}
}
