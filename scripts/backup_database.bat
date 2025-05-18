#!/bin/bash

# Tạo thời gian hiện tại
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
BACKUP_FILE="mysql/backup/product_db_$TIMESTAMP.sql"

# Tạo backup
echo "Đang tạo backup database..."
docker exec spring-boot-mysql sh -c 'exec mysqldump -uroot -p"$MYSQL_ROOT_PASSWORD" product_db' > $BACKUP_FILE

# Nén file backup
gzip $BACKUP_FILE
echo "Đã tạo backup tại: ${BACKUP_FILE}.gz"
