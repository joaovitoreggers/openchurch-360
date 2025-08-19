CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE users (
                       id             UUID          PRIMARY KEY DEFAULT gen_random_uuid(),
                       name           VARCHAR(255)  NOT NULL,
                       email          VARCHAR(255)  NOT NULL UNIQUE,
                       password_hash  VARCHAR(400)  NOT NULL,
                       active         BOOLEAN       NOT NULL DEFAULT TRUE,
                       created_at     TIMESTAMPTZ   NOT NULL DEFAULT now(),
                       updated_at     TIMESTAMPTZ   NULL
);