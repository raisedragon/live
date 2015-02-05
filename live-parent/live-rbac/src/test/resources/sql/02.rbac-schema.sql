/*
 * WFF Web Application Development Framework
 *
 * Copyright (c) 2006 Marver Solutions Ltd (www.marversolutions.com)
 *
 * Web Fast Forms (WFF) is free software; you can redistribute it and/or modify
 * it under the terms of version 2 of the GNU General Public License as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

CREATE TABLE IF NOT EXISTS `rbac_help_topic` (
  `help_topic_id` varchar(40) NOT NULL default '',
  `help_topic_desc` varchar(100) NOT NULL default '',
  `subsys_id` varchar(8) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`help_topic_id`)
) ENGINE=InnoDB COMMENT='Help Topic';

CREATE TABLE IF NOT EXISTS `rbac_help_text` (
  `help_topic_id` varchar(40) NOT NULL default '',
  `locale_code`	 varchar(6)	NOT NULL default '',
  `help_header` varchar(100) NOT NULL default '',
  `help_text` text,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`help_topic_id`, `locale_code`)
) ENGINE=InnoDB COMMENT='Localized help texts for a topic';

CREATE TABLE IF NOT EXISTS `rbac_app_setting` (
  `record_id` varchar(16) NOT NULL default '',
  `field_id` varchar(32) NOT NULL default '',
  `field_value` varchar(255) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`record_id`,`field_id`)
) ENGINE=InnoDB COMMENT='RBAC application settings';

CREATE TABLE IF NOT EXISTS `rbac_menu_button` (
  `parent_menu_task_id` varchar(40) NOT NULL default '',
  `menu_button_task_id` varchar(40) NOT NULL default '',
  `sort_seq` tinyint(3) unsigned zerofill NOT NULL default '000',
  `button_text_key` varchar(100) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`parent_menu_task_id`,`menu_button_task_id`)
) ENGINE=InnoDB COMMENT='Menu buttons for an application menu';

CREATE TABLE IF NOT EXISTS `rbac_nav_button` (
  `parent_form_task_id` varchar(40) NOT NULL default '',
  `nav_button_task_id` varchar(40) NOT NULL default '',
  `sort_seq` tinyint(3) unsigned zerofill NOT NULL default '000',
  `button_type` varchar(8) NOT NULL default '',
  `button_text_key` varchar(100) default NULL,
  `context_preselect` char(1) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`parent_form_task_id`,`nav_button_task_id`)
) ENGINE=InnoDB COMMENT='Navigation buttons for an application form';

CREATE TABLE IF NOT EXISTS `rbac_web_page_template` (
  `template_id` varchar(16) NOT NULL default '',
  `template_type` varchar(12) NOT NULL default '',
  `template_desc` varchar(60) NOT NULL default '',
  `template_long_desc` text,
  `visible_screen` char(1) default NULL,
  `context_preselect` char(1) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`template_id`)
) ENGINE=InnoDB COMMENT='Web page templates/patterns';


CREATE TABLE IF NOT EXISTS `rbac_role` (
  `role_id` varchar(16) NOT NULL default '',
  `role_desc` varchar(30) NOT NULL default '',
  `start_task_id` varchar(40) default NULL,
  `global_access` char(1) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB COMMENT='Roles used to setup role-based access control';

CREATE TABLE IF NOT EXISTS `rbac_role_task` (
  `role_id` varchar(16) NOT NULL default '',
  `task_id` varchar(40) NOT NULL default '',
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`role_id`,`task_id`)
) ENGINE=InnoDB COMMENT='Task access control lists (ACL) for roles';

CREATE TABLE IF NOT EXISTS `rbac_role_taskfield` (
  `role_id` varchar(16) NOT NULL default '',
  `task_id` varchar(40) NOT NULL default '',
  `field_id` varchar(40) NOT NULL default '',
  `access_type` varchar(4) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`role_id`,`task_id`,`field_id`)
) ENGINE=InnoDB COMMENT='Task-Field access control lists (ACL) for roles';

CREATE TABLE IF NOT EXISTS `rbac_subsystem` (
  `subsys_id` varchar(8) NOT NULL default '',
  `subsys_desc` varchar(255) NOT NULL default '',
  `hivemind_module` varchar(255) default NULL,
  `task_prefix` varchar(8) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`subsys_id`)
) ENGINE=InnoDB COMMENT='Subsystems/applications/modules';

CREATE TABLE IF NOT EXISTS `rbac_task` (
  `task_id` varchar(40) NOT NULL default '',
  `task_desc` varchar(50) NOT NULL default '',
  `task_type` varchar(12) NOT NULL default '',
  `task_action` varchar(40) NOT NULL default '',
  `form_title_text_key` varchar(100) default NULL,
  `breadcrumb_text_key` varchar(100) default NULL,
  `is_disabled` char(1) default NULL,
  `template_id` varchar(16) default NULL,
  `subsys_id` varchar(8) default NULL,
  `help_topic_id` varchar(40) default NULL,
  `initial_passthru_task_action` varchar(40) default NULL,
  `dynamic_where_sql` varchar(255) default NULL,
  `search_where_sql` varchar(255) default NULL,
  `extra_parameters` varchar(40) default NULL,
  `order_by` varchar(255) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`task_id`),
  UNIQUE KEY  (`task_action`),
  KEY `subsys_id` (`subsys_id`),
  KEY `template_id` (`template_id`)
) ENGINE=InnoDB COMMENT='Application Tasks';

CREATE TABLE IF NOT EXISTS `rbac_task_field` (
  `task_id` varchar(40) NOT NULL default '',
  `field_id` varchar(40) NOT NULL default '',
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`task_id`,`field_id`)
) ENGINE=InnoDB COMMENT='Task fields used for task-field access control';

CREATE TABLE IF NOT EXISTS `rbac_user` (
  `user_id` varchar(16) NOT NULL default '',
  `user_name` varchar(30) NOT NULL default '',
  `user_password` varchar(40) NOT NULL default '',
  `role_id` varchar(16) NOT NULL default '',
  `pswd_chg_date` date default NULL,
  `pswd_chg_time` time default NULL,
  `pswd_count` smallint(6) unsigned default NULL,
  `in_use` char(1) NOT NULL default 'N',
  `is_disabled` char(1) NOT NULL default 'N',
  `logon_date` date default NULL,
  `logon_time` time default NULL,
  `language_code` varchar(6) default NULL,
  `start_date` date NOT NULL default '2000-01-01',
  `end_date` date default '9999-12-31',
  `ip_address` varchar(16) default NULL,
  `email_addr` varchar(50) default NULL,
  `created_date` datetime NOT NULL default '2000-01-01 00:00:00',
  `created_user` varchar(16) NOT NULL default 'UNKNOWN',
  `revised_date` datetime default NULL,
  `revised_user` varchar(16) default NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `email_addr` (`email_addr`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB COMMENT='Users';
