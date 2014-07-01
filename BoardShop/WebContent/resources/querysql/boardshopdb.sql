# SQL Manager Lite for MySQL 5.3.1.7
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : boardshopdb


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `boardshopdb`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `boardshopdb`;

#
# Structure for the `linha` table : 
#

CREATE TABLE `linha` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `tipoQuilha` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
)ENGINE=InnoDB
AUTO_INCREMENT=7 AVG_ROW_LENGTH=3276 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `prancha` table : 
#

CREATE TABLE `prancha` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `conteudo` LONGTEXT COLLATE utf8_general_ci,
  `dataDisponibilidade` DATETIME DEFAULT NULL,
  `descricaoMax` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `descricaoMin` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `imagem` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `medidas` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `valor` DOUBLE NOT NULL,
  `linha_id` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
   INDEX `FK_7b8babae1p7p2qdo1cq4vrcxk` USING BTREE (`linha_id`),
  CONSTRAINT `FK_7b8babae1p7p2qdo1cq4vrcxk` FOREIGN KEY (`linha_id`) REFERENCES `linha` (`id`)
)ENGINE=InnoDB
AUTO_INCREMENT=12 AVG_ROW_LENGTH=1820 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `usuario` table : 
#

CREATE TABLE `usuario` (
  `nome` VARCHAR(255) COLLATE utf8_general_ci NOT NULL,
  `senha` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`nome`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=16384 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Data for the `linha` table  (LIMIT -494,500)
#

INSERT INTO `linha` (`id`, `modelo`, `tipoQuilha`) VALUES

  (2,'Thruster','Triquilha'),
  (3,'Fish','Biquilha'),
  (4,'Evolution','Quadriquilha'),
  (5,'Stand Up Paddle','Monoquilha'),
  (6,'Longboard','Monoquilha');
COMMIT;

#
# Data for the `prancha` table  (LIMIT -490,500)
#

INSERT INTO `prancha` (`id`, `conteudo`, `dataDisponibilidade`, `descricaoMax`, `descricaoMin`, `imagem`, `medidas`, `valor`, `linha_id`) VALUES

  (3,NULL,'2015-03-19 21:00:00','Quilha G3, rabeta squash com double concave e astro-deck parte detrás','Rabeta squash','98df6bf3-6cb2-41e4-aca8-1954b24c9467.jpg','6''2''''',1199.59,2),
  (4,NULL,'2014-07-16 21:00:00','Quilha G3, rabeta swallow, double concave, astro-deck parte detrás','Rabeta swallow','81a748d2-6c67-4d94-a1d2-203d97b30e7c.jpg','5''11''''',849.29,2),
  (5,NULL,'2014-08-19 21:00:00','Quilha G3, rabeta swallow astro-deck em toda prancha','Rabeta pin','70e5cfde-33d4-4c7b-b207-546e318badfa.jpg','5''6''''',759.49,3),
  (6,NULL,'2014-09-11 21:00:00','Quilha G6 clássica rabeta squash acompanha remo',' Rabeta squash','30ef14fe-06c1-44db-9536-ba5e62aa3cac.jpg','9''8''''',2399.99,5),
  (7,NULL,'2014-10-16 21:00:00','Quilha G5 clássica, rabeta pin e astro-deck em toda prancha','Rabeta round pin','945df2fa-6afb-4b26-92d4-9ca80e9ea11e.jpg','12''9''''',1799.39,6),
  (8,NULL,'2014-12-01 22:00:00','Quilha G3 KS, rabeta swallow, double wing com single concave e deck traseiro','Rabeta swallow','f3c2c008-17bd-49c9-b5f6-4b59487bdd1d.jpg','5''5''''',559.49,4),
  (9,NULL,'2014-07-24 21:00:00','Quilha G3, rabeta round pin, single wing, double convave e astro-deck parte detrás','Rabeta round pin','bc58d735-398d-4cb3-a89a-e42f2aa4cd00.jpg','5''8''''',729.79,4),
  (10,NULL,'2014-12-09 22:00:00','Quilha G5, rabeta pin, astro-deck em toda prancha, acompanha remo','Rabeta pin','19ba8218-80bc-4ae5-9986-24ebbf69e13e.jpg','14''6''''',3499.39,5),
  (11,NULL,'2014-09-22 21:00:00','Quilha G5 clássica, rabeta squash, double concave e astro-deck parte detrás','Rabeta squash','6d2561c2-4d70-42ae-b983-350cefa0e020.jpg','9''5''''',1999.79,6);
COMMIT;

#
# Data for the `usuario` table  (LIMIT -498,500)
#

INSERT INTO `usuario` (`nome`, `senha`) VALUES

  ('nm','123');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;