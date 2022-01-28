CREATE DATABASE janken_fighter_alpha;
USE janken_fighter_alpha;
CREATE TABLE users(
	user_id int NOT NULL AUTO_INCREMENT,
    stat_id int,
    avatar_id int,
    moveset_id int,
	user_name varchar(64),
	email varchar(300),
	user_password varchar(32),
    -- wins int,
    -- losses int default(0),
    -- coins int default(10),
	PRIMARY KEY(user_id),
	UNIQUE KEY (user_name)
);
ALTER TABLE users
	AUTO_INCREMENT = 1001;
CREATE TABLE user_stats(
	stat_id int NOT NULL auto_increment,
    chisei int DEFAULT(1),
    ken int DEFAULT(1),
    seishin int DEFAULT(1),
    attack float DEFAULT(1),
    defense float DEFAULT(1),
    hit float DEFAULT(1),
    pwr float DEFAULT(1),
    PRIMARY KEY(stat_id)
);
ALTER TABLE user_stats
	AUTO_INCREMENT = 1001;
CREATE TABLE avatar(
	avatar_id int NOT NULL auto_increment,
--    class_id int,
	arms_part int,
    back_arms_part int,
    head_part int,
    back_head_part int,
	legs_part int,
    back_legs_part int,
    torso_part int,
    back_torso_part int,
    waist_part int,
    back_waist_part int,
--    accessory varchar(20),
--    back_accessory varchar(20),
--    pet varchar(20),
    primary key(avatar_id)
);
ALTER TABLE avatar
	AUTO_INCREMENT = 1001;
create table moveset(
	moveset_id int not null auto_increment,
    c_move_id int,
    c_move_use boolean,
    k_move_id int,
    k_move_use boolean,
    s_move_id int,
    s_move_use boolean,
    p_move_id int,
    p_move_use boolean,
    -- z_move_id int,
    -- z_move_use boolean,
    primary key(moveset_id)
);
ALTER TABLE moveset
	auto_increment = 1001;
-- create table character_class(
-- 	class_id int not null auto_increment,
-- 	class_name varchar(52),
--  unlock_key int unique,
-- 	primary key(class_id)
-- );
create table arms(
	arms_id int not null auto_increment,
    arms varchar(20) not null,
    arms_name varchar(60),
    arms_desc varchar(200),
--    unlock_key int,
    arms_image_file varchar(60),
    primary key(arms_id)
);
create table back_arms(
	back_arms_id int not null auto_increment,
    back_arms varchar(20) not null,
    arms_name varchar(60),
    arms_desc varchar(200),
--    unlock_key int,
    arms_image_file varchar(60),
    primary key(back_arms_id)
);
create table head(
	head_id int not null auto_increment,
    head varchar(20) not null,
    head_name varchar(60),
    head_desc varchar(200),
--    unlock_key int,
    head_image_file varchar(60),
    primary key(head_id)
);
create table back_head(
	back_head_id int not null auto_increment,
    back_head varchar(20) not null,
    head_name varchar(60),
    head_desc varchar(200),
--    unlock_key int,
    head_image_file varchar(60),
    primary key(back_head_id)
);
create table legs(
	legs_id int not null auto_increment,
    legs varchar(20) not null,
    legs_name varchar(60),
    legs_desc varchar(200),
--    unlock_key int,
    legs_image_file varchar(60),
    primary key(legs_id)
);
create table back_legs(
	back_legs_id int not null auto_increment,
    back_legs varchar(20) not null,
    legs_name varchar(60),
    legs_desc varchar(200),
--    unlock_key int,
    legs_image_file varchar(60),
    primary key(back_legs_id)
);
create table torso(
	torso_id int not null auto_increment,
    torso varchar(20) not null,
    torso_name varchar(60),
    torso_desc varchar(200),
--    unlock_key int,
    torso_image_file varchar(60),
    primary key(torso_id)
);
create table back_torso(
	back_torso_id int not null auto_increment,
    back_torso varchar(20) not null,
    torso_name varchar(60),
    torso_desc varchar(200),
--    unlock_key int,
    torso_image_file varchar(60),
    primary key(back_torso_id)
);
create table waist(
	waist_id int not null auto_increment,
    waist varchar(20) not null,
    waist_name varchar(60),
    waist_desc varchar(200),
--    unlock_key int,
    waist_image_file varchar(60),
    primary key(waist_id)
);
create table back_waist(
	back_waist_id int not null auto_increment,
    back_waist varchar(20) not null,
    waist_name varchar(60),
    waist_desc varchar(200),
--    unlock_key int,
    waist_image_file varchar(60),
    primary key(back_waist_id)
);
-- create table accessory(
-- 	  accs_id varchar(20) not null,
-- 	  accs_name varchar(60),
--    accs_desc varchar(200),
--    accs_image_file varchar(60),
--    primary key(accs_id)
-- );
-- create table back_accessory(
-- 	  back_accs_id varchar(20) not null,
-- 	  accs_name varchar(60),
--    accs_desc varchar(200),
--    accs_image_file varchar(60),
--    primary key(back_accs_id)
-- );
-- create table pet(
-- 	  pet_id varchar(20) not null,
--    pet_name varchar(60),
--    pet_desc varchar(200),
--    pet_buff_name varchar(60),
--    pet_buff_stat int,
-- 	  pet_image_file varchar(60),
--    primary key(pet_id)
-- );
create table chi_move(
	c_move_id int auto_increment not null,
	c_move varchar(16) not null unique,
    c_move_key varchar(4),
    move_name varchar(60),
    move_desc varchar(200),
    move_stat int,
    move_buff float,
    primary key(c_move_id)
);
create table ken_move(
	k_move_id int auto_increment not null,
    k_move varchar(16) not null unique,
    k_move_key varchar(4),
    move_name varchar(60),
    move_desc varchar(200),
    move_stat int,
    move_buff float,
    primary key(k_move_id)
);
create table sei_move(
	s_move_id int auto_increment not null,
    s_move varchar(16) not null unique,
    s_move_key varchar(4),
    move_name varchar(60),
    move_desc varchar(200),
    move_stat int,
    move_buff float,
    primary key(s_move_id)
);
create table surprise_move(
	p_move_id int auto_increment not null,
    p_move varchar(16) not null,
    p_move_key varchar(4),
    move_name varchar(60),
    move_desc varchar(200),
    move_stat int,
    move_buff float,
    primary key(p_move_id)
);
create table battle(
	battle_id int not null auto_increment,
    attacker_id int,
    attacker_hp float,
    attacker_surprise_count int,
	defender_id int,
    defender_hp float,
    defender_surprise_count int,
    result_id int,
    primary key(battle_id)
);
create table results(
	result_id int not null auto_increment,
    winner varchar(60),
    round_count int,
    formula varchar(24),
--    round_list JSON,
    primary key(result_id)
);
INSERT INTO chi_move(c_move_id,c_move,move_name,move_desc,move_stat,move_buff)
VALUES
	(1,"C-10-00-999-0000","Omega Punch","When you have to absolutely, positively knock out every motherflipper in the dojo.",1000,1000),
    (2,"C-10-00-000-0000","Puff Punch","Not much better than a regular punch. Good for softening up marshmellows at best.",1,.1),
    (3,"C-80-00-000-0000","Tail Spin","Use that fluffy appendage on the rear to smack opponents in the face.",1,.1);
INSERT INTO ken_move(k_move_id,k_move,move_name,move_desc,move_stat,move_buff)
VALUES
	(1,"K-20-00-999-0000","Omega Kick","A powerful kick that can send your opponent into orbit.",1000,1000),
    (2,"K-20-00-000-0000","Puff Kick","Not much better than a regular kick. Good for stubbing toes on various rocks laying around the ground.",1,.1),
    (3,"K-50-00-000-0000","Claw Mark","The only thing worse than getting scratched is getting scratched by a monster.",1,.1);
INSERT INTO sei_move(s_move_id,s_move,move_name,move_desc,move_stat,move_buff)
VALUES
	(1,"S-30-00-999-0000","Omega Blast","A giant blast with enough energy behind it to blast a hole in the moon.",1000,1000),
    (2,"S-30-00-000-0000","Finger Gun","Just point your finger and shoot. Pew, pew, pew.",1,.1),
    (3,"S-90-00-000-0000","Smelly Breath","Ewwwww...whatever you ate does not smell very good on the way up.",1,.1);
INSERT INTO surprise_move(p_move_id,p_move,move_name,move_desc,move_stat,move_buff)
VALUES
	(1,"P-10-00-999-0000","Teleport Punch","Disappear out of your opponent's sight to reappear behind them for a punch in the kidney.",1000,1000),
    (2,"P-A0-00-000-0000","Smoke Bomb","Good for disorienting an opponent. And causing some coughing.",1,.1),
    (3,"P-30-00-000-0000","Poison Spit","Not only is that spit disorienting, it hurts also!",1,.1);
INSERT INTO users(user_id,stat_id, avatar_id, moveset_id, user_name, email, user_password)
VALUES
	(1,1,1,1,"The Old Man","admin@email.com","password"),
    (900,900,900,900,"Testy Monster","monster@email.com","password"),
    (999,999,999,999,"The Fault","default@email.com","password"),
    (1000,1000,1000,1000,"Mister Newbie","gswoodruff@gmail.com","password");
INSERT INTO user_stats(stat_id,chisei,ken,seishin,attack,defense,hit,pwr)
VALUES
	(1,9000,9000,9000,9999,9999,9999,9999),
    (900,1,1,1,1,1,10,1),
    (999,1,1,1,1,1,10,1),
    (1000,1,1,1,1,1,10,1);
INSERT INTO avatar(avatar_id,arms_part,back_arms_part,head_part,back_head_part,legs_part,back_legs_part,torso_part,back_torso_part,waist_part,back_waist_part)
VALUES
	(1,1,1,1,1,1,1,1,1,1,1),
    (900,5,5,5,5,5,5,5,5,5,5),
    (999,2,2,2,2,2,2,2,2,2,2),
    (1000,3,3,3,3,3,3,3,3,3,3);
INSERT INTO moveset(moveset_id,c_move_id,c_move_use,k_move_id,k_move_use,s_move_id,s_move_use,p_move_id,p_move_use)
VALUES
	(1,1,false,1,false,1,false,1,false),
    (900,3,false,3,false,3,false,3,false),
    (999,2,false,2,false,2,false,2,false),
    (1000,2,false,2,false,2,false,2,false);
-- INSERT INTO character_class(class_id,class_name,unlock_key)
--	  (1,"Default",1),
--    (2,"Sensei",2),
--    (3,"Martial Artist",3),
--    (4,"Magic User",4),
--    (5,"Gunslinger",5),
--    (6,"Fuzzy Monster",6)
-- );
INSERT INTO arms(arms_id,arms,arms_name,arms_desc,arms_image_file)
VALUES
	(1,"A-20-10-00-00-00-001","Sensei","Default Sensei Head",""),
    (2,"A-20-00-00-00-10-001","Default Arms","A totally non-descript set of arms. Seriously, these arms are not exciting at all.",'../../assets/A-20-00-00-00-10-001.png'),
    (3,"A-20-20-20-10-10-001","Martial Artist (1)","These arms of the martial artist are weapons of destruction.",'../../assets/A-20-20-20-10-10-001.png'),
	(4,"A-20-30-40-20-10-001","Magic User (1)","The nimble fingers of the magic user quickly cast spells charged with mystical energy.",'../../assets/A-20-30-40-20-10-001.png'),
    (5,"A-20-40-50-70-00-001","Fuzzy Monster (1)","The purple fuzzy monster's arms are soft but those claws are still very dangerous.",'../../assets/A-20-40-50-70-00-001.png'),
    (6,"A-20-40-50-80-00-001","Fuzzy Monster (2)","The orange fuzzy monster's arms are soft but those claws are still very dangerous.",'../../assets/A-20-40-50-80-00-001.png');
INSERT INTO back_arms(back_arms_id,back_arms,arms_name,arms_desc,arms_image_file)
VALUES
	(1,"A-22-10-00-00-00-001","Sensei","Default Sensei Head",""),
    (2,"A-22-00-00-00-10-001","Default Arms","A totally non-descript set of arms. Seriously, these arms are not exciting at all.",'../../assets/A-22-00-00-00-10-001.png'),
    (3,"A-22-20-20-10-10-001","Martial Artist (1)","These arms of the martial artist are weapons of destruction.",'../../assets/A-22-20-20-10-10-001.png'),
	(4,"A-22-30-40-20-10-001","Magic User (1)","The nimble fingers of the magic user quickly cast spells charged with mystical energy.",'../../assets/A-22-30-40-20-10-001.png'),
    (5,"A-22-40-50-70-00-001","Fuzzy Monster (1)","The purple fuzzy monster's arms are soft but those claws are still very dangerous.",'../../assets/A-22-40-50-70-00-001.png'),
    (6,"A-22-40-50-80-00-001","Fuzzy Monster (2)","The orange fuzzy monster's arms are soft but those claws are still very dangerous.",'../../assets/A-22-40-50-80-00-001.png');
INSERT INTO head(head_id,head,head_name,head_desc,head_image_file)
VALUES
	(1,"H-30-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"H-30-00-00-00-10-001","Default Head","A totally non-descript head. Seriously, it's nothing special.",'../../assets/H-30-00-00-00-10-001.png'),
    (3,"H-30-20-20-20-80-001","Martial Artist (1)","That look of fury on the Martial Artist's just exudes strenghth and determination.",'../../assets/H-30-20-20-20-80-001.png'),
    (4,"H-30-30-40-10-00-001","Magic User (1)","More than just a pretty face, the Magic User's look strikes fear into opponents.",'../../assets/H-30-30-40-10-00-001.png'),
    (5,"H-30-40-50-70-40-001","Fuzzy Monster (1)","Awww, only the purple fuzzy monster could look cute and terrifying at once.",'../../assets/H-30-40-50-70-40-001.png'),
    (6,"H-30-40-50-80-40-001","Fuzzy Monster (2)","Awww, only the orange fuzzy monster could look cute and terrifying at once.",'../../assets/H-30-40-50-80-40-001.png');
INSERT INTO back_head(back_head_id,back_head,head_name,head_desc,head_image_file)
VALUES
	(1,"H-33-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"H-33-00-00-00-10-001","Default Head","A totally non-descript head. Seriously, it's nothing special.",'../../assets/H-33-00-00-00-10-001.png'),
    (3,"H-33-20-20-20-80-001","Martial Artist (1)","That look of fury on the Martial Artist's just exudes strenghth and determination.",'../../assets/H-33-20-20-20-80-001.png'),
    (4,"H-33-30-40-10-00-001","Magic User (1)","More than just a pretty face, the Magic User's look strikes fear into opponents.",'../../assets/H-33-30-40-10-00-001.png'),
    (5,"H-33-40-50-70-40-001","Fuzzy Monster (1)","Awww, only the purple fuzzy monster could look cute and terrifying at once.",'../../assets/H-33-40-50-70-40-001.png'),
    (6,"H-33-40-50-80-40-001","Fuzzy Monster (2)","Awww, only the orange fuzzy monster could look cute and terrifying at once.",'../../assets/H-33-40-50-80-40-001.png');
INSERT INTO legs(legs_id,legs,legs_name,legs_desc,legs_image_file)
VALUES
	(1,"L-40-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"L-40-00-00-00-10-001","Default Legs","A totally non-descript pair of legs. Seriously, these legs really are pretty average.",'../../assets/L-40-00-00-00-10-001.png'),
    (3,"L-40-20-20-00-10-001","Martial Artist (1)","The powerful legs of the Martial Artist have been trained to near perfection.",'../../assets/L-40-20-20-00-10-001.png'),
    (4,"L-40-30-40-10-00-001","Magic User (1)","The Magic User's legs are strong, beautiful, and deadly.",'../../assets/L-40-30-40-10-00-001.png'),
    (5,"L-40-40-50-70-10-001","Fuzzy Monster (1)","The purple fuzzy monster's legs might be short, but those claws make them dangerous as well.",'../../assets/L-40-40-50-70-10-001.png'),
    (6,"L-40-40-50-80-10-001","Fuzzy Monster (2)","The orange fuzzy monster's legs might be short, but those claws make them dangerous as well.",'../../assets/L-40-40-50-80-10-001.png');
INSERT INTO back_legs(back_legs_id,back_legs,legs_name,legs_desc,legs_image_file)
VALUES
	(1,"L-44-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"L-44-00-00-00-10-001","Default Legs","A totally non-descript pair of legs. Seriously, these legs really are pretty average.",'../../assets/L-44-00-00-00-10-001.png'),
    (3,"L-44-20-20-00-10-001","Martial Artist (1)","The powerful legs of the Martial Artist have been trained to near perfection.",'../../assets/L-44-20-20-00-10-001'),
    (4,"L-44-30-40-10-00-001","Magic User (1)","The Magic User's legs are strong, beautiful, and deadly.",'../../assets/L-44-30-40-10-00-001.png'),
    (5,"L-44-40-50-70-10-001","Fuzzy Monster (1)","The purple fuzzy monster's legs might be short, but those claws make them dangerous as well.",'../../assets/L-44-40-50-70-10-001.png'),
    (6,"L-44-40-50-80-10-001","Fuzzy Monster (2)","The orange fuzzy monster's legs might be short, but those claws make them dangerous as well.",'../../assets/L-44-40-50-80-10-001.png');
INSERT INTO torso(torso_id,torso,torso_name,torso_desc,torso_image_file)
VALUES
	(1,"T-50-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"T-50-00-00-00-10-001","Default Torso","A totally non-descript torso. Seriously, there really isn't anything special about this torso.",'../../assets/T-50-00-00-00-10-001.png'),
    (3,"T-50-20-20-00-20-001","Martial Artist (1)","The martial artist is always looking for a fight. Today, it's your turn.",'../../assets/T-50-20-20-00-20-001.png'),
    (4,"T-50-30-40-20-10-001","Magic User (1)","That skull necklace is rumored to be the skull of a former opponent. Yikes.",'../../assets/T-50-30-40-20-10-001.png'),
    (5,"T-50-40-50-70-00-001","Fuzzy Monster (1)","The purple fuzzy monster is most definitely a people eater.",'../../assets/T-50-40-50-70-00-001.png'),
    (6,"T-50-40-50-80-00-001","Fuzzy Monster (2)","The orange fuzzy monster is most definitely a people eater.",'../../assets/T-50-40-50-80-00-001.png');
INSERT INTO back_torso(back_torso_id,back_torso,torso_name,torso_desc,torso_image_file)
VALUES
	(1,"T-55-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"T-55-00-00-00-10-001","Default Torso","A totally non-descript torso. Seriously, there really isn't anything special about this torso.",'../../assets/T-55-00-00-00-10-001.png'),
    (3,"T-55-20-20-00-20-001","Martial Artist (1)","The martial artist is always looking for a fight. Today, it's your turn.",'../../assets/T-55-20-20-00-20-001.png'),
    (4,"T-55-30-40-20-10-001","Magic User (1)","That skull necklace is rumored to be the skull of a former opponent. Yikes.",'../../assets/T-55-30-40-20-10-001.png'),
    (5,"T-55-40-50-70-20-001","Fuzzy Monster (1)","The purple fuzzy monster is most definitely a people eater.",'../../assets/T-55-40-50-70-20-001.png'),
    (6,"T-55-40-50-80-20-001","Fuzzy Monster (2)","The orange fuzzy monster is most definitely a people eater.",'../../assets/T-55-40-50-80-20-001.png');
INSERT INTO waist(waist_id,waist,waist_name,waist_desc,waist_image_file)
VALUES
	(1,"W-60-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"W-60-00-00-00-10-001","Default Waist","A totally non-descript waist. Seriously, this waist is about as regular as they can get.",'../../assets/W-60-00-00-00-10-001.png'),
    (3,"W-60-20-20-20-00-001","Martial Artist (1)","The Martial Artist's belt is a testament to the time and dedication to battle.",'../../assets/W-60-20-20-20-00-001.png'),
    (4,"W-60-30-40-20-10-001","Magic User (1)","Specially made for both beauty and ease of use, the Magic User's skirt is well designed.",'../../assets/W-60-30-40-20-10-001.png'),
    (5,"W-60-40-50-10-00-001","Fuzzy Monster (1)","This fuzzy tail is as white as the pure driven snow.",'../../assets/W-60-40-50-10-00-001.png'),
    (6,"W-60-40-50-50-00-001","Fuzzy Monster (2)","The fuzzy tail is as brown as the surrounding tree bark.",'../../assets/W-60-40-50-50-00-001.png');
INSERT INTO back_waist(back_waist_id,back_waist,waist_name,waist_desc,waist_image_file)
VALUES
	(1,"W-66-10-00-00-00-001","Sensei","Default Sensei",""),
    (2,"W-66-00-00-00-10-001","Default Waist","A totally non-descript waist. Seriously, this waist is about as regular as they can get.",'../../assets/W-66-00-00-00-10-001.png'),
    (3,"W-66-20-20-20-00-001","Martial Artist (1)","The Martial Artist's belt is a testament to the time and dedication to battle.",'../../assets/W-66-20-20-20-00-001.png'),
    (4,"W-66-30-40-20-10-001","Magic User (1)","Specially made for both beauty and ease of use, the Magic User's skirt is well designed.",'../../assets/W-66-30-40-20-10-001.png'),
    (5,"W-66-40-50-10-10-001","Fuzzy Monster (1)","This fuzzy tail is as white as the pure driven snow.",'../../assets/W-66-40-50-10-10-001.png'),
    (6,"W-66-40-50-50-00-001","Fuzzy Monster (2)","The fuzzy tail is as brown as the surrounding tree bark.",'../../assets/W-66-40-50-50-00-001.png');
-- INSERT INTO accessory(accs_id,accs_name,accs_desc)
-- VALUES
-- 	(1,"0000000000000000","Ancient Staff of Knowledge","A staff carried for hundreds of years by the head of the Dojo."),
--  (2,"0000000000000001","Foam Finger of Doom","It's a foam finger. It's about as threatening as foam can be (which is not very).");
ALTER TABLE users
	add foreign key (stat_id) references user_stats(stat_id),
    add foreign key (avatar_id) references avatar(avatar_id),
    add foreign key (moveset_id) references moveset(moveset_id);
ALTER TABLE avatar
    add foreign key(arms_part) references arms(arms_id),
	add foreign key(back_arms_part) references back_arms(back_arms_id),
    add foreign key(head_part) references head(head_id),
    add foreign key(back_head_part) references back_head(back_head_id),
    add foreign key(legs_part) references legs(legs_id),
    add foreign key(back_legs_part) references back_legs(back_legs_id),
    add foreign key(torso_part) references torso(torso_id),
    add foreign key(back_torso_part) references back_torso(back_torso_id),
    add foreign key(waist_part) references waist(waist_id),
    add foreign key(back_waist_part) references back_waist(back_waist_id);
--    add foreign key(accessory) references accessory(accs_id),
--    add foreign key(back_accessory) references back_accessory(back_accs_id);
--    add foreign key(pet) references pet(pet_id);
alter table moveset
    add foreign key(c_move_id) references chi_move(c_move_id),
    add foreign key(k_move_id) references ken_move(k_move_id),
    add foreign key(s_move_id) references sei_move(s_move_id),
    add foreign key(p_move_id) references surprise_move(p_move_id);
    -- add foreign key(z_move_id) references z_move(z_move_id);
alter table battle
    add foreign key(result_id) references results(result_id);