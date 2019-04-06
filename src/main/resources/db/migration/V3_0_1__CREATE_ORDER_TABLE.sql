--Story: S000002 | 1.0 | [DB PREP] CREATE_ORDER
--Description: Create a new cart at the FLYWAYUSER.ORDER.
--Author: Elsao boladao
--Date: 2019-04-03
--Error code reference: https://docs.oracle.com/cd/B10500_01/server.920/a96525/e900.htm

ALTER SESSION SET DDL_LOCK_TIMEOUT = 60;

DECLARE
  COUNT_TABLE_ORDERS PLS_INTEGER;

  V_TABLE_NAME VARCHAR2(30) := 'ORDERS';
  V_SCHEMA_NAME VARCHAR2(30) := 'FLYWAYUSER';

  BEGIN
     SELECT COUNT(*) INTO COUNT_TABLE_ORDERS FROM ALL_TABLES WHERE TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

     IF(COUNT_TABLE_ORDERS = 0) THEN

       BEGIN

			   --EXECUTE IMMEDIATE 'CREATE TABLE ' || V_SCHEMA_NAME || '.' || V_TABLE_NAME || '( ID NUMBER (10,0) NOT NULL, CONSTRAINT ORDER_ID_PK PRIMARY KEY(ID))';
			   EXECUTE IMMEDIATE 'CREATE TABLE ' || V_SCHEMA_NAME || '.' || V_TABLE_NAME || '( ID NUMBER (10,0) NOT NULL)';

			   EXCEPTION WHEN OTHERS THEN
			       IF SQLCODE != -00955 -- Name already used by an existing object (For more details refer to error code described at header);
				      THEN RAISE;
				     END IF;
		   END;
	  END IF;
  END;
/
