
# 类(class)、方法(method)和字段(Attribute)
## 本章我们会涉及:
- Java类(Class)
- Java包(Package)
- 方法(Method)
- 字段(Attribute)
- 访问修饰符(Access modifier)
- 关键字 `static`(静态)
- Java的原始数据类型(Primitive Type)

### Java的类(Class)以及面向对象编程(OOP)
- 在Java中一个<b>类(class)</b>或<b>对象定义(object definition)</b>或<b>对象(object)</b>是由<b>实例变量(instance variables)</b>和/或<b>方法(methods)</b>组成的。
- 按照惯例，实例变量都在<b>方法之前声明</b>：


```Java
public class ShowStructure{
    // 声明实例变量 or 属性(attributes)
    // 定义方法
}   // 结束类 ShowStructure
```

- 在Java当中, 一个<b>类(class)</b>就是一个<b>对象(object)</b>, 反之亦然
- <b>类的实例(an instance of a class)</b>也是对象
- 任何的代码都<b>不能</b>在类外定义
- 方法外部可以存在的唯一代码是属性声明或其他("内部"或"嵌套")类定义
- 请注意:
    - 静态类(static class)的成员变量可以直接使用，而无需创建类的实例。
    - 否则必须对类进行实例化
    - 类的作用类似于"蓝图"，而关键字`new`则用于创建该蓝图的实例。
    - 构造函数(Constructor)可用于在实例化时初始化属性

### Java的包(package)
- 包(package)是项目文件中src文件夹下的子文件夹
- 使用多个包将会帮助在大项目中保证代码有条不紊
- 如果要进行`import`, 则包名应该在最前，即:<br>
`import <package_name>.<class_name>.<attribute_or_method_name>;`

### 方法(Method)

- <b>如何定义一个方法</b>
    - `[private|public] [static] [final] returnType methodName([parameterList]) {…}`
    - 如果main调用方法或使用与自身相同的类中的字段，则这些字段和方法也<b>必须声明为静态</b>
    - 声明一个方法时也需要声明该方法返回值的类型(`returnType`)
    - 返回值可以是一个对象或者任何Java原始数据类型(primitive type): 如 int, double, String, 或者一个array。
    - 如果这个方法不返回任何值，则我们将返回类型定义为void
    - main方法不反回任何值
    - `parameterList`一项用于向方法传递参数，两个以上参数用逗号隔开，格式是:<br>`type variableName, type variableName, …`，这一项可以为空
    - 与Python和C++不同的是，Java<b>不能定义参数的默认值</b>

- <b>关于可变参数: </b>
    - 如果在参数类型和参数名之间加入`...`就可以令其和不确定个数个参数匹配，如：


```Java
public class Main {
    static int  sumvarargs(int... intArrays){
        int sum, i;
        sum=0;
        for(i=0; i< intArrays.length; i++) {
            sum += intArrays[i];
        }
        return(sum);
    }
    public static void main(String args[]){
        int sum=0;
        sum = sumvarargs(new int[]{10,12,33});
        System.out.println("数字相加之和为: " + sum);
    }
}
```

以上代码运行结果为: <br>`数字相加之和为: 55`

- <b>关于`main`方法</b>
    - `public static void main (String[] args) {…}`
    - 为了使JVM运行应用程序，它必须知道程序要从哪里开始
    - 通过设计，起点始终是`main`方法的执行
    - JVM希望main方法的声明时唯一可以更改的是String数组的名称，在上面称为args。

- <b>关于返回值: </b>
    - 除非返回类型为`void`否则一个方法必须要有一个返回结果。返回类型为`void`的方法则可以使用`return;`(即`return none;`)来中止方法
    - 当运行到`return`语句时，方法会终止
    - 定义返回结果:<br>`return [literal|expression];`
    - 返回的`literal|expression`必须和最开始定义的类型相匹配

### 字段(Attributes)
- attribute也称为"类变量"或"实例变量"或"字段(feild)"
- 在class中和方法在同一层级被定义
- 这些变量对于类(其"作用域(scope)")中的所有方法都是已知的。
- 以下这个demo展示了什么是attributes


```Java
public class Demo {
    private int Id;//成员变量(字段)、实例变量(表示该Id变量既属于成员变量又属于实例变量)
    private String name;//成员变量(字段)、实例变量
    public int age;//成员变量(字段)、实例变量(这里用来举例子,在实际中一般都会设置为private)
    public static final String mood = "happy";//成员变量(公共字段)、常量
    private static String height = "all high";//成员变量(字段)、类变量(静态变量)
    public void study() {//普通方法
        String study = "learning";//局部变量
    }
    public int getId() {//id的可读属性
        return Id;
    }
    public void setId(int id) {//id的可写属性
        Id = id;
    }
    public String getName() {//name的可读属性
        return name;
    }
    public void setName(String name) {//name的可写属性
        this.name = name;
    }
    public int getAge() {//age的可读属性
        return age;
    }
    public void setAge(int age) {//age的可写属性
        this.age = age;
    }
}
```

PS: 在这里给大家解释一下，为什么我称attribute为字段:<br>
首先attributes在英语中有两个定义: <br>
- 定义1: "A quality or feature regarded as a characteristic or inherent part of someone or something."这个定义中，attribute更倾向于是某一样物品或人的特性(characteristic)这个意向, 因而也更倾向于将attribute翻译为中文中的"属性"一词
- 定义2: "A piece of information that determines the properties of a field or tag in a database or a string of characters in a display."在这个定义中，attribute更倾向于是一段信息(a piece of information)，因而也更倾向于将这个词翻译为中文中的"字段"一词

在教授的讲义中attribute包含了class variables(类变量)、"instance variables"(实例变量)以及 “fields”(字段)。中文中"字段"可以表示"成员变量"和"实例变量", 且"属性"一词在计算机科学的语境下却对应了英文中的"property"(指得往往是一个类下面的一些特殊方法例如:.getString()代表了某一变量的<b>可读属性</b>)。因而，这里attribute代表了第二个定义，所以翻译为"字段"更为贴切<br>
如果有更好的翻译也欢迎来联系我

- <b>如何声明一个字段</b>:
    - 如果要在类外定义一个字段:<br> `[private|public] [static] [final] type attributeName [= literal];`
    - 请注意type和attributeName是<b>不可以省略的!</b>
    - 任何变量、字段、属性都<b>需要先定义才能使用!</b>
    - 如果将一个变量在class的作用域内进行声明，则该变量只能作用于该类内
    - 如果要在类内定义一个变量:<br> `type attributeName [= literal];`
    - 在java 10和更新版本中, 一个变量可以通过关键字`var`来定义，程序会在运行时判断其变量类型


```Java
public static String greeting_en = "hello"; // 在类外声明一个字段并初始化
public static String greeting_zh; // 在类外声明一个字段但不初始化
public static void demo(){
    greeting_zh = "你好"; // 初始化已经声明的字段
    String greeting_fr = "bonjour"; // 在类内声明一个变量
    var greeting_de = "hallo"; // 在类内声明一个变量
    System.out.println(greeting_en);
    System.out.println(greeting_fr);
    System.out.println(greeting_de);
    System.out.println(greeting_zh);
}
demo()
```

    hello
    bonjour
    hallo
    你好
    

### 访问修饰符(Access modifier)
- `public`表示了这个类中的属性和方法<b>可以被任何外部类使用</b>
- `private`表示了这个类中的属性、方法或者任何成员变量都<b>只能在类的内部使用</b>
- `protected`表示了这个类中的性、方法或者任何成员变量<b>只能在同一包下的类中使用</b>
- 作为成员的所有者，仍必须通过<b>该类或该类的实例</b>对`public`或`protected`的成员进行访问
- 在类内部，访问修饰符没有任何作用。
- 某个类的所有成员均可供<b>该类中的所有其他成员</b>使用和访问，而不管访问修饰符如何。

### 关键词`static`
- `static`往往有着不同的含义，具体取决于使用它的地方
- `public static`(静态公有类)的成员可以在类外直接使用而不需要对该类进行实例化
- 任何静态成员或静态变量将会常驻内存，直到程序退出
- 由于main方法是静态的, 它只能在其他静态方法位于同一类中时调用它们
- 如果一个静态方法想要调用同一类下的其他任何字段，则必须要保证它们都是静态的(IDE通常会帮助我们完成这个部分)
- `main`方法可以直接在调用同一类下的静态方法而无需使用`ClassName.MethodName()`

### Java的原始数据类型(Primitive Types)

- Java定义了八种基本类型的数据：`byte`，`short`，`int`，`long`，`char`，`float`，`double`和`boolean`。这些类型可以分为以下四类:
    - <b>整数</b> - 包括：`byte`(-128~127)，`short`(-32768~32767)，`int`(-2147483648~2147483647)和`long`(-9223372036854775808~9223372036854775807)，用于整数有符号数字。
    - <b>浮点数</b> - 包括`float`(单精度)和`double`(双精度)，表示具有分数精度的数字。
    - <b>字符</b> - 包括`char`(\u0000 ~ \uffff)，表示字符集中的符号，如字母和数字。
    - <b>布尔(Boolean)</b> - 包括`boolean`，它是表示 `true`/`false` 值的特殊类型。
- `String`<b>不是原始数据类型!!!</b>
