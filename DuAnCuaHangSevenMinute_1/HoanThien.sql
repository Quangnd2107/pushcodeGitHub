USE [DA4]
GO
/****** Object:  Table [dbo].[Chat_Lieu]    Script Date: 8/14/2024 9:10:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chat_Lieu](
	[ID_ChatLieu] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nvarchar](50) NOT NULL,
	[ChatLieu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Chat_Lieu] PRIMARY KEY CLUSTERED 
(
	[ID_ChatLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Chi_Tiet_San_Pham]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chi_Tiet_San_Pham](
	[ID_CTSP] [int] IDENTITY(1,1) NOT NULL,
	[maSPCT] [nchar](10) NOT NULL,
	[ID_SP] [int] NOT NULL,
	[ID_CoAo] [int] NULL,
	[ID_KhuyAo] [int] NULL,
	[ID_DuongMay] [int] NULL,
	[ID_KieuDang] [int] NULL,
	[ID_HoaTiet] [int] NULL,
	[ID_PhongCach] [int] NULL,
	[ID_ChatLieu] [int] NULL,
	[ID_MauSac] [int] NULL,
	[ID_TayAo] [int] NULL,
	[ID_KichThuoc] [int] NULL,
	[SoLuong] [int] NULL,
	[Gia] [float] NULL,
 CONSTRAINT [PK_Chi_Tiet_San_Pham] PRIMARY KEY CLUSTERED 
(
	[ID_CTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CoAo]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CoAo](
	[ID_CoAo] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[CoAo] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_CoAo] PRIMARY KEY CLUSTERED 
(
	[ID_CoAo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Duong_May]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Duong_May](
	[ID_DuongMay] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[DuongMay] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Duong_May] PRIMARY KEY CLUSTERED 
(
	[ID_DuongMay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Giam_Gia]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Giam_Gia](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaGG] [nchar](10) NOT NULL,
	[TenGG] [nvarchar](50) NOT NULL,
	[NgayBD] [date] NOT NULL,
	[NgayKT] [date] NOT NULL,
	[GiamToiDa] [int] NOT NULL,
	[HoaDonToiThieu] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TrangThai] [int] NOT NULL,
	[TinhTrang] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Giam_Gia_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hinh_Thuc_Thanh_Toan]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hinh_Thuc_Thanh_Toan](
	[ID_HinhThuc] [int] IDENTITY(1,1) NOT NULL,
	[HinhThuc] [bit] NOT NULL,
 CONSTRAINT [PK_Hinh_Thuc_Thanh_Toan_1] PRIMARY KEY CLUSTERED 
(
	[ID_HinhThuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hoa_Don]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hoa_Don](
	[ID_HD] [int] IDENTITY(1,1) NOT NULL,
	[ID_NV] [int] NULL,
	[ID_KH] [int] NULL,
	[ID_GG] [int] NULL,
	[ID_HinhThuc] [int] NULL,
	[MaHD] [nvarchar](20) NULL,
	[TongTien] [float] NULL,
	[TenKhachHang] [nvarchar](20) NULL,
	[NgaySua] [date] NULL,
	[SDT_KH] [nchar](12) NULL,
	[HinhThucThanhToan] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
	[NgayTao] [date] NULL,
 CONSTRAINT [PK_Hoa_Don] PRIMARY KEY CLUSTERED 
(
	[ID_HD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hoa_Don_Chi_Tiet]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hoa_Don_Chi_Tiet](
	[ID_HDCT] [int] IDENTITY(1,1) NOT NULL,
	[ID_HD] [int] NULL,
	[ID_NV] [int] NULL,
	[ID_CTSP] [int] NULL,
	[ID_KH] [int] NULL,
	[Ma] [nvarchar](20) NULL,
	[GiaTien] [money] NULL,
	[SoLuong] [int] NULL,
	[ThanhTien] [int] NULL,
	[TenSP] [nvarchar](20) NULL,
	[MauSP] [nvarchar](20) NULL,
	[LoaiCo] [nvarchar](20) NULL,
	[ChatLieu] [nvarchar](20) NULL,
	[TayAo] [nvarchar](20) NULL,
 CONSTRAINT [PK_Hoa_Don_Chi_Tiet_1] PRIMARY KEY CLUSTERED 
(
	[ID_HDCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hoa_Tiet]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hoa_Tiet](
	[ID_HoaTiet] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[HoaTiet] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Hoa_Tiet] PRIMARY KEY CLUSTERED 
(
	[ID_HoaTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khach_Hang]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khach_Hang](
	[ID_KH] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nvarchar](20) NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[Ho] [nvarchar](50) NULL,
	[Trangthai] [int] NOT NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SDT_KH] [nchar](12) NOT NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[QuocTich] [nchar](50) NULL,
	[Email] [nchar](100) NULL,
 CONSTRAINT [PK_Khach_Hang] PRIMARY KEY CLUSTERED 
(
	[ID_KH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khuy_Ao]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khuy_Ao](
	[ID_KhuyAo] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[KhuyAo] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Khuy_Ao] PRIMARY KEY CLUSTERED 
(
	[ID_KhuyAo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[ID_KichThuoc] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[KichThuoc] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_KichThuoc] PRIMARY KEY CLUSTERED 
(
	[ID_KichThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KieuDang]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KieuDang](
	[ID_KieuDang] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[KieuDang] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_KieuDang] PRIMARY KEY CLUSTERED 
(
	[ID_KieuDang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lich_Su_Hoa_Don]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lich_Su_Hoa_Don](
	[ID_LS_HD] [int] IDENTITY(1,1) NOT NULL,
	[ID_HD] [int] NOT NULL,
	[TenNV] [nvarchar](20) NULL,
	[Ngay] [date] NULL,
	[GhiChu] [nvarchar](50) NULL,
	[ThemSP] [nvarchar](20) NULL,
	[XoaSP] [nvarchar](10) NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_Lich_Su_Hoa_Don_1] PRIMARY KEY CLUSTERED 
(
	[ID_LS_HD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mau_Sac]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mau_Sac](
	[ID_MauSac] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[Mau] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Mau_Sac] PRIMARY KEY CLUSTERED 
(
	[ID_MauSac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nhan_Vien]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nhan_Vien](
	[ID_NV] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nvarchar](10) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](20) NOT NULL,
	[SDT] [nvarchar](12) NOT NULL,
	[CCCD] [nvarchar](20) NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](40) NOT NULL,
	[ChucVu] [bit] NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_Nhan_Vien] PRIMARY KEY CLUSTERED 
(
	[ID_NV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong_Cach]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong_Cach](
	[ID_PhongCach] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[PhongCach] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Phong_Cach] PRIMARY KEY CLUSTERED 
(
	[ID_PhongCach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[San_Pham]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[San_Pham](
	[ID_SP] [int] IDENTITY(1,1) NOT NULL,
	[MaSP] [nchar](10) NOT NULL,
	[TenSP] [nvarchar](100) NOT NULL,
	[MoTa] [nvarchar](500) NOT NULL,
	[TrangThai] [bit] NULL,
	[Ngay] [date] NULL,
 CONSTRAINT [PK_San_Pham_1] PRIMARY KEY CLUSTERED 
(
	[ID_SP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tay_Ao]    Script Date: 8/14/2024 9:10:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tay_Ao](
	[ID_TayAo] [int] IDENTITY(1,1) NOT NULL,
	[Ma] [nchar](10) NOT NULL,
	[TayAo] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Tay_Ao] PRIMARY KEY CLUSTERED 
(
	[ID_TayAo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Chat_Lieu] ON 

INSERT [dbo].[Chat_Lieu] ([ID_ChatLieu], [Ma], [ChatLieu]) VALUES (1, N'CL001', N'NyLon')
INSERT [dbo].[Chat_Lieu] ([ID_ChatLieu], [Ma], [ChatLieu]) VALUES (2, N'CL002', N'Cotton')
INSERT [dbo].[Chat_Lieu] ([ID_ChatLieu], [Ma], [ChatLieu]) VALUES (3, N'CL003', N'CaoSu')
SET IDENTITY_INSERT [dbo].[Chat_Lieu] OFF
GO
SET IDENTITY_INSERT [dbo].[Chi_Tiet_San_Pham] ON 

INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (1, N'SPCT001   ', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 85, 300000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (2, N'SPCT002   ', 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 294, 400000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (3, N'SPCT003   ', 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 200, 350000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (4, N'SPCT004   ', 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 200, 600000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (5, N'SPCT005   ', 5, 3, 1, 4, 1, 1, 1, 2, 3, 1, 3, 400, 900000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (6, N'SPCT006   ', 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 300, 320000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (7, N'SPCT007   ', 7, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 200, 200000)
INSERT [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP], [maSPCT], [ID_SP], [ID_CoAo], [ID_KhuyAo], [ID_DuongMay], [ID_KieuDang], [ID_HoaTiet], [ID_PhongCach], [ID_ChatLieu], [ID_MauSac], [ID_TayAo], [ID_KichThuoc], [SoLuong], [Gia]) VALUES (8, N'SPCT008   ', 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0)
SET IDENTITY_INSERT [dbo].[Chi_Tiet_San_Pham] OFF
GO
SET IDENTITY_INSERT [dbo].[CoAo] ON 

INSERT [dbo].[CoAo] ([ID_CoAo], [Ma], [CoAo]) VALUES (1, N'CA001     ', N'Tàu')
INSERT [dbo].[CoAo] ([ID_CoAo], [Ma], [CoAo]) VALUES (2, N'CA002     ', N'Vuông')
INSERT [dbo].[CoAo] ([ID_CoAo], [Ma], [CoAo]) VALUES (3, N'CA003     ', N'Vát')
SET IDENTITY_INSERT [dbo].[CoAo] OFF
GO
SET IDENTITY_INSERT [dbo].[Duong_May] ON 

INSERT [dbo].[Duong_May] ([ID_DuongMay], [Ma], [DuongMay]) VALUES (1, N'DM001     ', N'Móc xích 1 kim ')
INSERT [dbo].[Duong_May] ([ID_DuongMay], [Ma], [DuongMay]) VALUES (2, N'DM002     ', N'Ẩn 1 chỉ')
INSERT [dbo].[Duong_May] ([ID_DuongMay], [Ma], [DuongMay]) VALUES (3, N'DM003     ', N'1 kim thắt nút')
INSERT [dbo].[Duong_May] ([ID_DuongMay], [Ma], [DuongMay]) VALUES (4, N'DM004     ', N'may kiểu này')
SET IDENTITY_INSERT [dbo].[Duong_May] OFF
GO
SET IDENTITY_INSERT [dbo].[Giam_Gia] ON 

INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (1, N'GG006     ', N'Ưu đãi mùa hè', CAST(N'2024-08-05' AS Date), CAST(N'2024-08-15' AS Date), 700000, 3000000, 100, 1, N'Sắp diễn ra')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (2, N'GG007     ', N'Giảm giá đặc biệt', CAST(N'2024-07-18' AS Date), CAST(N'2024-07-28' AS Date), 200000, 500000, 50, 1, N'Đã kết thúc')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (3, N'GG008     ', N'Khuyến mãi cuối tuần', CAST(N'2024-07-05' AS Date), CAST(N'2024-07-15' AS Date), 250000, 800000, 200, 1, N'Đã kết thúc')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (4, N'GG009     ', N'Ưu đãi VIP', CAST(N'2024-09-10' AS Date), CAST(N'2024-09-20' AS Date), 800000, 4000000, 120, 1, N'Sắp diễn ra')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (5, N'GG010     ', N'Giảm giá mùa thu', CAST(N'2024-07-22' AS Date), CAST(N'2024-08-01' AS Date), 450000, 1800000, 80, 1, N'Đã kết thúc')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (6, N'GG012     ', N'1', CAST(N'2022-01-01' AS Date), CAST(N'2022-01-01' AS Date), 1, 1, 1, 0, N'Đã kết thúc')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (7, N'GG0011    ', N'Ưu đãi mùa hè', CAST(N'2024-08-05' AS Date), CAST(N'2024-08-15' AS Date), 700000, 3000000, 100, 1, N'Sắp diễn ra')
INSERT [dbo].[Giam_Gia] ([ID], [MaGG], [TenGG], [NgayBD], [NgayKT], [GiamToiDa], [HoaDonToiThieu], [SoLuong], [TrangThai], [TinhTrang]) VALUES (8, N'GG0012    ', N'Ưu đãi mùa đông', CAST(N'2024-08-05' AS Date), CAST(N'2024-08-15' AS Date), 700000, 300000, 100, 1, N'Sắp diễn ra')
SET IDENTITY_INSERT [dbo].[Giam_Gia] OFF
GO
SET IDENTITY_INSERT [dbo].[Hinh_Thuc_Thanh_Toan] ON 

INSERT [dbo].[Hinh_Thuc_Thanh_Toan] ([ID_HinhThuc], [HinhThuc]) VALUES (1, 1)
INSERT [dbo].[Hinh_Thuc_Thanh_Toan] ([ID_HinhThuc], [HinhThuc]) VALUES (2, 0)
SET IDENTITY_INSERT [dbo].[Hinh_Thuc_Thanh_Toan] OFF
GO
SET IDENTITY_INSERT [dbo].[Hoa_Don] ON 

INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (1, 1, 1, 1, 1, N'MA01', 250000, N'Lan', CAST(N'2010-03-02' AS Date), N'021382741   ', N'Tiền Mặt', 1, CAST(N'2010-03-01' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (2, 1, 1, 2, 2, N'MA02', 300000, N'Huyền', CAST(N'2011-03-02' AS Date), N'0214932432  ', N'Chuyển Khoản', 1, CAST(N'2011-03-01' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (3, 1, 1, 3, 3, N'MA03', 400000, N'Minh', CAST(N'2012-03-02' AS Date), N'0328483754  ', N'Tiền Mặt', 1, CAST(N'2012-03-01' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (7, 1, 1, 2, 7, N'MA07', 832476, N'Kim', CAST(N'2016-06-02' AS Date), N'0182348324  ', N'Chuyển Khoản', 1, CAST(N'2016-06-02' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (8, 1, 1, 3, 8, N'MA08', 400000, N'Huyền', CAST(N'2017-07-02' AS Date), N'0932487235  ', N'Chuyển Khoản', 1, CAST(N'2017-07-02' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (9, 1, 1, 4, 9, N'MA09', 300000, N'Bảo', CAST(N'2018-08-02' AS Date), N'0932173724  ', N'Tiền Mặt', 1, CAST(N'2017-08-02' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (10, 1, 1, NULL, NULL, N'HD33029', 300000, NULL, NULL, NULL, NULL, 1, CAST(N'2024-08-07' AS Date))
INSERT [dbo].[Hoa_Don] ([ID_HD], [ID_NV], [ID_KH], [ID_GG], [ID_HinhThuc], [MaHD], [TongTien], [TenKhachHang], [NgaySua], [SDT_KH], [HinhThucThanhToan], [TrangThai], [NgayTao]) VALUES (11, 1, 1, NULL, NULL, N'HD32853', 0, NULL, NULL, NULL, NULL, 0, CAST(N'2024-08-08' AS Date))
SET IDENTITY_INSERT [dbo].[Hoa_Don] OFF
GO
SET IDENTITY_INSERT [dbo].[Hoa_Don_Chi_Tiet] ON 

INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (1, 1, 1, 1, 1, N'NV01', 30.0000, 2, 300000, N'Áo sơ mi trắng', N'Trắng', N'Cổ Tròn', N'Vải', N'Tay Dài')
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (2, 2, 2, 2, 2, N'NV02', 30.0000, 1, 400000, N'Áo sơ mi đen', N'Đen', N'Cổ Vuông', N'Vải', N'Tay Ngắn')
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (3, 3, 3, 3, 3, N'NV03', 40.0000, 3, 400000, N'Áo sơ mi đỏ', N'Đỏ', N'Cổ Dẹp', N'Vải', N'Tay Ngắn')
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (5, 1, NULL, 4, NULL, NULL, 50.0000, 4, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (6, 11, NULL, 2, NULL, NULL, 400000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (7, 11, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (8, 11, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (9, 10, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (10, 10, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (11, 10, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (12, 10, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (13, 10, NULL, 1, NULL, NULL, 300000.0000, 2, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Hoa_Don_Chi_Tiet] ([ID_HDCT], [ID_HD], [ID_NV], [ID_CTSP], [ID_KH], [Ma], [GiaTien], [SoLuong], [ThanhTien], [TenSP], [MauSP], [LoaiCo], [ChatLieu], [TayAo]) VALUES (14, 10, NULL, 1, NULL, NULL, 300000.0000, 1, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Hoa_Don_Chi_Tiet] OFF
GO
SET IDENTITY_INSERT [dbo].[Hoa_Tiet] ON 

INSERT [dbo].[Hoa_Tiet] ([ID_HoaTiet], [Ma], [HoaTiet]) VALUES (1, N'HT001     ', N'Chấm bi')
INSERT [dbo].[Hoa_Tiet] ([ID_HoaTiet], [Ma], [HoaTiet]) VALUES (2, N'HT002     ', N'Kẻ sọc')
INSERT [dbo].[Hoa_Tiet] ([ID_HoaTiet], [Ma], [HoaTiet]) VALUES (3, N'HT003     ', N'Kẻ ngang')
INSERT [dbo].[Hoa_Tiet] ([ID_HoaTiet], [Ma], [HoaTiet]) VALUES (4, N'HT004     ', N'Chấm hỏi?')
SET IDENTITY_INSERT [dbo].[Hoa_Tiet] OFF
GO
SET IDENTITY_INSERT [dbo].[Khach_Hang] ON 

INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (1, N'KH001', N'Văn An', N'Nguyễn', 1, N'123 Đường An lão', N'0123456789  ', 1, CAST(N'1990-01-01' AS Date), N'Vietnam                                           ', N'Dung@gmail.com                                                                                      ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (2, N'KH002', N'Thị Bình', N'Lê', 1, N'456 Đường Bồ Đề', N'0987654321  ', 0, CAST(N'1992-02-02' AS Date), N'Vietnam                                           ', N'lethib@example.com                                                                                  ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (3, N'KH003', N'Minh Cao', N'Trần', 1, N'789 Đường Văn Cao', N'0321654987  ', 1, CAST(N'1988-03-03' AS Date), N'Vietnam                                           ', N'tranminhc@example.com                                                                               ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (4, N'KH004', N'Thị Dung', N'Phạm', 1, N'321 Đường Tố Hữu', N'0932486754  ', 0, CAST(N'1995-04-04' AS Date), N'Vietnam                                           ', N'phamthid@example.com                                                                                ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (5, N'KH005', N'Văn Thụ', N'Hoàng', 1, N'654 Đường Phú Diễn', N'0901234567  ', 1, CAST(N'1993-05-05' AS Date), N'Vietnam                                           ', N'hoangvane@example.com                                                                               ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (6, N'KH006', N'Anh Quân', N'Đinh', 1, N'952 Đường Láng', N'0909844567  ', 1, CAST(N'1991-05-23' AS Date), N'Vietnam                                           ', N'anhquan@example.com                                                                                 ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (7, N'KH007', N'Văn Tấn', N'Lê', 1, N'65 Đường Lâm', N'0901971567  ', 1, CAST(N'1997-06-25' AS Date), N'Vietnam                                           ', N'anhtan@example.com                                                                                  ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (8, N'KH008', N'Sỹ Lâm', N'Phùng', 1, N'654 Đường Xã Đàn', N'0904704567  ', 1, CAST(N'1996-09-02' AS Date), N'Vietnam                                           ', N'phunglame@example.com                                                                               ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (9, N'KH009', N'Đình Thắng', N'Lê', 1, N'654 Đường Hoàng Cầu', N'0905024567  ', 1, CAST(N'1993-11-20' AS Date), N'Vietnam                                           ', N'emthange@example.com                                                                                ')
INSERT [dbo].[Khach_Hang] ([ID_KH], [Ma], [Ten], [Ho], [Trangthai], [DiaChi], [SDT_KH], [GioiTinh], [NgaySinh], [QuocTich], [Email]) VALUES (10, N'KH0010', N'Thị Trang', N'Hoàng', 1, N'654 Đường Hoàng Công Chứ', N'0943034567  ', 0, CAST(N'1989-02-07' AS Date), N'Vietnam                                           ', N'thitrang9@example.com                                                                               ')
SET IDENTITY_INSERT [dbo].[Khach_Hang] OFF
GO
SET IDENTITY_INSERT [dbo].[Khuy_Ao] ON 

INSERT [dbo].[Khuy_Ao] ([ID_KhuyAo], [Ma], [KhuyAo]) VALUES (1, N'KA001     ', N'2 hàng nude')
INSERT [dbo].[Khuy_Ao] ([ID_KhuyAo], [Ma], [KhuyAo]) VALUES (2, N'KA002     ', N'6 khuy')
INSERT [dbo].[Khuy_Ao] ([ID_KhuyAo], [Ma], [KhuyAo]) VALUES (3, N'KA003     ', N'Sử dụng 1 khuy')
INSERT [dbo].[Khuy_Ao] ([ID_KhuyAo], [Ma], [KhuyAo]) VALUES (4, N'KA004     ', N'sử dụng 99 khuy')
SET IDENTITY_INSERT [dbo].[Khuy_Ao] OFF
GO
SET IDENTITY_INSERT [dbo].[KichThuoc] ON 

INSERT [dbo].[KichThuoc] ([ID_KichThuoc], [Ma], [KichThuoc]) VALUES (1, N'KT001     ', N'S')
INSERT [dbo].[KichThuoc] ([ID_KichThuoc], [Ma], [KichThuoc]) VALUES (2, N'KT002     ', N'M')
INSERT [dbo].[KichThuoc] ([ID_KichThuoc], [Ma], [KichThuoc]) VALUES (3, N'KT003     ', N'L')
SET IDENTITY_INSERT [dbo].[KichThuoc] OFF
GO
SET IDENTITY_INSERT [dbo].[KieuDang] ON 

INSERT [dbo].[KieuDang] ([ID_KieuDang], [Ma], [KieuDang]) VALUES (1, N'KD001     ', N'kiểu này')
INSERT [dbo].[KieuDang] ([ID_KieuDang], [Ma], [KieuDang]) VALUES (2, N'KD002     ', N'kiểu kia')
SET IDENTITY_INSERT [dbo].[KieuDang] OFF
GO
SET IDENTITY_INSERT [dbo].[Lich_Su_Hoa_Don] ON 

INSERT [dbo].[Lich_Su_Hoa_Don] ([ID_LS_HD], [ID_HD], [TenNV], [Ngay], [GhiChu], [ThemSP], [XoaSP], [TrangThai]) VALUES (1, 1, N'Bình', CAST(N'2012-02-01' AS Date), N'Hủy đơn Hàng', N'Áo sơ mi đỏ', N'  Áo sơ mi', 1)
INSERT [dbo].[Lich_Su_Hoa_Don] ([ID_LS_HD], [ID_HD], [TenNV], [Ngay], [GhiChu], [ThemSP], [XoaSP], [TrangThai]) VALUES (2, 2, N'Lương', CAST(N'2012-04-02' AS Date), N'Đổi sản phẩm', N'Áo sơ mi đen', N'Áo sơ mi', 0)
INSERT [dbo].[Lich_Su_Hoa_Don] ([ID_LS_HD], [ID_HD], [TenNV], [Ngay], [GhiChu], [ThemSP], [XoaSP], [TrangThai]) VALUES (3, 3, N'Ngân', CAST(N'2012-06-04' AS Date), N'Đổi sản phẩm', N'Áo cổ tròn', N'Áo sơ mi', 1)
SET IDENTITY_INSERT [dbo].[Lich_Su_Hoa_Don] OFF
GO
SET IDENTITY_INSERT [dbo].[Mau_Sac] ON 

INSERT [dbo].[Mau_Sac] ([ID_MauSac], [Ma], [Mau]) VALUES (1, N'MS001     ', N'Đen')
INSERT [dbo].[Mau_Sac] ([ID_MauSac], [Ma], [Mau]) VALUES (2, N'MS002     ', N'Be')
INSERT [dbo].[Mau_Sac] ([ID_MauSac], [Ma], [Mau]) VALUES (3, N'MS003     ', N'Trắng')
SET IDENTITY_INSERT [dbo].[Mau_Sac] OFF
GO
SET IDENTITY_INSERT [dbo].[Nhan_Vien] ON 

INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (1, N'A1', N'Nguyễn Ngọc Minhz', N'minh@4789', N'0456287985', N'096321478530', 0, CAST(N'2005-06-27' AS Date), N'Nghệ An', 1, 0, N'hihi')
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (2, N'A2', N'Đinh Anh Dũng', N'dung@142563', N'0124563789', N'', 1, CAST(N'2005-06-27' AS Date), N'Hà Nội', 1, 1, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (3, N'A3', N'Trần Quốc Bảo', N'bao@1452', N'0862044736', N'01235', 1, CAST(N'2005-06-27' AS Date), N'Quảng Nam', 1, 1, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (4, N'A4', N'Nguyễn ThanhTùng', N'tung@158963', N'0789456125', N'014785963201452', 1, CAST(N'2005-06-27' AS Date), N'Ninh Bình', 0, 1, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (5, N'A5', N'Nguyễn Thị Hà Lan', N'lan@290625', N'0869067747', N'012366547896385', 0, CAST(N'2005-06-27' AS Date), N'Hòa Bình', 1, 0, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (6, N'A6', N'Nguyễn Thị Hà Lan', N'lan@290625', N'0869067747', N'0147859632', 0, CAST(N'2005-06-27' AS Date), N'Hòa Bình', 1, 0, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (8, N'A8', N'Nguyễn ThanhTùng', N'tung@158963', N'0789456125', N'dcfgd', 1, CAST(N'2005-06-27' AS Date), N'Ninh Bình', 0, 0, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (9, N'A9', N'Nguyễn Thị Hà Lan', N'lan@290625', N'0869067747', N'748521369', 0, CAST(N'2005-06-27' AS Date), N'Hòa Bình', 1, 1, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (14, N'A10', N'dinh anh dung', N'bao123@gmail.com', N'0123456489', NULL, 1, CAST(N'2004-01-01' AS Date), N'ha noi', 0, 1, N'hihi')
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (17, N'A11', N'Nguyễn ThanhTùnz', N'tung@158963', N'0789456125', NULL, 1, CAST(N'2005-06-20' AS Date), N'Ninh Bình', 0, 0, NULL)
INSERT [dbo].[Nhan_Vien] ([ID_NV], [MaNV], [Ten], [Email], [SDT], [CCCD], [GioiTinh], [NgaySinh], [DiaChi], [ChucVu], [TrangThai], [MatKhau]) VALUES (21, N'A10', N'dinh anh dung', N'bao123@gmail.com', N'0123456489', NULL, 1, CAST(N'2004-01-01' AS Date), N'ha noi', 0, 1, NULL)
SET IDENTITY_INSERT [dbo].[Nhan_Vien] OFF
GO
SET IDENTITY_INSERT [dbo].[Phong_Cach] ON 

INSERT [dbo].[Phong_Cach] ([ID_PhongCach], [Ma], [PhongCach]) VALUES (1, N'PC001     ', N'Năng Động')
INSERT [dbo].[Phong_Cach] ([ID_PhongCach], [Ma], [PhongCach]) VALUES (2, N'PC002     ', N'Tăng Động')
INSERT [dbo].[Phong_Cach] ([ID_PhongCach], [Ma], [PhongCach]) VALUES (3, N'PC003     ', N'Thẳng Niêu')
INSERT [dbo].[Phong_Cach] ([ID_PhongCach], [Ma], [PhongCach]) VALUES (4, N'PC004     ', N'Tăng Giảm Chú Ý')
SET IDENTITY_INSERT [dbo].[Phong_Cach] OFF
GO
SET IDENTITY_INSERT [dbo].[San_Pham] ON 

INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (1, N'SP001     ', N'áo kia', N'Thoai Mái', 1, CAST(N'2024-07-27' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (2, N'SP002     ', N'áo này', N'Đẹp', 1, CAST(N'2024-07-27' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (3, N'SP003     ', N'áo nọ', N'Good', 1, CAST(N'2024-07-27' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (4, N'SP004     ', N'Áo hình con cho', N'đẹp
', 1, CAST(N'2024-07-27' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (5, N'SP005     ', N'Áo Gucci khói lửa rồng phượng bay múa lượn trên trời', N'CHẤT CHƠI NGƯỜI  DƠI', 1, CAST(N'2024-07-27' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (6, N'SP006     ', N'áo đẹp khỏi bàn', N'đẹp khỏi bàn', 0, CAST(N'2024-07-25' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (7, N'SP007     ', N'Áo như cái ghế', N'vì nó đẹp không phải bàn', 0, CAST(N'2024-08-10' AS Date))
INSERT [dbo].[San_Pham] ([ID_SP], [MaSP], [TenSP], [MoTa], [TrangThai], [Ngay]) VALUES (8, N'SP0010    ', N'ao sieu nhan do', N'Thoai Mái', 1, CAST(N'2024-08-14' AS Date))
SET IDENTITY_INSERT [dbo].[San_Pham] OFF
GO
SET IDENTITY_INSERT [dbo].[Tay_Ao] ON 

INSERT [dbo].[Tay_Ao] ([ID_TayAo], [Ma], [TayAo]) VALUES (1, N'TA001     ', N'Lửng')
INSERT [dbo].[Tay_Ao] ([ID_TayAo], [Ma], [TayAo]) VALUES (2, N'TA002     ', N'Dài')
INSERT [dbo].[Tay_Ao] ([ID_TayAo], [Ma], [TayAo]) VALUES (3, N'TA003     ', N'Cộc')
SET IDENTITY_INSERT [dbo].[Tay_Ao] OFF
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Chat_Lieu] FOREIGN KEY([ID_ChatLieu])
REFERENCES [dbo].[Chat_Lieu] ([ID_ChatLieu])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Chat_Lieu]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_CoAo] FOREIGN KEY([ID_KhuyAo])
REFERENCES [dbo].[CoAo] ([ID_CoAo])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_CoAo]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Duong_May] FOREIGN KEY([ID_DuongMay])
REFERENCES [dbo].[Duong_May] ([ID_DuongMay])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Duong_May]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Hoa_Tiet] FOREIGN KEY([ID_HoaTiet])
REFERENCES [dbo].[Hoa_Tiet] ([ID_HoaTiet])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Hoa_Tiet]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Khuy_Ao] FOREIGN KEY([ID_CoAo])
REFERENCES [dbo].[Khuy_Ao] ([ID_KhuyAo])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Khuy_Ao]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_KichThuoc] FOREIGN KEY([ID_KichThuoc])
REFERENCES [dbo].[KichThuoc] ([ID_KichThuoc])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_KichThuoc]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_KieuDang] FOREIGN KEY([ID_KieuDang])
REFERENCES [dbo].[KieuDang] ([ID_KieuDang])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_KieuDang]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Mau_Sac] FOREIGN KEY([ID_MauSac])
REFERENCES [dbo].[Mau_Sac] ([ID_MauSac])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Mau_Sac]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Phong_Cach] FOREIGN KEY([ID_PhongCach])
REFERENCES [dbo].[Phong_Cach] ([ID_PhongCach])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Phong_Cach]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_San_Pham] FOREIGN KEY([ID_SP])
REFERENCES [dbo].[San_Pham] ([ID_SP])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_San_Pham]
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham]  WITH CHECK ADD  CONSTRAINT [FK_Chi_Tiet_San_Pham_Tay_Ao] FOREIGN KEY([ID_TayAo])
REFERENCES [dbo].[Tay_Ao] ([ID_TayAo])
GO
ALTER TABLE [dbo].[Chi_Tiet_San_Pham] CHECK CONSTRAINT [FK_Chi_Tiet_San_Pham_Tay_Ao]
GO
ALTER TABLE [dbo].[Hoa_Don]  WITH CHECK ADD  CONSTRAINT [FK_Hoa_Don_Giam_Gia] FOREIGN KEY([ID_GG])
REFERENCES [dbo].[Giam_Gia] ([ID])
GO
ALTER TABLE [dbo].[Hoa_Don] CHECK CONSTRAINT [FK_Hoa_Don_Giam_Gia]
GO
ALTER TABLE [dbo].[Hoa_Don]  WITH CHECK ADD  CONSTRAINT [FK_Hoa_Don_Khach_Hang] FOREIGN KEY([ID_NV])
REFERENCES [dbo].[Khach_Hang] ([ID_KH])
GO
ALTER TABLE [dbo].[Hoa_Don] CHECK CONSTRAINT [FK_Hoa_Don_Khach_Hang]
GO
ALTER TABLE [dbo].[Hoa_Don]  WITH CHECK ADD  CONSTRAINT [FK_Hoa_Don_Nhan_Vien] FOREIGN KEY([ID_NV])
REFERENCES [dbo].[Nhan_Vien] ([ID_NV])
GO
ALTER TABLE [dbo].[Hoa_Don] CHECK CONSTRAINT [FK_Hoa_Don_Nhan_Vien]
GO
ALTER TABLE [dbo].[Hoa_Don_Chi_Tiet]  WITH CHECK ADD  CONSTRAINT [FK_Hoa_Don_Chi_Tiet_Chi_Tiet_San_Pham] FOREIGN KEY([ID_CTSP])
REFERENCES [dbo].[Chi_Tiet_San_Pham] ([ID_CTSP])
GO
ALTER TABLE [dbo].[Hoa_Don_Chi_Tiet] CHECK CONSTRAINT [FK_Hoa_Don_Chi_Tiet_Chi_Tiet_San_Pham]
GO
ALTER TABLE [dbo].[Hoa_Don_Chi_Tiet]  WITH CHECK ADD  CONSTRAINT [FK_Hoa_Don_Chi_Tiet_Hoa_Don] FOREIGN KEY([ID_HD])
REFERENCES [dbo].[Hoa_Don] ([ID_HD])
GO
ALTER TABLE [dbo].[Hoa_Don_Chi_Tiet] CHECK CONSTRAINT [FK_Hoa_Don_Chi_Tiet_Hoa_Don]
GO
ALTER TABLE [dbo].[Lich_Su_Hoa_Don]  WITH CHECK ADD  CONSTRAINT [FK_Lich_Su_Hoa_Don_Hoa_Don] FOREIGN KEY([ID_HD])
REFERENCES [dbo].[Hoa_Don] ([ID_HD])
GO
ALTER TABLE [dbo].[Lich_Su_Hoa_Don] CHECK CONSTRAINT [FK_Lich_Su_Hoa_Don_Hoa_Don]
GO
