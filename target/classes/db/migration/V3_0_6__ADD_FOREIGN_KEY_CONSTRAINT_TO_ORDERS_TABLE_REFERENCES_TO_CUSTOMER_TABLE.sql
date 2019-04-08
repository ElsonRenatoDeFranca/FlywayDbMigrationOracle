--Story: S000001 | 1.0 | [DB PREP] CREATE PRODUCT
--Description: Create an associative table that will holds many to many relationships between order and product.
--Author: Elsao boladao
--Date: 2019-01-03
--Error code reference: https://docs.oracle.com/cd/B10500_01/server.920/a96525/e900.htm

ALTER SESSION SET DDL_LOCK_TIMEOUT = 60;

DECLARE
  COUNT_TABLE_ORDERS PLS_INTEGER;
  COUNT_CUST_CONSTR_FK PLS_INTEGER;

  V_TABLE_NAME VARCHAR2(30) := 'ORDERS';
  V_SCHEMA_NAME VARCHAR2(30) := 'FLYWAYUSER';

  BEGIN

     SELECT COUNT(*) INTO COUNT_TABLE_ORDERS FROM ALL_TABLES WHERE TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

     /*IF(COUNT_TABLE_ORDERS > 0) THEN

        SELECT COUNT(*) INTO COUNT_TABLE_ORDERS FROM ALL_TAB_COLUMNS WHERE COLUMN_NAME ='fk_customer_key' AND TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

        IF(COUNT_PROD_CONSTR_FK = 0) THEN
          BEGIN
			      EXECUTE IMMEDIATE 'ALTER TABLE ' || V_SCHEMA_NAME || '.' || V_TABLE_NAME || ' ADD CONSTRAINT fk_customer_key FOREIGN KEY (CUST_ID) REFERENCES CUSTOMER(CUST_ID)';
			      EXCEPTION WHEN OTHERS THEN
			      IF SQLCODE != -00955 -- Name already used by an existing object (For more details refer to error code described at header);
				      THEN RAISE;
				    END IF;
		      END;
	      END IF;
	  END IF;

	  */

  END;
/

