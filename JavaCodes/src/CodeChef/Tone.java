package CodeChef;

public class Tone {

  // create a pure tone of the given frequency for the given duration
    private static double[] tone(double hz, double duration) { 
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * 2* i * hz / StdAudio.SAMPLE_RATE);
        }
        return a; 
    } 


    
    public void playFrequency(Double hz1) {

        // frequency
        double hz = hz1;

        // number of seconds to play the note
        double duration = Double.parseDouble(".25");

        // create the array
        double[] a = tone(hz, duration);

        // play it using standard audio
        StdAudio.play(a);
    }
}