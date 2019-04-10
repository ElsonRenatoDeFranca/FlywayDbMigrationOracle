--Story: S000002 - 1 - CREATE A NEW SEQUENCE FOR CUSTOMER PRIMARY KEY
-------------------------------------------------------
--Description: create a new customer sequence
--Author: e00001 - Elsao boladao
--Date: 2010-03-25
--Oracle Documentation: https://docs.oracle.com/cd/B10500_01/server.920/a96525/e2100.htm

---------------------------------------------------------------------------------------
-- Create sequence for CART primary key
---------------------------------------------------------------------------------------

-- Drop the SEQUENCE if it exists, absorb the not found exception

BEGIN
  EXECUTE IMMEDIATE 'DROP SEQUENCE FLYWAYUSER.CUST_SEQ';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -2289 THEN -- ORA-02289 sequence does not exist
      RAISE;
    END IF;
END;
/

CREATE SEQUENCE  "FLYWAYUSER"."CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
