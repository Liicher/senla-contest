package converter.model;

import java.util.Scanner;

public class ConsoleConverter {

	public void run() {
		Scanner scanner = new Scanner(System.in);
		Currency currency = new Currency();

		currency.displayExchangeRates();
		String fromCurrency = "";
		String amountStr = "";
		String toCurrency = "";

		while (!currency.checkCurrencyInput(fromCurrency)) {
			System.out.print("Введите валюту, из которой конвертируете (USD, EUR, RUB, JPY, AED): ");
			fromCurrency = scanner.next().toUpperCase();
		}

		while (!currency.checkValueInput(amountStr)) {
			System.out.print("Введите сумму для конвертации: ");
			amountStr = scanner.next();
		}
		double amount = Integer.parseInt(amountStr);

		while (!currency.checkCurrencyInput(toCurrency)) {
			System.out.print("Введите валюту, в которую конвертируете (USD, EUR, RUB, JPY, AED): ");
			toCurrency = scanner.next().toUpperCase();
		}

		try {
			double convertedAmount = currency.convertCurrency(amount, fromCurrency, toCurrency);
			System.out.printf("Сумма %.2f %s равна %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
