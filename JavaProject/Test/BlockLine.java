import javafx.scene.control.TextField;

public class BlockLine extends TextField {
    
    public BlockLine() {
        super();
        super.setDisable(true);
        super.setScaleY(0.08);
        super.setStyle("-fx-background-color: #FFFFFF;");
        super.setMinHeight(8);
        super.setMaxHeight(8);
    }    
}