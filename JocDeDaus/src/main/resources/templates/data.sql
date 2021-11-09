

INSERT INTO PLAYERS (register_date, name, current_roll, win_rate) VALUES ( (CURRENT_TIMESTAMP), "Jugador1", 7, 60.5);

INSERT INTO PLAYERS (register_date, name, current_roll, win_rate) VALUES ( (CURRENT_TIMESTAMP), "Jugador2", 4, 43.2);

INSERT INTO PLAYERS (register_date, name, current_roll, win_rate) VALUES ( (CURRENT_TIMESTAMP), "Jugador3", 2, 80.0);

INSERT INTO PLAYERS (register_date, current_roll, win_rate) VALUES ( (CURRENT_TIMESTAMP), 6, 35.2);


INSERT INTO GAMES (player_id, winner, loser) VALUES (1, "Jugador1", null);
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador2");
INSERT INTO GAMES (player_id, winner, loser) VALUES (3, null, "Jugador3");
INSERT INTO GAMES (player_id, winner, loser) VALUES (4, null, "Jugador4");



INSERT INTO DICES (player_id, result) VALUES (1, 4);
INSERT INTO DICES (player_id, result) VALUES (1, 3);
INSERT INTO DICES (player_id, result) VALUES (2, 2);
INSERT INTO DICES (player_id, result) VALUES (2, 2);
INSERT INTO DICES (player_id, result) VALUES (3, 1);
INSERT INTO DICES (player_id, result) VALUES (3, 1);
INSERT INTO DICES (player_id, result) VALUES (4, 2);
INSERT INTO DICES (player_id, result) VALUES (4, 4);