import java.awt.*;

public class Node
{
	private char label;
	private boolean visited=false;
    private Point point;

	public Node(char l , int x , int y)
	{
		this.label=l;
        this.point = new Point(x,y);
	}

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {

        this.visited = visited;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }


}
