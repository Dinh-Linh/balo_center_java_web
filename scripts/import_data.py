import pandas as pd
import mysql.connector
from mysql.connector import Error
import sys

def import_excel_to_mysql(excel_file):
    try:
        # Read Excel file
        print(f"Reading Excel file: {excel_file}")
        df = pd.read_excel(excel_file)
        print(f"Found {len(df)} rows in Excel")

        # Connect to MySQL
        print("Connecting to MySQL...")
        conn = mysql.connector.connect(
            host='localhost',
            user='springuser',
            password='springpassword',
            database='product_db'
        )
        cursor = conn.cursor()

        # Clear existing data
        cursor.execute("TRUNCATE TABLE products")

        # Insert data
        for index, row in df.iterrows():
            sql = """INSERT INTO products
                         (brand_name, name, price, image_link, detail_link, description)
                     VALUES (%s, %s, %s, %s, %s, %s)"""
            values = (
                str(row.get('brand_name', '')),
                str(row['name']),
                str(row.get('price', '')),
                str(row.get('image_link', '')),
                str(row.get('detail_link', '')),
                str(row.get('description', ''))
            )
            cursor.execute(sql, values)
            if index % 100 == 0:
                print(f"Imported {index} rows...")

        conn.commit()
        print(f"Successfully imported {len(df)} rows")

    except Exception as e:
        print(f"Error: {str(e)}")
        sys.exit(1)
    finally:
        if 'conn' in locals() and conn.is_connected():
            cursor.close()
            conn.close()

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python import_data.py <excel_file>")
        sys.exit(1)

    import_excel_to_mysql(sys.argv[1])