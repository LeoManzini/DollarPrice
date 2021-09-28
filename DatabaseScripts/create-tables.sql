CREATE TABLE IF NOT EXISTS realtime (
	quote_id BIGSERIAL PRIMARY KEY,
	code VARCHAR(3) NOT NULL,
	codein VARCHAR(3) NOT NULL,
	bid NUMERIC(15,2) NOT NULL,
    stamp VARCHAR(20) NOT NULL
);