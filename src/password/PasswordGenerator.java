package password;

import java.security.SecureRandom;

public class PasswordGenerator {
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
	private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
	private SecureRandom random;

	public PasswordGenerator() {
		random = new SecureRandom();
	}

	public String generatePassword(int length) {
		if (length < 8 || length > 12) {
			throw new IllegalArgumentException("Длина пароля должна быть от 8 до 12 символов.");
		}

		StringBuilder password = new StringBuilder(length);
		password.append(selectRandomCharacter(UPPERCASE));
		password.append(selectRandomCharacter(LOWERCASE));
		password.append(selectRandomCharacter(DIGITS));
		password.append(selectRandomCharacter(SPECIAL_CHARACTERS));

		for (int i = 4; i < length; i++) {
			password.append(selectRandomCharacter(ALL_CHARACTERS));
		}

		return shuffleString(password.toString());
	}

	private char selectRandomCharacter(String characters) {
		return characters.charAt(random.nextInt(characters.length()));
	}

	private String shuffleString(String input) {
		char[] characters = input.toCharArray();
		for (int i = characters.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = characters[i];
			characters[i] = characters[j];
			characters[j] = temp;
		}
		return new String(characters);
	}
}
