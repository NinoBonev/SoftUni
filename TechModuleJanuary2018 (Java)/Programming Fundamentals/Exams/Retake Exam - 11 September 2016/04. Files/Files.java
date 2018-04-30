import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Files {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Integer inputNumber = Integer.parseInt(console.readLine());

        Map<String, Map<String, Long>> files = new LinkedHashMap<>(); //<root, <filename, size>>

        for (int i = 0; i < inputNumber; i++) {

            String [] data = console.readLine().split("\\\\");
            String root = data[0];
            String file = data[data.length - 1];
            String fileName = file.split(";")[0];
            Long fileSize = Long.parseLong(file.split(";")[1]);

            files.putIfAbsent(root, new TreeMap<>());
            files.get(root).putIfAbsent(fileName, 0L);
            files.get(root).replace(fileName, fileSize);
        }

        String search = console.readLine();
        String searchExtension = search.split(" in ")[0];
        String searchRoot = search.split(" in ")[1];

        if (files.get(searchRoot).entrySet().stream()
                .filter(x -> x.getKey().split("\\.")[1].equals(searchExtension)).count() > 0)
        {
            files.get(searchRoot).entrySet().stream()
                    .filter(x -> x.getKey().split("\\.")[1].equals(searchExtension))
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .forEach(z -> {
                        System.out.printf("%s - %d KB%n", z.getKey(), z.getValue());
                    });
        } else {
            System.out.println("No");
        }
    }
}
