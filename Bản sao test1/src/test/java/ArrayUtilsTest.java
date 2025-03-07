import com.example.test1.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {
    ArrayUtils arrayUtils = new ArrayUtils();
    @Test
    public void testFindMax(){
        //arr = 2,4,6,8,9,-8,1
        int exp = 9;
        int act = arrayUtils.findMax(new int[]{2,4,6,1,9,-8,1});
        Assertions.assertEquals(exp, act);
    }
    @Test
    public void testFindMaxEx(){
         Assertions.assertThrows(IllegalArgumentException.class, ()->arrayUtils.findMax(new int[]{}));
    }
    @Test
    public void testFindMaxEx2(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->arrayUtils.findMax(null));
    }
}
