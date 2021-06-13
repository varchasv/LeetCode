import java.util.*;

public class Minimum_Number_of_Vertices_to_Reach_All_Nodes_1557 {
    private class Node{
        int vertex;
        int incoming;
        int outgoing;
        List<Integer> edges;
        Node(int vertex){
            this.vertex=vertex;
            edges = new ArrayList<>();
        }
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer,Node> map = new HashMap<>();
        for(List<Integer> list : edges){
            int start= list.get(0);
            int end = list.get(1);
            if(map.get(start)!=null){
                Node node = map.get(start);
                node.outgoing++;
                node.edges.add(end);
                node.vertex=start;
            }else{
                Node newNode = new Node(start);
                newNode.outgoing++;
                newNode.edges.add(end);
                newNode.vertex=start;
                map.put(start,newNode);
            }

            if(map.get(end)!=null){
                Node node = map.get(end);
                node.incoming++;
            }else{
                Node newNode = new Node(end);
                newNode.vertex=end;
                newNode.incoming++;
                map.put(end,newNode);
            }

        }
        Queue<Node> q = new PriorityQueue<Node>(n,new Comparator<Node>(){
            public int compare(Node a, Node b){
                if(a.incoming == b.incoming){
                    return b.outgoing - a.outgoing;
                }
                return a.incoming - b.incoming;
            }
        });

        for(Map.Entry<Integer,Node> entry : map.entrySet()){
            q.add(entry.getValue());
        }

        boolean[] visited = new boolean[n];
        List<Integer> output = new ArrayList<>();
        while(!q.isEmpty()){
            Node nn= q.remove();
            if(!visited[nn.vertex]){
                output.add(nn.vertex);
                check(nn.vertex , visited,output,map);
            }
        }
        return output;

    }
    void check(int vertex, boolean[] visited , List<Integer> output,Map<Integer,Node> map){
        visited[vertex]=true;
        Node node = map.get(vertex);
        for(Integer edge : node.edges){
            if(!visited[edge]){
                check(edge,visited,output,map);
            }
        }
    }


}

