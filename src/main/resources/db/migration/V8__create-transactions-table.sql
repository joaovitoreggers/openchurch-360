CREATE TABLE transactions (
                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             amount DECIMAL NOT NULL,
                             description TEXT,
                             date DATE NOT NULL,
                             member_id UUID NOT NULL,
                             transaction_category_id UUID NOT NULL,
                             payment_method_id UUID NOT NULL,
                             active BOOLEAN NOT NULL,
                             CONSTRAINT fk_member FOREIGN KEY (member_id) REFERENCES member(id),
                             CONSTRAINT fk_category FOREIGN KEY (transaction_category_id) REFERENCES transaction_categories(id),
                             CONSTRAINT fk_payment FOREIGN KEY (payment_method_id) REFERENCES payment_methods(id)
);