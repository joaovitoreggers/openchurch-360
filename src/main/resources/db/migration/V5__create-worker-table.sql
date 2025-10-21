CREATE TABLE worker(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    active BOOLEAN NOT NULL,
    member_id UUID NOT NULL
);