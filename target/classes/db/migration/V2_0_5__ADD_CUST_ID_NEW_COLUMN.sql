--Story: S000002 | 2.0 | [DB PREP] ADD RELATIONSHIP BETWEEN CUSTOMER AND ORDERS
--Description: Add the new column CUST_FIRST_NAME at the FLYWAYUSER.CUSTOMER table in order to save customer information.
--Author: e000001 Elsao Boladao
--Date: 2019-04-03


ALTER SESSION SET DDL_LOCK_TIMEOUT = 60;

DECLARE
  COUNT_TBL_CUSTOMER PLS_INTEGER;
  COUNT_CUST_ID PLS_INTEGER;
  COUNT_COMMENT_CUST_ID PLS_INTEGER;

  V_TABLE_NAME VARCHAR2(30) := 'CUSTOMER';
  V_SCHEMA_NAME VARCHAR2(30) := 'FLYWAYUSER';
  V_CUST_ID VARCHAR2(30) := 'CUST_ID';

  BEGIN

      SELECT COUNT(*) INTO COUNT_TBL_CUSTOMER FROM ALL_TABLES WHERE TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

      IF (COUNT_TBL_CUSTOMER > 0) THEN

        SELECT COUNT(*) INTO COUNT_CUST_ID FROM ALL_TAB_COLUMNS WHERE COLUMN_NAME = V_CUST_ID
        AND TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

        IF(COUNT_CUST_ID = 0) THEN
          BEGIN
              EXECUTE IMMEDIATE 'ALTER TABLE ' || V_SCHEMA_NAME || '.' || V_TABLE_NAME ||  ' ADD ' || V_CUST_ID || ' NUMBER (10,0) NOT NULL';

              EXCEPTION WHEN OTHERS THEN
              IF SQLCODE != -1430
				        THEN RAISE;
			        END IF;
          END;

        END IF;

        SELECT COUNT(*) INTO COUNT_COMMENT_CUST_ID FROM ALL_COL_COMMENTS WHERE COLUMN_NAME = V_CUST_ID
        AND TABLE_NAME = V_TABLE_NAME AND OWNER = V_SCHEMA_NAME;

        IF(COUNT_COMMENT_CUST_ID = 0) THEN
          BEGIN
              EXECUTE IMMEDIATE 'COMMENT ON COLUMN CUSTOMER.CUST_ID IS ''Customer first name description'';';

              EXCEPTION WHEN OTHERS THEN
                IF SQLCODE != -32594
				            THEN RAISE;
			          END IF;
          END;

        END IF;
      END IF;



  END;


/

