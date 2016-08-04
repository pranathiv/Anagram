import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

	// Main function calling all the other functions
	public static void main(String[] args) {
		ArrayList<String> words = getWordsFromFile("C:\\Users\\pushpisingh\\Desktop\\sowpods.txt");
		ArrayList<String> wordsCopy = (ArrayList<String>) words.clone();
		sortAllWords(wordsCopy);
		printAnagrams(putIntoHashMap(wordsCopy), words);
	}
<<<<<<< HEAD
	
	// Function to print the list of anagrams	
	private static void printAnagrams(HashMap<String, ArrayList<Integer>> hash,ArrayList<String> words) {
		
		for(ArrayList<Integer> list : hash.values()) {
			if(list.size() > 1) {
				for(Integer l : list)
					p(words.get(l)+" ");
				p("\n");
=======

	// Function to print the anagrams
	private static void printAnagrams(HashMap<String, ArrayList<Integer>> hash, ArrayList<String> words) {

		for (ArrayList<Integer> list : hash.values()) {
			if (list.size() > 1) {
				for (Integer l : list)
					print(words.get(l) + " ");
				print("\n");
>>>>>>> ab15d9ebc54efc87d73bee7b58116d140717c399
			}
		}
	}

	// Create a hashmap of String --> List of Indices of the anagrams
	private static HashMap<String, ArrayList<Integer>> putIntoHashMap(ArrayList<String> wordsCopy) {

		HashMap<String, ArrayList<Integer>> hash = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < wordsCopy.size(); i++) {
			if (hash.containsKey(wordsCopy.get(i)) == false) {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				hash.put(wordsCopy.get(i), al);
			} else {
				hash.get(wordsCopy.get(i)).add(i);
			}

		}
		print(hash.size() + "\n");
		return hash;

	}

	// Sort all the words internally
	private static void sortAllWords(ArrayList<String> wordsCopy) {

		for (int i = 0; i < wordsCopy.size(); i++) {
			char[] temp = wordsCopy.get(i).toCharArray();
			Arrays.sort(temp);
			wordsCopy.set(i, String.valueOf(temp));
		}

	}

	private static void print(Object o) {
		System.out.print(o);

	}

	// Read all the words from the file
	private static ArrayList<String> getWordsFromFile(String path) {

		ArrayList<String> words = new ArrayList<String>();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				words.add(line);
			}
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}

		return words;
	}
}