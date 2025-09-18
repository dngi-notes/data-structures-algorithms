package google.medium.lc_48_rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);        
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j);              
            }
        }
    }

    private void reverse(int[][] matrix) {
        for (int[] row : matrix) {
            int left = 0;
            int right = row.length - 1;
            while (left < right) {
                swap(row, left, right);
                left++;
                right--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
