--Story: S000001 | 2.0 | [DB PREP] CUSTOMER UPDATE SCRIPT
--Description: Add the new column CUST_LAST_NAME at the FLYWAYUSER.CUSTOMER table in order to save customer information.
--Author: e000001 Elsao Boladao
--Date: 2019-05-03


ALTER TABLE FLYWAYUSER.CUSTOMER ADD CUST_LAST_NAME VARCHAR2(30) NOT NULL;
