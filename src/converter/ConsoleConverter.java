package converter;

import converter.model.Currency;

import java.util.Scanner;

public class ConsoleConverter {

	public void run() {
		Scanner scanner = new Scanner(System.in);
		Currency converter = new Currency();

		converter.displayExchangeRates();

		System.out.print("Введите валюту, из которой конвертируете (USD, EUR, GBP, JPY, RUB): ");
		String fromCurrency = scanner.next().toUpperCase();

		System.out.print("Введите сумму для конвертации: ");
		double amount = scanner.nextDouble();

		System.out.print("Введите валюту, в которую конвертируете (USD, EUR, GBP, JPY, RUB): ");
		String toCurrency = scanner.next().toUpperCase();

		try {
			double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
			System.out.printf("Сумма %.2f %s равна %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
