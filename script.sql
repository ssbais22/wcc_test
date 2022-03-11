DROP TABLE IF EXISTS public.postcodelatlng;

CREATE TABLE IF NOT EXISTS public.postcodelatlng
(
    postcode character varying(10) COLLATE pg_catalog."default" NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL
)
