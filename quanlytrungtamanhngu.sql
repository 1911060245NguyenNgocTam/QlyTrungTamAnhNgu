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
	[Diem] varchar (10) not null,
Primary Key ([MaTrinhDo])
) 
go

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
	[NgayBatDau] Date NOT NULL,
	[NgayKetThuc] Date NOT NULL,
Primary Key ([MaLop]),
foreign key (MaKhoaHoc) references dbo.KhoaHoc(MaKhoaHoc),	
) 
go

---------------Bảng ngày học---------------7
/*Create table [NgayHoc]
(
	[MaNgayHoc] Varchar(10) NOT NULL,
	[Thu] Nvarchar(15) NOT NULL,
	[NgayHoc] Date NOT NULL,
	[GioBatDau] Nvarchar (10) NOT NULL,
	[GioKetThuc] Nvarchar (10) NOT NULL,
Primary Key ([MaNgayHoc])
) 
*/



---------------Bảng học viên---------------8
Create table [HocVien]
(
	[MaHocVien] Varchar(10) NOT NULL,
	[TenHocVien] Nvarchar(30) NOT NULL,
	[NgaySinh] Date NOT NULL,
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
	[NgayHoc] date not null,
	[GioBatDau] varchar (10) not null,
	[GioKetThuc] varchar(10) not null,
	--[MaNgayHoc] Varchar(10) NOT NULL,
	[TrangThai] Nvarchar(10) NOT NULL,
--Primary Key ([MaLop],[MaHocVien]
foreign key (MaLop) references dbo.Lop(MaLop),
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),	
) 

go


---------------Bảng chi tiết học viên---------------10



---------------Bảng thi xét lớp---------------11
Create table [ThiXetLop]
(
	[MaKiThi] Varchar(10) NOT NULL,
	[NgayThi] Date NOT NULL,
	[GioBatDau] Nvarchar(10) NOT NULL,
	[GioKetThuc] Nvarchar(10) NOT NULL,
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
	[HanDongHocPhi] Date NOT NULL,
Primary Key ([MaHocPhi]),
foreign key (MaHocVien) references dbo.HocVien(MaHocVien),	
) 
go


---------------Bảng hóa đơn---------------14


Create table [HoaDon]
(
	[MaHoaDon] Varchar(10) NOT NULL,
	[MaHocPhi] Varchar(10) NOT NULL,
	[MaHocVien] Varchar(10) NOT NULL,
	[SoTienDaDong] Float NOT NULL,
	[NgayDong] Date NOT NULL,
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
VALUES ('TD1', 'Beginner', N'1-4')
INSERT TRINHDO
VALUES ('TD2', ' Elementary',N'5-7')
INSERT TRINHDO
VALUES ('TD3', ' Intermediate',N'8-10')

select *from TRINHDO

-------------------GIẢNG VIÊN-------------------
INSERT GIANGVIEN
VALUES ('GV1',N'Võ Thị Phúc Hồng',N'33/1, Lê Thị Riêng, Quận 12, TPHCM',N'0903122945')
INSERT GIANGVIEN
VALUES ('GV2',N'Đoàn Thị Hồng Thắm',N'23/9, Lê Văn Thọ, Gò Vấp, TPHCM',N'0387223987')
INSERT GIANGVIEN
VALUES ('GV3',N'Trần Diễm My',N'66/5, Nguyễn Hữu Cảnh, Bình Thạnh, TPHCM',N'0776589632')
INSERT GIANGVIEN
VALUES ('GV4',N'Trần Hoàng',N'340, Tân Chánh Hiệp 10, Quận 12, TPHCM',N'0777562214')
INSERT GIANGVIEN
VALUES ('GV5',N'Võ Hoàng Quân',N'33, Lê Duẩn, Quận 1, TPHCM',N'0383658974')

select *from GIANGVIEN

-------------------KHÓA HỌC-------------------
INSERT KHOAHOC
VALUES ('KH1', 'VB1','TD1','GV1','TOEIC căn bản')
INSERT KHOAHOC
VALUES ('KH2', 'VB1','TD2','GV2','TOEIC giải bài tập')
INSERT KHOAHOC
VALUES ('KH3', 'VB2','TD1','GV3','IELTS căn bản')
INSERT KHOAHOC
VALUES ('KH4', 'VB2','TD2','GV4','IELTS cấp tốc')

select *from KHOAHOC

-------------------LỚP-------------------
INSERT LOP
VALUES ('L1','KH1',N'Lớp T1','2019-7-13','2020-1-13')
INSERT LOP
VALUES ('L2','KH2',N'Lớp TNC1','2019-7-13','2020-1-13')
INSERT LOP
VALUES ('L3','KH3',N'Lớp I1','2020-3-1','2020-9-1')
INSERT LOP
VALUES ('L4','KH4',N'Lớp INC1','2019-3-1','2020-3-1')

select *from LOP

-------------------NGÀY HỌC-------------------
/*INSERT NGAYHOC
VALUES ('NH1', N'Thứ 3','2019-7-14',N'6pm',N'9pm')
INSERT NGAYHOC
VALUES ('NH2', N'Thứ 5','2019-7-16',N'9am',N'11am')
INSERT NGAYHOC
VALUES ('NH3', N'Thứ 4','2019-7-15',N'6pm',N'9pm')

select *from NGAYHOC
*/
-------------------HỌC VIÊN-------------------
INSERT HOCVIEN
VALUES ('HV1',N'Trần Kiên','2001-9-1',N'11, Phan Văn Hớn, Quận 12, TPHCM', N'0903982094')
INSERT HOCVIEN
VALUES ('HV2',N'Nguyễn Tuấn','2002-10-9',N'322, Phan Văn Trị, Gò Vấp, TPHCM', N'0902000111')
INSERT HOCVIEN
VALUES ('HV3',N'Bùi Huy','2001-9-1',N'22/1, Cây Trâm, Gò Vấp, TPHCM', N'0778632158')
INSERT HOCVIEN
VALUES ('HV4',N'Trần Hoàng Tâm','2001-10-19',N'21, Phan Huy Ích, Tân Bình, TPHCM', N'0776983214')
INSERT HOCVIEN
VALUES ('HV5',N'Cao Gia Hưng','2003-7-8',N'33/3, Tây Thạnh, Tân Phú, TPHCM', N'0778525693')
INSERT HOCVIEN
VALUES ('HV6',N'Nguyễn Thị Mỹ Lệ','2001-2-14',N'22, Phan Văn Hớn, Quận 12, TPHCM', N'0369587412')
INSERT HOCVIEN
VALUES ('HV7',N'Hồng Bích Thủy','2004-9-2',N'37/11/12, Lê Văn Khương, Quận 12, TPHCM', N'0903258194')
INSERT HOCVIEN
VALUES ('HV8',N'Hồ Thu Uyên','2005-1-1',N'1, Cây Trâm, Gò Vấp, TPHCM', N'0787452369')
INSERT HOCVIEN
VALUES ('HV9',N'Nguyễn Kim Tuyền','2000-4-1',N'15/12/11/2, Hà Đặc, Quận 12, TPHCM', N'0918456225')
INSERT HOCVIEN
VALUES ('HV10',N'Cao Thành Trung','1998-5-19',N'225/1/4, Quang Trung, Gò Vấp, TPHCM', N'0776982147')

select *from HOCVIEN


-------------------ĐIỂM DANH-------------------
INSERT DIEMDANH
VALUES ('L1','HV1','2021-2-19', '7pm','9pm', N'Có')
INSERT DIEMDANH
VALUES ('L2','HV2','2021-3-2','6pm','8pm',N'Vắng')
INSERT DIEMDANH
VALUES ('L3','HV3','2021-5-21','8am','9am',N'Vắng')

select *from DIEMDANH 




-------------------THI XÉT LỚP------------------
INSERT THIXETLOP
VALUES ('KT1','2019-2-4',N'5pm',N'6pm','T1')
INSERT THIXETLOP
VALUES ('KT2','2019-2-5',N'5pm',N'6pm','TNC1')
INSERT THIXETLOP
VALUES ('KT3','2019-2-6',N'5pm',N'6pm','I1')
INSERT THIXETLOP
VALUES ('KT4','2019-5-7',N'5pm',N'6pm','I1')
INSERT THIXETLOP
VALUES ('KT5','2020-1-4',N'3pm',N'5pm','TNC1')
INSERT THIXETLOP
VALUES ('KT6','2021-1-9',N'5pm',N'7pm','I1')
INSERT THIXETLOP
VALUES ('KT7','2020-7-5',N'4pm',N'5pm','TNC1')
INSERT THIXETLOP
VALUES ('KT8','2022-2-6',N'6pm',N'7pm','I1')
INSERT THIXETLOP
VALUES ('KT9','2020-6-6',N'2pm',N'3pm','I1')

select *from ThiXetLop


-------------------DANH SÁCH THI XÉT LỚP------------------
INSERT DanhSachThiXetLop
VALUES ('HV1','KT1', '5')
INSERT DanhSachThiXetLop
VALUES ('HV2','KT2', '7')
INSERT DanhSachThiXetLop
VALUES ('HV3','KT1', '4')
INSERT DanhSachThiXetLop
VALUES ('HV4','KT3', '1')
INSERT DanhSachThiXetLop
VALUES ('HV5','KT2', '8')

select *from DanhSachThiXetLop


-------------------HỌC PHÍ------------------
INSERT HocPhi
VALUES ('HP1','HV1','6000000','2020-12-3')
INSERT HocPhi
VALUES ('HP2','HV2','7000000','2020-3-23')
INSERT HocPhi
VALUES ('HP3','HV3','3000000','2020-5-11')
INSERT HocPhi
VALUES ('HP4','HV4','5000000','2022-4-5')
INSERT HocPhi
VALUES ('HP5','HV5','4000000','2020-8-16')


select *from HOCPHI


-------------------HÓA ĐƠN------------------
INSERT HOADON
VALUES ('HD1','HP1','HV1','6000000','2020-12-2',N'Momo',N'Đã đóng')
INSERT HOADON
VALUES ('HD2','HP2','HV2','7000000','2020-3-23',N'Chuyển Khoản',N'Đã đóng')
INSERT HOADON
VALUES ('HD3','HP3','HV3','3000000','2020-5-10',N'Tiền mặt',N'Đã đóng')
INSERT HOADON
VALUES ('HD4','HP4','HV4','6000000','2022-4-4',N'Momo',N'Đã đóng')
INSERT HOADON
VALUES ('HD5','HP5','HV5','4000000','2020-8-15',N'Tiền mặt',N'Đã đóng')

select *from HOADON




