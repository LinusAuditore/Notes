package sample;
/**
 * This class include a constructor of an Exception Object
 * <p>This class inherit the RuntimeException
 * <p>In most cases, you need to inherit Exception to create customized exceptions.
 * @author Xinghao Zuo
 *
 */
public class IllegalPizza extends RuntimeException{
    private String msg;


    /**
     * This constructor used to build Exception Object take a String message
     * @param msg the String message the Exception took.
     * @return None
     */
    public IllegalPizza(String msg){
        this.msg = msg;
    }
}
