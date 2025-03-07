import com.example.test1.XepLoaiHocLuc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XepLoaiHocLucTest {
   XepLoaiHocLuc hocLuc = new XepLoaiHocLuc();
   @Test
    public void testHLPhanVung1_95(){
       String exp  = "Xuất sắc";
       String act = hocLuc.xepLoaiHocLuc(9.5);
       Assertions.assertEquals(exp, act);
   }


    @Test
    public void testHLPhanVung1_85(){
        String exp  = "Gioi";
        String act = hocLuc.xepLoaiHocLuc(8.5);
        Assertions.assertEquals(exp, act);
    }
    @Test
    public void testHLPhanVung1_75(){
        String exp  = "Kha";
        String act = hocLuc.xepLoaiHocLuc(7.5);
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void testHLPhanVung1_5(){
        String exp  = "Trung binh";
        String act = hocLuc.xepLoaiHocLuc(5);
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void testHLPhanVung1_3(){
        String exp  = "Yeu";
        String act = hocLuc.xepLoaiHocLuc(3);
        Assertions.assertEquals(exp, act);
    }
   //diem tb = 15
    @Test
    public void testHLEx_max(){
       Assertions.assertThrows(IllegalArgumentException.class, ()-> hocLuc.xepLoaiHocLuc(15));

    }
    @Test
    public void testHLEx_min(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> hocLuc.xepLoaiHocLuc(-5));

    }
    @Test
    public void testHL_TaiBien_9(){
       String exp = "Xuất sắc";
       String act = hocLuc.xepLoaiHocLuc(9);
       Assertions.assertEquals(exp, act);
    }
    @Test
    public void testHL_TaiBien_8(){
       String exp = "Gioi";
       String act = hocLuc.xepLoaiHocLuc(8);
       Assertions.assertEquals(exp, act);
    }
    @Test
    public void testHL_TaiBien_7(){
        String exp = "Kha";
        String act = hocLuc.xepLoaiHocLuc(7);
        Assertions.assertEquals(exp, act);
    }
    @Test
    public void testHL_TaiBien_6(){
        String exp = "Trung binh";
        String act = hocLuc.xepLoaiHocLuc(6);
        Assertions.assertEquals(exp, act);
    }
    @Test
    public void testHL_TaiBien_3(){
        String exp = "Yeu";
        String act = hocLuc.xepLoaiHocLuc(3);
        Assertions.assertEquals(exp, act);
    }

}
