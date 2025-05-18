# Balo Center Java Web

This branch contains the source code for the Balo Center Java Web application, a Spring Boot project for managing products, categories, and branches in a balo (backpack) store.

## Features
- Product management (CRUD)
- Category and branch management
- RESTful API endpoints
- MySQL database integration
- Admin interface
- End-user features:
  - Product browsing and search
  - View product details
  - Filter products by category or branch
  - User-friendly web interface
  - Shopping cart and checkout
  - Place orders and payment processing

## Project Structure
- `src/main/java/com/example/balo_center/` - Main Java source code
- `src/main/resources/` - Application configuration and templates
- `src/main/webapp/` - Static resources (JS, CSS, images)
- `docker-compose.yml`, `Dockerfile` - Docker configuration for local development
- `scripts/` - Database and data import scripts

## Getting Started
1. **Clone the repository**
2. **Configure the database**
   - Update `src/main/resources/application.properties` with your MySQL credentials
   - Use provided SQL scripts in `mysql/init/` to set up the schema
3. **Build and run the application**
   - With Maven: `./mvnw spring-boot:run`
   - Or use Docker: `docker-compose up --build`
4. **Access the application**
   - Visit `http://localhost:8080` in your browser

## Requirements
- Java 17 or newer
- Maven
- MySQL
- (Optional) Docker & Docker Compose

## Scripts
- Database backup and restore scripts are in the `scripts/` folder
- Data import script: `import_data.py`

## Deployment

### Option 1: Deploy as a JAR file
1.  **Build the application:**
    ```bash
    ./mvnw clean package
    ```
2.  **Run the JAR file:**
    ```bash
    java -jar target/balo_center-0.0.1-SNAPSHOT.jar
    ```
    (Replace `balo_center-0.0.1-SNAPSHOT.jar` with the actual JAR file name if different)

### Option 2: Deploy with Docker
1.  **Build the Docker image:**
    ```bash
    docker build -t balo-center-app .
    ```
2.  **Run the Docker container (using `docker-compose.yml` if preferred for managing database and app together):
    ```bash
    docker-compose up -d
    ```
    Or run the application container directly:
    ```bash
    docker run -p 8080:8080 --name balo-center-instance -e SPRING_DATASOURCE_URL=jdbc:mysql://<your_mysql_host>:<port>/<database_name> -e SPRING_DATASOURCE_USERNAME=<username> -e SPRING_DATASOURCE_PASSWORD=<password> balo-center-app
    ```
    Ensure you replace placeholders for database connection details if not using Docker Compose with a linked MySQL service.

### Option 3: Deploy to a Cloud Platform (e.g., AWS, Azure, Google Cloud)
-   Follow the specific platform's documentation for deploying Spring Boot applications.
-   This typically involves packaging the application (as a JAR or Docker image) and configuring the cloud service (e.g., AWS Elastic Beanstalk, Azure App Service, Google App Engine).

## Contact
For questions or contributions, please open an issue or contact the maintainer.

