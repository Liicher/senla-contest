package converter.model;

import java.util.HashMap;
import java.util.Map;

public class Currency {
	private Map<String, Double> exchangeRates;

	public Currency() {
		// Вводим фиксированные курсы обмена валют
		exchangeRates = new HashMap<>();
		exchangeRates.put("USD", 1.0); // Базовая валюта - USD
		exchangeRates.put("EUR", 0.90);
		exchangeRates.put("AED", 3.60);
		exchangeRates.put("JPY", 110.0);
		exchangeRates.put("RUB", 100.0);
	}

	public double convert(double amount, String fromCurrency, String toCurrency) {
		if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
			throw new IllegalArgumentException("Некорректная валюта для конвертации");
		}

		double baseAmount = amount / exchangeRates.get(fromCurrency);
		return baseAmount * exchangeRates.get(toCurrency);
	}

	public void displayExchangeRates() {
		System.out.println("Курсы валют:");
		for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	public boolean checkValueInput(String input) {
		if (!input.isEmpty() && input.matches("\\d+")) {
			return true;
		}
		return false;
	}

	public boolean checkCurrencyInput(String input) {
		if (input.isEmpty()) {
			return false;
		}

		for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
			if (input.equals(entry.getKey())) {
				return true;
			}
		}
		return false;
	}
}
