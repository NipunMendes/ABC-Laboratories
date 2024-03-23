# ABC-Laboratories
 Laboratory Appointment System
This is a laboratory appointment system designed to streamline the process of scheduling appointments for laboratory tests. It provides a user-friendly interface for both patients and administrators to manage appointments efficiently.

#Technologies Used
Frontend: HTML, Tailwind CSS
Backend: Java, Spring Boot
Database: MySQL
Installation
To run this system locally, follow these steps:

#Clone the repository:
bash
git clone https://github.com/yourusername/ABC-Laboratories.git

#Navigate to the project directory:
bash
cd ABC-Laboratories


#Backend Setup:

Make sure you have Java and Maven installed.
Navigate to the backend directory.
Configure the MySQL database settings in application.properties.

#Run the following commands to create the MySQL database:
bash
mysql -u your_username -p

#sql
CREATE DATABASE appointment_scheduling;

Exit the MySQL shell:
sql
exit;

#Run the Spring Boot application:
bash
mvn spring-boot:run


#Frontend Setup:

Navigate to the frontend directory.
Open admin_login.html in your preferred web browser.
Access the Application:

Open your web browser and go to http://localhost:8080 to access the application.
Usage

Fork the repository.
Create your feature branch (git checkout -b feature/YourFeature).
Commit your changes (git commit -am 'Add some feature').
Push to the branch (git push origin feature/YourFeature).
Create a new Pull Request.
