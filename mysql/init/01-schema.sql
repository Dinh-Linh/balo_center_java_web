CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand_name VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    price VARCHAR(50),
    image_link VARCHAR(512),
    detail_link VARCHAR(512),
    description TEXT,
    price_value DECIMAL(12,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Cấp quyền cho người dùng Spring Boot
GRANT ALL PRIVILEGES ON product_db.* TO 'springuser'@'%';
FLUSH PRIVILEGES;
