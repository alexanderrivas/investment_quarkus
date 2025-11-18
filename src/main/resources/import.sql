-- This file allow to write SQL commands that will be emitted in test and dev.
-- Populating the 'produto' table with initial data

insert into produto (id, nome, tipo, rentabilidade, risco) values (101, 'CDB Caixa 2026', 'CDB', 0.12, 'Baixo');
insert into produto (id, nome, tipo, rentabilidade, risco) values (102, 'LCI Banco do Brasil 2025', 'LCI', 0.10, 'Baixo');
insert into produto (id, nome, tipo, rentabilidade, risco) values (103, 'Fundo Imobiliário XPTO', 'Fundo Imobiliário', 0.08, 'Medio');
insert into produto (id, nome, tipo, rentabilidade, risco) values (104, 'Ações Petrobras', 'Ações', 0.20, 'Alto');
insert into produto (id, nome, tipo, rentabilidade, risco) values (105, 'Tesouro Selic 2024', 'Tesouro Direto', 0.06, 'Baixo');
insert into produto (id, nome, tipo, rentabilidade, risco) values (106, 'Debêntures Empresa XYZ', 'Debêntures', 0.15, 'Medio');
insert into produto (id, nome, tipo, rentabilidade, risco) values (107, 'Fundo Multimercado ABC', 'Fundo Multimercado', 0.18, 'Alto');

-- investimento example
--"id": 1,
-- "clienteId": 123,
-- "tipo": "CDB",
-- "valor": 5000.00,
-- "rentabilidade": 0.12,
-- "data": "2025-01-15"

insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (2, 124, 'LCI', 7000.00, 0.10, '2025-02-10');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (3, 125, 'Fundo Imobiliário', 3000.00, 0.08, '2025-03-05');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (4, 126, 'Ações', 12000.00, 0.20, '2025-04-20');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (5, 123, 'Tesouro Direto', 2500.00, 0.06, '2025-05-15');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (6, 124, 'Debêntures', 8000.00, 0.15, '2025-06-10');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (7, 125, 'Fundo Multimercado', 6000.00, 0.18, '2025-07-01');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (8, 126, 'CDB', 4000.00, 0.12, '2025-08-12');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (9, 123, 'LCI', 3500.00, 0.10, '2025-09-03');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (10, 124, 'Fundo Imobiliário', 9000.00, 0.08, '2025-10-22');
insert into investimentos (id, cliente_id, tipo, valor, rentabilidade, data) values (11, 125, 'Ações', 15000.00, 0.20, '2025-11-30');

