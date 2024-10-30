package password.model;

import java.util.Scanner;

public class ConsolePassword {

	public void run() {
		Scanner scanner = new Scanner(System.in);
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = "";

		while (password.isEmpty() || password.matches("\\d+")) {
			System.out.print("\nВведите длину пароля (от 8 до 12 цифрой): ");
			String str = scanner.nextLine();
			int length;
			if (str.matches("\\d+")) {
				length = Integer.parseInt(str);
			} else {
				System.out.println("Длина пароля должна быть от 8 до 12 символов!");
				continue;
			}

			try {
				password = passwordGenerator.generatePassword(length);
				System.out.println("Сгенерированный пароль: " + password);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
	}
}
