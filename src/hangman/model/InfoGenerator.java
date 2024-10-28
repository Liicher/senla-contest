package hangman.model;

import hangman.utils.Dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InfoGenerator {
	private final static int MIN_LENGTH = 4;
	private final static Random random = new Random();
	private final static Character[] alphabetRu = {
			'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
			'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
			'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
	};

	private static List<Character> alphabet = new ArrayList<>();

	public char[] getRandomWordFromDictionary() {
		// Получаем массив строк из нашего "словаря" со словами
		String[] answers = Dictionary.getWordsFromDictionaryFile("src/hangman/resources/dictionaryFileRu");

		// Проверяем, что слово подходит под критерии/условия игры
		String randomWord = null;
		while (randomWord == null || randomWord.length() < MIN_LENGTH) {
			randomWord = answers[random.nextInt(answers.length)];
		}
		return randomWord.toCharArray();
	}

	public List<Character> createAlphabetList() {
		List<Character> letters = new ArrayList<>();
		Collections.addAll(letters, alphabetRu);
		return letters;
	}

	public static List<Character> getAlphabet() {
		return alphabet;
	}
}
