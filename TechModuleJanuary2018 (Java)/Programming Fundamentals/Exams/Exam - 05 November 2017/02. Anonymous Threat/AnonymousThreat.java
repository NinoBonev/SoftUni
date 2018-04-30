import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnonymousThreat {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.asList(console.readLine().split("\\s+"));
        List<String> result = new ArrayList<>(input);

        while (true)
        {
            String line = console.readLine();
            if (line.equals("3:1"))
            {
                break;
            }
            else
            {
                String[] command = line.split("\\s+");
                String operation = command[0];

                if (operation.equals("merge"))
                {
                    Integer startIndex = Integer.parseInt(command[1]);

                    if (startIndex >= result.size() - 1)
                    {
                        startIndex = result.size() - 1;
                    }
                    else if (startIndex < 0)
                    {
                        startIndex = 0;
                    }

                    Integer endIndex = Integer.parseInt(command[2]);

                    if (endIndex < 0)
                    {
                        endIndex = 0;
                    }
                    else
                    {
                        endIndex = Math.min(endIndex, result.size() - 1);
                    }

                    StringBuilder merged = new StringBuilder();

                    List<String> current = new ArrayList<>();
                    for (int i = 0; i < startIndex; i++)
                    {
                        current.add(result.get(i));
                    }

                    for (int j = startIndex; j <= endIndex; j++)
                    {
                        merged.append(result.get(j));
                    }

                    current.add(merged.toString());

                    for (int n = endIndex + 1; n < result.size(); n++)
                    {
                        current.add(result.get(n));
                    }

                    result = current;
                }
                else if (operation.equals("divide"))
                {
                    Integer index = Integer.parseInt(command[1]);
                    Integer partitions = Integer.parseInt(command[2]);
                    Integer substringCount = result.get(index).length() / partitions;

                    List<String> current = new ArrayList<>();
                    for (int i = 0; i < index; i++)
                    {
                        current.add(result.get(i));
                    }

                    for (int j = 0; j < result.get(index).length(); j+= substringCount)
                    {
                        if (result.get(index).length() % partitions == 0)
                        {
                            current.add(result.get(index).substring(j, j + substringCount));
                        }
                        else
                        {
                            Integer differece = result.get(index).length() % partitions;
                            if (j == result.get(index).length() - substringCount - differece)
                            {
                                current.add(result.get(index).substring(j, j + substringCount + differece));
                                break;
                            }
                            else
                            {
                                current.add(result.get(index).substring(j, j + substringCount));
                            }
                        }

                    }

                    for (int n = index + 1; n < result.size(); n++)
                    {
                        current.add(result.get(n));
                    }

                    result = current;
                }
            }
        }

        System.out.println(String.join(" ", result));

    }
}
