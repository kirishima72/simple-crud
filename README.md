# simple-crud
Simple CRUD process using Springboot (Maven } Java 17) 

Progress : Backend sudah bisa digunakan

Cara test :
1. Buat database dengan nama "madatabase"
2. buat table di dalam madatabase dengan query di bawah ini
  CREATE TABLE `madatabase`.`users` (`id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , `email` VARCHAR(100) NOT NULL , `address` TEXT NOT NULL , PRIMARY KEY (`id`)); 
3. Jalankan project ini menggunakan Intellij.
4. Untuk pengujian CRUD dapat menggunakan link di bawah ini
   - CREATE
       Method: POST | http://localhost:8080/users
       Body : {
              "name": "abuy",
              "email": "abuy@gmail.com",
              "address": "Cikarang"
              }
   - READ
     > Get All Data
       Method: GET | http://localhost:8080/users
     > Get Data By ID
       Method: GET | http://localhost:8080/users/{id}
   - UPDATE
       Method: PUT | http://localhost:8080/users/{id}
       Body : {
              "name": "{new name}",
              "email": "{new email}",
              "address": "{new address}"
              }
   - DELETE
       Method: DELETE | http://localhost:8080/users/{id}
