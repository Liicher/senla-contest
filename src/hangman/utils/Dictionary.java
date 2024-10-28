package hangman.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Dictionary {
	public Dictionary() {}

	public static String[] getWordsFromDictionaryFile(String pathToFile) {
		try {
			// Чтение всех строк из файла
			List<String> lines = Files.readAllLines(Paths.get(pathToFile));

			// Объединяем все строки в одну, разбивая на слова
			String allText = String.join(" ", lines);

			// Разделяем текст на слова, используя регулярное выражение
			String[] words = allText.split(" ");
			return words;
		} catch (IOException e) {
			e.printStackTrace();
			return new String[0]; // Возвращаем пустой массив в случае ошибки
		}
	}
}
