ALTER TABLE public.transactions
    ADD CONSTRAINT fk_conta 
    FOREIGN KEY ("idConta")
    REFERENCES public."accounts" ("idConta");