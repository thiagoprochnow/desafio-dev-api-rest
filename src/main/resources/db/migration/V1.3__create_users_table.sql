CREATE TABLE public.users
(
    "idPessoa" bigint NOT NULL,
    "nome" text NOT NULL,
    "cpf" text NOT NULL,
    "dataNascimento" date NOT NULL,
    PRIMARY KEY ("idPessoa")
);

INSERT INTO public.users("idPessoa", "nome", "cpf", "dataNascimento") VALUES ('1', 'Thiago', '123.456.789-00', '1990-10-10');
INSERT INTO public.users("idPessoa", "nome", "cpf", "dataNascimento") VALUES ('2', 'Willian', '987.654.321-00', '1987-03-05');
INSERT INTO public.users("idPessoa", "nome", "cpf", "dataNascimento") VALUES ('3', 'Lucas', '567.123.789-00', '1988-01-07');