CREATE TABLE item
(
    id          UUID,
    description TEXT      NOT NULL,
    created_at  TIMESTAMP NOT NULL,
    updated_at  TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);