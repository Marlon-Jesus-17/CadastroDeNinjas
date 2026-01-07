-- V2: Migrations para adicionar a coluna rank na tabela TB_CADASTRO

ALTER TABLE TB_CADASTRO
ADD COLUMN rank VARCHAR(255);