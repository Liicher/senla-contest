package converter.model;

import java.util.HashMap;
import java.util.Map;

public class Currency {
	private Map<String, Double> exchangeRates;

	public Currency() {
		// Вводим фиксированные курсы обмена валют
		exchangeRates = new HashMap<>();
		exchangeRates.put("USD", 1.0); // Базовая валюта - USD
		exchangeRates.put("EUR", 0.85);
		exchangeRates.put("GBP", 0.75);
		exchangeRates.put("JPY", 110.0);
		exchangeRates.put("RUB", 75.0);
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
}
