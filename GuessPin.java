import java.util.Arrays;
import java.util.Random;

public class GuessPin {
    public static void main(String[] args) {

        int[] pin = new int[4];
        int[] guess = new int[4];
        Random ran = new Random();
        for(int i=0; i < 4; ++i) {
            pin[i] = ran.nextInt(5) + 1;
            guess[i] = ran.nextInt(5) + 1;
        }
        System.out.println("pin   = " + Arrays.toString(pin) + "");
        System.out.println("guess = " + Arrays.toString(guess) + "");
        guessPin(guess, pin);
    }


    public static void guessPin(int[] guess, int[] pin) {
        assert guess.length == 4;
        assert pin.length == 4;

        int r = 0;
        int w = 0;
        int[] counter = new int[6];
        for(int i=0; i < 4; ++i) {
            if(guess[i] == pin[i]) {
                ++r;
                guess[i] += 5; // mark for correctness, also for recovering later
            } else {
                counter[pin[i]]++;
            }
        }
        System.out.println("guess = " + Arrays.toString(guess) + ": after marking");
        System.out.println("count = " + Arrays.toString(counter));

        for(int i=0; i<4; ++i) {
            if(guess[i] > 5) {
                guess[i] -= 5; // recover
                continue;
            }
            if (counter[guess[i]] > 0) {
                w++;
                counter[guess[i]]--; // if not duplicated
            }
        }

        System.out.println("guess = " + Arrays.toString(guess) + ": after recovering");

        System.out.println("Guess result: [" + r + "] digits correctly, [" + w + "] digits are in wrong place");
    }
}
