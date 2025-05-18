@echo off
powershell Start-Process "python" -ArgumentList "scripts/import_data.py","%~1" -Verb RunAs