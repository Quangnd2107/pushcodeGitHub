package com.example.test1;

public class XepLoaiHocLuc {
    public String xepLoaiHocLuc(double diemTB){
        if (diemTB < 0 || diemTB > 10){
            throw new IllegalArgumentException("diem trung binh chi trong khoang tu 0-10");
        }
        if(diemTB >= 9.0){
            return "Xuất sắc";

        }else if (diemTB >= 8){
            return "Gioi";

        }else if (diemTB >= 7){
            return "Kha";

        }else if (diemTB >= 5){
            return "Trung binh";
        }else
            return "Yeu";
    }
}
