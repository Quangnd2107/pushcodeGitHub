/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nguyenquang2107
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PhieuGiamGia {
    private Integer id_GG;
    
    private String maGG;
    
    private String tenGG;
    
    private String giamToiDa;
    
    private String giaTriToiThieu;
    
    private String ngayBatDau;
    
    private String ngayKetThuc;
    
    private Integer trangThai;
    
    private String tinhTrang;
    
    
}
