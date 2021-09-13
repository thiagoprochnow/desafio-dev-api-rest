CREATE TABLE public.accounts
(
    "idConta" bigint NOT NULL,
    "idPessoa" bigint NOT NULL,
    "saldo" double precision NOT NULL,
    "limiteSaqueDiario" double precision,
    "flagAtivo" boolean NOT NULL,
    "tipoConta" integer NOT NULL,
    "dataCriacao" date NOT NULL,
    PRIMARY KEY ("idConta")
);