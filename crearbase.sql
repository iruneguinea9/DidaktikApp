BEGIN TRANSACTION;
DROP TABLE IF EXISTS 'Progreso';
CREATE TABLE IF NOT EXISTS `Progreso` (
	'juego' varchar ( 8 ) NOT NULL,
	'hecho'	varchar ( 5 ) DEFAULT 'false',
	PRIMARY KEY('juego'),
);
commit;
insert into 'Progreso' values('juego 1','false');
insert into 'Progreso' values('juego 2','false');
insert into 'Progreso' values('juego 3','false');
insert into 'Progreso' values('juego 4','false');
insert into 'Progreso' values('juego 5','false');
insert into 'Progreso' values('juego 6','false');
insert into 'Progreso' values('juego 7','false');
commit;
