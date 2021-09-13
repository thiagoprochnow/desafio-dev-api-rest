CREATE TABLE public.transactions
(
    "idTransacao" bigint NOT NULL,
    "idConta" bigint NOT NULL,
    "valor" double precision NOT NULL,
    "dataTransacao" date NOT NULL,
    PRIMARY KEY ("idTransacao")
);