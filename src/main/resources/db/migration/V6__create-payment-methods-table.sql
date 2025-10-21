CREATE TABLE payment_methods(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    active BOOLEAN NOT NULL
);