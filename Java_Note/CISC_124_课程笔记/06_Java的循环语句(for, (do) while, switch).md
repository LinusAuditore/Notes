
# Java的循环语句: for, (do) while, switch
## 本章我们会涉及
- <b>Java的循环</b>
    - `(do) while`语句
    - `for`语句
    - `switch`语句
    - `break`语句
    - `continue`语句

## while循环
`while`是最基本的循环，它的结构为:<br>
```Java
while( 布尔表达式 ) {
  //循环内容
}
```
只要布尔表达式为`true`, 语句就会一直执行下去。<br>
以下的demo展示了一个简单的`while`循环:


```Java
public class demo {
   public static void foobar0() {
      int x = 15;
      while( x < 20 ) {
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }
   }
}
demo.foobar0();
```

    value of x : 15
    value of x : 16
    value of x : 17
    value of x : 18
    value of x : 19
    

## do...while循环
对于 `while` 语句而言，如果不满足条件, 则不能进入循环。但有时候我们需要即使不满足条件, 也至少执行一次。它的基本结构为:<br>
```Java
do {
       //代码语句
}while(布尔表达式);
```
注意：布尔表达式在循环体的后面, 所以语句块在检测布尔表达式之前已经执行了。 如果布尔表达式的值为 `true`, 则语句块一直执行, 直到布尔表达式的值为 `false`<br>
`do…while` 循环和 `while` 循环相似, 不同的是, `do…while` 循环至少会执行一次。<br>
以下的demo展示了一个简单的`do...while`循环


```Java
public class demo {
   public static void foobar1(){
      int x = 15;
 
      do{
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }while( x < 20 );
   }
}
demo.foobar1();
```

    value of x : 15
    value of x : 16
    value of x : 17
    value of x : 18
    value of x : 19
    

## for循环
虽然所有循环结构都可以用 `while` 或者 `do...while`表示, 但 Java 提供了另一种语句`for`循环, 使一些循环结构变得更加简单<br>
`for`循环的执行次数是在执行前就已经确定的, 其语法格式如下: <br>
```Java
for(初始化; 布尔表达式; 数值刷新式){
    // 代码语句
}
```
关于`for`循环有以下几点说明:<br>
- 最先执行初始化步骤。可以声明一种类型, 但可初始化一个或多个循环控制变量, 也可以是空语句。
- 然后, 检测布尔表达式的值。如果为 `true`, 循环体被执行。如果为`false`, 循环终止, 开始执行循环体后面的语句。
- 执行一次循环后, 会执行数值刷新式。
- 再次检测布尔表达式。循环执行上面的过程。

以下的demo展示了一个简单的`for`循环:


```Java
public class demo {
   public static void foobar2() {
      for(int x = 15; x < 20; x = x+1) {
         System.out.print("value of x : " + x );
         System.out.print("\n");
      }
   }
}
demo.foobar2();
```

    value of x : 15
    value of x : 16
    value of x : 17
    value of x : 18
    value of x : 19
    

## for循环(Pro)
从Java5开始, Java引入了一种<b>主要用于数组</b>的增强型`for`循环<br>
其语法为如下格式:<br>
```Java
for(声明语句: 表达式)
{
   //代码句子
}
```
<b>声明语句</b>：声明新的局部变量, <b>该变量的类型必须和数组元素的类型匹配</b>。其作用域限定在循环语句块中, 其值与此时数组元素的值相等<br>
<b>表达式</b>: <b>表达式是要访问的数组名</b>, 或者是返回值为数组的方法<br>
以下的demo展示了一个简单的增强型`for`循环:


```Java
public class demo {
   public static void foobar3(){
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ){
         System.out.print( x );
         System.out.print(",");
      }
      System.out.print("\n");
      String [] names ={"James", "Larry", "Tom", "Lacy"};
      for( String name : names ) {
         System.out.print( name );
         System.out.print(",");
      }
   }
}
demo.foobar3()
```

    10,20,30,40,50,
    James,Larry,Tom,Lacy,

## Java switch语句
`switch`语句判断<b>一个变量与一系列值中某个值是否相等</b>，每个值称为一个分支。<br>
`switch`语句语法格式如下:<br>
```Java
switch(expression){
    case value :
       //语句
       break; //可选
    case value :
       //语句
       break; //可选
    //你可以有任意数量的case语句
    default : //可选
       //语句
}
```
`switch` 语句有如下规则:
- `switch` 语句中的变量类型可以是: `byte`、`short`、`int` 或者 `char`。从 Java SE 7 开始, `switch` 支持字符串 `String` 类型了, 同时 ase标签必须为字符串常量或字面量。
- `switch` 语句可以拥有多个 case 语句。每个 case 后面跟一个要比较的值和冒号。
- case 语句中的值的数据类型必须与变量的数据类型相同, 而且只能是常量或者字面常量。
- 当变量的值与 case 语句的值相等时, 那么 case 语句之后的语句开始执行, 直到 `break` 语句出现才会跳出 `switch` 语句
- 当遇到 `break` 语句时, `switch` 语句终止。程序跳转到 `switch` 语句后面的语句执行。case 语句不必须要包含 `break` 语句。如果没有 `break` 语句出现, 程序会继续执行下一条 case 语句, 直到出现 `break` 语句。
- `switch` 语句可以包含一个默认分支, 该分支一般是 `switch` 语句的最后一个分支 (可以在任何位置，但建议在最后一个)。默认语句在没有 case 语句的值和变量值相等的时候执行。default 分支不需要 `break` 语句。

<b>`switch`语句执行时, 一定会先进行匹配, 匹配成功返回当前 case 的值，再根据是否有 `break`, 判断是否继续输出, 或是跳出判断。</b><br>
`switch`语句demo1:


```Java
public class demo {
   public static void foobar4(){
      //char grade = args[0].charAt(0);
      char grade = 'C';
 
      switch(grade)
      {
         case 'A' :
            System.out.println("优秀"); 
            break;
         case 'B' :
         case 'C' :
            System.out.println("良好");
            break;
         case 'D' :
            System.out.println("及格");
            break;
         case 'F' :
            System.out.println("你需要再努力努力");
            break;
         default :
            System.out.println("未知等级");
      }
      System.out.println("你的等级是 " + grade);
   }
}
demo.foobar4();
```

    良好
    你的等级是 C
    

如果 case 语句块中没有 `break` 语句时, JVM 并<b>不会顺序输出每一个 case 对应的返回值, 而是继续匹配, 匹配不成功则返回默认 case。</b><br>
`switch`语句demo2:


```Java
public class demo {
   public static void foobar5(){
      int i = 5;
      switch(i){
         case 0:
            System.out.println("0");
         case 1:
            System.out.println("1");
         case 2:
            System.out.println("2");
         default:
            System.out.println("default");
      }
   }
}
demo.foobar5();
```

    default
    

如果 case 语句块中没有 `break` 语句时, <b>匹配成功后, 从当前 case 开始, 后续所有 case 的值都会输出。</b><br>
`switch`语句demo3:


```Java
public class demo {
   public static void foobar6(){
      int i = 1;
      switch(i){
         case 0:
            System.out.println("0");
         case 1:
            System.out.println("1");
         case 2:
            System.out.println("2");
         default:
            System.out.println("default");
      }
   }
}
demo.foobar6();
```

    1
    2
    default
    

如果当前匹配成功的 case 语句块没有 `break` 语句, <b>则从当前 case 开始, 后续所有 case 的值都会输出, 如果后续的 case 语句块有 `break` 语句则会跳出判断。</b><br>
`switch`语句demo4:


```Java
public class demo {
   public static void foobar7(){
      int i = 1;
      switch(i){
         case 0:
            System.out.println("0");
         case 1:
            System.out.println("1");
         case 2:
            System.out.println("2");
         case 3:
            System.out.println("3"); break;
         default:
            System.out.println("default");
      }
   }
}
demo.foobar7();
```

    1
    2
    3
    

## break 关键字
`break` 主要用在循环语句或者 `switch` 语句中, 用来跳出整个循环语句块。<br>
`break` 跳出最里层的循环, 并且继续执行该循环下面的语句。<br>
`break` 的用法很简单, 就是循环结构中的一条语句:
```Java
break;
```

以下的demo展示了一个简单的`break`用法:


```Java
public class demo {
   public static void foobar8() {
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ) {
         // x 等于 30 时跳出循环
         if( x == 30 ) {
            break;
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}
demo.foobar8();
```

    10
    20
    

## continue 关键字
`continue` 适用于任何循环控制结构中。作用是让程序立刻跳转本次循环。
在 `for` 循环中, `continue` 语句使程序立即跳转到更新语句。
在 `while` 或者 `do…while` 循环中, 程序立即跳转回布尔表达式的判断语句。
`break` 的用法也很简单, 就是循环结构中的一条语句:
```Java
continue;
```


```Java
public class demo {
   public static void foobar9() {
      int [] numbers = {10, 20, 30, 40, 50};
      for(int x : numbers ) {
         if( x == 30 ) {
        continue;
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}
demo.foobar9();
```

    10
    20
    40
    50
    
