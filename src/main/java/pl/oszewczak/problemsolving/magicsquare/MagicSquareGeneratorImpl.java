package pl.oszewczak.problemsolving.magicsquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicSquareGeneratorImpl {

    public static List<List<List<Integer>>> generateAllValidSquares() {
        List<List<List<Integer>>> magicSquares = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(nums, 0, magicSquares);
        return magicSquares;
    }

    private static void backtrack(int[] nums, int start, List<List<List<Integer>>> magicSquares) {
        if (start == nums.length) {
            if (isMagicSquare(nums)) {
                magicSquares.add(convertToMatrix(nums));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, magicSquares);
            swap(nums, start, i); // Backtrack
        }
    }

    private static boolean isMagicSquare(int[] nums) {
        int sum = nums[0] + nums[1] + nums[2];
        return (nums[3] + nums[4] + nums[5] == sum &&
                nums[6] + nums[7] + nums[8] == sum &&
                nums[0] + nums[3] + nums[6] == sum &&
                nums[1] + nums[4] + nums[7] == sum &&
                nums[2] + nums[5] + nums[8] == sum &&
                nums[0] + nums[4] + nums[8] == sum &&
                nums[2] + nums[4] + nums[6] == sum);
    }

    private static List<List<Integer>> convertToMatrix(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            matrix.add(Arrays.asList(nums[i * 3], nums[i * 3 + 1], nums[i * 3 + 2]));
        }
        return matrix;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    public void main(String[] args) {
//        List<List<List<Integer>>> magicSquares = generateAllValidSquares();
//        for (List<List<Integer>> square : magicSquares) {
//            for (List<Integer> row : square) {
//                System.out.println(row);
//            }
//            System.out.println();
//        }
//        System.out.println("Total Magic Squares: " + magicSquares.size());
//    }

}
