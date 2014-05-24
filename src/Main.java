import javax.swing.*;
import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

        Random random = new Random();

        Node nA=new Node('A',random.nextInt(400),random.nextInt(400));
        Node nB=new Node('B',random.nextInt(400),random.nextInt(400));
        Node nC=new Node('C',random.nextInt(400),random.nextInt(400));
        Node nD=new Node('D',random.nextInt(400),random.nextInt(400));
        Node nE=new Node('E',random.nextInt(400),random.nextInt(400));
        Node nF=new Node('F',random.nextInt(400),random.nextInt(400));
        Node n1=new Node('1',random.nextInt(400),random.nextInt(400));
        Node n2=new Node('2',random.nextInt(400),random.nextInt(400));
        Node n3=new Node('3',random.nextInt(400),random.nextInt(400));


//		Node nA=new Node('A',50,100);
//		Node nB=new Node('B',110,100);
//		Node nC=new Node('C',150,100);
//		Node nD=new Node('D',50,200);
//		Node nE=new Node('E',110,200);
//		Node nF=new Node('F',150,200);

		//Create the graph, add nodes, create edges between nodes
		Graph g=new Graph();

		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
		g.setRootNode(nA);
		
		g.connectNode(nA,nB);
		g.connectNode(nA,nC);
		g.connectNode(nA,nD);
		
		g.connectNode(nB,nE);
		g.connectNode(nB,nF);
		g.connectNode(nC,nF);
        g.connectNode(nC,n1);
        g.connectNode(nC,n2);
        g.connectNode(nC,n3);



        JFrame frame = new JFrame();

        frame.setSize(500,500);
        frame.add(g);
        frame.setVisible(true);


        //Perform the traversal of the graph
		System.out.println("DFS Traversal of a tree is ------------->");
		//g.dfs();

		System.out.println("\nBFS Traversal of a tree is ------------->");
		g.bfs();
		
	}

}
