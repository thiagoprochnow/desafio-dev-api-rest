ALTER TABLE public.accounts
    ADD CONSTRAINT fk_pessoa 
    FOREIGN KEY ("idPessoa")
    REFERENCES public."users" ("idPessoa");