# shopping app

Steps to run the application

1. Build 
   ```bash
   ./mvnw clean install
      ```
   
2. Run
   ```bash
   ./mvnw spring-boot:run
   ```
   
3. Setup Database

   ```bash
   http://localhost:8080/watch-console/login.do
   login with username/password from application.yml
   ```

4. Run the queries
   ```bash
   insert into WATCH_CATALOGUE (WATCH_ID,DISCOUNT,UNIT_PRICE,WATCH_NAME) VALUES (1 , '3 for 200', 100, 'Rolex');
   insert into WATCH_CATALOGUE (WATCH_ID,DISCOUNT,UNIT_PRICE,WATCH_NAME) VALUES (2 , '2 for 120', 80, 'Michael Kors');
   insert into WATCH_CATALOGUE (WATCH_ID,UNIT_PRICE,WATCH_NAME) VALUES (3 , 50, 'Swatch');
   insert into WATCH_CATALOGUE (WATCH_ID,UNIT_PRICE,WATCH_NAME) VALUES (4 , 30, 'Casio');
   ```

5. Run the curl command
   ```bash
   POST /checkout HTTP/1.1
   Host: localhost:8080
   Content-Type: application/json
   Cache-Control: no-cache
   Postman-Token: 43b6db93-8183-7988-3823-2dc381a90edc
   [1,2,1,4,3]
   ```

