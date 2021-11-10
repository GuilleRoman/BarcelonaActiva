
INSERT INTO PLAYERS (register_date, name, win_rate) VALUES ( (CURRENT_TIMESTAMP), "Jugador1",  60.5);

INSERT INTO PLAYERS (register_date, name,  win_rate) VALUES ( (CURRENT_TIMESTAMP), "Jugador2",  43.2);

INSERT INTO PLAYERS (register_date, name,  win_rate) VALUES ( (CURRENT_TIMESTAMP), "Jugador3",  80.0);

INSERT INTO PLAYERS (register_date,  win_rate) VALUES ( (CURRENT_TIMESTAMP), 35.2);


INSERT INTO GAMES (player_id, winner, loser) VALUES (1, "Jugador1", null);
INSERT INTO GAMES (player_id, winner, loser) VALUES (1, null, "Jugador2");
INSERT INTO GAMES (player_id, winner, loser) VALUES (1, null, "Jugador3");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (3, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (3, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (3, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (1, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (3, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (3, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (2, null, "Jugador4");
INSERT INTO GAMES (player_id, winner, loser) VALUES (1, null, "Jugador4");



INSERT INTO DICES (player_id) VALUES (1);
INSERT INTO DICES (player_id) VALUES (1);
INSERT INTO DICES (player_id) VALUES (2);
INSERT INTO DICES (player_id) VALUES (2);
INSERT INTO DICES (player_id) VALUES (3);
INSERT INTO DICES (player_id) VALUES (3);
INSERT INTO DICES (player_id) VALUES (4);
INSERT INTO DICES (player_id) VALUES (4);

INSERT INTO ROLLS (game_id, player_id) VALUES (1,1);

INSERT INTO ROLLS (game_id, player_id) VALUES (2,1);

INSERT INTO ROLLS (game_id, player_id) VALUES (3,1);

INSERT INTO ROLLS (game_id, player_id) VALUES (4,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (5,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (6,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (7,3);

INSERT INTO ROLLS (game_id, player_id) VALUES (8,3);

INSERT INTO ROLLS (game_id, player_id) VALUES (9,3);

INSERT INTO ROLLS (game_id, player_id) VALUES (10,1);

INSERT INTO ROLLS (game_id, player_id) VALUES (11,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (12,3);

INSERT INTO ROLLS (game_id, player_id) VALUES (13,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (14,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (15,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (16,3);

INSERT INTO ROLLS (game_id, player_id) VALUES (17,2);

INSERT INTO ROLLS (game_id, player_id) VALUES (18,1);