import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.regex.Pattern;

public class MyApplication extends Application {
    @Override
    public void start (Stage primaryStage){
        MyPanel myPanel = new MyPanel( );
        BorderPane borderPane = new BorderPane();
        //盒子
        HBox hBox = new HBox();
        Text text_1 = new Text( "请输入数字：" );
        TextField text_2 = new TextField();
        Tooltip tooltip = new Tooltip();
        tooltip.setText("不要乱输哦~");
        text_2.setTooltip(tooltip);
        Button button_1 = new Button( "插入" );
        button_1.setOnAction( event -> {
            Pattern pattern = Pattern.compile("[0-9]*");
            String text =  text_2.getText();
            if (!text.isEmpty()) {
                if (pattern.matcher( text ).matches()) {
                    myPanel.reDrew(Integer.valueOf( text ));
                } else {
                    caveat( "Do not enter characters other than numbers!","请勿输入除数字外的其它字符！");
                }
            } else {
                caveat( "Do not submit null values!","请不要提交空值！" );
            }
        } );
        Button button_2 = new Button( "删除" );
        button_2.setOnAction( event -> {
            System.out.println("删除树顶元素");
            myPanel.reMove();
        } );
        hBox.setAlignment( Pos.CENTER );
        hBox.getChildren().addAll( text_1,text_2,button_1,button_2 );
        borderPane.setBottom( hBox );
        borderPane.setCenter( myPanel );
        Scene s = new Scene( borderPane,800,400 );
        primaryStage.setTitle( "堆排序示例" );
        primaryStage.setScene( s );
        primaryStage.show();
    }
    private void caveat (String content_1,String content_2){
        Alert alert = new Alert( Alert.AlertType.WARNING);
        alert.setTitle( "FBI Warning" );
        alert.setHeaderText(content_1);
        alert.setContentText(content_2);
        alert.showAndWait();
    }
}
