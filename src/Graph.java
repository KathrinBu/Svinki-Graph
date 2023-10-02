import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    // Список списков для представления списка смежности
    List<List<Integer>> adjList=new ArrayList<>();

    // Конструктор для построения Graphа
    public Graph(List<Edge> edges) {
        // найти вершину с максимальным номером
        int n=1;
        for (Edge e: edges) {
            n=Integer.max(n,Integer.max(e.src,e.dest));
        }
        // выделяем память для списка смежности
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        // добавляем ребра в ориентированный graph
        for (Edge current:edges) {
            // выделяем новый узел в списке смежности от источника до места назначения
            adjList.get(current.src).add(current.dest);
        }
    }
    // Функция для печати представления списка смежности Graph
    public static void printGraph(Graph graph){
        int src=1;
        int n=graph.adjList.size();
        while (src<n) {
            // вывести текущую вершину и все соседние с ней вершины
            for (int dest:graph.adjList.get(src)) {
                System.out.println("(" + src + "->" + dest + ")");
            }
            src++;
        }
    }
}
