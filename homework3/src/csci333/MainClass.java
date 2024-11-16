package csci333;

import java.util.Arrays;

public class MainClass {

	/**
	 * Runs tests to check the three quicksort methods
	 * 
	 * @param args Unused in this code.
	 */
	public static void main(String[] args) {
		// Fruits
		String[] fruits1 = { "apple", "banana", "orange", "grape", "kiwi", "pear", "mango", "strawberry", "blueberry",
				"raspberry"};
		String[] fruits2 = { "cherry", "pineapple", "melon", "avocado", "plum", "peach", "apricot", "nectarine", "fig",
				"pomegranate"};
		String[] fruits3 = { "lime", "lemon", "grapefruit", "cantaloupe", "honeydew", "watermelon", "papaya", "guava",
				"passion fruit", "persimmon"};

		// Animals
		String[] animals1 = { "cat", "dog", "bird", "fish", "rabbit", "hamster", "turtle", "snake", "lizard", "frog"};
		String[] animals2 = { "elephant", "giraffe", "zebra", "lion", "tiger", "monkey", "bear", "panda", "kangaroo",
				"dolphin"};
		String[] animals3 = { "horse", "cow", "sheep", "pig", "goat", "chicken", "duck", "turkey", "goose", "rabbit"};

		// Programming Languages
		String[] programmingLanguages1 = { "java", "python", "javascript", "c++", "c#", "ruby", "php", "go", "swift",
				"kotlin"};
		String[] programmingLanguages2 = { "scala", "haskell", "rust", "perl", "fortran", "cobol", "lisp", "prolog",
				"matlab", "r"};
		String[] programmingLanguages3 = { "sql", "html", "css", "c", "pascal", "ada", "fortran", "cobol", "lisp",
				"prolog"};

		// Buildings
		String[] buildings1 = { "house", "apartment", "condo", "cabin", "villa", "bungalow", "mansion", "cottage",
				"loft", "penthouse"};
		String[] buildings2 = { "school", "hospital", "library", "museum", "church", "mosque", "synagogue", "temple",
				"cathedral", "palace"};
		String[] buildings3 = { "skyscraper", "tower", "bridge", "dam", "tunnel", "stadium", "arena", "theater",
				"cinema", "mall"};

		// Foods
		String[] foods1 = { "pizza", "burger", "hotdog", "sandwich", "taco", "sushi", "pasta", "steak", "chicken",
				"fish"};
		String[] foods2 = { "salad", "soup", "cereal", "yogurt", "fruit", "vegetable", "bread", "cheese", "milk",
				"eggs"};
		String[] foods3 = { "ice cream", "cake", "cookie", "candy", "chocolate", "popcorn", "chips", "nuts", "seeds",
				"dried fruit"};

		// Instantializing fruit arrays for quicksorting
		Quicksort qsFruits1 = new Quicksort(fruits1);
		Quicksort qsFruits2 = new Quicksort(fruits2);
		Quicksort qsFruits3 = new Quicksort(fruits3);

		// Running fruit sorts
		System.out.println("\nSorting fruit arrays");
		System.out.println("Unsorted array: " + qsFruits1);
		qsFruits1.quicksortNaive();
		System.out.println("Naive Sorted array: " + qsFruits1 + "\n");
		// Best of three
		System.out.println("Unsorted array: " + qsFruits2);
		qsFruits2.quicksortBestOfThree();
		System.out.println("Best of Three Sorted array: " + qsFruits2 + "\n");
		// Randomized
		System.out.println("Unsorted array: " + qsFruits3);
		qsFruits3.quicksortRandomized();
		System.out.println("Random Sorted array: " + qsFruits3 + "\n");

		// Instantializing animal arrays for quicksorting
		Quicksort qsAnimals1 = new Quicksort(animals1);
		Quicksort qsAnimals2 = new Quicksort(animals2);
		Quicksort qsAnimals3 = new Quicksort(animals3);

		// Running animal sorts
		System.out.println("\nSorting animal arrays");
		System.out.println("Unsorted array: " + qsAnimals1);
		qsAnimals1.quicksortNaive();
		System.out.println("Naive Sorted array: " + qsAnimals1 + "\n");
		// Best of three
		System.out.println("Unsorted array: " + qsAnimals2);
		qsAnimals2.quicksortBestOfThree();
		System.out.println("Best of Three Sorted array: " + qsAnimals2 + "\n");
		// Randomized
		System.out.println("Unsorted array: " + qsAnimals3);
		qsAnimals3.quicksortRandomized();
		System.out.println("Random Sorted array: " + qsAnimals3 + "\n");

		// Instantializing programmingLanguage arrays for quicksorting
		Quicksort qsProgrammingLanguages1 = new Quicksort(programmingLanguages1);
		Quicksort qsProgrammingLanguages2 = new Quicksort(programmingLanguages2);
		Quicksort qsProgrammingLanguages3 = new Quicksort(programmingLanguages3);

		// Running programmingLanguage sorts
		System.out.println("\nSorting programming language arrays");
		System.out.println("Unsorted array: " + qsProgrammingLanguages1);
		qsProgrammingLanguages1.quicksortNaive();
		System.out.println("Naive Sorted array: " + qsProgrammingLanguages1 + "\n");
		// Best of three
		System.out.println("Unsorted array: " + qsProgrammingLanguages2);
		qsProgrammingLanguages2.quicksortBestOfThree();
		System.out.println("Best of Three Sorted array: " + qsProgrammingLanguages2 + "\n");
		// Randomized
		System.out.println("Unsorted array: " + qsProgrammingLanguages3);
		qsProgrammingLanguages3.quicksortRandomized();
		System.out.println("Random Sorted array: " + qsProgrammingLanguages3 + "\n");

		// Instantializing building arrays for quicksorting
		Quicksort qsBuildings1 = new Quicksort(buildings1);
		Quicksort qsBuildings2 = new Quicksort(buildings2);
		Quicksort qsBuildings3 = new Quicksort(buildings3);
		// Running building sorts
		System.out.println("\nSorting building arrays");
		System.out.println("Unsorted array: " + qsBuildings1);
		qsBuildings1.quicksortNaive();
		System.out.println("Naive Sorted array: " + qsBuildings1 + "\n");
		// Best of three
		System.out.println("Unsorted array: " + qsBuildings2);
		qsBuildings2.quicksortBestOfThree();
		System.out.println("Best of Three Sorted array: " + qsBuildings2 + "\n");
		// Randomized
		System.out.println("Unsorted array: " + qsBuildings3);
		qsBuildings3.quicksortRandomized();
		System.out.println("Random Sorted array: " + qsBuildings3 + "\n");

		// Instantializing food arrays for quicksorting
		Quicksort qsFoods1 = new Quicksort(foods1);
		Quicksort qsFoods2 = new Quicksort(foods2);
		Quicksort qsFoods3 = new Quicksort(foods3);

		// Running food sorts
		System.out.println("\nSorting food arrays");
		System.out.println("Unsorted array: " + qsFoods1);
		qsFoods1.quicksortNaive();
		System.out.println("Naive Sorted array: " + qsFoods1 + "\n");
		// Best of three
		System.out.println("Unsorted array: " + qsFoods2);
		qsFoods2.quicksortBestOfThree();
		System.out.println("Best of Three Sorted array: " + qsFoods2 + "\n");
		// Randomized
		System.out.println("Unsorted array: " + qsFoods3);
		qsFoods3.quicksortRandomized();
		System.out.println("Random Sorted array: " + qsFoods3 + "\n");

	}

}
