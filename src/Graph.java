import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Graph extends JPanel
{
	public Node rootNode;
	public ArrayList<Node> nodes=new ArrayList();
	int size;
    private ArrayList<Edge> edges = new ArrayList(); //Edges will be represented as adjacency List

	public void setRootNode(Node n)
	{
		this.rootNode=n;
	}
	
	public Node getRootNode()
	{
		return this.rootNode;
	}
	
	public void addNode(Node n)
	{
		nodes.add(n);
	}
	
	//This method will be called to make connect two nodes
	public void connectNode(Node start,Node end)
	{
        edges.add(new Edge(start,end));


	}
	
	private Node getUnvisitedChildNode(Node n)
	{

        for (Edge edge : edges) {
            if((edge.getStartLine()== n) && !(edge.getEndLine().isVisited())) {
                return edge.getEndLine();
            }
        }
        return null;
    }
	
	//BFS traversal of a tree is performed by the bfs() function
	public void bfs()
	{
		
		//BFS uses Queue data structure
		Queue<Node> q=new LinkedList();
		q.add(this.rootNode);
		rootNode.setVisited(true);
        printNode(this.rootNode);
		while(!q.isEmpty())
		{

			Node n=q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{

				child.setVisited(true);
				printNode(child);
				q.add(child);
			}
		}
		//Clear visited property of nodes
		//clearNodes();

	}
	
	//DFS traversal of a tree is performed by the dfs() function
	public void dfs()
	{
		//DFS uses Stack data structure
		Stack<Node> s=new Stack();
		s.push(this.rootNode);
		rootNode.setVisited(true);
		printNode(rootNode);
		while(!s.isEmpty())
		{

			Node n=s.peek();
			Node child=getUnvisitedChildNode(n);
			if(child!=null)
			{
				child.setVisited(true);
				printNode(child);
				s.push(child);
			}
			else
			{
				s.pop();
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	
	//Utility methods for clearing visited property of node
	private void clearNodes()
	{
		int i=0;
		while(i<size)
		{
			Node n=nodes.get(i);
			n.setVisited(false);
			i++;
		}
	}
	
	//Utility methods for printing the node's label
	private void printNode(Node n)
	{
		System.out.print(n.getLabel()+" : " + n.isVisited() + "   ");
        sleep();
       repaint();

    }

    private void sleep() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i=0 ; i <= nodes.size()-1 ; i++) {

            g.drawOval(nodes.get(i).getPoint().x,nodes.get(i).getPoint().y,30,30);

            g.drawString(String.valueOf(nodes.get(i).getLabel()), nodes.get(i).getPoint().x, nodes.get(i).getPoint().y);

            if(edges.size() != i) {
                g.setColor(Color.black);
                g.drawLine(edges.get(i).getStartLine().getPoint().x, edges.get(i).getStartLine().getPoint().y,
                        edges.get(i).getEndLine().getPoint().x, edges.get(i).getEndLine().getPoint().y);
            }

            if(nodes.get(i).isVisited()) {
                g.setColor(Color.RED);
            } else {g.setColor(Color.black);}
        }
    }
}
