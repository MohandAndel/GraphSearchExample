import java.awt.*;

/**
 * Created by mohand on 5/16/14.
 */
public class Edge {

    private Node startLine;
    private Node endLine;

    public Edge() {}

    public Edge(Node startLine, Node endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
        this.startLine.setPoint(new Point(startLine.getPoint().x+20,startLine.getPoint().y+10));
        this.endLine.setPoint(new Point(endLine.getPoint().x+20,endLine.getPoint().y+10));
    }

    public Node getStartLine() {
        return startLine;
    }

    public void setStartLine(Node startLine) {
        this.startLine = startLine;
    }

    public Node getEndLine() {
        return endLine;
    }

    public void setEndLine(Node endLine) {
        this.endLine = endLine;
    }
}
