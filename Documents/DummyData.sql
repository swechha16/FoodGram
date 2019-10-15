use foodgramdb;

INSERT INTO user(user_id, account_type, email, password, username) VALUES(1, 'user', 'alexi@gmail.com', 'pass123', 'alexi');
INSERT INTO user(user_id, account_type, email, password, username) VALUES(2, 'user', 'sweaty@gmail.com', 'pass123', 'sweaty');
INSERT INTO user(user_id, account_type, email, password, username) VALUES(3, 'user', 'rony@gmail.com', 'pass123', 'rony');
INSERT INTO user(user_id, account_type, email, password, username) VALUES(4, 'user', 'suraj@gmail.com', 'pass123', 'suraj');

INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(1, 'caption', '$', 'american', 'url', 'rest', '12:00', 1);
INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(2, 'caption', '$', 'american', 'url', 'rest', '12:01', 2);
INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(3, 'caption', '$', 'american', 'url', 'rest', '12:02', 3);
INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(4, 'caption', '$', 'american', 'url', 'rest', '12:03', 4);
INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(5, 'caption', '$', 'american', 'url', 'rest', '12:04', 1);
INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(6, 'caption', '$', 'american', 'url', 'rest', '12:05', 2);
INSERT INTO photo(pic_id, caption, cost_tag, food_tag, pic, restaurant, timestamp, user_id_user_id) values(7, 'caption', '$', 'american', 'url', 'rest', '12:06', 3);
