--
-- PostgreSQL database cluster dump
--

-- Started on 2015-04-23 15:36:42

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE "appUser";
ALTER ROLE "appUser" WITH NOSUPERUSER NOINHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION PASSWORD 'md5db523f52e41cdc210c6204067ffe9e08' VALID UNTIL 'infinity';
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION PASSWORD 'md5d4786e1f5a56293ab2966fc92ab5f58d';
CREATE ROLE tad;
ALTER ROLE tad WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN NOREPLICATION PASSWORD 'md5994ace1d12370ba7d190afb6c4b28719' VALID UNTIL 'infinity';






--
-- Database creation
--

CREATE DATABASE pharma WITH TEMPLATE = template0 OWNER = "appUser";
CREATE DATABASE tags WITH TEMPLATE = template0 OWNER = postgres;
REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect pharma

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-04-23 15:36:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 176 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1968 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 49234)
-- Name: roles; Type: TABLE; Schema: public; Owner: appUser; Tablespace: 
--

CREATE TABLE roles (
    id bigint NOT NULL,
    estado character varying(255) NOT NULL,
    fecha_creacion timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    usuario_ingreso character varying(45) NOT NULL,
    usuario_modificacion character varying(45) NOT NULL,
    descripcion character varying(512),
    nombre character varying(512) NOT NULL
);


ALTER TABLE public.roles OWNER TO "appUser";

--
-- TOC entry 170 (class 1259 OID 49232)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: appUser
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO "appUser";

--
-- TOC entry 1969 (class 0 OID 0)
-- Dependencies: 170
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: appUser
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 173 (class 1259 OID 49245)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: appUser; Tablespace: 
--

CREATE TABLE usuarios (
    id bigint NOT NULL,
    estado character varying(255) NOT NULL,
    fecha_creacion timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    usuario_ingreso character varying(45) NOT NULL,
    usuario_modificacion character varying(45) NOT NULL,
    apellido character varying(512) NOT NULL,
    clave character varying(128) NOT NULL,
    correo character varying(255) NOT NULL,
    nombre character varying(512) NOT NULL,
    telefono_fijo character varying(255),
    telefono_movil character varying(255),
    usuario character varying(50) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO "appUser";

--
-- TOC entry 172 (class 1259 OID 49243)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: appUser
--

CREATE SEQUENCE usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_seq OWNER TO "appUser";

--
-- TOC entry 1970 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: appUser
--

ALTER SEQUENCE usuarios_id_seq OWNED BY usuarios.id;


--
-- TOC entry 175 (class 1259 OID 49256)
-- Name: usuarios_roles; Type: TABLE; Schema: public; Owner: appUser; Tablespace: 
--

CREATE TABLE usuarios_roles (
    id bigint NOT NULL,
    estado character varying(255) NOT NULL,
    fecha_creacion timestamp without time zone NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL,
    usuario_ingreso character varying(45) NOT NULL,
    usuario_modificacion character varying(45) NOT NULL,
    rol bigint NOT NULL,
    usuario bigint NOT NULL
);


ALTER TABLE public.usuarios_roles OWNER TO "appUser";

--
-- TOC entry 174 (class 1259 OID 49254)
-- Name: usuarios_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: appUser
--

CREATE SEQUENCE usuarios_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_roles_id_seq OWNER TO "appUser";

--
-- TOC entry 1971 (class 0 OID 0)
-- Dependencies: 174
-- Name: usuarios_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: appUser
--

ALTER SEQUENCE usuarios_roles_id_seq OWNED BY usuarios_roles.id;


--
-- TOC entry 1837 (class 2604 OID 49237)
-- Name: id; Type: DEFAULT; Schema: public; Owner: appUser
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 1838 (class 2604 OID 49248)
-- Name: id; Type: DEFAULT; Schema: public; Owner: appUser
--

ALTER TABLE ONLY usuarios ALTER COLUMN id SET DEFAULT nextval('usuarios_id_seq'::regclass);


--
-- TOC entry 1839 (class 2604 OID 49259)
-- Name: id; Type: DEFAULT; Schema: public; Owner: appUser
--

ALTER TABLE ONLY usuarios_roles ALTER COLUMN id SET DEFAULT nextval('usuarios_roles_id_seq'::regclass);


--
-- TOC entry 1956 (class 0 OID 49234)
-- Dependencies: 171
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: appUser
--

COPY roles (id, estado, fecha_creacion, fecha_modificacion, usuario_ingreso, usuario_modificacion, descripcion, nombre) FROM stdin;
1	A	2015-03-10 14:28:00	2015-03-10 14:28:00	MLLERENA	MLLERENA	Administrador aplicativo	ADMINISTRADOR
6	A	2015-03-10 14:30:00	2015-03-10 14:30:00	MLLERENA	MLLERENA	Invitado aplicativo	INVITADO
13	A	2015-03-10 14:30:00	2015-03-10 14:30:00	MLLERENA	MLLERENA	Administrador dashboard	admin
14	A	2015-03-10 14:30:00	2015-03-10 14:30:00	MLLERENA	MLLERENA	Usuario Final dashboard	user
15	A	2015-03-10 14:30:00	2015-03-10 14:30:00	MLLERENA	MLLERENA	Operador aplicativo	OPERADOR
16	A	2015-03-10 14:30:00	2015-03-10 14:30:00	MLLERENA	MLLERENA	Supervisor Aplicativo	SUPERVISOR
\.


--
-- TOC entry 1972 (class 0 OID 0)
-- Dependencies: 170
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: appUser
--

SELECT pg_catalog.setval('roles_id_seq', 16, true);


--
-- TOC entry 1958 (class 0 OID 49245)
-- Dependencies: 173
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: appUser
--

COPY usuarios (id, estado, fecha_creacion, fecha_modificacion, usuario_ingreso, usuario_modificacion, apellido, clave, correo, nombre, telefono_fijo, telefono_movil, usuario) FROM stdin;
5	I	2015-03-10 17:56:27.125	2015-03-11 08:55:14.625	MLLERENA	MLLERENA	chavez	1	amontalvo@correo.com	Adrian			ACHAVEZ
4	I	2015-03-10 17:01:55.102	2015-03-11 08:55:46.551	MLLERENA	MLLERENA	chavez	1	amontalvo@correo.com	juan	22 2222222	11 11111111	JCHAVEZ
3	I	2015-03-10 16:59:04.297	2015-03-11 08:55:49.575	MLLERENA	MLLERENA	Leon	1	amontalvo@correo.com	Adrian			ALEON
6	I	2015-03-11 08:55:58.207	2015-03-13 14:02:13.314	MLLERENA	MLLERENA	chavez	1	amontalvo@correo.com	Adrian			ACHAVEZ
2	I	2015-03-10 16:02:51.267	2015-03-31 11:32:27.421	MLLERENA	MLLERENA	Montalvo	1	amontalvo@correo.com	Adrian	55 5555555	88 88888888	AMONTALV
1	A	2015-03-10 14:28:00	2015-03-31 11:34:40.557	MLLERENA	MLLERENA	LLERENA	1	MLLERENA@CORREO.COM	EMILIO		11 11111111	MLLERENA
7	A	2015-03-31 11:35:19.746	2015-03-31 11:35:19.746	MLLERENA	MLLERENA	Lopez	1	jlopez@correo.com	Jose			JLOPEZ
8	A	2015-04-13 18:06:43.681	2015-04-17 16:53:32.986	MLLERENA	MLLERENA	PER1	1	jvera@correo.com	OMAR			OPER1
9	A	2015-04-17 16:53:56.129	2015-04-17 16:53:56.129	MLLERENA	MLLERENA	AL1	1	jlopez@correo.com	CARLOS			CAL1
\.


--
-- TOC entry 1973 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: appUser
--

SELECT pg_catalog.setval('usuarios_id_seq', 9, true);


--
-- TOC entry 1960 (class 0 OID 49256)
-- Dependencies: 175
-- Data for Name: usuarios_roles; Type: TABLE DATA; Schema: public; Owner: appUser
--

COPY usuarios_roles (id, estado, fecha_creacion, fecha_modificacion, usuario_ingreso, usuario_modificacion, rol, usuario) FROM stdin;
3	I	2015-03-13 14:02:34.755	2015-03-13 14:02:39.131	MLLERENA	MLLERENA	1	2
4	A	2015-03-13 14:03:00.932	2015-03-13 14:03:00.932	MLLERENA	MLLERENA	6	2
2	I	2015-03-13 13:54:56.725	2015-03-13 13:56:28.472	MLLERENA	MLLERENA	1	6
6	I	2015-03-31 10:46:02.887	2015-03-31 10:46:40.821	MLLERENA	MLLERENA	1	1
5	I	2015-03-10 14:30:00	2015-03-31 11:24:05.035	MLLERENA	MLLERENA	6	1
7	I	2015-03-31 11:24:44.141	2015-03-31 11:31:01.007	MLLERENA	MLLERENA	6	1
1	I	2015-03-10 14:30:00	2015-03-31 11:33:03.822	MLLERENA	MLLERENA	1	1
8	A	2015-03-31 11:33:14.926	2015-03-31 11:33:37.026	MLLERENA	MLLERENA	1	1
9	I	2015-03-31 11:36:10.172	2015-03-31 11:37:24.038	MLLERENA	MLLERENA	6	7
10	A	2015-03-31 11:37:46.941	2015-03-31 11:37:46.941	MLLERENA	MLLERENA	6	7
11	A	2015-03-31 11:37:46.941	2015-03-31 11:37:46.941	MLLERENA	MLLERENA	13	1
12	A	2015-03-31 11:37:46.941	2015-03-31 11:37:46.941	MLLERENA	MLLERENA	14	7
13	A	2015-04-13 18:06:52.033	2015-04-13 18:06:52.033	MLLERENA	MLLERENA	15	8
14	A	2015-04-17 16:54:02.519	2015-04-17 16:54:02.519	MLLERENA	MLLERENA	16	9
\.


--
-- TOC entry 1974 (class 0 OID 0)
-- Dependencies: 174
-- Name: usuarios_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: appUser
--

SELECT pg_catalog.setval('usuarios_roles_id_seq', 14, true);


--
-- TOC entry 1841 (class 2606 OID 49242)
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: appUser; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 1843 (class 2606 OID 49253)
-- Name: usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: appUser; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 1845 (class 2606 OID 49261)
-- Name: usuarios_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: appUser; Tablespace: 
--

ALTER TABLE ONLY usuarios_roles
    ADD CONSTRAINT usuarios_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 1847 (class 2606 OID 49267)
-- Name: fk_24u0h7c9s7w879p8qxrdxrpsg; Type: FK CONSTRAINT; Schema: public; Owner: appUser
--

ALTER TABLE ONLY usuarios_roles
    ADD CONSTRAINT fk_24u0h7c9s7w879p8qxrdxrpsg FOREIGN KEY (usuario) REFERENCES usuarios(id);


--
-- TOC entry 1846 (class 2606 OID 49262)
-- Name: fk_a4idq8a34d28sxd61wlin8431; Type: FK CONSTRAINT; Schema: public; Owner: appUser
--

ALTER TABLE ONLY usuarios_roles
    ADD CONSTRAINT fk_a4idq8a34d28sxd61wlin8431 FOREIGN KEY (rol) REFERENCES roles(id);


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-04-23 15:36:42

--
-- PostgreSQL database dump complete
--

\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-04-23 15:36:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1929 (class 1262 OID 12029)
-- Dependencies: 1928
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 170 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1932 (class 0 OID 0)
-- Dependencies: 170
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-04-23 15:36:42

--
-- PostgreSQL database dump complete
--

\connect tags

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-04-23 15:36:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 170 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 170
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1930 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-04-23 15:36:42

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-04-23 15:36:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1929 (class 1262 OID 1)
-- Dependencies: 1928
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 170 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1932 (class 0 OID 0)
-- Dependencies: 170
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-04-23 15:36:42

--
-- PostgreSQL database dump complete
--

-- Completed on 2015-04-23 15:36:42

--
-- PostgreSQL database cluster dump complete
--

