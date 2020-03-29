
# 开始使用 JavaFX

<b>在本章节中，我们会涉及以下内容：</b><br>
- JavaFX概览<br>
- JavaFX安装和配置<br>
- 了解初始化后的JavaFX项目<br>
- 了解CSS样式表<br>

## JavaFX概览

在JavaFX中，UI的样式和布局将会使用*.css 和 *.fxml 的功能性代码文件

JavaFX包含了一系列的工具，包括：<br>
- 网页浏览<br>
- 媒体播放<br>
- 2D和3D的绘图动画<br>
- 硬件加速<br> 


## JavaFX安装

值得注意的是，在JDK11及以后的版本中，JavaFX不在包含于JDK当中，这就需要下载JavaFX的SDK并完成对包的导入

同时，也要完成对SceneBuilder的安装

我们的教授使用的是eclipse作为IDE<br>
如果将eclipse作为IDE则需要完成对e(fx)clipse的配置<br>
具体方法请参见：<http://www.eclipse.org/efxclipse>

但如果要使用IntelliJ IDEA作为IDE，则需要在IDEA内部完成配置<br>
具体方法请参见 [JDK11在IDEA中配置JAVAFX](https://blog.csdn.net/qq_41190856/article/details/90726800)<br>
感谢CSDN作者 浮生若梦 -

## JavaFX项目初始化向导

项目的配置包括导入JavaFX库、配置VMOptions,在将这些完成以后，就可以开始对项目的编写了。如果使用的是IDEA，则会自动包含好一个标题栏为"hello, world"的空窗口。代码如下：


```Java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
```

通过观察上述代码我们可以发现：<br>
- GUI类需要继承Application类(javafx.application.Application)<br>
- main()方法必须调用继承的launch()方法来启动应用程序, 将主要参数列表中的args将作为launch()的参数<br>
- 初始化后，GUI类会重写Application中的start()方法，并且start()的参数是窗口的Stage对象，即primaryStage<br> 
- JavaFX中，一个对象（布局，控件，图像等）被称为“节点”(node)<br>
- 一个Node会被添加到Nodes hierarchy当中，而根结点(root)会在Scene对象实例化时被添加到其中，同时也会给出一个由像素值描述的尺寸当中
- 场景对象Scene作为参数传递给setScene
- 最终，方法.show()被用于展示stage对象

不同于eclipse, IDEA完成初始化后不会默认添加一个css文件所以我们需要手动添加并连接：


```Java
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root, 300, 275);
            scene.getStylesheets().add("sample/application.css");
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(scene);
            primaryStage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}

```

完成之后，一个CSS(Cascading Style Sheet 层叠样式表)文件将会被他关联到scene<br>
通过编辑这个文件，我们可以为scene设置皮肤。在文件为空时，scene将默认使用皮肤Modena
