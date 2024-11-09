package part_2.part_A;


public class Main {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");
        ShortestLongestNumber shortestLongestNumber = new ShortestLongestNumber();
        shortestLongestNumber.findShortestAndLongest(args);

        SortNumbersByLength sortNumbersByLength = new SortNumbersByLength();
        sortNumbersByLength.sortAndDisplay(args, true);  // По возрастанию длины
        sortNumbersByLength.sortAndDisplay(args, false); // По убыванию длины

        NumbersWithLengthComparison numbersWithLengthComparison = new NumbersWithLengthComparison();
        numbersWithLengthComparison.compareWithAverageLength(args);

        MinimalDistinctDigits minimalDistinctDigits = new MinimalDistinctDigits();
        minimalDistinctDigits.findNumberWithMinDistinctDigits(args);

        EvenDigitNumbers evenDigitNumbers = new EvenDigitNumbers();
        evenDigitNumbers.analyzeEvenDigitNumbers(args);

        StrictlyIncreasingNumber strictlyIncreasingNumber = new StrictlyIncreasingNumber();
        strictlyIncreasingNumber.findStrictlyIncreasing(args);

        DistinctDigitsNumber distinctDigitsNumber = new DistinctDigitsNumber();
        distinctDigitsNumber.findNumberWithDistinctDigits(args);

        PalindromeNumber palindromeNumber = new PalindromeNumber();
        palindromeNumber.findPalindrome(args);

        if (args.length >= 3) {
            double a = Double.parseDouble(args[args.length - 3]);
            double b = Double.parseDouble(args[args.length - 2]);
            double c = Double.parseDouble(args[args.length - 1]);
            QuadraticEquationSolver quadraticEquationSolver = new QuadraticEquationSolver();
            quadraticEquationSolver.solve(a, b, c);
        }
    }
}
