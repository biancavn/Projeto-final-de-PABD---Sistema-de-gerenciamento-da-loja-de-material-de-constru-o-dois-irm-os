/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Bianca
 * Created: 25/03/2022
 */

create database Loja_DoisIrmaos;

use loja_doisirmaos;

create table produtos(
id_produto integer auto_increment unique,
nome varchar(100),
categoria varchar(150), #construção, decoração, reforma,acabamento   
quantidade integer, 
marca varchar(100),
tamanho varchar(100) #varchar porque deve indicar o tamanho 1 litro(tubo de tinta) ou 10 metros(corda)
);

create table frotaVeiculos(
id_frotaVeiculos integer auto_increment unique,
nomeVeiculo varchar(100),
marca varchar(100),
função varchar(100), #entregas, aluguel
disponibilidade varchar(100) #está disponivel ou não, manutenção, entrega
);
