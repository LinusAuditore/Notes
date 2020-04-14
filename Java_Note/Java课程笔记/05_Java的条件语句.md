
# Java的条件语句(Conditionals)

## 本章我们会涉及：
- <b>Java的循环结构</b>
    - `while` 和 `do while`
    - `for`
    - `switch`
    
## Java的条件语句(Conditionals) - if...else
### if语句
一个 `if` 语句包含<b>一个布尔表达式</b>和<b>一条或多条语句</b>。
#### 语法
`if`语句的基本语法如下:<br>
```Java
if(<booleanStatement>){
    // 如果判断为true会执行的语句
}
```
如果布尔表达式的值为 `true`，则执行 `if` 语句中的代码块，否则执行 `if` 语句块后面的代码。<br>
下面展示了一个简单的`if`语句的demo:


```Java
public void foobar0(){
    int x = 10;
 
    if( x < 20 ){
        System.out.print("this is a if statement");
    }
}
foobar0();
```

    this is a if statement

### if...else语句
`if` 语句后面可以跟 `else` 语句，当 `if` 语句的布尔表达式值为 `false` 时，`else` 语句会被执行
#### 语法
if...else的基本用法如下：<br>
```Java
if(<booleanStatement>){
   // <booleanStatement>的值为true
}else{
   // <booleanStatement>为false
}
```

下面是一个简单的`if ... else`语句的demo:


```Java
public void foobar1(){
    int x = 30;
 
    if( x < 20 ){
        System.out.print("this is a if statement");
    }else{
        System.out.print("this is an else statement");
    }
}
foobar1()
```

    this is an else statement

如果你闲着无聊, 你也可以把一个一般的`if`语句改成`if ... else`语句:<br>
```Java
if(<booleanStatement>){
   // 如果布尔表达式的值为true
}else{
   assert true; // 并没有什么卵用的断言语句
}
```

上述`else`语句中的`assert true;`在这里仅仅是占一个位置，并没有什么用, 它起的作用就和Python里的`pass`效果一样

### if ... else if... else...语句
`if` 语句后面可以跟 `else if…else` 语句，这种语句可以检测到多种可能的情况。<br>
使用 `if`，`else if`，`else` 语句的时候，需要注意下面几点：
- `if` 语句最多有 1 个 `else` 语句，`else` 语句在所有的 `else if` 语句之后。
- `if` 语句可以有若干个 `else if` 语句, 它们必须在 `else` 语句之前。
- 一旦其中一个 `else if` 语句检测为 `true`, 其他的 `else if` 以及 `else` 语句都将跳过执行。

#### 语法
`if...else` 的一般语法格式如下:<br>
```Java
if(<booleanStatement0>){
   // 如果<booleanStatement0>的值为true执行的代码
}else if(<booleanStatement1>){
   // 如果<booleanStatement1>的值为true执行的代码
}else if(<booleanStatement2>){
   // 如果<booleanStatement2>的值为true执行的代码
}else {
   // 如果以上<booleanStatement>都不为true执行的代码
}
```

以下这个demo展示了一个简单的`if... else if... else`语句:


```Java
public void foobar2(){
    int x = 30;
 
    if( x == 10 ){
        System.out.print("Value of X is 10");
    }else if( x == 20 ){
        System.out.print("Value of X is 20");
    }else if( x == 30 ){
        System.out.print("Value of X is 30");
    }else{
        System.out.print("this is an else statement");
    }
}
foobar2();
```

    Value of X is 30

### 嵌套的 if…else 语句(不禁止套娃)
使用嵌套的 `if…else` 语句是合法的(不禁止套娃)。也就是说你可以在另一个 `if` 或者 `else if` 语句中使用 `if` 或者 `else if` 语句
#### 语法
一个`if`的套娃格式如下(`if...else`语句的套娃和其方法一致): 
```Java
if(<booleanStatement0>){
   // 如果<booleanStatement0>的值为true执行的代码
   if(<booleanStatement1>){
      // 如果<booleanStatement1>的值为true执行的代码
   }
}
```

以下这个demo展示了一个简单的`if`套娃:


```Java
public void foobar3(){
    int x = 30;
    int y = 10;
 
    if( x == 30 ){
        if( y == 10 ){
            System.out.print("X = 30 and Y = 10");
        }
    }
}
foobar3();
```

    X = 30 and Y = 10
