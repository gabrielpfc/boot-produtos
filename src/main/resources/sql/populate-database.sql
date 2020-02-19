INSERT INTO TB_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA) VALUES (CATEGORIA_SEQ.NEXTVAL, 'Notebook');
INSERT INTO TB_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA) VALUES (CATEGORIA_SEQ.NEXTVAL, 'Smartphone');
INSERT INTO TB_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA) VALUES (CATEGORIA_SEQ.NEXTVAL, 'TV');
INSERT INTO TB_CATEGORIA (ID_CATEGORIA, NOME_CATEGORIA) VALUES (CATEGORIA_SEQ.NEXTVAL, 'Tablet');

INSERT INTO TB_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'LG');
INSERT INTO TB_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'Apple');
INSERT INTO TB_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'Samsumg');
INSERT INTO TB_MARCA (ID_MARCA, NOME_MARCA) VALUES (MARCA_SEQ.NEXTVAL, 'Sony');

INSERT INTO TB_PRODUTO (ID, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA) VALUES (PRODUTO_SEQ.NEXTVAL, 'Nome do produto 1', 'sku-0001', 'Descrição do Produto 1', 'Características do produto 1', 1.99, sysdate , 1, 1);
INSERT INTO TB_PRODUTO (ID, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA) VALUES (PRODUTO_SEQ.NEXTVAL, 'Nome do produto 2', 'sku-0002', 'Descrição do Produto 2', 'Características do produto 2', 2.99, sysdate , 2, 2);
INSERT INTO TB_PRODUTO (ID, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA) VALUES (PRODUTO_SEQ.NEXTVAL, 'Nome do produto 3', 'sku-0002', 'Descrição do Produto 3', 'Características do produto 3', 3.99, sysdate , 3, 3);
INSERT INTO TB_PRODUTO (ID, NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA, ID_MARCA) VALUES (PRODUTO_SEQ.NEXTVAL, 'Nome do produto 4', 'sku-0002', 'Descrição do Produto 4', 'Características do produto 4', 4.99, sysdate , 4, 4);