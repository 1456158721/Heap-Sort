import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

class MyPanel extends Pane {
    private Heap<TreeNode> heap = new Heap<>();

    void reDrew(Integer num){
        TreeNode node = new TreeNode( num );
        heap.add( node );
        this.getChildren().clear();
        drew();
    }
    void reMove(){
        heap.remove();
        drew();
    }
    private void drew(){
        double x = 0;
        double y;
        TreeNode root;
        for (int i = 0;i<heap.getNum().size();i++){
            if(i == 0){
                x = this.getWidth() / 2 ;
                y = 20;
                root = heap.getNum().get( 0 );
                root.setCenterX( x );
                root.setCenterY( y );
                root.height = 50;
                root.side  = 100;
                Label label = new Label( heap.getNum().get( i ).value + "");
                label.setLayoutX( root.getCenterX()-5 );
                label.setLayoutY( root.getCenterY()-5 );
                this.getChildren().addAll( root, label);
            }else{
                Line line = new Line( );
                this.getChildren().add( line );
                int pended = (i - 1) / 2;
                TreeNode  panose = heap.getNum().get( pended );
                double dis = panose.side * Math.cos( 30 * Math.PI / 180);
                int left = pended * 2 + 1;
                int right = pended * 2 + 2;
                if(i == left){
                    x = panose.getCenterX() - dis;
                }else if(i == right){
                    x = panose.getCenterX() + dis;
                }
                y = panose.getCenterY() + panose.height;
                TreeNode child  = heap.getNum().get( i );
                child.setCenterX( x );
                child.setCenterY( y );
                child.side = panose.side * 0.5;
                child.height = panose.height * 0.5;
                line.setStartX( panose.getCenterX() );
                line.setStartY( panose.getCenterY() );
                line.setEndX( child.getCenterX() );
                line.setEndY( child.getCenterY() );
                Label label = new Label( heap.getNum().get( i ).value + "");
                label.setLayoutX( child.getCenterX()-5 );
                label.setLayoutY( child.getCenterY()-5 );
                this.getChildren().addAll( child , label);
            }
        }
    }
}
