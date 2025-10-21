CREATE TABLE transaction_categories(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    transaction_type VARCHAR(30),
    active BOOLEAN NOT NULL
);