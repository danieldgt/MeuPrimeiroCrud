--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.9
-- Dumped by pg_dump version 9.4.9
-- Started on 2017-05-11 10:11:49

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 179 (class 1259 OID 17396)
-- Name: contem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE contem (
    id_prato integer NOT NULL,
    id_produto integer NOT NULL
);


ALTER TABLE contem OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 17411)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pedido (
    id_prato integer NOT NULL,
    id_usuario integer NOT NULL,
    data_hora timestamp without time zone NOT NULL
);


ALTER TABLE pedido OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 17352)
-- Name: prato; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prato (
    id_prato integer NOT NULL,
    descricao character varying(100),
    nome_prato character varying(100),
    preco numeric(5,2)
);


ALTER TABLE prato OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 17350)
-- Name: prato_id_prato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prato_id_prato_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE prato_id_prato_seq OWNER TO postgres;

--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 175
-- Name: prato_id_prato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prato_id_prato_seq OWNED BY prato.id_prato;


--
-- TOC entry 178 (class 1259 OID 17360)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE produto (
    id_produto integer NOT NULL,
    nome_produto character varying(100)
);


ALTER TABLE produto OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 17358)
-- Name: produto_id_produto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produto_id_produto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE produto_id_produto_seq OWNER TO postgres;

--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 177
-- Name: produto_id_produto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produto_id_produto_seq OWNED BY produto.id_produto;


--
-- TOC entry 174 (class 1259 OID 17344)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    nome character varying(100),
    email character varying(100),
    login character varying(100)
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 17342)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 173
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id_usuario;


--
-- TOC entry 1902 (class 2604 OID 17355)
-- Name: id_prato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prato ALTER COLUMN id_prato SET DEFAULT nextval('prato_id_prato_seq'::regclass);


--
-- TOC entry 1903 (class 2604 OID 17363)
-- Name: id_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produto ALTER COLUMN id_produto SET DEFAULT nextval('produto_id_produto_seq'::regclass);


--
-- TOC entry 1901 (class 2604 OID 17347)
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_id_usuario_seq'::regclass);


--
-- TOC entry 2033 (class 0 OID 17396)
-- Dependencies: 179
-- Data for Name: contem; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY contem (id_prato, id_produto) FROM stdin;
25	5
25	14
25	15
20	2
20	3
20	15
26	5
26	13
\.


--
-- TOC entry 2034 (class 0 OID 17411)
-- Dependencies: 180
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido (id_prato, id_usuario, data_hora) FROM stdin;
20	2	2017-05-11 08:52:46.935
25	2	2017-05-11 08:52:46.935
25	3	2017-05-11 08:52:46.935
\.


--
-- TOC entry 2030 (class 0 OID 17352)
-- Dependencies: 176
-- Data for Name: prato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prato (id_prato, descricao, nome_prato, preco) FROM stdin;
25	Com queijo e mostarda	Hamburguer	7.00
20	Com molho e tudo.	Cachorro-Quente	5.00
26	asf	AV	3.60
\.


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 175
-- Name: prato_id_prato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prato_id_prato_seq', 26, true);


--
-- TOC entry 2032 (class 0 OID 17360)
-- Dependencies: 178
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY produto (id_produto, nome_produto) FROM stdin;
5	Carne
2	Mostarda
3	Salsicha
11	Maçã
12	Macarrão
13	Pimenta
14	Pão
15	Queijo
1	Arroz2
\.


--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 177
-- Name: produto_id_produto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produto_id_produto_seq', 15, true);


--
-- TOC entry 2028 (class 0 OID 17344)
-- Dependencies: 174
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id_usuario, nome, email, login) FROM stdin;
2	Felipe	felipe.ja.maia@gmail.com	felipemaia
3	Roberto	rob@gmail.com	rob1
\.


--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 173
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 3, true);


--
-- TOC entry 1911 (class 2606 OID 17400)
-- Name: contem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY contem
    ADD CONSTRAINT contem_pkey PRIMARY KEY (id_prato, id_produto);


--
-- TOC entry 1913 (class 2606 OID 17415)
-- Name: pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id_prato, id_usuario, data_hora);


--
-- TOC entry 1907 (class 2606 OID 17357)
-- Name: prato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prato
    ADD CONSTRAINT prato_pkey PRIMARY KEY (id_prato);


--
-- TOC entry 1909 (class 2606 OID 17365)
-- Name: produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);


--
-- TOC entry 1905 (class 2606 OID 17349)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 1914 (class 2606 OID 17401)
-- Name: contem_id_prato_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contem
    ADD CONSTRAINT contem_id_prato_fkey FOREIGN KEY (id_prato) REFERENCES prato(id_prato);


--
-- TOC entry 1915 (class 2606 OID 17406)
-- Name: contem_id_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contem
    ADD CONSTRAINT contem_id_produto_fkey FOREIGN KEY (id_produto) REFERENCES produto(id_produto);


--
-- TOC entry 1916 (class 2606 OID 17416)
-- Name: pedido_id_prato_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_id_prato_fkey FOREIGN KEY (id_prato) REFERENCES prato(id_prato);


--
-- TOC entry 1917 (class 2606 OID 17421)
-- Name: pedido_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-05-11 10:11:50

--
-- PostgreSQL database dump complete
--

