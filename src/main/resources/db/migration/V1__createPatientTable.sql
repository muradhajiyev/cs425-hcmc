CREATE TABLE IF NOT EXISTS patient (
  id INT AUTO_INCREMENT PRIMARY KEY,
  patient_number VARCHAR(255) NOT NULL,
  is_an_out_patient TINYINT NOT NULL,
  full_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255),
  date_of_birth DATE
);