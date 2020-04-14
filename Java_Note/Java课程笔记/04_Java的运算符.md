
# Java的运算符
## 今天我们会涉及到：
- <b>Java的预算符</b>
   - Java运算符的几大类型
   - Java运算符的优先级
 
## Java运算符
计算机的最基本用途之一就是执行数学运算，作为一门计算机语言，Java也提供了一套丰富的运算符来操纵变量。根据功能，我们可以把运算符分成以下几组：
- 算术运算符
- 关系运算符
- 位运算符 (CISC124未涉及)
- 逻辑运算符
- 赋值运算符 (该部分有关位运算符的赋值运算符在CISC124中没有涉及)
- 其他运算符 

### 算术运算符
算术运算符用在数学表达式中, 它们的作用和在数学中的作用一样。以下列出了所有算术运算符。
- `+` 加法，相加运算符两侧的值
- `-` 减法，左操作数减去右操作数
- `*` 乘法，相乘操作符两侧的值
- `/` 除法，左操作数除以右操作数
- `%` 取余除法，左操作数除以右操作数的余数
- `++` 操作数的值+1
- `--` 操作数的值-1
下面这个demo为大家展示了上述操作符:


```Java
public void foobar0() {
    int a = 10;
    int b = 20;
    int c = 25;
    int d = 25;
    System.out.println("a + b = " + (a + b) );
    System.out.println("a - b = " + (a - b) );
    System.out.println("a * b = " + (a * b) );
    System.out.println("b / a = " + (b / a) );
    System.out.println("b % a = " + (b % a) );
    System.out.println("c % a = " + (c % a) );
    System.out.println("a++   = " +  (a++) );
    System.out.println("a--   = " +  (a--) );
    // 查看  d++ 与 ++d 的不同
    System.out.println("d++   = " +  (d++) );
    System.out.println("++d   = " +  (++d) );
}
foobar()
```

    a + b = 30
    a - b = -10
    a * b = 200
    b / a = 2
    b % a = 0
    c % a = 5
    a++   = 10
    a--   = 11
    d++   = 25
    ++d   = 27
    

#### 自增自减运算符
1. <b>自增（++）自减（--）运算符</b>是一种特殊的算术运算符，在算术运算符中需要两个操作数来进行运算，而自增自减运算符是一个操作数。以下这个demo为大家展示了自增运算符:


```Java
public void foobar1(){
    int a = 3;//定义一个变量；
    int b = ++a;//自增运算
    int c = 3;
    int d = --c;//自减运算
    System.out.println("进行自增运算后的值等于"+b);
    System.out.println("进行自减运算后的值等于"+d);
}
foobar1();
```

    进行自增运算后的值等于4
    进行自减运算后的值等于2
    

解析: 
int b = ++a; 拆分运算过程为: a=a+1=4; b=a=4, 最后结果为b=4,a=4;
int d = --c; 拆分运算过程为: c=c-1=2; d=c=2, 最后结果为d=2,c=2;

2. <b>前缀自增自减法(++a,--a)</b>: 先进行自增或者自减运算，再进行表达式运算。
3. <b>后缀自增自减法(a++,a--)</b>: 先进行表达式运算，再进行自增或者自减运算。以下这个demo展示了前缀和后缀自增自减法:


```Java
public void foobar2(){
    int a = 5;//定义一个变量；
    int b = 5;
    int x = 2*++a;
    int y = 2*b++;
    System.out.println("自增运算符前缀运算后a="+a+",x="+x); // 先算a+=1, 然后a*2
    System.out.println("自增运算符后缀运算后b="+b+",y="+y); // 先算b*2, 然后b+=1
,}
foobar2();
```

    自增运算符前缀运算后a=6,x=12
    自增运算符后缀运算后b=6,y=10
    

### 关系运算符
以下为Java所支持的关系运算符:
- `==`, 检查如果两个操作数的值是否相等，如果相等则条件为真。
- `!=`, 检查如果两个操作数的值是否相等，如果值不相等则条件为真。
- `>`, 	检查左操作数的值是否大于右操作数的值，如果是那么条件为真。
- `<`, 检查左操作数的值是否小于右操作数的值，如果是那么条件为真。
- `>=`, 检查左操作数的值是否大于或等于右操作数的值，如果是那么条件为真。
- `<=`, 检查左操作数的值是否小于或等于右操作数的值，如果是那么条件为真。<br>

下面的demo为大家演示了关系运算符:


```Java
public void foobar3() {
    int a = 10;
    int b = 20;
    System.out.println("a = 10, b=20\n------------------");
    System.out.println("a == b = " + (a == b) );
    System.out.println("a != b = " + (a != b) );
    System.out.println("a > b = " + (a > b) );
    System.out.println("a < b = " + (a < b) );
    System.out.println("b >= a = " + (b >= a) );
    System.out.println("b <= a = " + (b <= a) );
}
foobar3();
```

    a = 10, b=20
    ------------------
    a == b = false
    a != b = true
    a > b = false
    a < b = true
    b >= a = true
    b <= a = false
    

### 位运算符(这一部分中的运算符在CISC124课程中并没有涉及)
Java定义了位运算符，应用于整数类型(int)，长整型(long)，短整型(short)，字符型(char)，和字节型(byte)等类型。<br>
位运算符作用在所有的位上，并且按位运算。设a = 60，b = 13;它们的二进制格式表示将如下：<br>
A = 0011 1100<br>
B = 0000 1101<br>
A & B = 0000 1100<br>
A | B = 0011 1101<br>
A ^ B = 0011 0001<br>
~A= 1100 0011<br>
以下是所有位运算符:
- `&`, 如果相对应位都是1，则结果为1，否则为0
- `|`, 如果相对应位都是 0，则结果为 0，否则为1
- `^`, 如果相对应位值相同，则结果为0，否则为1
- `~`, 按位取反运算符翻转操作数的每一位，即0变成1，1变成0。
- `<<`, 按位左移运算符。左操作数按位左移右操作数指定的位数。
- `>>`, 按位右移运算符。左操作数按位右移右操作数指定的位数。
- `>>>`, 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。

PS: 由于课程没有涉及这部分的内容, 就只做简介不展示demo

### 逻辑运算符
下面列出了基本的逻辑运算符:
- `&&`, 称为逻辑与<b>'和'</b>运算符。当且仅当两个操作数都为真，条件才为真。
- `||`, 称为逻辑<b>'或'</b>操作符。如果任何两个操作数任何一个为真，条件为真。
- `!`, 称为逻辑<b>'非'</b>运算符。用来反转操作数的逻辑状态。如果条件为true，则逻辑非运算符将得到false
以下这个demo为大家展示了逻辑运算符:


```Java
public void foobar4() {
    boolean t = true;
    boolean f = false;
    System.out.println("t && f = " + (t&&f));
    System.out.println("t || f = " + (t||f) );
    System.out.println("!(t && f) = " + !(t && f));
}
foobar4();
```

    t && f = false
    t || f = true
    !(t && f) = true
    

### 赋值运算符(该部分有关位运算符的赋值运算符在CISC124中没有涉及)
- `=`, 简单的赋值运算符，将右操作数的值赋给左侧操作数
- `+=`, 加和赋值操作符，它把左操作数和右操作数相加赋值给左操作数
- `-=`, 减和赋值操作符，它把左操作数和右操作数相减赋值给左操作数
- `*=`, 乘和赋值操作符，它把左操作数和右操作数相乘赋值给左操作数
- `/=`, 除和赋值操作符，它把左操作数和右操作数相除赋值给左操作数
- `%=`, 取模和赋值操作符，它把左操作数和右操作数取模后赋值给左操作数
- `<<=`, `>>=`, `&=`, `^=`, `|=`未涉及, 暂时不做介绍

以下demo展示了赋值运算符:


```Java
public static void foobar5() {
    int a = 10;
    int b = 20;
    int c = 0;
    c = a + b;
    System.out.println("c = a + b = " + c );
    c += a ;
    System.out.println("c += a  = " + c );
    c -= a ;
    System.out.println("c -= a = " + c );
    c *= a ;
    System.out.println("c *= a = " + c );
    a = 10;
    c = 15;
    c /= a ;
    System.out.println("c /= a = " + c );
    a = 10;
    c = 15;
    c %= a ;
    System.out.println("c %= a  = " + c );
}
foobar5();
```

    c = a + b = 30
    c += a  = 40
    c -= a = 30
    c *= a = 300
    c /= a = 1
    c %= a  = 5
    

### 其他的运算符
除了上述几类以外, 还有一些运算符, 如条件运算符`?:`和`instanceof`运算符, 我在本课程的代码实践中，只遇到过`instanceof`运算符，这里来对其进行讲解<br>
`instanceof`运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。其使用格式如下: <br>
`(Object reference variable) instanceof (class/interface type)`<br>
例如：<br>
`boolean result = "Linus" instanceof String`<br>
在上面这个例子里, `"Linus"`属于`String`类所以结果`result`为真<br>
如果被比较的对象兼容于比较对象, 则结果也为真, 请看以下demo:


```Java
class Dog {}
public class Animal extends Dog {
   public static void main(){
      Dog a = new Animal();
      boolean result =  a instanceof Animal;
      System.out.println( result);
   }
}
Animal.main();
```

    true
    

### Java运算符的优先级
在多个运算符同时出现时, Java会遵循运算符完成运算, 其顺序为(优先级从上到下):<br>
![image.png](https://i.loli.net/2020/04/14/Bp862fNkdxOA91V.png)<br>(图片来自[菜鸟教程](https://www.runoob.com/java/java-operators.html))
