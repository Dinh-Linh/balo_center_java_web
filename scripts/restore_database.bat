@echo off
setlocal

REM Check input parameter
if "%~1"=="" (
    echo Usage: restore_database.bat ^<path_to_backup.sql[.gz]^>
    exit /b 1
)
if not exist "%~1" (
    echo Backup file does not exist: %~1
    exit /b 1
)

REM Check if Docker container is running
docker ps | findstr "spring-boot-mysql" >nul
if %ERRORLEVEL% NEQ 0 (
    echo MySQL container is not running. Starting...
    docker-compose up -d
    timeout /t 15 /nobreak
)

echo Restoring database from backup...

REM Handle compressed files
if "%~x1"==".gz" (
    REM Requires 7-Zip
    "C:\Program Files\7-Zip\7z.exe" e -so "%~1" | docker exec -i spring-boot-mysql sh -c "exec mysql -uroot -p$MYSQL_ROOT_PASSWORD product_db"
) else (
    type "%~1" | docker exec -i spring-boot-mysql sh -c "exec mysql -uroot -p$MYSQL_ROOT_PASSWORD product_db"
)

echo Database restored successfully!