--------------------------------------------------------
--  File created - Sunday-November-26-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EM_MEDICAMENTOS
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_MEDICAMENTOS" 
   (	"CODIGO_MEDICAMENTO" NUMBER(19,0), 
	"FABRICANTE" VARCHAR2(255 CHAR), 
	"NOME" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_MEDICOS
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_MEDICOS" 
   (	"CODIGO_MEDICO" NUMBER(19,0), 
	"CRM" VARCHAR2(255 CHAR), 
	"CODIGO_PESSOA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_PACIENTES
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_PACIENTES" 
   (	"CODIGO_PACIENTE" NUMBER(19,0), 
	"ALTURA" FLOAT(53), 
	"PESO" FLOAT(53), 
	"CODIGO_PESSOA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_PESSOA_FISICA
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_PESSOA_FISICA" 
   (	"CPF" VARCHAR2(14 CHAR), 
	"CODIGO_PESSOA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_PESSOA_JURIDICA
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_PESSOA_JURIDICA" 
   (	"CNPJ" VARCHAR2(255 CHAR), 
	"CODIGO_PESSOA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_PESSOAS
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_PESSOAS" 
   (	"CODIGO_PESSOA" NUMBER(19,0), 
	"NASCIMENTO" DATE, 
	"NOME" VARCHAR2(255 CHAR), 
	"TP_PESSOA" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_TRATAMENTOS
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_TRATAMENTOS" 
   (	"CODIGO_TRATAMENTO" NUMBER(19,0), 
	"DT_FIM" DATE, 
	"DT_INICIO" DATE, 
	"INTERVALO" NUMBER(19,0), 
	"CODIGO_MEDICAMENTO" NUMBER(19,0), 
	"CODIGO_MEDICO" NUMBER(19,0), 
	"CODIGO_PACIENTE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Table EM_USUARIOS
--------------------------------------------------------

  CREATE TABLE "RM96950"."EM_USUARIOS" 
   (	"CODIGO_USUARIO" NUMBER(19,0), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"SENHA" VARCHAR2(255 CHAR), 
	"CODIGO_PESSOA" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532036
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532036" ON "RM96950"."EM_MEDICAMENTOS" ("CODIGO_MEDICAMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index UK_EM_MEDICAMENTO_NOME_FABRICANTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."UK_EM_MEDICAMENTO_NOME_FABRICANTE" ON "RM96950"."EM_MEDICAMENTOS" ("NOME", "FABRICANTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532038
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532038" ON "RM96950"."EM_MEDICOS" ("CODIGO_MEDICO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index UK_EM_MEDICO_CRM
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."UK_EM_MEDICO_CRM" ON "RM96950"."EM_MEDICOS" ("CRM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532040
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532040" ON "RM96950"."EM_PACIENTES" ("CODIGO_PACIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532042
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532042" ON "RM96950"."EM_PESSOA_FISICA" ("CODIGO_PESSOA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index UK_EM_PESSOA_FISICA_CPF
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."UK_EM_PESSOA_FISICA_CPF" ON "RM96950"."EM_PESSOA_FISICA" ("CPF") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532044
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532044" ON "RM96950"."EM_PESSOA_JURIDICA" ("CODIGO_PESSOA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index UK_EM_PESSOA_JURIDICA_CNPJ
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."UK_EM_PESSOA_JURIDICA_CNPJ" ON "RM96950"."EM_PESSOA_JURIDICA" ("CNPJ") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532047
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532047" ON "RM96950"."EM_PESSOAS" ("CODIGO_PESSOA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532049
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532049" ON "RM96950"."EM_TRATAMENTOS" ("CODIGO_TRATAMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index SYS_C001532053
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."SYS_C001532053" ON "RM96950"."EM_USUARIOS" ("CODIGO_USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  DDL for Index UK_EM_USUARIOS_EMAIL
--------------------------------------------------------

  CREATE UNIQUE INDEX "RM96950"."UK_EM_USUARIOS_EMAIL" ON "RM96950"."EM_USUARIOS" ("EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS" ;
--------------------------------------------------------
--  Constraints for Table EM_MEDICAMENTOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_MEDICAMENTOS" MODIFY ("CODIGO_MEDICAMENTO" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_MEDICAMENTOS" ADD PRIMARY KEY ("CODIGO_MEDICAMENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
  ALTER TABLE "RM96950"."EM_MEDICAMENTOS" ADD CONSTRAINT "UK_EM_MEDICAMENTO_NOME_FABRICANTE" UNIQUE ("NOME", "FABRICANTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_MEDICOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_MEDICOS" MODIFY ("CODIGO_MEDICO" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_MEDICOS" ADD PRIMARY KEY ("CODIGO_MEDICO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
  ALTER TABLE "RM96950"."EM_MEDICOS" ADD CONSTRAINT "UK_EM_MEDICO_CRM" UNIQUE ("CRM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_PACIENTES
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PACIENTES" MODIFY ("CODIGO_PACIENTE" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_PACIENTES" ADD PRIMARY KEY ("CODIGO_PACIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_PESSOA_FISICA
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PESSOA_FISICA" MODIFY ("CODIGO_PESSOA" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_PESSOA_FISICA" ADD PRIMARY KEY ("CODIGO_PESSOA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
  ALTER TABLE "RM96950"."EM_PESSOA_FISICA" ADD CONSTRAINT "UK_EM_PESSOA_FISICA_CPF" UNIQUE ("CPF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_PESSOA_JURIDICA
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PESSOA_JURIDICA" MODIFY ("CODIGO_PESSOA" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_PESSOA_JURIDICA" ADD PRIMARY KEY ("CODIGO_PESSOA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
  ALTER TABLE "RM96950"."EM_PESSOA_JURIDICA" ADD CONSTRAINT "UK_EM_PESSOA_JURIDICA_CNPJ" UNIQUE ("CNPJ")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_PESSOAS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PESSOAS" MODIFY ("CODIGO_PESSOA" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_PESSOAS" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_PESSOAS" ADD PRIMARY KEY ("CODIGO_PESSOA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_TRATAMENTOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_TRATAMENTOS" MODIFY ("CODIGO_TRATAMENTO" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_TRATAMENTOS" ADD PRIMARY KEY ("CODIGO_TRATAMENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EM_USUARIOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_USUARIOS" MODIFY ("CODIGO_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_USUARIOS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_USUARIOS" MODIFY ("SENHA" NOT NULL ENABLE);
  ALTER TABLE "RM96950"."EM_USUARIOS" ADD PRIMARY KEY ("CODIGO_USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
  ALTER TABLE "RM96950"."EM_USUARIOS" ADD CONSTRAINT "UK_EM_USUARIOS_EMAIL" UNIQUE ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "TBSPC_ALUNOS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EM_MEDICOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_MEDICOS" ADD CONSTRAINT "FK_MEDICO_PESSOA" FOREIGN KEY ("CODIGO_PESSOA")
	  REFERENCES "RM96950"."EM_PESSOA_FISICA" ("CODIGO_PESSOA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EM_PACIENTES
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PACIENTES" ADD CONSTRAINT "FK_PACIENTE_PESSOA" FOREIGN KEY ("CODIGO_PESSOA")
	  REFERENCES "RM96950"."EM_PESSOA_FISICA" ("CODIGO_PESSOA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EM_PESSOA_FISICA
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PESSOA_FISICA" ADD CONSTRAINT "FKOEC2WD4Q5WMM4UNK888X388E9" FOREIGN KEY ("CODIGO_PESSOA")
	  REFERENCES "RM96950"."EM_PESSOAS" ("CODIGO_PESSOA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EM_PESSOA_JURIDICA
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_PESSOA_JURIDICA" ADD CONSTRAINT "FKJ5TSNRO2S0LUFX4TEY0XKXP52" FOREIGN KEY ("CODIGO_PESSOA")
	  REFERENCES "RM96950"."EM_PESSOAS" ("CODIGO_PESSOA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EM_TRATAMENTOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_TRATAMENTOS" ADD CONSTRAINT "FK_TRATAMENTO_MEDICAMENTO" FOREIGN KEY ("CODIGO_MEDICAMENTO")
	  REFERENCES "RM96950"."EM_MEDICAMENTOS" ("CODIGO_MEDICAMENTO") ENABLE;
  ALTER TABLE "RM96950"."EM_TRATAMENTOS" ADD CONSTRAINT "FK_TRATAMENTO_MEDICO" FOREIGN KEY ("CODIGO_MEDICO")
	  REFERENCES "RM96950"."EM_MEDICOS" ("CODIGO_MEDICO") ENABLE;
  ALTER TABLE "RM96950"."EM_TRATAMENTOS" ADD CONSTRAINT "FK_TRATAMENTO_PACIENTE" FOREIGN KEY ("CODIGO_PACIENTE")
	  REFERENCES "RM96950"."EM_PACIENTES" ("CODIGO_PACIENTE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EM_USUARIOS
--------------------------------------------------------

  ALTER TABLE "RM96950"."EM_USUARIOS" ADD CONSTRAINT "FK_USUARIO_PESSOA" FOREIGN KEY ("CODIGO_PESSOA")
	  REFERENCES "RM96950"."EM_PESSOAS" ("CODIGO_PESSOA") ENABLE;
