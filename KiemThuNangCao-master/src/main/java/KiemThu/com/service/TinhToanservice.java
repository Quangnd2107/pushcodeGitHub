package KiemThu.com.service;

import java.util.List;
import java.util.NoSuchElementException;

public class TinhToanservice {
    public static int Tich2so(Integer a, Integer b) {
        return a * b;
    }

    public static boolean Songuyen(Object obj) {
        return obj instanceof Integer;
    }

    public static int tinhThuong(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Không chia đuược cho 0");
        }
        return  a / b;
    }
        public double tinhTrungBinh(List<Integer> so) {
            if (so == null || so.isEmpty()) {
                throw new ArithmeticException("Danh sách rỗng, không thể tính trung bình!");
            }
            int tong = 0;
            for (int num : so) {
                tong += num;
            }
            return  tong / so.size();
        }
        public int TimViTri(List<Integer> list, int index) {
            if (list == null || index < 0 || index >= list.size()) {
                throw new IndexOutOfBoundsException("Chỉ mục ngoài phạm vi mảng!");
            }
            return list.get(index);
        }
    public static class HoSo {
        private String name;

        public HoSo(String name) {
            this.name = name;
        }

        public String getName() {
            if (name == null) {
                throw new NullPointerException("Tên không được để trống!");
            }
            return name;
        }
    }
    public static int timPhanMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new NoSuchElementException("Mảng rỗng, không có phần tử nhỏ nhất!");
        }
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
