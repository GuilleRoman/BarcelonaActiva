-- MySQL Script generated by MySQL Workbench
-- Sat Jul 17 13:18:59 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema spotify
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spotify` ;

-- -----------------------------------------------------
-- Schema spotify
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spotify` DEFAULT CHARACTER SET utf8 ;
USE `spotify` ;

-- -----------------------------------------------------
-- Table `spotify`.`artista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`artista` ;

CREATE TABLE IF NOT EXISTS `spotify`.`artista` (
  `idartista` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `imagen` BLOB NULL DEFAULT NULL,
  `genero musical` VARCHAR(45) NULL DEFAULT NULL,
  `artista_idartista` INT(11) NOT NULL,
  PRIMARY KEY (`idartista`),
  INDEX `fk_artista_artista1_idx` (`artista_idartista` ASC) ,
  CONSTRAINT `fk_artista_artista1`
    FOREIGN KEY (`artista_idartista`)
    REFERENCES `spotify`.`artista` (`idartista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`album` ;

CREATE TABLE IF NOT EXISTS `spotify`.`album` (
  `idalbum` INT(11) NOT NULL AUTO_INCREMENT,
  `artista_idartista` INT(11) NOT NULL,
  PRIMARY KEY (`idalbum`),
  INDEX `fk_album_artista1_idx` (`artista_idartista` ASC) ,
  CONSTRAINT `fk_album_artista1`
    FOREIGN KEY (`artista_idartista`)
    REFERENCES `spotify`.`artista` (`idartista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`albumes_favoritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`albumes_favoritos` ;

CREATE TABLE IF NOT EXISTS `spotify`.`albumes_favoritos` (
  `idalbumes favoritos` INT(11) NOT NULL AUTO_INCREMENT,
  `album_idalbum` INT(11) NOT NULL,
  PRIMARY KEY (`idalbumes favoritos`),
  INDEX `fk_albumes_favoritos_album1_idx` (`album_idalbum` ASC) ,
  CONSTRAINT `fk_albumes_favoritos_album1`
    FOREIGN KEY (`album_idalbum`)
    REFERENCES `spotify`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`usuario_free`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`usuario_free` ;

CREATE TABLE IF NOT EXISTS `spotify`.`usuario_free` (
  `idusuario_free` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `cp` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario_free`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`usuario_premium`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`usuario_premium` ;

CREATE TABLE IF NOT EXISTS `spotify`.`usuario_premium` (
  `idusuario_premium` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `cp` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario_premium`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`playlist_activa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`playlist_activa` ;

CREATE TABLE IF NOT EXISTS `spotify`.`playlist_activa` (
  `idplaylist_activa` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `numero_canciones` INT(11) NULL DEFAULT NULL,
  `fecha_creacion` DATE NULL DEFAULT NULL,
  `usuario_free_idusuario_free` INT(11) NOT NULL,
  `usuario_premium_idusuario_premium` INT(11) NOT NULL,
  PRIMARY KEY (`idplaylist_activa`),
  INDEX `fk_playlist_usuario_free1_idx` (`usuario_free_idusuario_free` ASC) ,
  INDEX `fk_playlist_usuario_premium1_idx` (`usuario_premium_idusuario_premium` ASC) ,
  CONSTRAINT `fk_playlist_usuario_free1`
    FOREIGN KEY (`usuario_free_idusuario_free`)
    REFERENCES `spotify`.`usuario_free` (`idusuario_free`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_usuario_premium1`
    FOREIGN KEY (`usuario_premium_idusuario_premium`)
    REFERENCES `spotify`.`usuario_premium` (`idusuario_premium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`playlist_compartida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`playlist_compartida` ;

CREATE TABLE IF NOT EXISTS `spotify`.`playlist_compartida` (
  `idplaylist_compartida` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL DEFAULT NULL,
  `playlist_activa_idplaylist` INT(11) NOT NULL,
  PRIMARY KEY (`idplaylist_compartida`),
  INDEX `fk_playlist_compartida_playlist_activa1_idx` (`playlist_activa_idplaylist` ASC) ,
  CONSTRAINT `fk_playlist_compartida_playlist_activa1`
    FOREIGN KEY (`playlist_activa_idplaylist`)
    REFERENCES `spotify`.`playlist_activa` (`idplaylist_activa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`cancion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`cancion` ;

CREATE TABLE IF NOT EXISTS `spotify`.`cancion` (
  `idcancion` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `duracion` FLOAT NULL DEFAULT NULL,
  `reproducida` INT(11) NULL DEFAULT NULL,
  `playlist_compartida_idplaylist_compartida` INT(11) NOT NULL,
  `album_idalbum` INT(11) NOT NULL,
  PRIMARY KEY (`idcancion`),
  INDEX `fk_cancion_playlist_compartida1_idx` (`playlist_compartida_idplaylist_compartida` ASC) ,
  INDEX `fk_cancion_album1_idx` (`album_idalbum` ASC) ,
  CONSTRAINT `fk_cancion_album1`
    FOREIGN KEY (`album_idalbum`)
    REFERENCES `spotify`.`album` (`idalbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cancion_playlist_compartida1`
    FOREIGN KEY (`playlist_compartida_idplaylist_compartida`)
    REFERENCES `spotify`.`playlist_compartida` (`idplaylist_compartida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`canciones_favoritas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`canciones_favoritas` ;

CREATE TABLE IF NOT EXISTS `spotify`.`canciones_favoritas` (
  `idcanciones_favoritas` INT(11) NOT NULL AUTO_INCREMENT,
  `cancion_idcancion` INT(11) NOT NULL,
  PRIMARY KEY (`idcanciones_favoritas`),
  INDEX `fk_canciones_favoritas_cancion1_idx` (`cancion_idcancion` ASC) ,
  CONSTRAINT `fk_canciones_favoritas_cancion1`
    FOREIGN KEY (`cancion_idcancion`)
    REFERENCES `spotify`.`cancion` (`idcancion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`paypal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`paypal` ;

CREATE TABLE IF NOT EXISTS `spotify`.`paypal` (
  `idpaypal` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idpaypal`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`tarjeta_credito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`tarjeta_credito` ;

CREATE TABLE IF NOT EXISTS `spotify`.`tarjeta_credito` (
  `idtarjeta_credito` INT(11) NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `codigo` VARCHAR(45) NULL DEFAULT NULL,
  `mes_a??o_caducidad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idtarjeta_credito`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`pagos` ;

CREATE TABLE IF NOT EXISTS `spotify`.`pagos` (
  `idpagos` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL DEFAULT NULL,
  `orden` INT(11) NULL DEFAULT NULL,
  `total` FLOAT NULL DEFAULT NULL,
  `usuario_premium_idusuario_premium` INT(11) NOT NULL,
  `tarjeta_credito_idtarjeta_credito` INT(11) NOT NULL,
  `paypal_idpaypal` INT(11) NOT NULL,
  PRIMARY KEY (`idpagos`),
  UNIQUE INDEX `orden_UNIQUE` (`orden` ASC) ,
  INDEX `fk_pagos_usuario_premium1_idx` (`usuario_premium_idusuario_premium` ASC) ,
  INDEX `fk_pagos_tarjeta_credito1_idx` (`tarjeta_credito_idtarjeta_credito` ASC) ,
  INDEX `fk_pagos_paypal1_idx` (`paypal_idpaypal` ASC) ,
  CONSTRAINT `fk_pagos_paypal1`
    FOREIGN KEY (`paypal_idpaypal`)
    REFERENCES `spotify`.`paypal` (`idpaypal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagos_tarjeta_credito1`
    FOREIGN KEY (`tarjeta_credito_idtarjeta_credito`)
    REFERENCES `spotify`.`tarjeta_credito` (`idtarjeta_credito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagos_usuario_premium1`
    FOREIGN KEY (`usuario_premium_idusuario_premium`)
    REFERENCES `spotify`.`usuario_premium` (`idusuario_premium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`playlist_borrada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`playlist_borrada` ;

CREATE TABLE IF NOT EXISTS `spotify`.`playlist_borrada` (
  `idplaylist_borrada` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `numero_canciones` INT(11) NULL DEFAULT NULL,
  `fecha_creacion` DATE NULL DEFAULT NULL,
  `eliminada` VARCHAR(1) NULL DEFAULT 'N',
  `usuario_free_idusuario_free` INT(11) NOT NULL,
  `usuario_premium_idusuario_premium` INT(11) NOT NULL,
  PRIMARY KEY (`idplaylist_borrada`),
  INDEX `fk_playlist_usuario_free1_idx` (`usuario_free_idusuario_free` ASC) ,
  INDEX `fk_playlist_usuario_premium1_idx` (`usuario_premium_idusuario_premium` ASC) ,
  CONSTRAINT `fk_playlist_usuario_free10`
    FOREIGN KEY (`usuario_free_idusuario_free`)
    REFERENCES `spotify`.`usuario_free` (`idusuario_free`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_usuario_premium10`
    FOREIGN KEY (`usuario_premium_idusuario_premium`)
    REFERENCES `spotify`.`usuario_premium` (`idusuario_premium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`suscripciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`suscripciones` ;

CREATE TABLE IF NOT EXISTS `spotify`.`suscripciones` (
  `idsuscripciones` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` DATE NULL DEFAULT NULL,
  `fecha_renovacion` DATE NULL DEFAULT NULL,
  `usuario_premium_idusuario_premium` INT(11) NOT NULL,
  PRIMARY KEY (`idsuscripciones`),
  INDEX `fk_suscripciones_usuario_premium_idx` (`usuario_premium_idusuario_premium` ASC) ,
  CONSTRAINT `fk_suscripciones_usuario_premium`
    FOREIGN KEY (`usuario_premium_idusuario_premium`)
    REFERENCES `spotify`.`usuario_premium` (`idusuario_premium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`usuario_free_artistas_seguidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`usuario_free_artistas_seguidos` ;

CREATE TABLE IF NOT EXISTS `spotify`.`usuario_free_artistas_seguidos` (
  `usuario_free_idusuario_free` INT(11) NOT NULL,
  `artista_idartista` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_free_idusuario_free`, `artista_idartista`),
  INDEX `fk_usuario_free_has_artista_artista1_idx` (`artista_idartista` ASC) ,
  INDEX `fk_usuario_free_has_artista_usuario_free1_idx` (`usuario_free_idusuario_free` ASC) ,
  CONSTRAINT `fk_usuario_free_has_artista_artista1`
    FOREIGN KEY (`artista_idartista`)
    REFERENCES `spotify`.`artista` (`idartista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_free_has_artista_usuario_free1`
    FOREIGN KEY (`usuario_free_idusuario_free`)
    REFERENCES `spotify`.`usuario_free` (`idusuario_free`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spotify`.`usuario_premium_artistas_seguidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`usuario_premium_artistas_seguidos` ;

CREATE TABLE IF NOT EXISTS `spotify`.`usuario_premium_artistas_seguidos` (
  `usuario_premium_idusuario_premium` INT(11) NOT NULL,
  `artista_idartista` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_premium_idusuario_premium`, `artista_idartista`),
  INDEX `fk_usuario_premium_has_artista_artista1_idx` (`artista_idartista` ASC) ,
  INDEX `fk_usuario_premium_has_artista_usuario_premium1_idx` (`usuario_premium_idusuario_premium` ASC) ,
  CONSTRAINT `fk_usuario_premium_has_artista_artista1`
    FOREIGN KEY (`artista_idartista`)
    REFERENCES `spotify`.`artista` (`idartista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_premium_has_artista_usuario_premium1`
    FOREIGN KEY (`usuario_premium_idusuario_premium`)
    REFERENCES `spotify`.`usuario_premium` (`idusuario_premium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
