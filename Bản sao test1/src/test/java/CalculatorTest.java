import com.example.test1.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    //tao doi tuong
    Calculator calc = new Calculator();
    @Test
    public void testAdd(){
        //ket qua mong muon
        int exp = 7;
        //ket qua thuc te
        int act = calc.add(4, 3);
        //so sanh ket qua mong muon co tra trung khop voi ket qua thuc te hay khong
        Assertions.assertEquals(exp, act);
    }
    @Test
    //chia a= 3, b = 2
    public void testDivide(){
        double exp = 1.5;
        double act = calc.divide(3, 2);
        Assertions.assertEquals(exp, act);
    }
    @Test
    //chia a  = 3, b = 0 co ngoai le
    public void testDivideByZero(){
        Assertions.assertThrows(ArithmeticException.class, ()->calc.divide(3,0));
    }

}
