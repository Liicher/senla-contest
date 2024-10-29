package converter;

import converter.model.Currency;

import java.util.Scanner;

public class ConsoleConverter {

	public void run() {
		Scanner scanner = new Scanner(System.in);
		Currency converter = new Currency();

		converter.displayExchangeRates();

		String fromCurrency = "";
		String amountStr = "";
		String toCurrency = "";

		while (!converter.checkCurrencyInput(fromCurrency)) {
			System.out.print("Введите валюту, из которой конвертируете (USD, EUR, GBP, JPY, RUB): ");
			fromCurrency = scanner.next().toUpperCase();
		}

		while (!converter.checkValueInput(amountStr)) {
			System.out.print("Введите сумму для конвертации: ");
			amountStr = scanner.nextLine();
		}
		double amount = Integer.parseInt(amountStr);

		while (!converter.checkCurrencyInput(toCurrency)) {
			System.out.print("Введите валюту, в которую конвертируете (USD, EUR, GBP, JPY, RUB): ");
			toCurrency = scanner.next().toUpperCase();
		}

		try {
			double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
			System.out.printf("Сумма %.2f %s равна %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
			System.out.printf("Сумма " + amount + " " + fromCurrency + " равна " + convertedAmount + " " + toCurrency);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
