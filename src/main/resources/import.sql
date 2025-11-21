
-- | Classe de Ativo                     | Exemplo de Produto                     | Pontuação de Risco (1-10) |
-- |-------------------------------------|----------------------------------------|---------------------------:|
-- | Renda Fixa Pós (Liquidez)           | Tesouro Selic, CDB 100% CDI            | 1                         |
-- | Renda Fixa Pós (Crédito)            | CDB Banco Médio, LCI/LCA               | 3                         |
-- | Renda Fixa Inflação                 | Tesouro IPCA+ (curto)                  | 4                         |
-- | Fundos Imobiliários (FIIs)          | IFIX                                   | 6                         |
-- | Renda Fixa Pré-fixado               | Tesouro Pré-fixado                     | 7                         |
-- | Fundos Multimercado                 | (Depende da estratégia)                | 5-8                       |
-- | Ações (Blue Chips)                  | VALE3, PETR4, ITUB4                    | 8                         |
-- | Ações (Small Caps)                  | MGLU3, VIIA3                           | 9                         |
-- | Criptomoedas / Opções               | BTC, ETH, Calls/Puts                   | 10                        |

-- Níveis de Perfil:
--Conservador: 1.0 a 3.9
--Moderado: 4.0 a 6.9
--Agressivo: 7.0 a 10.0

insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (101, 'CDB Caixa 2026', 'CDB', 0.12, 'BAIXO', 1);
insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (102, 'LCI Banco do Brasil 2025', 'LCI', 0.10, 'BAIXO', 3);
insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (103, 'Fundo Imobiliário XPTO', 'Fundo Imobiliario', 0.08, 'MEDIO', 6);
insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (104, 'Ações Petrobras', 'Ações', 0.20, 'ALTO', 8);
insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (105, 'Tesouro Selic 2024', 'Tesouro Direto', 0.06, 'BAIXO', 1);
insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (106, 'Debêntures Empresa XYZ', 'Debêntures', 0.15, 'MEDIO' , 5);
insert into produto (id, nome, tipo, rentabilidade, risco, pontuacao_risco) values (107, 'Fundo Multimercado ABC', 'Fundo Multimercado', 0.18, 'ALTO' , 7);


insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (3, 124, 102, 2250.00, 0.10, '2025-02-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (4, 125, 103, 3500.00, 0.08, '2025-03-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (5, 126, 104, 4750.00, 0.20, '2025-04-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (6, 123, 105, 5000.00, 0.06, '2025-05-05');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (7, 124, 106, 6250.00, 0.15, '2025-06-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (8, 125, 107, 7500.00, 0.18, '2025-07-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (9, 126, 101, 8750.00, 0.12, '2025-08-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (10, 123, 102, 9000.00, 0.10, '2025-09-09');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (11, 124, 103, 10250.00, 0.08, '2025-10-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (12, 125, 104, 11500.00, 0.20, '2025-11-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (13, 126, 105, 12750.00, 0.06, '2025-12-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (15, 124, 107, 14250.00, 0.18, '2025-02-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (16, 125, 101, 15500.00, 0.12, '2025-03-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (17, 126, 102, 16750.00, 0.10, '2025-04-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (18, 123, 103, 17000.00, 0.08, '2025-05-17');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (19, 124, 104, 18250.00, 0.20, '2025-06-18');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (20, 125, 105, 19500.00, 0.06, '2025-07-19');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (21, 126, 106, 20750.00, 0.15, '2025-08-20');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (22, 123, 107, 1000.00, 0.18, '2025-09-21');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (23, 124, 101, 2250.00, 0.12, '2025-10-22');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (24, 125, 102, 3500.00, 0.10, '2025-11-23');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (25, 126, 103, 4750.00, 0.08, '2025-12-24');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (26, 123, 104, 5000.00, 0.20, '2025-01-25');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (27, 124, 105, 6250.00, 0.06, '2025-02-26');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (28, 125, 106, 7500.00, 0.15, '2025-03-27');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (29, 126, 107, 8750.00, 0.18, '2025-04-28');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (31, 124, 102, 10250.00, 0.10, '2025-06-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (32, 125, 103, 11500.00, 0.08, '2025-07-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (33, 126, 104, 12750.00, 0.20, '2025-08-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (35, 124, 106, 14250.00, 0.15, '2025-10-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (36, 125, 107, 15500.00, 0.18, '2025-11-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (37, 126, 101, 16750.00, 0.12, '2025-12-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (39, 124, 103, 18250.00, 0.08, '2025-02-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (40, 125, 104, 19500.00, 0.20, '2025-03-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (41, 126, 105, 20750.00, 0.06, '2025-04-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (43, 124, 107, 2250.00, 0.18, '2025-06-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (44, 125, 101, 3500.00, 0.12, '2025-07-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (45, 126, 102, 4750.00, 0.10, '2025-08-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (46, 123, 103, 5000.00, 0.08, '2025-09-17');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (47, 124, 104, 6250.00, 0.20, '2025-10-18');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (48, 125, 105, 7500.00, 0.06, '2025-11-19');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (49, 126, 106, 8750.00, 0.15, '2025-12-20');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (50, 123, 107, 9000.00, 0.18, '2025-01-21');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (51, 124, 101, 10250.00, 0.12, '2025-02-22');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (52, 125, 102, 11500.00, 0.10, '2025-03-23');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (53, 126, 103, 12750.00, 0.08, '2025-04-24');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (54, 123, 104, 13000.00, 0.20, '2025-05-25');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (55, 124, 105, 14250.00, 0.06, '2025-06-26');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (56, 125, 106, 15500.00, 0.15, '2025-07-27');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (57, 126, 107, 16750.00, 0.18, '2025-08-28');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (59, 124, 102, 18250.00, 0.10, '2025-10-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (60, 125, 103, 19500.00, 0.08, '2025-11-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (61, 126, 104, 20750.00, 0.20, '2025-12-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (62, 123, 105, 1000.00, 0.06, '2025-01-05');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (63, 124, 106, 2250.00, 0.15, '2025-02-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (64, 125, 107, 3500.00, 0.18, '2025-03-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (65, 126, 101, 4750.00, 0.12, '2025-04-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (67, 124, 103, 6250.00, 0.08, '2025-06-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (68, 125, 104, 7500.00, 0.20, '2025-07-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (69, 126, 105, 8750.00, 0.06, '2025-08-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (71, 124, 107, 10250.00, 0.18, '2025-10-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (72, 125, 101, 11500.00, 0.12, '2025-11-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (73, 126, 102, 12750.00, 0.10, '2025-12-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (74, 123, 103, 13000.00, 0.08, '2025-01-17');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (75, 124, 104, 14250.00, 0.20, '2025-02-18');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (76, 125, 105, 15500.00, 0.06, '2025-03-19');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (77, 126, 106, 16750.00, 0.15, '2025-04-20');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (78, 123, 107, 17000.00, 0.18, '2025-05-21');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (79, 124, 101, 18250.00, 0.12, '2025-06-22');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (80, 125, 102, 19500.00, 0.10, '2025-07-23');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (81, 126, 103, 20750.00, 0.08, '2025-08-24');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (82, 123, 104, 1000.00, 0.20, '2025-09-25');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (83, 124, 105, 2250.00, 0.06, '2025-10-26');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (84, 125, 106, 3500.00, 0.15, '2025-11-27');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (85, 126, 107, 4750.00, 0.18, '2025-12-28');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (86, 123, 101, 5000.00, 0.12, '2025-01-01');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (87, 124, 102, 6250.00, 0.10, '2025-02-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (88, 125, 103, 7500.00, 0.08, '2025-03-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (89, 126, 104, 8750.00, 0.20, '2025-04-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (90, 123, 105, 9000.00, 0.06, '2025-05-05');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (91, 124, 106, 10250.00, 0.15, '2025-06-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (92, 125, 107, 11500.00, 0.18, '2025-07-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (93, 126, 101, 12750.00, 0.12, '2025-08-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (95, 124, 103, 14250.00, 0.08, '2025-10-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (96, 125, 104, 15500.00, 0.20, '2025-11-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (97, 126, 105, 16750.00, 0.06, '2025-12-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (98, 123, 106, 17000.00, 0.15, '2025-01-13');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (99, 124, 107, 18250.00, 0.18, '2025-02-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (100, 125, 101, 19500.00, 0.12, '2025-03-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (101, 126, 102, 20750.00, 0.10, '2025-04-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (201, 124, 106, 2250.00, 0.15, '2025-02-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (202, 125, 104, 3500.00, 0.20, '2025-03-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (203, 126, 103, 4750.00, 0.08, '2025-04-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (205, 124, 106, 6250.00, 0.15, '2025-06-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (206, 125, 104, 7500.00, 0.20, '2025-07-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (207, 126, 105, 8750.00, 0.06, '2025-08-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (208, 123, 103, 9000.00, 0.08, '2025-09-09');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (209, 124, 106, 10250.00, 0.15, '2025-10-10');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (210, 125, 104, 1000.00, 0.20, '2025-11-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (211, 126, 102, 2250.00, 0.10, '2025-12-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (212, 123, 105, 3500.00, 0.06, '2025-01-13');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (213, 124, 106, 4750.00, 0.15, '2025-02-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (214, 125, 104, 5000.00, 0.20, '2025-03-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (215, 126, 101, 6250.00, 0.12, '2025-04-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (217, 124, 106, 8750.00, 0.15, '2025-06-18');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (218, 125, 104, 9000.00, 0.20, '2025-07-19');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (219, 126, 106, 10250.00, 0.15, '2025-08-20');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (220, 123, 101, 1000.00, 0.12, '2025-09-21');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (221, 124, 106, 2250.00, 0.15, '2025-10-22');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (222, 125, 104, 3500.00, 0.20, '2025-11-23');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (223, 126, 103, 4750.00, 0.08, '2025-12-24');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (225, 124, 106, 6250.00, 0.15, '2025-02-26');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (226, 125, 104, 7500.00, 0.20, '2025-03-27');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (227, 126, 105, 8750.00, 0.06, '2025-04-28');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (228, 123, 103, 9000.00, 0.08, '2025-05-01');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (229, 124, 106, 10250.00, 0.15, '2025-06-02');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (230, 125, 104, 1000.00, 0.20, '2025-07-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (231, 126, 102, 2250.00, 0.10, '2025-08-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (233, 124, 106, 4750.00, 0.15, '2025-10-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (234, 125, 104, 5000.00, 0.20, '2025-11-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (235, 126, 101, 6250.00, 0.12, '2025-12-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (237, 124, 106, 8750.00, 0.15, '2025-02-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (238, 125, 104, 9000.00, 0.20, '2025-03-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (239, 126, 106, 10250.00, 0.15, '2025-04-12');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (241, 124, 106, 2250.00, 0.15, '2025-06-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (242, 125, 104, 3500.00, 0.20, '2025-07-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (243, 126, 103, 4750.00, 0.08, '2025-08-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (245, 124, 106, 6250.00, 0.15, '2025-10-18');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (246, 125, 104, 7500.00, 0.20, '2025-11-19');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (247, 126, 105, 8750.00, 0.06, '2025-12-20');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (248, 123, 103, 9000.00, 0.08, '2025-01-21');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (249, 124, 106, 10250.00, 0.15, '2025-02-22');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (250, 125, 104, 1000.00, 0.20, '2025-03-23');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (251, 126, 102, 2250.00, 0.10, '2025-04-24');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (253, 124, 106, 4750.00, 0.15, '2025-06-26');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (254, 125, 104, 5000.00, 0.20, '2025-07-27');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (255, 126, 101, 6250.00, 0.12, '2025-08-28');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (257, 124, 106, 8750.00, 0.15, '2025-10-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (258, 125, 104, 9000.00, 0.20, '2025-11-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (259, 126, 106, 10250.00, 0.15, '2025-12-04');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (261, 124, 106, 2250.00, 0.15, '2025-02-06');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (262, 125, 104, 3500.00, 0.20, '2025-03-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (263, 126, 103, 4750.00, 0.08, '2025-04-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (265, 124, 106, 6250.00, 0.15, '2025-06-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (266, 125, 104, 7500.00, 0.20, '2025-07-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (267, 126, 105, 8750.00, 0.06, '2025-08-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (268, 123, 103, 9000.00, 0.08, '2025-09-13');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (269, 124, 106, 10250.00, 0.15, '2025-10-14');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (270, 125, 104, 1000.00, 0.20, '2025-11-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (271, 126, 102, 2250.00, 0.10, '2025-12-16');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (272, 123, 105, 3500.00, 0.06, '2025-01-17');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (273, 124, 106, 4750.00, 0.15, '2025-02-18');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (274, 125, 104, 5000.00, 0.20, '2025-03-19');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (275, 126, 101, 6250.00, 0.12, '2025-04-20');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (277, 124, 106, 8750.00, 0.15, '2025-06-22');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (278, 125, 104, 9000.00, 0.20, '2025-07-23');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (279, 126, 106, 10250.00, 0.15, '2025-08-24');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (280, 123, 101, 1000.00, 0.12, '2025-09-25');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (281, 124, 106, 2250.00, 0.15, '2025-10-26');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (282, 125, 104, 3500.00, 0.20, '2025-11-27');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (283, 126, 103, 4750.00, 0.08, '2025-12-28');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (285, 124, 106, 6250.00, 0.15, '2025-02-02');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (286, 125, 104, 7500.00, 0.20, '2025-03-03');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (287, 126, 105, 8750.00, 0.06, '2025-04-04');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (288, 123, 103, 9000.00, 0.08, '2025-05-05');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (289, 124, 106, 10250.00, 0.15, '2025-06-06');

insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (290, 125, 104, 1000.00, 0.20, '2025-07-07');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (291, 126, 102, 2250.00, 0.10, '2025-08-08');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (293, 124, 106, 4750.00, 0.15, '2025-10-10');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (294, 125, 104, 5000.00, 0.20, '2025-11-11');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (295, 126, 101, 6250.00, 0.12, '2025-12-12');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (296, 123, 102, 7500.00, 0.10, '2025-01-13');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (297, 124, 106, 8750.00, 0.15, '2025-02-14');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (298, 125, 104, 9000.00, 0.20, '2025-03-15');
insert into investimentos (id, cliente_id, produto_id, valor, rentabilidade, data) values (299, 126, 106, 10250.00, 0.15, '2025-04-16');
