CREATE TABLE department_member(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    member_id UUID NOT NULL,
    active BOOLEAN NOT NULL,
    department_id UUID NOT NULL
);