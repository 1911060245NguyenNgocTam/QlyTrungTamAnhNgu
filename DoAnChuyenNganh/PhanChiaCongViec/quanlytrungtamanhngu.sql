CREATE DATABASE quanlytrungtamanhngu

USE quanlytrungtamanhngu
GO 
---------------Bảng đăng nhập---------------1
Create table [DangNhap]
(
	[UserName] Varchar(10) NOT NULL,
	[PassWord] Varchar(10) NOT NULL,
Primary Key ([UserName])
)
go

---------------Bảng văn bằng---------------2
Create table [VanBang]
(
	[MaVanBang] Varchar(10) NOT NULL,
	[TenVanBang] Nvarchar(30) NOT NULL,
Primary Key ([MaVanBang])
) 
go

---------------Bảng trình độ---------------3
Create table [TrinhDo]
(
	[MaTrinhDo] Varchar(10) NOT NULL,
	[TrinhDo] Nvarchar(30) NOT NULL,
Primary Key ([MaTrinhDo])
) 
go
alter table [TrinhDo]
add
	Diem varchar (10) not null

---------------Bảng giảng viên---------------4
Create table [GiangVien]
(
	[MaGiangVien] Varchar(10) NOT NULL,
	[TenGiangVien] Nvarchar(30) NOT NULL,
	[DiaChi] Nvarchar(70) NOT NULL,
	[SDT] Varchar(11) NOT NULL,
Primary Key ([MaGiangVien])
) 
go

---------------Bảng khóa học---------------5
Create table [KhoaHoc]
(
	[MaKhoaHoc] Varchar(10) NOT NULL,
	[MaVanBang] Varchar(10) NOT NULL,
	[MaTrinhDo] Varchar(10) NOT NULL,
	[MaGiangVien] Varchar(10) NOT NULL,
	[TenKhoaHoc] Nvarchar(30) NOT NULL,
Primary Key ([MaKhoaHoc]),
foreign key (MaVanBang) references dbo.VanBang(MaVanBang),	
foreign key (MaTrinhDo) references dbo.TrinhDo(MaTrinhDo),	
foreign key (MaGiangVien) references dbo.GiangVien(MaGiangVien),	
) 
go

---------------Bảng lớp---------------6
Create table [Lop]
(
	[MaLop] Varchar(10) NOT NULL,
	[MaKhoaHoc] Varchar(10) NOT NULL,
	[TenLop] Nvarchar(30) NOT NULL,
	[NgayBatDau] Datetime NOT NULL,
	[NgayKetThuc] Datetime NOT NULL,
Primary Key ([MaLop]),
foreign key (MaKhoaHoc) references dbo.KhoaHoc(MaKhoaHoc),	
) 
go

---------------Bảng ngày học---------------7
Create table [NgayHoc]
(
	[MaNgayHoc] Varchar(10) NOT NULL,
	[Thu] Nvarchar(15) NOT NULL,
	[NgayHoc] Datetime NOT NULL,
	[GioBatDau] Datetime NOT NULL,
	[GioKetThuc] Datetime NOT NULL,
Primary Key ([MaNgayHoc])
) 
go


---------------Bảng học viên---------------8
Create table [HocVien]
(
	[MaHocVien] Varchar(10) NOT NULL,
	[TenHocVien] Nvarchar(30) NOT NULL,
	[NgaySinh] Datetime NOT NULL,
	[DiaChi] Nvarchar(70) NOT NULL,
	[SDT] Varchar(11) NOT NULL,
Primary Key ([MaHocVien])
) 
go


---------------Bảng điểm danh---------------9
Create table [DiemDanh]
(
	[MaLop] Varchar(10) NOT NULL,
	[MaHocVien] Varchar(10) NOT NULL,
	[MaNgayHoc] Varchar(10) NOT NULL,
	[TrangThai] Nvarchar(15) NULL,
--Primary Key ([MaLop],[MaHocVien],[MaNgayHoc]),
foreign key (MaLop) references dbo.Lop(MaLop),
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),
foreign key (MaNgayHoc) references dbo.NgayHoc(MaNgayHoc),	
) 
go


---------------Bảng chi tiết học viên---------------10
Create table [ChiTietHocVien]
(
	[MaLop] Varchar(10) NOT NULL,
	[MaHocVien] Varchar(10) NOT NULL,
foreign key (MaLop) references dbo.Lop(MaLop),
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),
) 
go


---------------Bảng thi xét lớp---------------11
Create table [ThiXetLop]
(
	[MaKiThi] Varchar(10) NOT NULL,
	[NgayThi] Datetime NOT NULL,
	[GioThi] Datetime NOT NULL,
	[PhongThi] Nvarchar(15) NOT NULL,
Primary Key ([MaKiThi])
) 
go

---------------Bảng danh sách thi xét lớp---------------12
Create table [DanhSachThiXetLop]
(
	[MaHocVien] Varchar(10) NOT NULL,
	[MaKiThi] Varchar(10) NOT NULL,
	[KetQua] Nvarchar(15) NOT NULL,
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),
foreign key (MaKiThi) references dbo.ThiXetLop(MaKiThi),
) 
go


---------------Bảng học phí---------------13
Create table [HocPhi]
(
	[MaHocPhi] Varchar(10) NOT NULL,
	[MaHocVien] Varchar(10) NOT NULL,
	[SoTienPhaiDong] Float NOT NULL,
	[HanDongHocPhi] Datetime NOT NULL,
Primary Key ([MaHocPhi]),
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),	
) 
go


---------------Bảng hóa đơn---------------14


Create table [HoaDon]
(
	[MaHoaDon] Char(1) NOT NULL,
	[MaHocPhi] Varchar(10) NOT NULL,
	[MaHocVien] Varchar(10) NOT NULL,
	[SoTienDaDong] Float NOT NULL,
	[NgayDong] Datetime NOT NULL,
	[HinhThucThanhToan] Nvarchar(15) NOT NULL,
	[TrangThai] Nvarchar(15) NOT NULL,
Primary Key ([MaHoaDon]),
foreign key (MaHocPhi) references dbo.HocPhi(MaHocPhi),
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),	
) 
go

-------------------ĐĂNG NHẬP-------------------
INSERT DANGNHAP
VALUES (N'admin','1')
INSERT DANGNHAP
VALUES (N'NHANVIEN','1')

select *from DANGNHAP

-------------------VĂN BẰNG-------------------

INSERT VANBANG
VALUES (N'VB1', 'TOEIC')
INSERT VANBANG
VALUES (N'VB2', 'IELTS')
INSERT VANBANG
VALUES (N'VB3', 'TOEFL')

select *from VANBANG

-------------------TRÌNH ĐỘ-------------------
INSERT TRINHDO
VALUES ('A1', 'Beginner')
INSERT TRINHDO
VALUES ('A2', ' Elementary')
INSERT TRINHDO
VALUES ('B1', ' Intermediate')
