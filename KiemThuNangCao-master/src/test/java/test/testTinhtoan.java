package test;

import KiemThu.com.service.TinhToanservice;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class testTinhtoan {
    TinhToanservice service = new TinhToanservice();
    @Test
    public void Testich2So() {
        assertEquals(6, service.Tich2so(2, 3));
        assertEquals(-15, service.Tich2so(-3, 5));
        assertEquals(0, service.Tich2so(0, 10));
        assertEquals(25, service.Tich2so(5, 5));
        assertEquals(-24, service.Tich2so(8, -3));
        assertEquals(1, service.Tich2so(1, 1));
        assertEquals(0, service.Tich2so(0, 0));
        assertEquals(-1, service.Tich2so(-1, 1));
        assertEquals(50, service.Tich2so(10, 5));
        assertEquals(100, service.Tich2so(10, 10));
    }
    @Test
    public void SoNguyen() {
        assertTrue(service.Songuyen(5));
        assertTrue(service.Songuyen(-10));
        assertTrue(service.Songuyen(0));
        assertFalse(service.Songuyen(5.5));
        assertFalse(service.Songuyen("10"));
        assertFalse(service.Songuyen(null));
        assertFalse(service.Songuyen(3.14));
    }
    @Test
    public void testTinhThuong() {

            assertEquals(2, service.tinhThuong(10, 5));
            assertEquals(-2, service.tinhThuong(10, -5));
            assertEquals(3, service.tinhThuong(-9, -3));
            assertEquals(0, service.tinhThuong(0, 5));
            assertEquals(7, service.tinhThuong(7, 1));
            assertEquals(1000, service.tinhThuong(1000000, 1000));
            assertEquals(-500, service.tinhThuong(-1000000, 2000));

             assertThrows(ArithmeticException.class, () -> service.tinhThuong(1, 0));
        }
    @Test
    public void testTinhTrungBinh() {
        assertEquals(5.0, service.tinhTrungBinh(Arrays.asList(2, 4, 6, 8)), 0.001);
        assertEquals(3.0, service.tinhTrungBinh(Arrays.asList(3, 4)), 0.001);
        assertEquals(-2.0, service.tinhTrungBinh(Arrays.asList(-2, -2, -2)), 0.001);
        assertEquals(0.0, service.tinhTrungBinh(Arrays.asList(0, 0, 0)), 0.001);


        assertEquals(7.0, service.tinhTrungBinh(Collections.singletonList(7)), 0.001);


        Exception e = assertThrows(ArithmeticException.class, () -> service.tinhTrungBinh(Collections.emptyList()));
        assertEquals("Danh sách rỗng, không thể tính trung bình!", e.getMessage());
    }

    @Test
    public void testGetElementAtIndex() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Kiểm tra truy xuất hợp lệ
        assertEquals(10, service.TimViTri(numbers, 0));
        assertEquals(30, service.TimViTri(numbers, 2));
        assertEquals(50, service.TimViTri(numbers, 4));

        // Kiểm tra chỉ mục ngoài phạm vi (ném ngoại lệ)
        assertThrows(IndexOutOfBoundsException.class, () -> service.TimViTri(numbers, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> service.TimViTri(numbers, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> service.TimViTri(Collections.emptyList(), 0));
    }
    @Test
    public void testGetName() {

        TinhToanservice.HoSo validProfile = new TinhToanservice.HoSo("Nguyen Van B");
        assertEquals("Nguyen Van B", validProfile.getName());


        TinhToanservice.HoSo nullNameProfile = new TinhToanservice.HoSo(null);
        assertThrows(NullPointerException.class, nullNameProfile::getName, "Tên không được để trống!");

        TinhToanservice.HoSo profile = null;
        assertThrows(NullPointerException.class, () -> {
            if (profile != null) {
                profile.getName();
            } else {
                throw new NullPointerException("Hồ sơ chưa được tạo!");
            }
        }, "Hồ sơ chưa được tạo!");
    }
    @Test
    public void testTimPhanTuMin() {
        // Trường hợp mảng hợp lệ
        int[] arr1 = {5, 3, 8, 1, 2};
        assertEquals(1, service.timPhanMin(arr1));

        // Trường hợp mảng chỉ có một phần tử
        int[] arr2 = {7};
        assertEquals(7, service.timPhanMin(arr2));

        // Trường hợp mảng rỗng
        int[] emptyArr = {};
        assertThrows(NoSuchElementException.class, () -> service.timPhanMin(emptyArr), "Mảng rỗng, không có phần tử nhỏ nhất!");
    }
}
