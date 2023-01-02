import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TextParser {

    public String parse(String filename) throws FileNotFoundException {

        StringBuilder result = new StringBuilder("The amount to pay ");
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        String name = "";

        long payment = 0;
        try (Scanner scanner =  new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                int endName = line.indexOf("=");
                name = line.substring(0,endName);
                StringTokenizer tokenizer = new StringTokenizer(line.substring(endName+1,line.length()), ",", false);


                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken(",");
                    String day = token.substring(0, 2);
                    String start = token.substring(2,7);
                    String end = token.substring(8,13);

                    payment += Calculator.calculate(day, start, end);
                }
            }
        }
        result.append(name).append(" is: ").append(payment);
        result.append(" USD");
        return result.toString();
    }
}
