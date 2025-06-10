-- Vô hiệu hóa kiểm tra khóa ngoại
SET FOREIGN_KEY_CHECKS = 0;

-- ✅ categories
INSERT INTO categories (id, category_name) VALUES
('1','Balo Thời Trang'),
('2','Túi Tote'),
('3','Túi Laptop'),
('4','Balo Du Lịch'),
('5','Balo Học Sinh');

-- ✅ branches (thương hiệu)
INSERT INTO branches (id, branch_name) VALUES
('1','Herschel Supply Co.'),   -- lấy tên từ thị trấn Herschel, Canada :contentReference[oaicite:1]{index=1}
('2', 'The North Face'),
('3', 'Fjällräven');
-- Xóa users cũ 
TRUNCATE TABLE users;

-- ✅ users
INSERT INTO users (id, email, fullname, password, phone, role, status, avatar, created_date) VALUES
('1', 'lam.van.son@example.com', 'Lâm Văn Sơn', '$2a$10$xyz...', '0912345678', 'USER', 'ACTIVE', '/avatars/lamvanson.png', CURRENT_TIMESTAMP),
('2', 'nguyen.van.tuan@example.com', 'Nguyễn Văn Tuấn', '$2a$10$xyz...', '0912345678', 'USER', 'ACTIVE', 'avatar1.jpg', CURRENT_TIMESTAMP - INTERVAL '5' DAY),
('3', 'nguyen.van.an@example.com', 'Nguyễn Văn An', '$2a$10$xyz...', '0912345678', 'USER', 'ACTIVE', '/avatars/nguyenv.an.vanquan.png', CURRENT_TIMESTAMP - INTERVAL '10' DAY),
('4', 'phan.thi.nga@example.com', 'Phan Thị Nga', '$2a$10$xyz...', '0920345678', 'USER', 'ACTIVE', '/avatars/phanthinga.png', CURRENT_TIMESTAMP - INTERVAL '15' DAY),
('5', 'tran.thi.bich@example.com', 'Trần Thị Bích', '$2a$10$xyz...', '0987654321', 'USER', 'ACTIVE', '/avatars/tranthibinh.png', CURRENT_TIMESTAMP - INTERVAL '20' DAY),
('6', 'ly.thanh.tung@example.com', 'Lý Thanh Tùng', '$2a$10$xyz...', '0930456789', 'USER', 'ACTIVE', '/avatars/lythanhtung.png', CURRENT_TIMESTAMP - INTERVAL '25' DAY),
('7', 'admin3@example.com', 'Quản trị viên', '$2a$10$xyz...', '0911222333', 'ADMIN', 'ACTIVE', 'avatar3.jpg', CURRENT_TIMESTAMP),
('8', 'le.thi.chi@example.com', 'Lê Thị Chi', '$2a$10$xyz...', '0934567890', 'USER', 'ACTIVE', '/avatars/lethichi.png', CURRENT_TIMESTAMP - INTERVAL '30' DAY),
('9', 'ngo.khanh.linh@example.com', 'Ngô Khánh Linh', '$2a$10$xyz...', '0940567890', 'USER', 'ACTIVE', '/avatars/ngokhanhlinh.png', CURRENT_TIMESTAMP - INTERVAL '2' MONTH),
('10', 'le.van.cuong@example.com', 'Lê Văn Cường', '$2a$10$xyz...', '0909988776', 'USER', 'ACTIVE', 'avatar4.jpg', CURRENT_TIMESTAMP - INTERVAL '3' MONTH),
('11', 'pham.van.dung@example.com', 'Phạm Văn Dũng', '$2a$10$xyz...', '0945678901', 'USER', 'ACTIVE', '/avatars/phamvandung.png', CURRENT_TIMESTAMP - INTERVAL '4' MONTH),
('12', 'duong.thanh.son@example.com', 'Dương Thanh Sơn', 'Tôi sẽ thay thế các dòng chèn dữ liệu hiện có cho bảng `orders` bằng các dòng mới sử dụng ngày tháng động. $2a$10$xyz...', '0950678901', 'USER', 'ACTIVE', '/avatars/duongthanhs.png', CURRENT_TIMESTAMP - INTERVAL '5' MONTH),
('13', 'pham.thi.dung@example.com', 'Phạm Thị Dung', '$2a$10$xyz...', '0911002003', 'USER', 'ACTIVE', 'avatar5.jpg', CURRENT_TIMESTAMP - INTERVAL '6' MONTH),
('14', 'hoang.thi.hoa@example.com', 'Hoàng Thị Hoa', '$2a$10$xyz...', '0956789012', 'USER', 'ACTIVE', '/avatars/hoangthihoa.png', CURRENT_TIMESTAMP - INTERVAL '7' MONTH),
('15', 'phung.thi.phuong@example.com', 'Phùng Thị Phương', '$2a$10$xyz...', '0960789012', 'USER', 'ACTIVE', '/avatars/phungthiphuong.png', CURRENT_TIMESTAMP - INTERVAL '8' MONTH),
('16', 'do.van.minh@example.com', 'Đỗ Văn Minh', '$2a$10$xyz...', '0967890123', 'USER', 'ACTIVE', '/avatars/dovanminh.png', CURRENT_TIMESTAMP - INTERVAL '9' MONTH),
('17', 'cao.minh.khoa@example.com', 'Cao Minh Khoa', '$2a$10$xyz...', '0970890123', 'USER', 'ACTIVE', '/avatars/caominhkhoa.png', CURRENT_TIMESTAMP - INTERVAL '10' MONTH);

-- ✅ products (30 mẫu balo)
INSERT INTO products (id, product_name, detail_desc, short_desc, quality, price, sold, branch_id, category_id, quantity) VALUES
('P101','Herschel Classic XL 30L','EcoSystem 600D tái chế, laptop sleeve 15–16″','Classic XL 30L',25,1590000.00,120,'1','1',50),
('P102','Herschel Classic 26L','EcoSystem 600D, sleeve laptop 13–14″','Classic 26L',22,1390000.00,150,'1','1',60),
('P103','Herschel Seymour 26L','Twill + da, sleeve 15–16″','Seymour 26L',30,1990000.00,80,'1','1',40),
('P104','Herschel Little America 30L','Flap‑over, sleeve 15″','Little America 30L',27,1800000.00,100,'1','1',45),
('P105','Herschel Kaslo 30L','Side‑entry, sleeve laptop','Kaslo 30L',20,1500000.00,70,'1','1',55),
('P106','Herschel Ultralight 22L','Nylon nhẹ, không sleeve','Ultralight 22L',18,900000.00,55,'1','1',70),
('P107','Herschel Ultralight Cinch 14L','Gấp gọn, dây rút','Ultralight Cinch 14L',15,700000.00,40,'1','1',80),
('P108','Herschel All Season 29L','Chống nước, sleeve 15″','All Season 29L',22,1500000.00,65,'1','1',50),
('P109','Herschel Settlement Laptop 15″','Laptop sleeve 15″, polyester','Settlement Laptop',18,799000.00,90,'1','1',75),
('P110','Herschel Retreat 25L','Flap‑top, sleeve 15″','Retreat 25L',24,1100000.00,75,'1','1',65),

('P201','The North Face Surge 31L','Ripstop nylon, FlexVent, sleeve 15″, 31 L','Surge 31L',30,2890000.00,85,'2','4',40),
('P202','The North Face Borealis 28L','Ripstop+DWR, sternum strap, sleeve 15″','Borealis 28L',28,2490000.00,95,'2','4',50),
('P203','The North Face Recon 30L','FlexVent, sleeve laptop','Recon 30L',26,2690000.00,60,'2','4',45),
('P204','The North Face Jester 28L','Ngăn laptop, giá mềm','Jester 28L',20,1090000.00,140,'2','4',65),
('P205','The North Face Vault 20L','Water‑repellent, sleeve laptop','Vault 20L',18,850000.00,120,'2','4',80),
('P206','The North Face Router 40L','FlexVent, phản quang, sleeve laptop','Router 40L',32,3590000.00,50,'2','4',35),
('P207','The North Face Base Camp 26L','Daypack, sleeve laptop','Base Camp 26L',22,1290000.00,80,'2','4',45),
('P208','The North Face Isabella 20L','Women's, sleeve laptop','Isabella 20L',18,890000.00,70,'2','4',55),
('P209','The North Face Mini Recon 20L','Kids, sleeve laptop','Mini Recon 20L',15,650000.00,90,'2','4',60),
('P210','The North Face Borealis Luxe 27L','Premium, sleeve laptop','Borealis Luxe 27L',24,2990000.00,45,'2','4',40),

('P301','Fjällräven Kanken 16L','Vinylon F, chống nước nhẹ','Kanken 16L',22,2000000.00,85,'3','4',50),
('P302','Fjällräven Kanken Laptop 17L','Ngăn laptop 13″','Kanken Laptop',24,2600000.00,60,'3','3',40),
('P303','Fjällräven Kanken Big 20L','Big size, sleeve laptop','Kanken Big 20L',24,2300000.00,50,'3','4',45),
('P304','Osprey Daylite Plus 20L','Recycled nylon, sleeve laptop','Daylite Plus 20L',26,1800000.00,40,'3','4',35),
('P305','JanSport SuperBreak 25L','Classic nylon budget','SuperBreak 25L',16,750000.00,150,'3','5',70),
('P306','JanSport Cool Student 30L','Budget, nhiều ngăn','Cool Student 30L',18,850000.00,130,'3','5',60),
('P307','SwissGear ScanSmart 17L','Lay‑flat sleeve 17″','ScanSmart 17L',28,2200000.00,55,'3','3',50),
('P308','Patagonia Arbor 25L','Recycled polyester, sleeve laptop','Arbor 25L',26,2400000.00,60,'3','4',45),
('P309','Lululemon Everyday 25L','Neoprene, sleeve laptop','Everyday 25L',24,2700000.00,45,'3','4',40),
('P310','Rains Backpack 15L','100% PU chống nước','Rains 15L',20,1200000.00,65,'3','5',55);

-- ✅ product_images
INSERT INTO product_images (id, product_id, images) VALUES
('IMG101','P101','https://images.pexels.com/photos/2905238/pexels-photo-2905238.jpeg'),
('IMG102','P201','https://images.pexels.com/photos/732629/pexels-photo-732629.jpeg'),
('IMG103','P202','https://images.pexels.com/photos/842958/pexels-photo-842958.jpeg'),
('IMG104','P301','https://images.pexels.com/photos/1576939/pexels-photo-1576939.jpeg'),
('IMG105','P203','https://images.pexels.com/photos/1478476/pexels-photo-1478476.jpeg'),
('IMG106','P204','https://images.pexels.com/photos/842958/pexels-photo-842958.jpeg'),
('IMG107','P205','https://images.pexels.com/photos/443417/pexels-photo-443417.jpeg'),
('IMG108','P206','https://images.pexels.com/photos/268013/pexels-photo-268013.jpeg'),
('IMG109','P302','https://images.pexels.com/photos/934673/pexels-photo-934673.jpeg'),
('IMG110','P310','https://images.pexels.com/photos/1251861/pexels-photo-1251861.jpeg');

-- ✅ carts (30)
INSERT INTO carts (id, quantity, product_id, user_id) VALUES
(1,1,'P101','1'),(2,2,'P102','1'),(3,1,'P103','2'),(4,1,'P104','2'),
(5,2,'P105','3'),(6,1,'P106','3'),(7,3,'P107','4'),(8,1,'P108','4'),
(9,2,'P109','5'),(10,1,'P110','5'),(11,1,'P201','1'),(12,2,'P202','1'),
(13,1,'P203','2'),(14,1,'P204','2'),(15,3,'P205','3'),(16,1,'P206','3'),
(17,2,'P207','4'),(18,1,'P208','4'),(19,1,'P209','5'),(20,2,'P210','5'),
(21,1,'P301','1'),(22,2,'P302','2'),(23,1,'P303','3'),(24,1,'P304','3'),
(25,2,'P305','4'),(26,1,'P306','4'),(27,1,'P307','5'),(28,3,'P308','5'),
(29,1,'P309','1'),(30,1,'P310','2');


-- Xóa dữ liệu bảng orders trước đó 
TRUNCATE TABLE orders;
-- ✅ orders (30)

INSERT INTO orders (id, address, date, phone, quality_product, total_price, status, user_id) VALUES
('O01','123 Trần Hưng Đạo, Q1, TP.HCM',CURRENT_TIMESTAMP,'0912345678',1,159000,'COMPLETED','1'),
('O02','66 Võ Văn Kiệt, Ninh Kiều, Cần Thơ',CURRENT_TIMESTAMP - INTERVAL '5' DAY,'0987654321',2,278000,'COMPLETED','2'),
('O03','56 Trần Phú, Đà Lạt',CURRENT_TIMESTAMP - INTERVAL '10' DAY,'0909988776',1,199000,'SHIPPED','3'),
('O04','88 Lê Duẩn, Huế',CURRENT_TIMESTAMP - INTERVAL '15' DAY,'0911002003',1,180000,'PENDING','4'),
('O05','102 Nguyễn Trãi, Nha Trang',CURRENT_TIMESTAMP - INTERVAL '20' DAY,'0911222333',3,359000,'PENDING','5'),
('O06','45 Lê Lợi, Q1, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '25' DAY,'0912345678',1,90000,'COMPLETED','1'),
('O07','27 Trần Hưng Đạo, Vũng Tàu',CURRENT_TIMESTAMP - INTERVAL '30' DAY,'0987654321',2,70000,'COMPLETED','2'),
('O08','78 Lý Tự Trọng, Cần Thơ',CURRENT_TIMESTAMP - INTERVAL '2' MONTH,'0909988776',1,150000,'SHIPPED','3'),
('O09','98 Nguyễn Trãi, Q5, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '3' MONTH,'0911002003',3,79900,'PENDING','4'),
('O10','92 Hùng Vương, Quy Nhơn',CURRENT_TIMESTAMP - INTERVAL '4' MONTH,'0911222333',2,110000,'COMPLETED','5'),
('O11','22 Trần Nhân Tông, Hà Nội',CURRENT_TIMESTAMP - INTERVAL '5' MONTH,'0912345678',1,289000,'PENDING','1'),
('O12','90 Hai Bà Trưng, Q3, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '6' MONTH,'0987654321',2,249000,'SHIPPED','2'),
('O13','30 Nguyễn Huệ, Đà Nẵng',CURRENT_TIMESTAMP - INTERVAL '7' MONTH,'0909988776',1,269000,'COMPLETED','3'),
('O14','12 Điện Biên Phủ, Q1, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '8' MONTH,'0911002003',3,109000,'PENDING','4'),
('O15','78 Phố Huế, QHai Bà Trưng, HN',CURRENT_TIMESTAMP - INTERVAL '9' MONTH,'0911222333',1,85000,'PENDING','5'),
('O16','34 Phan Đình Phùng, Huế',CURRENT_TIMESTAMP - INTERVAL '10' MONTH,'0912345678',2,359000,'COMPLETED','1'),
('O17','54 Trần Quang Khải, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '11' MONTH,'0987654321',1,129000,'SHIPPED','2'),
('O18','15 Nguyễn Trãi, Q5, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '12' MONTH,'0901234567',2,159000,'PENDING','3'),
('O19','200 Phan Đình Phùng, Huế',CURRENT_TIMESTAMP - INTERVAL '13' MONTH,'0934567890',1,179000,'COMPLETED','4'),
('O20','500 Nguyễn Văn Cừ, Long Xuyên',CURRENT_TIMESTAMP - INTERVAL '14' MONTH,'0945678901',3,229000,'SHIPPED','5'),
('O21','7 Phan Chu Trinh, Thanh Hóa',CURRENT_TIMESTAMP - INTERVAL '15' MONTH,'0956789012',1,149000,'PENDING','1'),
('O22','123 Trần Phú, Nha Trang',CURRENT_TIMESTAMP - INTERVAL '16' MONTH,'0967890123',2,199000,'COMPLETED','2'),
('O23','88 Nguyễn Văn Linh, Q7, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '17' MONTH,'0978901234',1,89900,'SHIPPED','3'),
('O24','34 Điện Biên Phủ, Q3, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '18' MONTH,'0989012345',3,329000,'PENDING','4'),
('O25','56 Hùng Vương, Quy Nhơn',CURRENT_TIMESTAMP - INTERVAL '19' MONTH,'0902345678',2,149000,'COMPLETED','5'),
('O26','66 Lý Thái Tổ, Vinh',CURRENT_TIMESTAMP - INTERVAL '20' MONTH,'0913456789',1,119000,'SHIPPED','1'),
('O27','44 Hoàng Văn Thụ, Đắk Lắk',CURRENT_TIMESTAMP - INTERVAL '21' MONTH,'0924567890',3,279000,'PENDING','2'),
('O28','77 Phan Chu Trinh, HN',CURRENT_TIMESTAMP - INTERVAL '22' MONTH,'0935678901',1,129000,'COMPLETED','3'),
('O29','33 Võ Văn Kiệt, Q1, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '23' MONTH,'0946789012',2,189000,'SHIPPED','4'),
('O30','99 Trần Hưng Đạo, Q5, TP.HCM',CURRENT_TIMESTAMP - INTERVAL '24' MONTH,'0957890123',1,209000,'PENDING','5');

-- Thêm 5 đơn hàng đã hoàn thành gần đây
INSERT INTO orders (id, address, date, phone, quality_product, total_price, status, user_id) VALUES
('O31','101 Đường Thống Nhất, Quận 1, TP.HCM', CURRENT_TIMESTAMP, '0901111222', 1, 500000.00, 'COMPLETED','1'),
('O32','202 Đường Văn Tiến Dũng , Quận Bắc Từ Liêm, Hà Nội', CURRENT_TIMESTAMP - INTERVAL '2' DAY, '0902222333', 2, 750000.00, 'COMPLETED','2'),
('O33','303 Đường 32, Hàm Rồng, Đà Nẵng', CURRENT_TIMESTAMP - INTERVAL '7' DAY, '0903333444', 1, 300000.00, 'COMPLETED','3'),
('O34','404 Đường 12, Quận Nhà Bè, Cần Thơ', CURRENT_TIMESTAMP - INTERVAL '15' DAY, '0904444555', 3, 1200000.00, 'COMPLETED','4'),
('O35','505 Đường 10, Thành Phố Lạch Tray, Hải Phòng', CURRENT_TIMESTAMP - INTERVAL '25' DAY, '0905555666', 1, 900000.00, 'COMPLETED','5');

-- Update Order
SET SQL_SAFE_UPDATES = 0;

UPDATE orders
SET user_id = CASE 
  WHEN phone = '0912345678' THEN '1'
  WHEN phone = '0987654321' THEN '2'
  WHEN phone = '0909988776' THEN '10'
  WHEN phone = '0920345678' THEN '4'
  WHEN phone = '0911002003' THEN '6'
  WHEN phone = '0930456789' THEN '6'
  ELSE user_id
END;

SET SQL_SAFE_UPDATES = 1;
-- ✅ order_details (30)
INSERT INTO order_details (id, discount, price, quantity, total, order_id, product_id) VALUES
(1,0.00,159000,1,159000,'O01','P101'),
(2,0.00,139000,2,278000,'O02','P102'),
(3,0.00,199000,1,199000,'O03','P103'),
(4,0.00,180000,1,180000,'O04','P104'),
(5,0.00,150000,3,450000,'O05','P105'),
(6,0.00,90000,1,90000,'O06','P106'),
(7,0.00,70000,1,70000,'O07','P107'),
(8,0.00,150000,1,150000,'O08','P108'),
(9,0.00,79900,1,79900,'O09','P109'),
(10,0.00,110000,1,110000,'O10','P110'),
(11,0.00,289000,1,289000,'O11','P201'),
(12,0.00,249000,1,249000,'O12','P202'),
(13,0.00,269000,1,269000,'O13','P203'),
(14,0.00,109000,1,109000,'O14','P204'),
(15,0.00,85000,1,85000,'O15','P205'),
(16,0.00,359000,1,359000,'O16','P206'),
(17,0.00,129000,1,129000,'O17','P207'),
(18,0.00,159000,2,318000,'O18','P108'),
(19,0.00,179000,1,179000,'O19','P109'),
(20,0.00,229000,3,687000,'O20','P110'),
(21,0.00,149000,1,149000,'O21','P101'),
(22,0.00,199000,2,398000,'O22','P102'),
(23,0.00,89900,1,89900,'O23','P103'),
(24,0.00,329000,3,987000,'O24','P104'),
(25,0.00,149000,1,149000,'O25','P105'),
(26,0.00,119000,1,119000,'O26','P106'),
(27,0.00,279000,3,837000,'O27','P107'),
(28,0.00,129000,1,129000,'O28','P108'),
(29,0.00,189000,2,378000,'O29','P109'),
(30,0.00,209000,1,209000,'O30','P110');


-- ✅ delivery_addresses (30)
INSERT INTO delivery_addresses (id, delivery_address, delivery_name, delivery_phone, user_id) VALUES
('DA01','8 Trần Phú, Ba Đình, Hà Nội','Nguyễn Văn Tuấn','0912345678','1'),
('DA02','50 Lê Lai, Q1, TP.HCM','Trần Thị Bích','0987654321','2'),
('DA03','100 Võ Văn Ngân, Thủ Đức, TP.HCM','Lê Văn Cường','0909988776','3'),
('DA04','30 Phạm Văn Đồng, Sơn Trà, Đà Nẵng','Phạm Thị Dũng','0911002003','4'),
('DA05','20 Nguyễn Huệ, Bình Thạnh, TP.HCM','Mai Thị Hồng','0911222333','5'),
('DA06','12 Tây Sơn, Đống Đa, Hà Nội','Hoàng Văn Huy','0901234567','1'),
('DA07','34 Điện Biên Phủ, Q3, TP.HCM','Phan Thị Huyền','0902345678','2'),
('DA08','56 Hùng Vương, Q5, TP.HCM','Võ Văn Huy','0903456789','3'),
('DA09','78 Nguyễn Văn Linh, Q7, TP.HCM','Lê Thị Hồng','0904567890','4'),
('DA10','90 Phan Châu Trinh, Hải Châu, Đà Nẵng','Ngô Văn Huy','0905678901','5'),
('DA11','23 Trần Đại Nghĩa, Q5, TP.HCM','Đinh Thị Hồng','0916789012','1'),
('DA12','45 Phan Đăng Lưu, Phú Nhuận, TP.HCM','Trương Văn Huy','0917890123','2'),
('DA13','67 Nguyễn Thị Minh Khai, Q3, TP.HCM','Bùi Thị Nguyệt','0918901234','3'),
('DA14','89 Lê Duẩn, Q1, Thanh Hóa','Đoàn Văn Hậu','0919012345','4'),
('DA15','11 Nguyễn Huệ, Bình Khánh, TP.HCM','Phùng Thị Khánh HuyềnHuyền','0901122334','5'),
('DA16','33 Võ Văn Kiệt, Q1, TP.HCM','Trịnh Văn Quânuân','0902233445','1'),
('DA17','55 Lê Lợi, Quảng Ngãi','Vũ Thị Tuyết','0903344556','2'),
('DA18','77 Phan Chu Trinh, Hà Nội','Hà Văn Sơn','0904455667','3'),
('DA19','99 Trần Phú, Nha Trang','Đặng Thị Tuyết','0905566778','4'),
('DA20','22 Hùng Vương, Cần Thơ','Nguyễn Văn Uyên','0906677889','5'),
('DA21','44 Hoàng Văn Thụ, Buôn Ma Thuột','Lâm Thị Vân','0917788990','1'),
('DA22','66 Lý Thái Tổ, Vinh','Cao Văn Lâm','0918899001','2'),
('DA23','88 Trần Hưng Đạo, Mỹ Tho','Trần Thị Xuân','0919900112','3'),
('DA24','12 Nguyễn Du, Hà Nội','Phan Văn Yến','0920011223','4'),
('DA25','34 Hai Bà Trưng, Hải Phòng','Lê Thị MỹMỹ','0921122334','5'),
('DA26','56 Cách Mạng Tháng 8, TP.HCM','Nguyễn Văn An','0922233445','1'),
('DA27','78 Phạm Hùng, Hà Nội','Hoàng Thị Bích','0923344556','2'),
('DA28','90 Nguyễn Trãi, Thanh Xuân, Hà Nội','Phạm Văn Cường','0924455667','3'),
('DA29','23 Lê Lợi, Đồng Hới','Đỗ Thị Hồng','0925566778','4'),
('DA30','45 Huỳnh Thúc Kháng, Đống Đa, Hà Nội','Trần Văn Minh','0905566778','5');

-- Bật lại kiểm tra khóa ngoại
SET FOREIGN_KEY_CHECKS = 1;
