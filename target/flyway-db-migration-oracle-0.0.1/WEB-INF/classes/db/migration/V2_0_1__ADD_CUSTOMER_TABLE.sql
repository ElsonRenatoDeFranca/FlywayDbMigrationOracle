--Story: S000001 | 1.0 | [DB PREP] CREATE_CUSTOMER
--Description: Create a new customer at the FLYWAY.CUSTOMER.
--Author: Elsao boladao
--Date: 2019-01-03
--Error code reference: https://docs.oracle.com/cd/B10500_01/server.920/a96525/e900.htm

ALTER SESSION SET DDL_LOCK_TIMEOUT = 60;

DECLARE
  COUNT_TABLE_CUSTOMER PLS_INTEGER;
  COUNT_CUSTOMER_ID PLS_INTEGER;

  V_TABLE_NAME VARCHAR2(30) := 'CUSTOMER';
  V_SCHEMA_NAME VARCHAR2(30) := 'FLYWAYUSER';

  BEGIN
     SELECT COUNT(*) INTO COUNT_TABLE_CUSTOMER FROM ALL_TABLES WHERE TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

     IF(COUNT_TABLE_CUSTOMER = 0) THEN
       BEGIN
			   EXECUTE IMMEDIATE 'CREATE TABLE ' || V_SCHEMA_NAME || '.' || V_TABLE_NAME ||
			   '( ID NUMBER (10,0) NOT NULL' || ',' ||
			   ' CUST_NAME NUMBER (10,0) NOT NULL' || ',' ||
			   ' CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY(ID))';

			   EXCEPTION WHEN OTHERS THEN
			       IF SQLCODE != -00955 -- Name already used by an existing object (For more details refer to error code described at header);
				      THEN RAISE;
				     END IF;
		   END;
	  END IF;
  END;
/

--CREATE TABLE FLYWAYUSER.CART(
--     ID NUMBER (10,0) NOT NULL,
--     CONSTRAINT "CART_ID_PK" PRIMARY KEY ("ID")
--);