
# JavaFX 容器 JavaFX Container

## 本章节我们会涉及：

- JavaFX 场景图 (Scene Graph)<br>
- 什么时Pane对象？<br>
    - 关于BorderPane的一些介绍
    - 一个BoderPane的样例代码

## JavaFX 场景图 (Scene Graph)

现有的Node Hierarchy包含了：<br>
 - Node
     - Parent
         - Region
             - Pane
         - Control
             - Labeled<br>

region下的分支我们称之为<b>容器 (Container)</b>, 用于承载和组织其他控件 <br>
control下的分支我们称之为<b>控件 (control)</b><br>
一般来说，一个<b>容器(Container)</b>从属于root类下

在上述结构下还包含了很多子节点，例如，在Labeled下还包含：<br>
- Labeled
    - ButtonBase
        - Button
        - CheckBox
        - ToggleButton
            - RadioButton
    - Label

有关所有类，请参见[JavaFX API文档](https://openjfx.io/javadoc/14/
)<br>
以及更多[有关JavaFX的信息](https://www.oracle.com/technetwork/java/javase/documentation/javafx-docs-2159875.html)

一般来说，我们首先通过实例化现有Node对象来构建GUI。例如：


```Java
Label myLabel = new Label("Hello!");
```

为了在窗口中显示Node，我们需要将实例化的对象添加到现有的<b>场景图(Scene Graph)</b>结构中。<br>
而为了能将Node正确的添加，我们需要使用<b>Pane对象 (Pane Object)</b>。<br>
一个Pane子对象包含了一个<b>布局管理器(Layout Manager)</b>用于决定在什么位置这些Node<br>
我们可以将一个Pane对象添加到不同类型的Pane对象中，就好像它是一个Node本身一样，可以为我们提供极大的布局灵活性<br>
在完成添加后，<b>根Pane对象(root Pane Object)</b>将作为整个<b>场景对象(Scene Object)</b>的根，并且可以显示已经构建的整个场景

## 什么是Pane对象?

JavaFX包含了各式各样的Pane对象，这其中包括：
 - AnchorPane
 - BorderPane
 - DialogPane (本课程不涉及)
 - FlowPane
 - GridPane
 - HBox
 - PopupControl.CSSBridge (本课程不涉及)
 - StackPane (本课程不涉及)
 - TextFlow
 - TilePane (本课程不涉及)
 - VBox

今天我们就来讨论一下<b>BorderPane</b>

### BoderPane

一个BoderPane将窗口划为<b>上(Top), 下(Bottom), 左(Left), 右(Right), 中(Centre)</b>

如果我们想要将一个按钮添加到位置<b>"上"(Top)</b>, 我们需要：


```Java
BorderPane bPane = new BoderPane; //实例化一个BorderPane对象
Button myButton = new Button("Bonjour et Bienvenue!"); //实例化一个按钮对象 
bPane.setTop(myButton); //将按钮对象放置于BorderPane的位置"上"
```

如果一个组件小于可用区域，则会自动采用其<b>首选大小(preferred size)</b>。<br>
如果其余四个方向都是空的，那么<b>中心(centre)</b>会占用他们。<br>
我们可以使用<b>"static.setMargin()"</b>来在组件周围添加边距。<br>
我们还可以使用<b>Pos enum</b>中的值和<b>"static.setAlignment()"</b>来指定位置内的对齐方式。<br>
这种布局非常适合将整个窗口分为多个子区域，然后在有需要的的区域中进行进一步的规划。<br>

现在，我们来看一个BoderPane的代码样例:<br>
![avatar](Java_Note/Java课程笔记/NotePicture/批注 2020-03-30 181325.png)


```Java
public void start(Stage primaryStage) {
            try {
                BorderPane root = new BorderPane();

                root.setTop(new Button("Top Button"));
                Button aTopButton = new Button("Another Top Button");
                // Note that this does not work to change the position of just the
                // aTopButton - it changes the alignment for both buttons because it
                // is changing the alignment for the Top region.
                BorderPane.setAlignment(aTopButton, Pos.CENTER);
                root.setTop(aTopButton);
                root.setLeft(new Button("Left Button"));
                root.setBottom(new Button("Bottom Button"));
                root.setRight(new Button("Right Button"));

                // Let's customize centreButton a bit more than the others:
                Button centreButton = new Button("Centre Button");
                centreButton.setFont(new Font("Consolas", 20));
                centreButton.setPrefSize(200, 100);
                centreButton.setAlignment(Pos.BASELINE_LEFT);	// Affects text alignment within Button
                BorderPane.setAlignment(centreButton, Pos.TOP_LEFT);
                BorderPane.setMargin(centreButton, new Insets(60, 20, 20, 60));
                root.setCenter(centreButton);

                // Let's change the alignment the buttons at the Top position
                // BorderPane.setAlignment(root.getTop(), Pos.CENTER);
                // BorderPane.setAlignment(root.getTop(), Pos.CENTER_LEFT);	// Default
                // BorderPane.setAlignment(root.getTop(), Pos.CENTER_RIGHT);

                Scene scene = new Scene(root,500,300);
                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setTitle("Border Pane Demo");
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
```

这就是以上代码的运行结果：<br>
![avatar](https://s1.ax1x.com/2020/03/30/GncjLF.png)
写在最后的一些小提示：<br>
在一个JavaFX项目被初始化的时候，这些Pane对象所在的类并不会被import，这句需要我们手动去完成，好在诸如Eclipse和IDEA这样的IDE可以自动Import，但是要注意，<b>import时一定要选定 javaFX包下的内容</b>
