package binary_search.lc374_guess_number_higher_or_lower;

public class GuessNumber {
    private int pickedNumber;

    public GuessNumber(int pickedNumber) {
        this.pickedNumber = pickedNumber;
    }

    /*
     * We are playing the Guess Game. The game is as follows:
     * 
     * I pick a number from 1 to n. You have to guess which number I picked.
     * 
     * Every time you guess wrong, I will tell you whether the number I picked is
     * higher or lower than your guess.
     * 
     * You call a pre-defined API int guess(int num), which returns three possible
     * results:
     * 
     * -1: Your guess is higher than the number I picked (i.e. num > pick).
     * 1: Your guess is lower than the number I picked (i.e. num < pick).
     * 0: your guess is equal to the number I picked (i.e. num == pick).
     * Return the number that I picked.
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            }

            if (result == -1) {
                right = mid - 1;
            }

            if (result == 1) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        if (num > pickedNumber) {
            return -1;
        } else if (num < pickedNumber) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GuessNumber gn = new GuessNumber(6);
        String output = "Output: ";

        int n1 = 10;
        System.out.println(output + gn.guessNumber(n1));

    }
}
