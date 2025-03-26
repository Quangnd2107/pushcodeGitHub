/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.DBConnect;
import java.util.ArrayList;
import java.util.Date;
import response.PhieuGiamGiaResponse;
/**
 *
 * @author nguyenquang2107
 */
public class PhieuGiamGiaRepository {
     public ArrayList<PhieuGiamGiaResponse> getAll(){
         ArrayList<PhieuGiamGiaResponse> lists = new ArrayList<>();
         String sql = """
SELECT ID, MaGG, TenGG, NgayBD, NgayKT, GiamToiDa, HoaDonToiThieu, SoLuong, TrangThai,TinhTrang from Giam_Gia
WHERE TrangThai = 1""";
         
         try(Connection con  = DBConnect.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
             ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                PhieuGiamGiaResponse response = PhieuGiamGiaResponse.builder()
                       .id_GG(rs.getInt(1))
                        .maGG(rs.getString(2))
                        .tenGG(rs.getString(3))
                        .ngayBatDau(rs.getDate(4))
                        .ngayKetThuc(rs.getDate(5))
                        .giamToiDa(rs.getString(6))
                        .giaTriToiThieu(rs.getString(7))
                        .soLuong(rs.getString(8))
                        .trangThai(rs.getInt(9))
                        .tinhTrang(rs.getString(10))
                        .build();
                lists.add(response);
            }
             
         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
         return lists;
     }  
     public boolean delete(Integer id){
        
        String sql = """
                      UPDATE Giam_Gia
                      set TrangThai = 0
                      where ID = ?
                      """;
        int check = 0;
         try (Connection con  = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
             ps.setObject(1, id);
             check = ps.executeUpdate();
             
         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
         return check > 0;
     }
     public boolean add(PhieuGiamGiaResponse pgg){
         String sql = """
                   INSERT into Giam_Gia(MaGG, TenGG,NgayBD, NgayKT, GiamToiDa, HoaDonToiThieu, SoLuong, TrangThai, TinhTrang)
                     VALUES(?,?,?,?,?,?,?,1,?)
                      
                      """;
         int check = 0;
         try (Connection con  = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
             ps.setObject(1, pgg.getMaGG());
             ps.setObject(2, pgg.getTenGG());
             ps.setObject(3, pgg.getNgayBatDau());
             ps.setObject(4, pgg.getNgayKetThuc());
             ps.setObject(5, pgg.getGiamToiDa());
             ps.setObject(6, pgg.getGiaTriToiThieu());
             ps.setObject(7, pgg.getSoLuong());
             ps.setObject(8, pgg.getTinhTrang());
             
             check = ps.executeUpdate();
             
         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
         return check > 0;
     }
     public boolean update(PhieuGiamGiaResponse pgg,Integer id){
         String sql = """
                     UPDATE Giam_Gia
                      set MaGG = ?,
                      TenGG = ?,
                      NgayBD = ?,
                      NgayKT = ?,
                      GiamToiDa = ?,
                      HoaDonToiThieu = ?,
                      SoLuong = ?,
                      TinhTrang = ?
                      WHERE ID = ?
                      
                      
                      """;
         int check = 0;
         try (Connection con  = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
             ps.setObject(1, pgg.getMaGG());
             ps.setObject(2, pgg.getTenGG());
             ps.setObject(3, pgg.getNgayBatDau());
             ps.setObject(4, pgg.getNgayKetThuc());
             ps.setObject(5, pgg.getGiamToiDa());
             ps.setObject(6, pgg.getGiaTriToiThieu());
             ps.setObject(7, pgg.getSoLuong());
             ps.setObject(8, pgg.getTinhTrang());
             ps.setObject(9, id);
             
             
             check = ps.executeUpdate();
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return check > 0;
     }
     public ArrayList<PhieuGiamGiaResponse> search(String keyword, Integer trangThai) {
    ArrayList<PhieuGiamGiaResponse> lists = new ArrayList<>();
    String sql = """
                 SELECT ID, MaGG, TenGG, NgayBD, NgayKT, GiamToiDa, HoaDonToiThieu,SoLuong, TrangThai, TinhTrang 
                 FROM Giam_Gia
                 WHERE TrangThai = 1
                 """;
    if (keyword.length() > 0) {
        sql += """
               AND 
               (MaGG LIKE ?
               OR TenGG LIKE ?
               OR NgayBD LIKE ?
               OR NgayKT LIKE ?
               OR GiamToiDa LIKE ?
               OR HoaDonToiThieu LIKE ?
               OR SoLuong LIKE ?
               OR TinhTrang LIKE ?)
               """;
    }
   
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        int index = 1;
//        ps.setObject(index++, trangThai);
        if (keyword.length() > 0) {
            String value = "%" + keyword + "%";
            ps.setObject(index++, value);
            ps.setObject(index++, value);
            ps.setObject(index++, value);
            ps.setObject(index++, value);
            ps.setObject(index++, value);
            ps.setObject(index++, value);
            ps.setObject(index++, value);
            ps.setObject(index++, value);
//            ps.setObject(index++, value);
            
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PhieuGiamGiaResponse response = PhieuGiamGiaResponse.builder()
                    .id_GG(rs.getInt(1))
                    .maGG(rs.getString(2))
                    .tenGG(rs.getString(3))
                    .ngayBatDau(rs.getDate(4))
                    .ngayKetThuc(rs.getDate(5))
                    .giamToiDa(rs.getString(6))
                    .giaTriToiThieu(rs.getString(7))
                        .soLuong(rs.getString(8))
                    .trangThai(rs.getInt(9))
                    .tinhTrang(rs.getString(10))
                    .build();
                lists.add(response);
            }
        }
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    return lists;
}
   public void  updateNgayHetHan(int ID){
       String sql = """
                    UPDATE Giam_Gia
                    set TinhTrang = N'Đã kết thúc'
                    WHERE ID  = ? or SoLuong = 0
                """;
       try(Connection con = DBConnect.getConnection();
               PreparedStatement ps  = con.prepareStatement(sql)) {
           ps.setObject(1, ID);
           ps.executeUpdate();
           
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
   }
   
   
   
     }
