@echo off
setlocal

REM Run as administrator
net session >nul 2>&1
if %errorLevel% neq 0 (
    powershell Start-Process "%~0" -Verb RunAs
    exit /b
)

REM Check Docker and Docker Compose
where docker >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Docker is not installed. Please install Docker first.
    exit /b 1
)
where docker-compose >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Docker Compose is not installed. Please install Docker Compose first.
    exit /b 1
)

REM Check Excel file exists and has correct extension
if "%~1"=="" (
    echo Usage: setup_database.bat ^<path_to_excel_file.xlsx^>
    exit /b 1
)
if not exist "%~1" (
    echo Excel file does not exist: %~1
    exit /b 1
)
if /i "%~x1" neq ".xlsx" if /i "%~x1" neq ".xls" (
    echo File must be an Excel file ^(.xlsx or .xls^)
    exit /b 1
)

REM Create config directories with explicit permissions
icacls "mysql\init" /grant Everyone:F /T /C /Q 2>nul
icacls "mysql\backup" /grant Everyone:F /T /C /Q 2>nul

REM Rest of the script remains the same...