
/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  17/07/2021 15:45:32                      */
/*==============================================================*/


drop table if exists CLIENT;

drop table if exists COMMENTAIRE;

drop table if exists VOITURE;

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table Client
(
   id                   int not null auto_increment,
   nom                  varchar(20) not null,
   login                varchar(20) not null,
   mdp                  varchar(100) not null,
   primary key (id)
);

/*==============================================================*/
/* Table : COMMENTAIRE                                          */
/*==============================================================*/
create table Commentaire
(
   id                   int not null auto_increment,
   id_client             int,
   id_voiture            int,
   commentaire          varchar(500) not null,
   primary key (id)
);

/*==============================================================*/
/* Table : VOITURE                                              */
/*==============================================================*/
create table Voiture
(
   id                   int not null auto_increment,
   matricule            varchar(20) not null,
   marque               varchar(20) not null,
   couleur              varchar(10) not null,
   image                varchar(100) not null,
   primary key (id)
);

alter table COMMENTAIRE add constraint FK_RELATION_1 foreign key (id_client)
      references CLIENT (id) on delete restrict on update restrict;
alter table COMMENTAIRE add constraint FK_RELATION_2 foreign key (id_voiture)
      references VOITURE (id) on delete restrict on update restrict;

insert into Voiture values(0,'1739 TBA',"Audi","Noir","audi.jpg");
insert into Voiture values(0,'1500 TBB',"Peugeot","Rouge","peugeot.jpg");
insert into Voiture values(0,'1811 TBJ',"Ferrari","Noir","ferrari.jpg");
insert into Voiture values(0,'34022 TBJ',"BMW","Noir","bmw.jpg");

insert into Client values(0,"Rabe","rabe","wawa");
insert into Client values(0,"Rakoto","koto","blabla");
insert into Client values(0,"Rasoa","rasoa","soa");  


insert into Commentaire values(0,1,1,"belle Voiture");
insert into Commentaire values(0,2,2,"magnifique vehicule");
insert into Commentaire values(0,3,3,"c'est ou le centre de vente");
insert into Commentaire values(0,2,1,"Luxe");
insert into Commentaire values(0,1,4,"wow fantastique");
insert into Commentaire values(0,3,2,"voiture de luxe");
