/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.DBConnect;
import entity.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author nguyenquang2107
 */
public class HoaDonRepository {
    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = """
                     SELECT ID_GG, MaHD, NgayTao, TongTien FROM Hoa_Don
                     """;

        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = HoaDon.builder()
                        .id_HD(rs.getInt(1))
                        .maHD(rs.getString(2))
                        .ngayTao(rs.getDate(3))
                        .thanhTien(rs.getFloat(4))
                        .build();
                list.add(hoaDon);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
       
   return list;
}
    public ArrayList<HoaDon> findDate(String Date){
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = """
                     SELECT ID_GG, MaHD, NgayTao,TongTien from Hoa_Don
                     where NgaySua like ?
                     """;
        try(Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setString(1, "%"+ Date+"%");
             ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = HoaDon.builder()
                        .id_HD(rs.getInt(1))
                        .maHD(rs.getString(2))
                        .ngayTao(rs.getDate(3))
                        .thanhTien(rs.getFloat(4))
                        .build();
                list.add(hoaDon);
                
            }
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
        return list;
    }
}
