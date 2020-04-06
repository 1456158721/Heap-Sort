import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TreeNode extends Circle implements Comparable<TreeNode>{
    Integer value;
    double side;
    double height;
    TreeNode (Integer value){
        this.value = value;
        this.setRadius( 15 );
        this.setFill( Color.WHITE );
        this.setStroke( Color.BLACK );
    }
    public int compareTo (TreeNode o) {
        return value - o.value;
    }

}
