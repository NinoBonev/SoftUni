import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatrixOperator {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(console.readLine());
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < r; i++)
        {
            String input = console.readLine();
            ArrayList<String> currentString = new ArrayList<String> (Arrays.asList(input.split(" ")));
            ArrayList<Integer> current = new ArrayList<>();

            for (int j = 0; j < currentString.size(); j++)
            {
                current.add(Integer.parseInt(currentString.get(j)));
            }
            arrays.add(current);
        }

        while (true)
        {
            String current = console.readLine();

            if (current.equals("end"))
            {
                break;
            }
            else
            {
                String [] tokens = current.split(" ");
                String command = tokens[0];

                if (command.equals("remove"))
                {
                    String type = tokens[1];
                    String positionName = tokens[2];
                    String positionNum = tokens[3];

                    if (type.equals("positive"))
                    {
                        if (positionName.equals("row"))
                        {
                            ArrayList<Integer> temp = new ArrayList<>(arrays.get(Integer.parseInt(positionNum)));
                            for (Integer y:
                                 temp) {
                                 if (y >= 0)
                                 {
                                      arrays.get(Integer.parseInt(positionNum)).remove(y);
                                 }
                            }

                        }
                        else if (positionName.equals("col"))
                        {
                            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(arrays);
                            for (int i = 0; i < temp.size(); i++)
                            {
                                if (Integer.parseInt(positionNum) >= temp.get(i).size())
                                {
                                    continue;
                                }

                                else if (temp.get(i).get(Integer.parseInt(positionNum)) >= 0)
                                {
                                    arrays.get(i).remove(Integer.parseInt(positionNum));
                                }

                            }
                        }
                    }

                    else if (type.equals("negative"))
                    {
                        if (positionName.equals("row"))
                        {
                            ArrayList<Integer> temp = new ArrayList<>(arrays.get(Integer.parseInt(positionNum)));
                            for (Integer y:
                                    temp) {
                                if (y < 0)
                                {
                                    arrays.get(Integer.parseInt(positionNum)).remove(y);
                                }
                            }

                        }
                        else if (positionName.equals("col"))
                        {
                            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(arrays);
                            for (int i = 0; i < temp.size(); i++)
                            {
                                if (Integer.parseInt(positionNum) >= temp.get(i).size())
                                {
                                    continue;
                                }

                                else if (temp.get(i).get(Integer.parseInt(positionNum)) < 0)
                                {
                                    arrays.get(i).remove(Integer.parseInt(positionNum));
                                }

                            }
                        }
                    }

                    else if (type.equals("even"))
                    {
                        if (positionName.equals("row"))
                        {
                            ArrayList<Integer> temp = new ArrayList<>(arrays.get(Integer.parseInt(positionNum)));
                            for (Integer y:
                                    temp) {
                                if (y % 2 == 0)
                                {
                                    arrays.get(Integer.parseInt(positionNum)).remove(y);
                                }
                            }

                        }
                        else if (positionName.equals("col"))
                        {
                            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(arrays);
                            for (int i = 0; i < temp.size(); i++)
                            {
                                if (Integer.parseInt(positionNum) >= temp.get(i).size())
                                {
                                    continue;
                                }
                                else if (temp.get(i).get(Integer.parseInt(positionNum)) % 2 == 0)
                                {
                                    arrays.get(i).remove(Integer.parseInt(positionNum));
                                }

                            }
                        }
                    }

                    else if (type.equals("odd"))
                    {
                        if (positionName.equals("row"))
                        {
                            ArrayList<Integer> temp = new ArrayList<>(arrays.get(Integer.parseInt(positionNum)));
                            for (Integer y:
                                    temp) {
                                if (y % 2 != 0)
                                {
                                    arrays.get(Integer.parseInt(positionNum)).remove(y);
                                }
                            }

                        }
                        else if (positionName.equals("col"))
                        {
                            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(arrays);
                            for (int i = 0; i < temp.size(); i++)
                            {
                                if (Integer.parseInt(positionNum) >= temp.get(i).size())
                                {
                                    continue;
                                }

                                else if (temp.get(i).get(Integer.parseInt(positionNum)) % 2 != 0)
                                {
                                    arrays.get(i).remove(Integer.parseInt(positionNum));
                                }

                            }
                        }
                    }
                }

                else if (command.equals("swap"))
                {
                    int firstRow = Integer.parseInt(tokens[1]);
                    int secondRow = Integer.parseInt(tokens[2]);

                    Collections.swap(arrays, firstRow, secondRow);

                }

                else if (command.equals("insert"))
                {
                    int row = Integer.parseInt(tokens[1]);
                    int element = Integer.parseInt(tokens[2]);

                    arrays.get(row).add(element);
                }
            }
        }

        for (ArrayList<Integer> x:
             arrays) {
            for (Integer y:
                 x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }
}
