ALTER TABLE FLYWAYUSER.CART_PRODUCT ADD CONSTRAINT fk_cart_foreign_key FOREIGN KEY (CART_ID) REFERENCES CART(CART_ID);
