
# Java的内置数据类型、字符串、数组
## 今天我们会涉及:
- Java的内置数据类型(Primitive Type)
- 字符串(String)
- 数组(Array)

## 简介:
变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。<br>
内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据<br>
因此，通过定义不同类型的变量，可以在内存中储存整数、小数或者字符。<br><br/>

## Java的内置数据类型(Primitive Types)

- Java定义了八种基本类型的数据：`byte`，`short`，`int`，`long`，`char`，`float`，`double`和`boolean`。这些类型可以分为以下四类:
    - <b>整数</b> - 包括：`byte`，`short`，`int`和`long`，用于整数有符号数字。
    - <b>浮点数</b> - 包括`float`和`double`，表示具有分数精度的数字。
    - <b>字符</b> - 包括`char`，表示字符集中的符号，如字母和数字。
    - <b>布尔(Boolean)</b> - 包括`boolean`，它是表示 `true`/`false` 值的特殊类型。
- `String`<b>不是原始数据类型!!!</b><br><br/>

- `byte`:
    - `byte` 数据类型是8位、有符号的，以二进制补码表示的整数；
    - 最小值是 `-128(-2^7)`;
    - 最大值是 `127(2^7-1)`;
    - 默认值是 `0`;
    - `byte` 类型用在大型数组中节约空间，主要代替整数，因为 `byte` 变量占用的空间只有 `int` 类型的<b>四分之一</b>；<br><br/>
- `short`:
    - short 数据类型是 16 位、有符号的以二进制补码表示的整数;
    - 最小值是 `-32768(2^15)`;
    - 最大值是 `32767(2^15-1)`;
    - 默认值是 `0`;<br><br/>
- `int`:
    - `int` 数据类型是32位、有符号的以二进制补码表示的整数;
    - 最小值是 `-2,147,483,648(2^31)`;
    - 最大值是 `2,147,483,647(2^31-1)`;
    - 默认值是 `0`;
    - 一般地整型变量默认为 `int` 类型; <br><br/>
- `long`::
    - `long` 数据类型是 64 位、有符号的以二进制补码表示的整数;
    - 最小值是 `-9,223,372,036,854,775,808(2^63)`;
    - 最大值是 `9,223,372,036,854,775,807(2^63 -1)`;
    - 这种类型主要使用在需要比较大整数的系统上;
    - 默认值是 `0L`;
    - "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写;<br><br/>
- `float`:
    - `float` 数据类型是单精度、32位、符合IEEE 754标准的浮点数;
    - `float` 在储存大型浮点数组的时候可节省内存空间;
    - 默认值是 `0.0f`;
    - `float`<b>不能用来表示需要高度精确的值</b>;<br><br/>
- `double`:
    - `double` 数据类型是双精度、64 位、符合IEEE 754标准的浮点数;
    - 一般来说浮点数的默认类型为`double`类型;
    - `double`<b>同样不能表示精确的值</b>;
    - 默认值是 `0.0d`;<br><br/>
- `boolean`:
    - `boolean`数据类型表示一位的信息;
    - 只有两个取值：`true` 和 `false`;
    - 这种类型只作为一种标志来记录 `true/false` 情况;
    - 默认值是 `false`;
- `char`：
    - `char`类型表示一个单一的 16 位 Unicode 字符;
    - 最小值是 `\u0000`（即为0）;
    - 最大值是 `\uffff`（即为65,535）;
    - `char` 数据类型可以储存任何字符;<br><br/>
    
除此之外，Java还给出了一个基本类型`void`, 其被封装在`java.lang.Void`, 但我们无法直接对它们进行操作。<br>
上述数据的最大和最小值时无需强制记忆的，它们都以常量的形式被定义在对应的包和类中了,请看以下这个demo(转载自菜鸟教程):


```Java
public class PrimitiveTypeTest {  
    public static void main() {  
        // byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();  
  
        // short  
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);  
        System.out.println("包装类：java.lang.Short");  
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);  
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);  
        System.out.println();  
  
        // int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");  
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  
        System.out.println();  
  
        // long  
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  
        System.out.println("包装类：java.lang.Long");  
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        // float  
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  
        System.out.println("包装类：java.lang.Float");  
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        // double  
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  
        System.out.println("包装类：java.lang.Double");  
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        // char  
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  
        System.out.println("包装类：java.lang.Character");  
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("最小值：Character.MIN_VALUE="  
                + (int) Character.MIN_VALUE);  
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("最大值：Character.MAX_VALUE="  
                + (int) Character.MAX_VALUE);  
    }  
}

PrimitiveTypeTest.main()
```

    基本类型：byte 二进制位数：8
    包装类：java.lang.Byte
    最小值：Byte.MIN_VALUE=-128
    最大值：Byte.MAX_VALUE=127
    
    基本类型：short 二进制位数：16
    包装类：java.lang.Short
    最小值：Short.MIN_VALUE=-32768
    最大值：Short.MAX_VALUE=32767
    
    基本类型：int 二进制位数：32
    包装类：java.lang.Integer
    最小值：Integer.MIN_VALUE=-2147483648
    最大值：Integer.MAX_VALUE=2147483647
    
    基本类型：long 二进制位数：64
    包装类：java.lang.Long
    最小值：Long.MIN_VALUE=-9223372036854775808
    最大值：Long.MAX_VALUE=9223372036854775807
    
    基本类型：float 二进制位数：32
    包装类：java.lang.Float
    最小值：Float.MIN_VALUE=1.4E-45
    最大值：Float.MAX_VALUE=3.4028235E38
    
    基本类型：double 二进制位数：64
    包装类：java.lang.Double
    最小值：Double.MIN_VALUE=4.9E-324
    最大值：Double.MAX_VALUE=1.7976931348623157E308
    
    基本类型：char 二进制位数：16
    包装类：java.lang.Character
    最小值：Character.MIN_VALUE=0
    最大值：Character.MAX_VALUE=65535
    

## Java String 类
字符串广泛应用在 Java 编程中，在 Java 中字符串属于<b>对象(Object)</b>，Java 提供了`String`类来创建和操作字符串。`String`<b>不是原始数据类型!!!</b><br>
### 创建字符串
创建字符串最简单的方法是:<br>`String greeting = "hello, world";`<br>
在代码中遇到字符串常量时(这里是"hello, world"), 编译器会使用该值创建一个 String 对象。<br>
和其它对象一样，可以使用关键字和构造方法来创建 `String` 对象<br>
注意, 一但`String`对象被创建并被赋值, 则<b>其值将无法发生改变, 只能改变其引用对象</b>。请看以下demo:


```Java
public void foobar0(){
    String str = "hello, "; 
    str.concat("world"); // .concat()用于连接字符串
    System.out.println(str);
    str = str.concat("world"); // 链接字符串，并将其重新赋值给str作为其引用对象
    System.out.println(str);
}
foobar()
```

    hello, 
    hello, world
    

`String` 类有 11 种构造方法，这些方法提供不同的参数来初始化字符串，比如提供一个`char`数组参数(我们一会讲数组):


```Java
public static void buildStr(){
    char[] helloArray = { 'B', 'o', 'n', 'j', 'o', 'u', 'r'};
    String helloString = new String(helloArray);  
    System.out.println( helloString );
}
buildStr()
```

    Bonjour
    

### 获取字符串长度
用于获取有关对象的有关信息的方法称为<b>访问器方法</b>
`String` 类的一个访问器方法是 `.length()` 方法，它返回字符串对象包含的字符数。
下面的代码执行后，`len` 变量等于 8:


```Java
public class StringLen {
    public static void main() {
        String name = "𒀭𒄑𒂆𒈦"; // 一个楔形文字字符长度为2,其余字符皆为为1
        int len = name.length();
        System.out.println( "该字符串全长: " + len );
   }
}
StringLen.main();
```

    该字符串全长: 8
    

### 链接字符串
除了在上面提到的`.concat()`可以连接字符串以外，更常用的方法通过`+`来对字符串进行连接操作:<br> `"hello, " + "world"`。在使用`+`进行操作时，可以转换为`String`的数据类型会自动完成转换，请看以下demo:


```Java
public void foobar1(){
    String str1 = "hello, ";
    System.out.println(str1 + "world");
    System.out.println("my number is " + 1);
}
foobar1();
```

    hello, world
    my number is 1
    

### 创建格式化字符串
我们可以通过`printf()`和`format()`来输出格式化的数字。<br>
`format()`会返回一个`String`对象而不是`PrintStream`对象以用于重复使用<br>
而`printf()`只能完成一次打印输出。<br>
使用方法如下:


```Java
// 打印格式化字符串
System.out.printf("浮点型变量的值为 " +
                  "%f, 整型变量的值为 " +
                  " %d, 字符串变量的值为 " +
                  " %s", floatVar, intVar, stringVar);
```


```Java
// 创建格式化字符串
String fs;
fs = String.format("浮点型变量的值为 " +
                   "%f, 整型变量的值为 " +
                   " %d, 字符串变量的值为 " +
                   " %s", floatVar, intVar, stringVar);
```

关于`%f`, `%d`, `%s`如何使用可以看这里:[Python中%s、%d、%f意义及用法详解](https://blog.csdn.net/weixin_43620235/article/details/90693182) (这里虽然是python中的用法，但是Java中用法和其相同)<br>
关于String类的更多方法, 请参阅[Java String API 文档](https://www.runoob.com/manual/jdk1.6/java/lang/String.html)<br><br/>
## 数组(Array)
Java 语言中提供的数组是用来存储固定大小的同类型元素。<br>
你可以声明一个数组变量，如 `numbers[100]` 来代替直接声明 100 个独立变量 `number[0]`，`number[0]`，....，`number[99]`。<br>
### 声明数组变量
必须<b>先声明数组变量</b>，才能在程序中使用数组。下面是声明数组变量的语法：


```Java
dataType[] arrayRefVar;   // 常用的方法

dataType arrayRefVar[];  // 效果相同，但不常用
```

注意: 建议使用 `dataType[] arrayRefVar` 的声明风格声明数组变量。 `dataType arrayRefVar[]` 风格是来自 C/C++ 语言 ，在Java中采用是为了让 C/C++ 程序员能够快速理解java语言

### 创建数组
Java语言使用new操作符来创建数组，语法如下: <br>
`arrayRefVar = new dataType[arraySize];`<br>
上面的这个字段做了两件事：
- 使用 dataType[arraySize] 创建了一个数组。
- 把新创建的数组的引用赋值给变量 arrayRefVar。
数组的声明和创建可以在一步之内完成, 具体操作方法是:<br>
`dataType[] arrayRefVar = new dataType[arraySize];`
当然也可以直接通过向数组里添加值来完成创建:<br>
`dataType[] arrayRefVar = {value0, value1, ..., valuen};`<br>
以下demo先声明了一个数组变量`myList`, 然后创建了一个包含 10 个 `double` 类型元素的数组, 并且把它的引用赋值给 myList 变量: 


```Java
public void foobar_ArrayList() {
    // 数组大小
    int size = 10;
    // 定义数组
    double[] myList = new double[size];
    myList[0] = 5.6;
    myList[1] = 4.5;
    myList[2] = 3.3;
    myList[3] = 13.2;
    myList[4] = 4.0;
    myList[5] = 34.33;
    myList[6] = 34.0;
    myList[7] = 45.45;
    myList[8] = 99.993;
    myList[9] = 11123;
    // 计算所有元素的总和
    double total = 0;
    for (int i = 0; i < size; i++) {
        total += myList[i];
    }
    System.out.println("总和为： " + total);
}
foobar_ArrayList();
```

    总和为： 11367.373
    

下面的图片描绘了数组 myList。这里 myList 数组里有 10 个 double 元素，它的下标从 0 到 9
![avartar](https://www.runoob.com/wp-content/uploads/2013/12/12-130Q0221Q5602.jpg) <br>(引用自菜鸟教程)
### 处理数组
数组的元素类型和数组的大小都是确定的，所以当处理数组元素时候，我们通常使用<b>基本循环</b>或者<b> For-Each 循环</b>。
请看以下demo(转载自菜鸟教程):


```Java
public class TestArray {
   public static void main() {
      double[] myList = {1.9, 2.9, 3.4, 3.5};
      // 打印所有数组元素
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      // 计算所有元素的总和
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Total is " + total);
      // 查找最大元素
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) max = myList[i];
      }
      System.out.println("Max is " + max);
   }
}
TestArray.main()
```

    1.9 
    2.9 
    3.4 
    3.5 
    Total is 11.7
    Max is 3.5
    

#### For-Each循环
在JDK 1.5和以后的版本中，引入了一种新的循环类型: For-Each循环, 他能在不适用下标的情况下遍历数组。
语法格式为:


```Java
for(type element: array)
{
    System.out.println(element);
}
```

以下demo展示了如何通过For-Each循环来实现显示数组`ArrayList`中的所有元素:


```Java
public void for_each_foobar(){
    int[] ArrayList = {1, 2, 3, 4};
    
    for (int element: ArrayList){
        System.out.println(element);
    }
}
for_each_foobar();
```

    1
    2
    3
    4
    

### 数组作为函数的参数
数组可以作为参数传递给方法<br>
例如，下面的例子就是一个打印 int 数组中元素的方法:


```Java
public static void printArray(int[] array) {
  for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
  }
}
printArray(new int[]{1, 2, 3, 4, 5, 6});
```

    1 2 3 4 5 6 

### 数组作为函数的返回值

以下demo中 `resultList` 数组作为方法的返回值:


```Java
public static int[] reverse(int[] list) {
  int[] result = new int[list.length];
 
  for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
    resultList[j] = list[i];
  }
  return resultList;
}
```

### 多维数组
多维数组可以看成是数组的数组, 比如二维数组就是一个特殊的一维数组, 其每一个元素都是一个一维数组, 例如:
`String str[][] = new String[3][4];`
#### 多维数组的动态初始化 (以二维数组为例):
- 直接为每一维分配空间，格式如下：<br>
`type[][] typeName = new type[typeLength1][typeLength2];`<br>
type 可以为基本数据类型和复合数据类型, arraylength1 和 arraylength2 必须为正整数, arraylength1 为行数, arraylength2 为列数。<br>
例如：<br>
`int a[][] = new int[2][3];`<br>
解析:<br>
二维数组 `a` 可以看成一个两行三列的数组。
- 从最高维开始，分别为每一维分配空间，例如：


```Java
String s[][] = new String[2][];
s[0] = new String[2];
s[1] = new String[3];
s[0][0] = new String("Good");
s[0][1] = new String("Luck");
s[1][0] = new String("to");
s[1][1] = new String("you");
s[1][2] = new String("!");
```

解析：<br>
`s[0]=new String[2]` 和 `s[1]=new String[3]` 是为最高维分配引用空间，也就是为最高维限制其能保存数据的最长的长度，然后再为其每个数组元素单独分配空间 `s0=new String("Good")` 等操作。
#### 多维数组的引用 (以二维数组为例):
对二维数组中的每个元素，引用方式为 `arrayName[index1][index2]`，例如:<br>
`num[1][0];`

### Arrays 类
`java.util.Arrays` 类能方便地操作数组，它提供的所有方法都是静态的。<br>
其具有以下功能：
- 给数组赋值：通过 fill 方法。
- 对数组排序：通过 sort 方法,按升序
- 比较数组：通过 equals 方法比较数组中元素值是否相等
- 查找数组元素：通过 binarySearch 方法能对排序好的数组进行二分查找法操作。
更详细内容请参阅 [java.util.Arrays API 文档](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)
