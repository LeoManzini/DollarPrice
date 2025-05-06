CREATE TABLE IF NOT EXISTS realtime (
	quote_id BIGSERIAL PRIMARY KEY,
	code VARCHAR(3) NOT NULL,
	codein VARCHAR(3) NOT NULL,
	price NUMERIC(15,2) NOT NULL,
    date_time VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS history (
	quote_id BIGSERIAL PRIMARY KEY,
	variation NUMERIC(15,2) NOT NULL,
	price NUMERIC(15,2) NOT NULL,
    date_time VARCHAR(20) NOT NULL
);

postgres://
ztenuchkszlxfu
:
77e3646678c652acf70257bff0284e85db9d9466b778b429b47a43282f7c9844
@
ec2-44-194-225-27.compute-1.amazonaws.com
:
5432
/
d5514lvi8kvlj1