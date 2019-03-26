
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("input.txt"), Charset.defaultCharset());
        String[] start = (lines.get(0)).split(",");

        // Create int array in which we place input information
        int[] middle = new int[start.length];
        for (int i = 0; i < start.length; i++) {
            middle[i] = Integer.parseInt(start[i]);
        }

        StringBuilder builder = new StringBuilder();

        // Find all triples in which sum of numbers equals zero,
        // but they will not be unique in this stage

        int[] sim = new int[3];  // in this array will be placed triple in which sum of numbers equals zero
        for (int i = 0; i < middle.length - 2; i++) {
            for (int j = 1; j < middle.length - 1; j++) {
                int net = -middle[i] - middle[j];
                for (int k = 2; k < middle.length; k++) {
                    if (middle[k] == net) {
                        sim[0] = middle[i];
                        sim[1] = middle[j];
                        sim[2] = middle[k];
                        Arrays.sort(sim);  // sort array, this will be useful in the next stages when working with set

                        // Build String - in which will be placed all triples(sorted), separated with " "
                        builder.append(Integer.toString(sim[0]) + "," + Integer.toString(sim[1]) + "," + Integer.toString(sim[2]) + " ");
                        break;
                    }
                }
            }
        }

        String completedString = builder.toString();
        // String is devided for substrings-triplets
        String[] finish = completedString.split(" ");

        // These all substrings-triplets will be places in the Set in order to find unique triplets
        Set<String> vvv = new HashSet<>();
        for (int i = 0; i < finish.length; i++) {
            vvv.add(finish[i]);
        }


        PrintWriter out = new PrintWriter("output.txt");
        for (String f : vvv
        ) {
            out.println(f); //print result in the text file - "output.txt"
        }
        out.close();

    }
}
