ALTER TABLE FLYWAYUSER.CART_PRODUCT ADD CONSTRAINT fk_product_foreign_key FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID);
