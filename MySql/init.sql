CREATE TABLE SENSORS( 
    ID INTEGER PRIMARY KEY NOT NULL, 
    LOCATION_CODE VARCHAR(3) NOT NULL, 
    MEASUREMENT_TYPE VARCHAR(2) NOT NULL 
 
); 

CREATE TABLE MEASUREMENTS( 
    ID INTEGER PRIMARY KEY NOT NULL, 
    SENSOR_ID INTEGER NOT NULL, 

    MEASUREMENT_VALUE FLOAT NOT NULL, 

    MEASUREMENT_DATE TIMESTAMP NOT NULL 
 
); 


INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (1, 'EEM', 'WH'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (2, 'EEM', 'WS'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (3, 'DSE', 'WH'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (4, 'DSE', 'WS'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (5, 'OLP', 'WH'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (6, 'OLP', 'WS'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (7, 'AAD', 'WH'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (8, 'AAD', 'WS'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (9, 'FEY', 'WH'); 

INSERT INTO HARBOUR.SENSORS (ID, LOCATION_CODE, MEASUREMENT_TYPE) VALUES (10, 'FEY', 'WS'); 
