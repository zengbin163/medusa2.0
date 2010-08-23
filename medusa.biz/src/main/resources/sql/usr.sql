CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) default NULL,
  `password` varchar(32) default NULL,
  PRIMARY KEY  (`id`)
);