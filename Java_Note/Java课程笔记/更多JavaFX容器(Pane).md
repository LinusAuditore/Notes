
# 更多JavaFX容器 (Pane)

## 本章节我们将涉及：

- 什么是Children(子对象)?
- AnchorPane
- FlowPane
- GridPane

## Children 子对象

被添加到pane中的Node(节点)被称为<b>Children(子对象)</b><br>
我们可以通过使用<b>.add()</b>或者<b>.addAll()</b>方法来向Pane中添加Children。其中，<b>.addAll()</b>方法也允许将集合<b>Collection&lt;? extends Node&gt;</b>作为对象传入<br>
通过使用Pane的<b>.getChildren()</b>将会返回一个包含了<b>所有已添加子节点的集合</b>

## AnchorPane

在AnchorPane中，组件将被使用<b>静态方法</b>,通过设定到<b>layout边界</b>的<b>距离</b>从而进行定位，这些方法包括：


```Java
static void setBottomAnchor(Node child, Double value);
static void setLeftAnchor(Node child, Double value);
static void setRightAnchor(Node child, Double value);
static void setTopAnchor(Node child, Double value);
```

变量value是<b>以像素为单位的空间到边界的距离</b>。<br>
因为AnchorPane是将对象的位置定义为对象到layout边界的距离，所以，即使窗口缩放，位置也将保持相对一致<br>
AnchorPane的一个好处是，能过做到比较好的在一个窗口的环境下管理组件

更多内容请见本章节的对应代码

## FlowPane

在<b>默认情况下</b>，FlowPane将<b>从左往右</b>在一行上添加Children(子对象)<br>
如果<b>可用空间已满</b>，则children会<b>被推入下一行(wrap)</b><br>
如果窗口的大小发生了调整，则所有控件会<b>自动灵活环绕</b><br>
所有的按钮将会被保存在一个<b>ArrayList&lt;Button&gt;</b>里

更多内容请见本章节的对应代码

## GridPane

GridPane <b>可能是最难使用的Pane</b> (PS:就这居然还是教授最爱的Pane，他是M吗?!) ，但也提供了最多的控制。SceneBuilder和它一起使用时会较为方便<br>
GridPane 以<b>网格 (Grid)</b>作为基础，因而选择控件位置时会较为灵活<br>
GridPane 的每一列<b>宽度</b>会被设定为和<b>该列最宽的控件一致</b><br>
GridPane 每一行的<b>高度</b>也会被设定为与<b>该行最高的控件一致</b><br>

我们可以在行与列中置入间隔，仅需使用方法<b>.add(node, column#, row#)</b><br>或<b>.add(node, column#, row#, columnspan, rowspan)</b>

在进行开发时，可以通过方法<b>.setGridLinesVisible(true)</b>来查看网格线

更多内容请见本章节的对应代码
