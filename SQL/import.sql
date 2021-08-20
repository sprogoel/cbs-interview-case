-- DROP TABLE cbs.movie_showing CASCADE;
-- DROP TABLE cbs.reservation CASCADE;

-- DROP SEQUENCE cbs.movie_showing_id_seq;
-- DROP SEQUENCE cbs.reservation_id_seq;


CREATE SEQUENCE cbs.movie_showing_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS cbs.movie_showing
(
    id integer NOT NULL DEFAULT nextval('cbs.movie_showing_id_seq'::regclass),
    date timestamp with time zone NOT NULL,
    title text NOT NULL,
    CONSTRAINT movie_showing_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE cbs.reservation_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS cbs.reservation
(
    id integer NOT NULL DEFAULT nextval('cbs.reservation_id_seq'::regclass),
    movie_showing_id integer NOT NULL,
    reservation_time timestamp with time zone NOT NULL,
    seat_count integer,
    CONSTRAINT reservation_pkey PRIMARY KEY (id),
    CONSTRAINT fk_movie_showing_id FOREIGN KEY (movie_showing_id)
        REFERENCES cbs.movie_showing (id) ON DELETE CASCADE
);


INSERT INTO cbs.movie_showing (id, date, title) VALUES (nextval('cbs.movie_showing_id_seq'),'2021-08-17 10:00:00', 'Gladiator');
INSERT INTO cbs.movie_showing (id, date, title) VALUES (nextval('cbs.movie_showing_id_seq'),'2021-08-17 15:00:00', 'Inception');
INSERT INTO cbs.movie_showing (id, date, title) VALUES (nextval('cbs.movie_showing_id_seq'),'2021-08-18 10:00:00', 'Alien');
INSERT INTO cbs.movie_showing (id, date, title) VALUES (nextval('cbs.movie_showing_id_seq'),'2021-08-18 15:00:00', 'The Godfather');
INSERT INTO cbs.movie_showing (id, date, title) VALUES (nextval('cbs.movie_showing_id_seq'),'2021-08-18 21:00:00', 'Terminator');