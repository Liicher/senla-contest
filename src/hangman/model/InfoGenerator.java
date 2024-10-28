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

	public char[] getRandomWordFromDictionary() {
		// Получаем массив строк из нашего "словаря" со словами
		String[] answers = Dictionary.getWordsFromDictionaryFile("src/hangman/resources/dictionaryFileRu");
		if (answers.length == 0) {
			System.out.println("Возникла проблемка со словарем :(");
			System.out.println("Будет взято слово из заготовленных в программе :D");
			answers = new String[] {
					"чашка", "книга", "столик", "цветок", "домик",
					"окно", "мышка", "дорога", "ключик", "лампа",
					"сумка", "картина", "ручка", "шляпа", "мячик"
			};
		}

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
}
