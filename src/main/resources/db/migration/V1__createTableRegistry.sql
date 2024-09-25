CREATE TABLE REGISTRY(
	id UUID PRIMARY KEY,
	navegador VARCHAR(50) NOT NULL,
	horario_acesso DATE NOT NULL,
	tipo_aparelho VARCHAR(20) NOT NULL,
	origem_acesso VARCHAR(20) NOT NULL
);