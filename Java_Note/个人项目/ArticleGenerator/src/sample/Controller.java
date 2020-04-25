package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {
    @FXML
    private Button Gene;
    @FXML
    private TextField theObj;
    @FXML
    private TextField theEvent;
    @FXML
    private TextField EventSys;
    @FXML
    private TextArea Article;
    private String theArticle;
    @FXML
    public void Generation(){
        if (theObj.getText().trim().isEmpty() && theEvent.getText().trim().isEmpty() && EventSys.getText().trim().isEmpty()){
            theArticle = "　　辣椒有的人不爱吃是怎么回事呢？辣椒相信大家都很熟悉，但是辣椒有的人不爱吃是怎么回事呢，下面就让小编带大家一起了解吧。\n" +
                    "　　辣椒有的人不爱吃，其实就是辣椒太辣了，有些人讨厌吃辣，大家可能会很惊讶辣椒怎么会有的人不爱吃呢？但事实就是这样，小编也感到非常惊讶。\n" +
                    "　　这就是关于辣椒有的人不爱吃的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！";
        } else if (theObj.getText().trim().isEmpty() || theEvent.getText().trim().isEmpty() || EventSys.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "虽然营销号文章很格式化,但你总得扯点什么" ,"噢不!",  JOptionPane.PLAIN_MESSAGE);
        } else {
            String str0 = theObj.getText();
            String str1 = theEvent.getText();
            String str2 = EventSys.getText();
            theArticle = "    " + str0 + str1 + "是怎么回事呢？" + str0 + "相信大家都很熟悉，但是" + str0 + str1 + "是怎么回事呢，下面就让小编带大家一起了解吧。\n"+
                "　　"+ str0 + str1+ "，其实就是" + str2 + "，大家可能会很惊讶" + str0+ "怎么会" + str1 + "呢？但事实就是这样，小编也感到非常惊讶。\n"+
                "   这就是关于" + str0 + str1 + "的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！";
        }


        Article.setText(theArticle);
    }
}
