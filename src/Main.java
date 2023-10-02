
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int numberOfBoxes = Integer.parseInt(reader.readLine()); // Число свинок-копилок
        int keyOfFirstBox= Integer.parseInt(reader.readLine()); //где лежит ключ от первой копилки
        int keyOfSecondBox= Integer.parseInt(reader.readLine()); //где лежит ключ от второй копилки
        int keyOfThirdBox= Integer.parseInt(reader.readLine()); //где лежит ключ от третьей копилки
        int keyOfFourthBox= Integer.parseInt(reader.readLine()); //где лежит ключ от четвертой копилки

        List<Edge> edges=Arrays.asList(new Edge(1,keyOfFirstBox), new Edge(2,keyOfSecondBox),
                                       new Edge(3,keyOfThirdBox), new Edge(4,keyOfFourthBox));
        Graph graph=new Graph(edges);
        // Graph.printGraph(graph);
        findMin(graph);
    }

    public static void findMin(Graph graph) {
        int count = 1;

        for (List<Integer> edges : graph.adjList) {
            if (edges.isEmpty()) {
                count++;
            }
        }
        System.out.println("минимум нужно открыть " + count + " копилок");

    }
}
