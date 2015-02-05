-- MySQL dump 10.10
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.0.21-community-nt
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `rbac_task`
--

INSERT INTO `rbac_task` VALUES ('audit_accesslog_enquire1','View access logs','CHILD_FORM','/auditaccesslog/enquire1','auditaccesslog.enquire1.component.form.title','auditaccesslog.enquire1.component.breadcrumb','N','ENQ1','AUDIT','audit_access_log',NULL,NULL,NULL,NULL,NULL,'2006-07-11 14:48:50','test','2006-07-14 18:49:07','test');
INSERT INTO `rbac_task` VALUES ('audit_accesslog_list1','List access logs from the AUDIT_ACCESS_LOG table','PARENT_FORM','/auditaccesslog/list1','auditaccesslog.list1.component.form.title','auditaccesslog.list1.component.breadcrumb','N','LIST1','AUDIT','audit_access_log',NULL,NULL,NULL,NULL,NULL,'2006-07-11 14:48:30','test','2006-07-15 17:51:26','test');
INSERT INTO `rbac_task` VALUES ('audit_accesslog_search1','Search for access logs','CHILD_FORM','/auditaccesslog/search1','auditaccesslog.search1.component.form.title','auditaccesslog.search1.component.breadcrumb','N','SRCH','AUDIT','audit_access_log',NULL,NULL,NULL,NULL,NULL,'2006-07-11 14:49:09','test','2006-07-15 17:51:36','test');
INSERT INTO `rbac_task` VALUES ('audit_fld_list2','List audit logs from the AUDIT_FLD table','PARENT_FORM','/auditfld/list2','auditfld.list2.component.form.title','auditfld.list2.component.breadcrumb','N','LIST2','AUDIT','audit_access_log','/audittbl/search1',NULL,NULL,NULL,NULL,'2006-07-11 15:16:01','test','2006-07-15 17:52:05','test');
INSERT INTO `rbac_task` VALUES ('audit_fld_list3','List audit logs from the AUDIT_FLD table / entity','PARENT_FORM','/auditfld/list3','auditfld.list3.component.form.title','auditfld.list3.component.breadcrumb','N','LIST3','AUDIT','audit_access_log',NULL,NULL,NULL,'pattern=similar',NULL,'2006-07-11 15:17:18','test','2006-07-16 14:59:01','test');
INSERT INTO `rbac_task` VALUES ('audit_menu','Audit Management Application Menu','MENU','/audit/menu','audit.management.menu.form.title','audit.management.menu.breadcrumb','N','MENU','AUDIT','audit_access_log',NULL,NULL,NULL,NULL,NULL,'2006-07-11 15:25:40','test','2006-07-16 14:59:10','test');
INSERT INTO `rbac_task` VALUES ('audit_tbl_search1','Search for Audit Logs','CHILD_FORM','/audittbl/search1','audittbl.search1.component.form.title','audittbl.search1.component.breadcrumb','N','SRCH','AUDIT','audit_access_log',NULL,NULL,NULL,NULL,NULL,'2006-07-11 15:19:08','test','2006-07-16 14:59:20','test');
INSERT INTO `rbac_task` VALUES ('cb_categories_add1','Add a cookbook category','CHILD_FORM','/categories/add1','categories.add1.component.form.title','categories.add1.component.breadcrumb','N','ADD1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:54:00','RBACADMIN','2006-07-18 17:11:11','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_categories_delete1','Delete a cookbook category','CHILD_FORM','/categories/delete1','categories.delete1.component.form.title','categories.delete1.component.breadcrumb','N','DEL1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:54:42','RBACADMIN','2006-07-18 17:25:57','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_categories_enquire1','View a cookbook category','CHILD_FORM','/categories/enquire1','categories.enquire1.component.form.title','categories.enquire1.component.breadcrumb','N','ENQ1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:54:19','RBACADMIN','2006-07-18 17:26:09','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_categories_list1','List cookbook categories','PARENT_FORM','/categories/list1','categories.list1.component.form.title','categories.list1.component.breadcrumb','N','LIST1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:55:37','RBACADMIN','2006-07-18 17:26:17','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_categories_update1','Update a cookbook category','CHILD_FORM','/categories/update1','categories.update1.component.form.title','categories.update1.component.breadcrumb','N','UPD1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:54:58','RBACADMIN','2006-07-18 17:26:23','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_cookbook_menu','Cookbook Application Menu','MENU','/cookbook/menu','cookbook.menu.form.title','cookbook.menu.breadcrumb','N','MENU','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:43:12','RBACADMIN','2006-07-18 17:24:14','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_recipes_add1','Add a cookbook recipe','CHILD_FORM','/recipes/add1','recipes.add1.component.form.title','recipes.add1.component.breadcrumb','N','ADD1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:56:02','RBACADMIN','2006-07-18 17:24:30','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_recipes_delete1','Delete a cookbook recipe','CHILD_FORM','/recipes/delete1','recipes.delete1.component.form.title','recipes.delete1.component.breadcrumb','N','DEL1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:56:18','RBACADMIN','2006-07-18 17:24:43','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_recipes_enquire1','View a cookbook recipe','CHILD_FORM','/recipes/enquire1','recipes.enquire1.component.form.title','recipes.enquire1.component.breadcrumb','N','ENQ1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:56:34','RBACADMIN','2006-07-18 17:24:56','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_recipes_list1','List cookbook recipes','PARENT_FORM','/recipes/list1','recipes.list1.component.form.title','recipes.list1.component.breadcrumb','N','LIST1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:57:52','RBACADMIN','2006-07-18 17:25:12','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_recipes_search1','Search for cookbook recipes','CHILD_FORM','/recipes/search1','recipes.search1.component.form.title','recipes.search1.component.breadcrumb','N','SRCH','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:57:12','RBACADMIN','2006-07-18 17:25:25','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('cb_recipes_update1','Update a cookbook recipe','CHILD_FORM','/recipes/update1','recipes.update1.component.form.title','recipes.update1.component.breadcrumb','N','UPD1','COOKBOOK',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-17 10:56:51','RBACADMIN','2006-07-18 17:25:38','RBACADMIN');
INSERT INTO `rbac_task` VALUES ('emp_department_add1','Add a department','CHILD_FORM','/department/add1','department.add1.component.form.title','department.add1.component.breadcrumb','N','ADD1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:43:06','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_department_delete1','Delete a department','CHILD_FORM','/department/delete1','department.delete1.component.form.title','department.delete1.component.breadcrumb','N','DEL1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:44:15','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_department_enquire1','View a department','CHILD_FORM','/department/enquire1','department.enquire1.component.form.title','department.enquire1.component.breadcrumb','N','ENQ1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:45:15','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_department_list1','List departments','PARENT_FORM','/department/list1','department.list1.component.form.title','department.list1.component.breadcrumb','N','LIST1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:42:14','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_department_search1','Search for departments','CHILD_FORM','/department/search1','department.search1.component.form.title','department.search1.component.breadcrumb','N','SRCH','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:43:42','test','2006-07-12 13:09:50','test');
INSERT INTO `rbac_task` VALUES ('emp_department_update1','Update a department','CHILD_FORM','/department/update1','department.update1.component.form.title','department.update1.component.breadcrumb','N','UPD1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:44:39','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employeeaddress_add2','Add an Address record for an Employee','CHILD_FORM','/employeeaddress/add2','employeeaddress.add2.component.form.title','employeeaddress.add2.component.breadcrumb','N','ADD2','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:23:19','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employeeaddress_delete1','Delete an Address record for an Employee','CHILD_FORM','/employeeaddress/delete1','employeeaddress.delete1.component.form.title','employeeaddress.delete1.component.breadcrumb','N','DEL1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:26:28','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employeeaddress_enquire1','View an Address record for an Employee','CHILD_FORM','/employeeaddress/enquire1','employeeaddress.enquire1.component.form.title','employeeaddress.enquire1.component.breadcrumb','N','ENQ1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:25:06','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employeeaddress_list2','List Address records for an Employee','PARENT_FORM','/employeeaddress/list2','employeeaddress.list2.component.form.title','employeeaddress.list2.component.breadcrumb','N','LIST2','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:22:20','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employeeaddress_search1','Search for employe address records','CHILD_FORM','/employeeaddress/search1','employeeaddress.search1.component.form.title','employeeaddress.search1.component.breadcrumb','N','SRCH','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:24:26','test','2006-07-12 13:10:17','test');
INSERT INTO `rbac_task` VALUES ('emp_employeeaddress_update1','Update an Address record for an Employee','CHILD_FORM','/employeeaddress/update1','employeeaddress.update1.component.form.title','employeeaddress.update1.component.breadcrumb','N','UPD1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:25:42','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employee_add1','Add an employee','CHILD_FORM','/employee/add1','employee.add1.component.form.title','employee.add1.component.breadcrumb','N','ADD1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:51:08','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employee_delete1','Delete an employee','CHILD_FORM','/employee/delete1','employee.delete1.component.form.title','employee.delete1.component.breadcrumb','N','DEL1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:52:49','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employee_enquire1','View an employee','CHILD_FORM','/employee/enquire1','employee.enquire1.component.form.title','employee.enquire1.component.breadcrumb','N','ENQ1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:52:00','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employee_filepicker','Add a favorite skype picture to an Employee','CHILD_FORM','/employee/filepicker','employee.filepicker.component.form.title','employee.filepicker.component.breadcrumb','N','FILEPICKER','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:18:58','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employee_list1','List employees','PARENT_FORM','/employee/list1','employee.list1.component.form.title','employee.list1.component.breadcrumb','N','LIST1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:50:27','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_employee_search1','Search for employees','CHILD_FORM','/employee/search1','employee.search1.component.form.title','employee.search1.component.breadcrumb','N','SRCH','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:51:35','test','2006-07-12 13:10:24','test');
INSERT INTO `rbac_task` VALUES ('emp_employee_update1','Update an employee','CHILD_FORM','/employee/update1','employee.update1.component.form.title','employee.update1.component.breadcrumb','N','UPD1','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 17:52:26','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('emp_menu','Employee Management App Menu','MENU','/employee/menu','employee.management.menu.form.title','employee.management.menu.breadcrumb','N','MENU','EMPLOYEE',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-11 18:02:34','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('previous_search','Previous Search (available after normal Search)','OPERATION','/previous_search',NULL,NULL,'N','PREV_SEARCH','SYSTEM',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-15 17:44:11','test','2006-07-15 17:49:07','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptext_add2','Add a localized help text for a help topic','CHILD_FORM','/rbac/helptext/add2','rbac.helptext.add2.component.form.title','rbac.helptext.add2.component.breadcrumb','N','ADD2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-13 14:34:01','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_helptext_delete1','Delete a localized help text','CHILD_FORM','/rbac/helptext/delete1','rbac.helptext.delete1.component.form.title','rbac.helptext.delete1.component.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:13:40','test','2006-07-13 14:32:22','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptext_enquire1','View a localized help text','CHILD_FORM','/rbac/helptext/enquire1','rbac.helptext.enquire1.component.form.title','rbac.helptext.enquire1.component.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:14:06','test','2006-07-13 14:32:30','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptext_list2','List localized help texts for a help topic','PARENT_FORM','/rbac/helptext/list2','rbac.helptext.list2.component.form.title','rbac.helptext.list2.component.breadcrumb','N','LIST2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-13 14:33:23','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_helptext_update1','Update a localized help text','CHILD_FORM','/rbac/helptext/update1','rbac.helptext.update1.component.form.title','rbac.helptext.update1.component.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:14:30','test','2006-07-13 14:32:39','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_add1','Add a help topic','CHILD_FORM','/rbac/helptopic/add1','rbac.helptopic.add1.component.form.title','rbac.helptopic.add1.component.breadcrumb','N','ADD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-13 14:34:01','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_datapicker1','Choose a a help topic','CHILD_FORM','/rbac/helptopic/datapicker','rbac.helptopic.datapicker1.component.form.title','rbac.helptopic.datapicker1.component.breadcrumb','N','DATAPICKER1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-13 14:34:44','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_delete1','Delete a help topic','CHILD_FORM','/rbac/helptopic/delete1','rbac.helptopic.delete1.component.form.title','rbac.helptopic.delete1.component.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:13:40','test','2006-07-13 14:32:22','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_enquire1','View a help topic','CHILD_FORM','/rbac/helptopic/enquire1','rbac.helptopic.enquire1.component.form.title','rbac.helptopic.enquire1.component.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:14:06','test','2006-07-13 14:32:30','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_list1','List help topics','PARENT_FORM','/rbac/helptopic/list1','rbac.helptopic.list1.component.form.title','rbac.helptopic.list1.component.breadcrumb','N','LIST1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-13 14:33:23','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_search1','Update a a help topic','CHILD_FORM','/rbac/helptopic/search1','rbac.helptopic.search1.component.form.title','rbac.helptopic.search1.component.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:14:30','test','2006-07-13 14:32:39','test');
INSERT INTO `rbac_task` VALUES ('rbac_helptopic_update1','Update a a help topic','CHILD_FORM','/rbac/helptopic/update1','rbac.helptopic.update1.component.form.title','rbac.helptopic.update1.component.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 21:14:30','test','2006-07-13 14:32:39','test');
INSERT INTO `rbac_task` VALUES ('rbac_link_role_task','Link tasks to selected role','PARENT_FORM','/rbac/roletask/link1','rbac.forms.role_task.link1.form.title','rbac.forms.role_task.link1.breadcrumb','N','LINK1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:58:53','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_link_task_role','Link roles to selected task','PARENT_FORM','/rbac/taskrole/link1','rbac.forms.task_role.link1.form.title','rbac.forms.task_role.link1.breadcrumb','N','LINK1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:00:06','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_menu','The RBAC Application Menu','MENU','/rbac/menu','rbac.mainmenu.form.title','rbac.mainmenu.breadcrumb','N','MENU','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 13:15:04','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_menubutton_add3','Add multiple menu buttons to a menu task','CHILD_FORM','/rbac/menubutton/add3','rbac.forms.menu_button.add3.form.title','rbac.forms.menu_button.add3.breadcrumb','N','ADD3','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:20:37','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_menubutton_delete2','Delete multiple selected menu buttons, no screen','CHILD_FORM','/rbac/menubutton/delete2','rbac.forms.menu_button.delete2.form.title','rbac.forms.menu_button.delete2.breadcrumb','N','DEL2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:19:51','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_menubutton_enquire1','View a menu button','CHILD_FORM','/rbac/menubutton/enquire1','rbac.forms.menu_button.enquire1.form.title','rbac.forms.menu_button.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:21:21','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_menubutton_multi2','Maintain menu buttons for a menu task','PARENT_FORM','/rbac/menubutton/multi2','rbac.forms.menu_button.multi2.form.title','rbac.forms.menu_button.multi2.breadcrumb','N','MULTI2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:17:51','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_menubutton_update1','Update a menu button','CHILD_FORM','/rbac/menubutton/update1','rbac.forms.menu_button.update1.form.title','rbac.forms.menu_button.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:21:41','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_navbutton_add3','Add multiple navigation buttons to a form task','CHILD_FORM','/rbac/navbutton/add3','rbac.forms.nav_button.add3.form.title','rbac.forms.nav_button.add3.breadcrumb','N','ADD3','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:25:13','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_navbutton_delete2','Delete multiple selected nav. buttons, no screen','CHILD_FORM','/rbac/navbutton/delete2','rbac.forms.nav_button.delete2.form.title','rbac.forms.nav_button.delete2.breadcrumb','N','DEL2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:25:47','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_navbutton_enquire1','View a navigation button','CHILD_FORM','/rbac/navbutton/enquire1','rbac.forms.nav_button.enquire1.form.title','rbac.forms.nav_button.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:26:19','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_navbutton_multi2','Maintain navigation buttons for a form task','PARENT_FORM','/rbac/navbutton/multi2','rbac.forms.nav_button.multi2.form.title','rbac.forms.nav_button.multi2.breadcrumb','N','MULTI2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:24:33','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_navbutton_update1','Update a navigation button','CHILD_FORM','/rbac/navbutton/update1','rbac.forms.nav_button.update1.form.title','rbac.forms.nav_button.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 11:26:44','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_pagetemplate_add1','Add a web page template','CHILD_FORM','/rbac/pagetemplate/add1','rbac.forms.page_template.add1.form.title','rbac.forms.page_template.add1.breadcrumb','N','ADD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:49:55','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_pagetemplate_delete1','Delete a web page template','CHILD_FORM','/rbac/pagetemplate/delete1','rbac.forms.page_template.delete1.form.title','rbac.forms.page_template.delete1.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:51:28','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_pagetemplate_enquire1','View a web page template','CHILD_FORM','/rbac/pagetemplate/enquire1','rbac.forms.page_template.enquire1.form.title','rbac.forms.page_template.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:50:47','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_pagetemplate_list1','List web page templates','PARENT_FORM','/rbac/pagetemplate/list1','rbac.forms.page_template.list1.form.title','rbac.forms.page_template.list1.breadcrumb','N','LIST1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:49:30','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_pagetemplate_search1','Search for web page templates','CHILD_FORM','/rbac/pagetemplate/search1','rbac.forms.page_template.search1.form.title','rbac.forms.page_template.search1.breadcrumb','N','SRCH','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:50:25','test','2006-07-12 13:10:31','test');
INSERT INTO `rbac_task` VALUES ('rbac_pagetemplate_update1','Update a web page template','CHILD_FORM','/rbac/pagetemplate/update1','rbac.forms.page_template.update1.form.title','rbac.forms.page_template.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:51:07','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_roletaskfield_multi3','Set task field access by role','PARENT_FORM','/rbac/roletaskfield/multi3','rbac.forms.roletaskfield.multi3.component.form.title','rbac.forms.roletaskfield.multi3.component.breadcrumb','N','MULTI3','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:37:08','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_role_add1','Add a role','CHILD_FORM','/rbac/role/add1','rbac.forms.role.add1.form.title','rbac.forms.role.add1.breadcrumb','N','ADD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:54:53','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_role_datapicker1','Choose roles','CHILD_FORM','/rbac/role/datapicker','rbac.forms.role.datapicker1.form.title','rbac.forms.role.datapicker1.breadcrumb','N','DATAPICKER1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:58:13','test','2006-07-12 16:45:07','test');
INSERT INTO `rbac_task` VALUES ('rbac_role_delete1','Delete a role','CHILD_FORM','/rbac/role/delete1','rbac.forms.role.delete1.form.title','rbac.forms.role.delete1.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:56:16','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_role_enquire1','View a role','CHILD_FORM','/rbac/role/enquire1','rbac.forms.role.enquire1.form.title','rbac.forms.role.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:55:36','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_role_list1','List roles','PARENT_FORM','/rbac/role/list1','rbac.forms.role.list1.form.title','rbac.forms.role.list1.breadcrumb','N','LIST1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:54:30','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_role_search1','Search for roles','CHILD_FORM','/rbac/role/search1','rbac.forms.role.search1.form.title','rbac.forms.role.search1.breadcrumb','N','SRCH','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:55:16','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_role_update1','Update a role','CHILD_FORM','/rbac/role/update1','rbac.forms.role.update1.form.title','rbac.forms.role.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:55:55','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_subsystem_add1','Add a subsystem','CHILD_FORM','/rbac/subsystem/add1','rbac.forms.subsystem.add1.form.title','rbac.forms.subsystem.add1.breadcrumb','N','ADD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:43:36','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_subsystem_delete1','Delete a subsystem','CHILD_FORM','/rbac/subsystem/delete1','rbac.forms.subsystem.delete1.form.title','rbac.forms.subsystem.delete1.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:45:08','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_subsystem_enquire1','View a subsystem','CHILD_FORM','/rbac/subsystem/enquire1','rbac.forms.subsystem.enquire1.form.title','rbac.forms.subsystem.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:44:25','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_subsystem_list1','List subsystems','PARENT_FORM','/rbac/subsystem/list1','rbac.forms.subsystem.list1.form.title','rbac.forms.subsystem.list1.breadcrumb','N','LIST1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:43:05','test','2006-07-12 09:45:41','test');
INSERT INTO `rbac_task` VALUES ('rbac_subsystem_search1','Search for subsystems','CHILD_FORM','/rbac/subsystem/search1','rbac.forms.subsystem.search1.form.title','rbac.forms.subsystem.search1.breadcrumb','N','SRCH','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:44:05','test','2006-07-12 13:10:41','test');
INSERT INTO `rbac_task` VALUES ('rbac_subsystem_update1','Update a subsystem','CHILD_FORM','/rbac/subsystem/update1','rbac.forms.subsystem.update1.form.title','rbac.forms.subsystem.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 09:44:46','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_taskfieldrole_multi3','Set task field access by task','PARENT_FORM','/rbac/taskfieldrole/multi3','rbac.forms.taskfieldrole.multi3.component.form.title','rbac.forms.taskfieldrole.multi3.component.breadcrumb','N','MULTI3','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:38:21','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_taskfield_add2','Add a task field for a task','CHILD_FORM','/rbac/taskfield/add2','rbac.forms.taskfield.add2.component.form.title','rbac.forms.taskfield.add2.component.breadcrumb','N','ADD2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:50:09','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_taskfield_delete1','Delete a task field for a task','CHILD_FORM','/rbac/taskfield/delete1','rbac.forms.taskfield.delete1.component.form.title','rbac.forms.taskfield.delete1.component.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:50:39','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_taskfield_list2','List task fields for a task','PARENT_FORM','/rbac/taskfield/list2','rbac.forms.taskfield.list2.component.form.title','rbac.forms.taskfield.list2.component.breadcrumb','N','LIST2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:48:41','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_task_add1','Add a task','CHILD_FORM','/rbac/task/add1','rbac.forms.task.add1.form.title','rbac.forms.task.add1.breadcrumb','N','ADD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:40:44','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_task_datapicker1','Choose a task','CHILD_FORM','/rbac/task/datapicker','rbac.forms.task.datapicker1.form.title','rbac.forms.task.datapicker1.breadcrumb','N','DATAPICKER1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:43:16','test','2006-07-12 16:45:13','test');
INSERT INTO `rbac_task` VALUES ('rbac_task_delete1','Delete a task','CHILD_FORM','/rbac/task/delete1','rbac.forms.task.delete1.form.title','rbac.forms.task.delete1.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:42:37','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_task_enquire1','View a task','CHILD_FORM','/rbac/task/enquire1','rbac.forms.task.enquire1.form.title','rbac.forms.task.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:41:56','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_task_list1','List tasks','PARENT_FORM','/rbac/task/list1','rbac.forms.task.list1.form.title','rbac.forms.task.list1.breadcrumb','N','LIST1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:40:16','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_task_search1','Search for tasks','CHILD_FORM','/rbac/task/search1','rbac.forms.task.search1.form.title','rbac.forms.task.search1.breadcrumb','N','SRCH','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:41:29','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_task_update1','Update a task','CHILD_FORM','/rbac/task/update1','rbac.forms.task.update1.form.title','rbac.forms.task.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 12:42:18','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_add1','Add a user','CHILD_FORM','/rbac/user/add1','rbac.forms.user.add1.form.title','rbac.forms.user.add1.breadcrumb','N','ADD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:01:13','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_changepwd','Change password for a user','CHILD_FORM','/rbac/user/changepwd','rbac.forms.user.changepwd.form.title','rbac.forms.user.changepwd.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:04:18','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_delete1','Delete a user','CHILD_FORM','/rbac/user/delete1','rbac.forms.user.delete1.form.title','rbac.forms.user.delete1.breadcrumb','N','DEL1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:02:41','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_enquire1','View a user','CHILD_FORM','/rbac/user/enquire1','rbac.forms.user.enquire1.form.title','rbac.forms.user.enquire1.breadcrumb','N','ENQ1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:01:59','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_list1','List users','PARENT_FORM','/rbac/user/list1','rbac.forms.user.list1.form.title','rbac.forms.user.list1.breadcrumb','N','LIST1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:00:21','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_list2','List users by role','PARENT_FORM','/rbac/user/list2','rbac.forms.user.list2.form.title','rbac.forms.user.list2.breadcrumb','N','LIST2','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:00:51','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_resetpwd','Reset password for a user','CHILD_FORM','/rbac/user/resetpwd','rbac.forms.user.resetpwd.form.title','rbac.forms.user.resetpwd.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:04:44','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_search1','Search for users','CHILD_FORM','/rbac/user/search1','rbac.forms.user.search1.form.title','rbac.forms.user.search1.breadcrumb','N','SRCH','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:01:37','test',NULL,NULL);
INSERT INTO `rbac_task` VALUES ('rbac_user_update1','Update a user','CHILD_FORM','/rbac/user/update1','rbac.forms.user.update1.form.title','rbac.forms.user.update1.breadcrumb','N','UPD1','RBAC',NULL,NULL,NULL,NULL,NULL,NULL,'2006-07-12 10:02:19','test',NULL,NULL);

--
-- Dumping data for table `rbac_nav_button`
--

INSERT INTO `rbac_nav_button` VALUES ('audit_accesslog_list1','audit_accesslog_enquire1',001,'READ','standard.navigation.button.read','Y','2006-07-11 14:49:18','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('audit_accesslog_list1','audit_accesslog_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-11 14:49:18','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('audit_fld_list2','audit_tbl_search1',001,'SEARCH','standard.navigation.button.search','N','2006-07-11 15:19:24','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_categories_list1','cb_categories_add1',002,'NEW','standard.navigation.button.new','N','2006-07-18 17:52:41','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_categories_list1','cb_categories_delete1',004,'DELETE','standard.navigation.button.delete','Y','2006-07-18 17:52:41','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_categories_list1','cb_categories_enquire1',001,'READ','standard.navigation.button.read','Y','2006-07-18 17:52:41','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_categories_list1','cb_categories_update1',003,'UPDATE','standard.navigation.button.update','Y','2006-07-18 17:52:41','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_recipes_list1','cb_recipes_add1',003,'NEW','standard.navigation.button.new','N','2006-07-18 18:02:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_recipes_list1','cb_recipes_delete1',001,'DELETE','standard.navigation.button.delete','Y','2006-07-18 18:02:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_recipes_list1','cb_recipes_enquire1',004,'READ','standard.navigation.button.read','Y','2006-07-18 18:02:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_recipes_list1','cb_recipes_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-18 18:02:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('cb_recipes_list1','cb_recipes_update1',005,'UPDATE','standard.navigation.button.update','Y','2006-07-18 18:02:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('emp_department_list1','audit_fld_list3',006,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-11 17:45:44','test','2006-07-11 17:46:44','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_department_list1','emp_department_add1',001,'NEW','standard.navigation.button.new','N','2006-07-11 17:45:44','test','2006-07-11 17:46:08','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_department_list1','emp_department_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-11 17:45:44','test','2006-07-11 17:46:08','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_department_list1','emp_department_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-11 17:45:44','test','2006-07-11 17:46:08','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_department_list1','emp_department_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-11 17:45:44','test','2006-07-11 17:46:08','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_department_list1','emp_department_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-11 17:45:44','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('emp_employeeaddress_list2','audit_fld_list3',006,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-11 17:37:11','test','2006-07-11 17:38:35','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employeeaddress_list2','emp_employeeaddress_add2',001,'NEW','standard.navigation.button.new','Y','2006-07-11 17:27:11','test','2006-07-11 17:27:50','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employeeaddress_list2','emp_employeeaddress_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-11 17:27:11','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('emp_employeeaddress_list2','emp_employeeaddress_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-11 17:27:11','test','2006-07-11 17:27:50','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employeeaddress_list2','emp_employeeaddress_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-11 17:27:11','test','2006-07-11 17:27:50','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employeeaddress_list2','emp_employeeaddress_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-11 17:27:11','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','audit_fld_list3',007,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-11 17:53:39','test','2006-07-11 17:54:59','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','emp_employeeaddress_list2',006,'CUSTOM','employee.list1.component.custom.navigation.button.employeeaddress.list2','Y','2006-07-11 17:53:39','test','2006-07-11 17:56:45','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','emp_employee_add1',001,'NEW','standard.navigation.button.new','N','2006-07-11 17:53:21','test','2006-07-11 17:54:15','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','emp_employee_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-11 17:53:21','test','2006-07-11 17:54:15','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','emp_employee_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-11 17:53:21','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','emp_employee_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-11 17:53:21','test','2006-07-11 17:54:15','test');
INSERT INTO `rbac_nav_button` VALUES ('emp_employee_list1','emp_employee_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-11 17:53:21','test','2006-07-11 17:54:15','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptext_list2','audit_fld_list3',005,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 09:52:13','test','2006-07-12 09:52:38','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptext_list2','rbac_helptext_add2',001,'NEW','standard.navigation.button.new','N','2006-07-13 14:35:37','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptext_list2','rbac_helptext_delete1',004,'DELETE','standard.navigation.button.delete','Y','2006-07-13 14:35:37','test','2006-07-13 14:35:48','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptext_list2','rbac_helptext_enquire1',002,'READ','standard.navigation.button.read','Y','2006-07-13 14:35:37','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptext_list2','rbac_helptext_update1',003,'UPDATE','standard.navigation.button.update','Y','2006-07-13 14:35:37','test','2006-07-13 14:35:48','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptopic_list1','rbac_helptext_list2',006,'CUSTOM','rbac.helptopic.list1.component.custom.navigation.button.rbac.helptext.list2','Y','2006-07-13 14:35:37','test','2006-07-13 14:35:48','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptopic_list1','rbac_helptopic_add1',001,'NEW','standard.navigation.button.new','N','2006-07-13 14:35:37','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptopic_list1','rbac_helptopic_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-13 14:35:37','test','2006-07-13 14:35:48','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptopic_list1','rbac_helptopic_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-13 14:35:37','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptopic_list1','rbac_helptopic_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-13 14:35:37','test','2006-07-13 14:35:48','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_helptopic_list1','rbac_helptopic_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-13 14:35:37','test','2006-07-13 14:35:48','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_link_role_task','rbac_task_search1',001,'SEARCH','standard.navigation.button.search','N','2006-07-12 12:59:30','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_link_task_role','rbac_role_search1',001,'SEARCH','standard.navigation.button.search','N','2006-07-12 12:01:19','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_menubutton_multi2','rbac_menubutton_add3',001,'NEW','standard.navigation.button.new','N','2006-07-12 11:22:48','test','2006-07-12 11:23:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_menubutton_multi2','rbac_menubutton_delete2',004,'DELETE','standard.navigation.button.delete','Y','2006-07-12 11:22:48','test','2006-07-12 11:23:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_menubutton_multi2','rbac_menubutton_enquire1',002,'READ','standard.navigation.button.read','Y','2006-07-12 11:22:48','test','2006-07-12 11:23:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_menubutton_multi2','rbac_menubutton_update1',003,'UPDATE','standard.navigation.button.update','Y','2006-07-12 11:22:48','test','2006-07-12 11:23:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_navbutton_multi2','rbac_navbutton_add3',001,'NEW','standard.navigation.button.new','N','2006-07-12 11:27:15','test','2006-07-12 11:27:30','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_navbutton_multi2','rbac_navbutton_delete2',004,'DELETE','standard.navigation.button.delete','Y','2006-07-12 11:27:14','test','2006-07-12 11:27:30','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_navbutton_multi2','rbac_navbutton_enquire1',002,'READ','standard.navigation.button.read','Y','2006-07-12 11:27:15','test','2006-07-12 11:27:30','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_navbutton_multi2','rbac_navbutton_update1',003,'UPDATE','standard.navigation.button.update','Y','2006-07-12 11:27:14','test','2006-07-12 11:27:30','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_pagetemplate_list1','audit_fld_list3',006,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 09:52:13','test','2006-07-12 09:52:38','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_pagetemplate_list1','rbac_pagetemplate_add1',001,'NEW','standard.navigation.button.new','N','2006-07-12 09:52:13','test','2006-07-12 09:52:39','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_pagetemplate_list1','rbac_pagetemplate_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-12 09:52:13','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_pagetemplate_list1','rbac_pagetemplate_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-12 09:52:13','test','2006-07-12 09:52:39','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_pagetemplate_list1','rbac_pagetemplate_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-12 09:52:13','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_pagetemplate_list1','rbac_pagetemplate_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-12 09:52:13','test','2006-07-12 09:52:39','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','audit_fld_list3',009,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 12:55:38','test','2006-07-12 12:57:53','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_link_role_task',007,'CUSTOM','rbac.forms.role.custom.navigation.button.set.task.access','Y','2006-07-12 12:55:38','test','2006-07-12 12:57:53','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_roletaskfield_multi3',008,'CUSTOM','rbac.forms.role.custom.navigation.button.set.taskfield.access','Y','2006-07-12 12:55:38','test','2006-07-12 12:57:53','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_role_add1',001,'NEW','standard.navigation.button.new','N','2006-07-12 12:55:38','test','2006-07-12 12:56:08','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_role_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-12 12:55:38','test','2006-07-12 12:56:08','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_role_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-12 12:55:38','test','2006-07-12 12:56:08','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_role_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-12 12:55:38','test','2006-07-12 12:56:08','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_role_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-12 12:55:38','test','2006-07-12 12:56:08','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_role_list1','rbac_user_list2',006,'CUSTOM','rbac.forms.role.custom.navigation.button.list.users','Y','2006-07-12 12:55:38','test','2006-07-12 12:57:53','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_subsystem_list1','audit_fld_list3',006,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 09:46:36','test','2006-07-12 09:47:28','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_subsystem_list1','rbac_subsystem_add1',001,'NEW','standard.navigation.button.new','N','2006-07-12 09:46:37','test','2006-07-12 09:47:00','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_subsystem_list1','rbac_subsystem_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-12 09:46:37','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_subsystem_list1','rbac_subsystem_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-12 09:46:37','test','2006-07-12 09:47:00','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_subsystem_list1','rbac_subsystem_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-12 09:46:37','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_subsystem_list1','rbac_subsystem_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-12 09:46:37','test','2006-07-12 09:47:01','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_taskfield_list2','rbac_taskfield_add2',001,'NEW','standard.navigation.button.new','Y','2006-07-12 13:07:50','test','2006-07-12 13:08:00','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_taskfield_list2','rbac_taskfield_delete1',002,'DELETE','standard.navigation.button.delete','Y','2006-07-12 13:07:49','test','2006-07-12 13:08:00','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','audit_fld_list3',011,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 13:02:11','test','2006-07-12 13:06:11','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_link_task_role',008,'CUSTOM','rbac.forms.task.custom.navigation.button.set.task.access','Y','2006-07-12 13:02:12','test','2006-07-12 13:04:52','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_menubutton_multi2',007,'CUSTOM','rbac.forms.task.custom.navigation.button.maintain.menu.buttons','Y','2006-07-12 13:02:12','test','2006-07-12 13:04:52','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_navbutton_multi2',006,'CUSTOM','rbac.forms.task.custom.navigation.button.maintain.nav.buttons','Y','2006-07-12 13:02:12','test','2006-07-12 13:04:52','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_taskfieldrole_multi3',010,'CUSTOM','rbac.forms.task.custom.navigation.button.set.taskfield.access','Y','2006-07-12 13:05:21','test','2006-07-12 13:06:41','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_taskfield_list2',009,'CUSTOM','rbac.forms.task.custom.navigation.button.maintain.taskfields','Y','2006-07-12 13:02:12','test','2006-07-12 13:04:52','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_task_add1',001,'NEW','standard.navigation.button.new','N','2006-07-12 13:02:12','test','2006-07-12 13:03:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_task_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-12 13:02:12','test','2006-07-12 13:03:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_task_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-12 13:02:11','test','2006-07-12 13:03:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_task_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-12 13:02:12','test','2006-07-12 13:03:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_task_list1','rbac_task_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-12 13:02:12','test','2006-07-12 13:03:07','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','audit_fld_list3',008,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 10:06:13','test','2006-07-12 10:08:27','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_add1',001,'NEW','standard.navigation.button.new','N','2006-07-12 10:06:01','test','2006-07-12 10:07:06','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_changepwd',006,'UPDATE','rbac.forms.user.custom.navigation.button.changepwd','Y','2006-07-12 10:06:00','test','2006-07-12 10:08:27','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_delete1',005,'DELETE','standard.navigation.button.delete','Y','2006-07-12 10:06:00','test','2006-07-12 10:07:06','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_enquire1',003,'READ','standard.navigation.button.read','Y','2006-07-12 10:06:00','test','2006-07-12 10:07:06','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_resetpwd',007,'UPDATE','rbac.forms.user.custom.navigation.button.resetpwd','Y','2006-07-12 10:06:00','test','2006-07-12 10:08:27','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_search1',002,'SEARCH','standard.navigation.button.search','N','2006-07-12 10:06:00','test','2006-07-12 10:07:06','test');
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list1','rbac_user_update1',004,'UPDATE','standard.navigation.button.update','Y','2006-07-12 10:06:00','test',NULL,NULL);
INSERT INTO `rbac_nav_button` VALUES ('rbac_user_list2','audit_fld_list3',001,'CUSTOM','audit.log.navigation.button.name','Y','2006-07-12 10:09:59','test','2006-07-12 10:10:12','test');

--
-- Dumping data for table `rbac_task_field`
--


--
-- Dumping data for table `rbac_web_page_template`
--

INSERT INTO `rbac_web_page_template` VALUES ('ADD1','ADD1','ADD1 - Insert a single record','This will allow the user to add a single record to a database table.\r\n\r\nThis will call the \'insertRecord\' method just once.','Y','N','2003-01-01 12:00:00','AJM','2004-04-11 16:38:46','AJM');
INSERT INTO `rbac_web_page_template` VALUES ('ADD2','ADD2','ADD2 - Insert a single child record','This will add an occurrence to the MANY entity in a ONE-to-MANY relationship with the primary key of the ONE entity being passed down from the previous screen.\r\n\r\nThis will call the \'insertRecord\' method just once.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-11 17:12:34','test');
INSERT INTO `rbac_web_page_template` VALUES ('ADD3','ADD3','ADD3 - Insert multiple records without user dialog','This will add records to the database without any dialog with the user.\r\n\r\nIt will use the primary key supplied by the previous screen and one or more primary keys selected in a data picker screen which will be called next.\r\n\r\nThis uses repeated calls to the \'insertRecord\' method.','N','N','2003-01-01 12:00:00','AJM','2004-04-11 16:39:10','AJM');
INSERT INTO `rbac_web_page_template` VALUES ('DATAPICKER','DATAPICKER1','DATAPICKER - Choose records','This shows the user a list of available data rows from a database table and allows the user to choose one (or more) for processing in the previous screen.\r\n\r\nThis is the same as a LIST1 template with a \r\nCHOOSE button on it. Plus the possibility to switch betweem multi and single selection mode.','Y','N','2006-07-12 16:42:44','test','2006-07-12 16:43:20','test');
INSERT INTO `rbac_web_page_template` VALUES ('DEL1','DELETE1','DEL1 - Delete a single record','This will delete a single record from the database using the primary key passed down by the previous screen.\r\n\r\nThis will call the \'deleteRecord\' method.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-09 18:05:06','test');
INSERT INTO `rbac_web_page_template` VALUES ('DEL2','DELETE2','DEL2 - Delete multiple records without user dialog','This will delete multiple records one at a time using the primary keys passed down from the previous screen.\r\n\r\nThis uses the \'deleteMultiple\' method.','N','Y','2003-01-01 12:00:00','AJM','2006-07-09 18:05:14','test');
INSERT INTO `rbac_web_page_template` VALUES ('ENQ1','ENQUIRE1','ENQ1 - Enquire/View a single record','This will read a single record from the database using the primary key passed down by the previous screen and display it to the user.\r\n\r\nIf multiple rows are selected then scrolling options will be provided.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-11 17:11:47','test');
INSERT INTO `rbac_web_page_template` VALUES ('FILEPICKER','FILEPICKER1','FILEPICKER - File Picker','This will allow the user to select the name of a file.','Y','N','2003-01-01 12:00:00','AJM','2004-04-11 16:40:44','AJM');
INSERT INTO `rbac_web_page_template` VALUES ('LINK1','LINK1','LINK1 - Update LINK table','This deals with a ONE-to-MANY-to-ONE relationship where MANY indicates a yes/no link between both of the ONE tables.\r\n\r\nThis allows multiple occurrences of MANY to be created, modified or deleted in a single screen.\r\n\r\nThis will call the \'updateLinkData\' method.','Y','Y','2003-01-01 12:00:00','AJM',NULL,NULL);
INSERT INTO `rbac_web_page_template` VALUES ('LIST1','LIST1','LIST1 - List multiple records','This will list all available rows from a database table one page at a time with (usually) 10 rows in each page.\r\n\r\nLinks at the bottom of the page will allow the user to jump to the first/last/previous/next page.\r\n\r\nThe selection may be refined by using the SEARCH button. This will bring up another screen into which selection criteria can be entered.','Y','N','2003-01-01 12:00:00','AJM','2004-04-11 16:57:00','AJM');
INSERT INTO `rbac_web_page_template` VALUES ('LIST2','LIST2','LIST2 - List multiple child records','This will list rows of MANY in a ONE-to-MANY relationship one page at a time with (usually) 10 rows in each page.\r\n\r\nThe primary key of ONE will be passed down from the previous screen.\r\n\r\nLinks at the bottom of the page will allow the user to jump to the first/last/previous/next page.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-11 17:13:00','test');
INSERT INTO `rbac_web_page_template` VALUES ('LIST3','LIST3','LIST3 - List multiple grandchild records','This will list rows of MANY(1) and MANY(2) in a ONE-to-MANY(1)-to-MANY(2) relationship.\r\n\r\nMANY(1)-to-MANY(2) is another ONE-to-MANY relationship\r\n\r\nThe primary key of ONE will be passed down from the previous screen.\r\n\r\nThis will then be passed to MANY(1) for processing.\r\n\r\nThe primary key of MANY(1) will then be passed to MANY(2) for processing.\r\n\r\nLinks at the bottom of the page will allow the user to jump to the first/last/previous/next page.','Y','Y','2005-06-22 23:17:59','AJM','2006-07-11 17:13:34','test');
INSERT INTO `rbac_web_page_template` VALUES ('MENU','MENU1','MENU - Display menu bar','This will display a list of menu buttons and allow the user to select one.','Y','N','2003-01-01 12:00:00','AJM','2006-07-11 17:14:01','test');
INSERT INTO `rbac_web_page_template` VALUES ('MULTI1','MULTI1','MULTI1 - Update/Insert/delete multiple records','This will take a selection of primary keys and allow individual databases rows to be inserted, updated or deleted.\r\n\r\nThe identity of the row(s) to be processed is passed down from the previous screen, and scrolling between rows is controlled by the setScrollArray() and getScrollItem() methods\r\n\r\nThis will deal with one row at a time and will call either the \'insertRecord\', \'updateRecord\' or \'deleteRecord\' methods as appropriate.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-12 16:39:30','test');
INSERT INTO `rbac_web_page_template` VALUES ('MULTI2','MULTI2','MULTI2 - Modify multiple child records','This will allow multiple MANY occurrences in a ONE-to-MANY relationship to be modified in a single operation. \r\n\r\nThe primary key of ONE is passed down from the previous screen.\r\n\r\nThis will call the \'updateMultiple\' method.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-11 17:14:52','test');
INSERT INTO `rbac_web_page_template` VALUES ('MULTI3','MULTI3','MULTI3 - Modify multiple grandchild records','This will allow updates to multiple occurrences of the CHILD table in a GRANDPARENT-PARENT-CHILD relationship n a single operation. \r\n\r\nThe primary key of GRANDPARENT is passed down from the previous screen.\r\n\r\nOccurrences of PARENT will start at the first available, with a scrolling area providing hyperlinks/buttons to step forwards or backwards through the available occurrences.\r\n\r\nOccurrences of CHILD will start at the first available page, with a pagination area providing hyperlinks/buttons to step forwards or backwards through the available occurrences.\r\n\r\nThis will call the \'updateMultiple\' method for the CHILD entity.','Y','Y','2003-01-01 12:00:00','AJM','2006-07-11 17:15:45','test');
INSERT INTO `rbac_web_page_template` VALUES ('PREV_SEARCH','PREV_SEARCH1','Previous Search operation (available after normal Search)','A Previos Search button will appear after the normal Search button when you have done a normal search followed by clicking the RESET button. The reset operation clears current search WHERE SQL but it is possible to activate it again via the Previous Search button.','N','N','2006-07-15 17:48:20','test',NULL,NULL);
INSERT INTO `rbac_web_page_template` VALUES ('SRCH','SEARCH1','SRCH - Enter search criteria','This will show a blank detail screen and allow the user to specify search criteria that will then be returned to the previous screen for action.','Y','N','2003-01-01 12:00:00','AJM','2006-07-11 17:16:05','test');
INSERT INTO `rbac_web_page_template` VALUES ('UPD1','UPDATE1','UPD1 - Update a single record','This will allow a single database record (row) to be displayed and updated.\r\n\r\nThe primary key of the row is passed down from the previous screen. If multiple rows are selected then scrolling options will be provided.\r\n\r\nThis will call the \'updateRecord\' method.','Y','Y','2003-01-01 12:00:00','AJM','2004-04-11 16:43:21','AJM');

--
-- Dumping data for table `rbac_help_topic`
--

INSERT INTO `rbac_help_topic` VALUES ('audit_access_log','Audit Access Log Help','AUDIT','2006-07-15 15:38:12','test','2006-07-16 15:00:59','test');

--
-- Dumping data for table `rbac_role`
--

INSERT INTO `rbac_role` VALUES ('AUDIT_ADMIN','Audit System Administrator','audit_menu','N','2006-07-12 13:23:47','test',NULL,NULL);
INSERT INTO `rbac_role` VALUES ('CB_ADMIN','Cookbook Administrator','cb_cookbook_menu','N','2006-07-17 12:39:59','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role` VALUES ('CB_VIEWER','Cookbook Viewer','cb_cookbook_menu','N','2006-07-17 13:01:51','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role` VALUES ('GLOBAL','Global Access','emp_menu','Y','2003-01-01 12:00:00','AJM','2006-07-11 18:09:30','test');
INSERT INTO `rbac_role` VALUES ('RBAC_ADMIN','RBAC Administrator','rbac_menu','N','2006-07-12 13:22:32','test',NULL,NULL);
INSERT INTO `rbac_role` VALUES ('READONLY','Can only read/view data','emp_menu','N','2006-07-11 18:09:04','test',NULL,NULL);

--
-- Dumping data for table `rbac_role_task`
--

INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_accesslog_enquire1','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_accesslog_list1','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_accesslog_search1','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_fld_list2','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_fld_list3','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_menu','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('AUDIT_ADMIN','audit_tbl_search1','2006-07-12 13:24:11','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_categories_add1','2006-07-17 13:17:18','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_categories_delete1','2006-07-17 13:17:18','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_categories_enquire1','2006-07-17 13:17:18','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_categories_list1','2006-07-17 13:17:18','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_categories_update1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_cookbook_menu','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_recipes_add1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_recipes_delete1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_recipes_enquire1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_recipes_list1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_recipes_search1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_ADMIN','cb_recipes_update1','2006-07-17 13:17:19','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_VIEWER','cb_categories_enquire1','2006-07-17 13:17:36','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_VIEWER','cb_categories_list1','2006-07-17 13:17:36','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_VIEWER','cb_cookbook_menu','2006-07-17 13:17:36','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_VIEWER','cb_recipes_enquire1','2006-07-17 13:17:36','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_VIEWER','cb_recipes_list1','2006-07-18 19:22:53','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('CB_VIEWER','cb_recipes_search1','2006-07-17 13:17:36','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','audit_fld_list3','2006-07-18 17:15:51','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptext_add2','2006-07-13 14:40:28','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptext_delete1','2006-07-13 14:40:28','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptext_enquire1','2006-07-13 14:40:28','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptext_list2','2006-07-13 14:40:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptext_update1','2006-07-13 14:40:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_add1','2006-07-13 14:40:28','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_datapicker1','2006-07-13 14:40:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_delete1','2006-07-13 14:40:28','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_enquire1','2006-07-13 14:40:28','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_list1','2006-07-13 14:40:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_search1','2006-07-13 14:40:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_helptopic_update1','2006-07-13 14:40:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_link_role_task','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_link_task_role','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_menu','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_menubutton_add3','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_menubutton_delete2','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_menubutton_enquire1','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_menubutton_multi2','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_menubutton_update1','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_navbutton_add3','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_navbutton_delete2','2006-07-12 13:22:57','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_navbutton_enquire1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_navbutton_multi2','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_navbutton_update1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_pagetemplate_add1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_pagetemplate_delete1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_pagetemplate_enquire1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_pagetemplate_list1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_pagetemplate_search1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_pagetemplate_update1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_roletaskfield_multi3','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_add1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_datapicker1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_delete1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_enquire1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_list1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_search1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_role_update1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_subsystem_add1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_subsystem_delete1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_subsystem_enquire1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_subsystem_list1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_subsystem_search1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_subsystem_update1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_taskfieldrole_multi3','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_taskfield_add2','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_taskfield_delete1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_taskfield_list2','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_add1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_datapicker1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_delete1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_enquire1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_list1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_search1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_task_update1','2006-07-12 13:22:58','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_add1','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_changepwd','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_delete1','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_enquire1','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_list1','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_list2','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_resetpwd','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_search1','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('RBAC_ADMIN','rbac_user_update1','2006-07-12 13:22:59','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_accesslog_enquire1','2006-07-11 18:12:34','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_accesslog_list1','2006-07-11 18:12:35','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_accesslog_search1','2006-07-11 18:12:35','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_fld_list2','2006-07-11 18:12:35','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_fld_list3','2006-07-11 18:12:35','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_menu','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','audit_tbl_search1','2006-07-11 18:12:35','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_department_enquire1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_department_list1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_department_search1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_employeeaddress_enquire1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_employeeaddress_list2','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_employeeaddress_search1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_employee_enquire1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_employee_list1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_employee_search1','2006-07-11 18:11:29','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','emp_menu','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_helptext_enquire1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_helptext_list2','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_helptopic_datapicker1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_helptopic_enquire1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_helptopic_list1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_helptopic_search1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_menu','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_menubutton_enquire1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_navbutton_enquire1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_pagetemplate_enquire1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_pagetemplate_list1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_pagetemplate_search1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_role_datapicker1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_role_enquire1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_role_list1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_role_search1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_subsystem_enquire1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_subsystem_list1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_subsystem_search1','2006-07-12 13:21:12','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_taskfield_list2','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_task_datapicker1','2006-07-13 14:41:44','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_task_enquire1','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_task_list1','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_task_search1','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_user_enquire1','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_user_list1','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_user_list2','2006-07-12 13:21:13','test',NULL,NULL);
INSERT INTO `rbac_role_task` VALUES ('READONLY','rbac_user_search1','2006-07-12 13:21:13','test',NULL,NULL);

--
-- Dumping data for table `rbac_role_taskfield`
--


--
-- Dumping data for table `rbac_menu_button`
--

INSERT INTO `rbac_menu_button` VALUES ('audit_menu','audit_accesslog_list1',002,'audit.menu.button.auditaccesslog.list1','2006-07-11 15:26:00','test','2006-07-11 15:48:26','test');
INSERT INTO `rbac_menu_button` VALUES ('audit_menu','audit_fld_list2',001,'audit.menu.button.auditfld.list2','2006-07-11 15:26:00','test','2006-07-11 15:48:25','test');
INSERT INTO `rbac_menu_button` VALUES ('cb_cookbook_menu','cb_categories_list1',001,'categories.list1.component.menubutton.name','2006-07-18 18:52:39','RBACADMIN','2006-07-18 18:57:07','RBACADMIN');
INSERT INTO `rbac_menu_button` VALUES ('cb_cookbook_menu','cb_recipes_list1',002,'recipes.list1.component.menubutton.name','2006-07-18 18:52:39','RBACADMIN','2006-07-18 18:57:07','RBACADMIN');
INSERT INTO `rbac_menu_button` VALUES ('emp_menu','emp_department_list1',001,'department.list1.component.menubutton.name','2006-07-11 18:05:57','test','2006-07-11 18:07:11','test');
INSERT INTO `rbac_menu_button` VALUES ('emp_menu','emp_employee_list1',002,'employee.list1.component.menubutton.name','2006-07-11 18:05:57','test','2006-07-11 18:07:20','test');
INSERT INTO `rbac_menu_button` VALUES ('rbac_menu','rbac_helptopic_list1',004,'rbac.helptopic.list1.component.menubutton.name','2006-07-13 14:38:12','test','2006-07-13 14:38:57','test');
INSERT INTO `rbac_menu_button` VALUES ('rbac_menu','rbac_pagetemplate_list1',006,'rbac.forms.page_template.menubutton','2006-07-12 13:16:07','test','2006-07-13 14:38:28','test');
INSERT INTO `rbac_menu_button` VALUES ('rbac_menu','rbac_role_list1',002,'rbac.forms.role.menubutton','2006-07-12 13:16:07','test','2006-07-12 13:18:20','test');
INSERT INTO `rbac_menu_button` VALUES ('rbac_menu','rbac_subsystem_list1',005,'rbac.forms.subsystem.menubutton','2006-07-12 13:16:07','test','2006-07-12 13:18:20','test');
INSERT INTO `rbac_menu_button` VALUES ('rbac_menu','rbac_task_list1',003,'rbac.forms.task.menubutton','2006-07-12 13:16:07','test','2006-07-12 13:18:20','test');
INSERT INTO `rbac_menu_button` VALUES ('rbac_menu','rbac_user_list1',001,'rbac.forms.user.menubutton','2006-07-12 13:16:07','test','2006-07-12 13:18:19','test');

--
-- Dumping data for table `rbac_subsystem`
--

INSERT INTO `rbac_subsystem` VALUES ('AUDIT','Audit Management Application','wff.core.forms.','audit_','2006-07-07 18:15:14','test','2006-07-11 15:45:11','test');
INSERT INTO `rbac_subsystem` VALUES ('COOKBOOK','Cookbook Sample Application','cookbook.components.','cb_','2006-07-17 09:37:29','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_subsystem` VALUES ('EMPLOYEE','Employee Management Sample Application','empman.components.','emp_','2006-07-07 18:12:52','test',NULL,NULL);
INSERT INTO `rbac_subsystem` VALUES ('RBAC','Role-based Access Control Management Application','wff.rbac.forms.','rbac_','2006-07-07 18:11:47','test','2006-07-11 17:10:12','test');
INSERT INTO `rbac_subsystem` VALUES ('SYSTEM','WFF System','wff.managers.',NULL,'2006-07-15 17:45:38','test',NULL,NULL);

--
-- Dumping data for table `rbac_help_text`
--

INSERT INTO `rbac_help_text` VALUES ('audit_access_log','en','Help on the Access Logging','Access logs are generated and written to the AUDIT_ACCESS_LOG table whenever a user login, logout, fails a login or logout, access a page, is denied access or prints something.\r\n\r\nThe different fields of the access log have the following meaning:\r\n<ul>\r\n<li>LOGGING_ID - Auto-generated Identifier and PK</li>\r\n<li>SESSION_IDENTIFIER - A unique number given to each HTTP Session as the user first accesses the Web Server.</li> \r\n<li>USERNAME - The username typed in by the user on the login screen. Will be whatever names the user types in no matter if login succeeds or not. So an Auditor can see what username was tried during the login attempt.</li>\r\n<li>COMPUTER - Contains the hostname and/or IP Address of the computer accessing the Web Fast Forms application (i.e. the remote client computer).</li> \r\n<li>LOGGING_TIME - The date and time this log was created.</li>\r\n<li>LOGGING_TYPE - Can be any of the following:\r\n<ul>\r\n<li>SESSION_CREATED ? a HTTP session was created to be used by user after successful login</li>\r\n<li>LOGIN ? for a successful login</li>\r\n<li>LOGIN_FAIL ? for an unsuccessful login</li>\r\n<li>LOGOUT ? for a logout</li>\r\n<li>LOGOUT_FAIL ? for an unsuccessful logout</li>\r\n<li>ACCESS ? a valid access of a form, operation or menu</li>\r\n<li>ACCESS_DENIED ? tried to access form, operation or menu but access was denied because of insufficient rights</li>\r\n<li>ACCESS_FAILED ? the RBAC system could not find the task that the user tried to access</li>\r\n<li>PRINT_OUT ? for a print out by a user</li>\r\n</ul>\r\n<li>EXTRA_LOGGING_INFO - Can contain extra information about this access log such as information about a printout. For example, a PRINT_OUT access log could contain extra information about the report name, search criteria etc. It will also contain extra info about an ACCESS such as URL, parameters etc.</li>\r\n</ul>','2006-07-13 15:01:13','test',NULL,NULL);
INSERT INTO `rbac_help_text` VALUES ('audit_access_log','sv','HjÃ???Ã??Ã?Â¤lp om Access Logging','Access loggar genereras och skrivs till AUDIT_ACCESS_LOG tabllen nÃ???Ã??Ã?Â¤r en anvÃ???Ã??Ã?Â¤ndare loggar in, loggar ut, misslyckas med login, accessar en sida, skriver ut etc.\r\n\r\nFÃ???Ã??Ã?Â¤lten i access log tabellen beskrivs nedan:\r\n<ul>\r\n<li>LOGGING_ID - Automatiskt genererad nyckel</li>\r\n<li>SESSION_IDENTIFIER - Ett unikt nummer som ges till varje HTTP Session nÃ???Ã??Ã?Â¤r en anvÃ???Ã??Ã?Â¤ndare accessar Webserver fÃ???Ã??Ã?Â¶r fÃ???Ã??Ã?Â¶rsta gÃ???Ã??Ã?Â¥ngen.</li> \r\n<li>USERNAME - AnvÃ???Ã??Ã?Â¤ndarnamn som angavs vid inloggningen av anvÃ???Ã??Ã?Â¤ndare. InnehÃ???Ã??Ã?Â¥ller vilken text som hellst som matas in sÃ???Ã??Ã?Â¥ man kan spÃ???Ã??Ã?Â¥ra felaktiga inloggningsfÃ???Ã??Ã?Â¶rsÃ???Ã??Ã?Â¶k.</li>\r\n<li>COMPUTER - Namnet pÃ???Ã??Ã?Â¥ dator eller/och IP adress fÃ???Ã??Ã?Â¶r anvÃ???Ã??Ã?Â¤ndaren som accessar applikationen.</li> \r\n<li>LOGGING_TIME - Datum och tid nÃ???Ã??Ã?Â¤r denna logg skapades.</li>\r\n<li>LOGGING_TYPE - Kan vara nÃ???Ã??Ã?Â¥gon av fÃ???Ã??Ã?Â¶ljande typer:\r\n<ul>\r\n<li>SESSION_CREATED - a HTTP session was created to be used by user after successful login</li>\r\n<li>LOGIN ? for a successful login</li>\r\n<li>LOGIN_FAIL ? for an unsuccessful login</li>\r\n<li>LOGOUT ? for a logout</li>\r\n<li>LOGOUT_FAIL ? for an unsuccessful logout</li>\r\n<li>ACCESS ? a valid access of a form, operation or menu</li>\r\n<li>ACCESS_DENIED ? tried to access form, operation or menu but access was denied because of insufficient rights</li>\r\n<li>ACCESS_FAILED ? the RBAC system could not find the task that the user tried to access</li>\r\n<li>PRINT_OUT ? for a print out by a user</li>\r\n</ul>\r\n<li>EXTRA_LOGGING_INFO - Can contain extra information about this access log such as information about a printout. For example, a PRINT_OUT access log could contain extra information about the report name, search criteria etc. It will also contain extra info about an ACCESS such as URL, parameters etc.</li>\r\n</ul>','2006-07-14 18:55:27','test',NULL,NULL);

--
-- Dumping data for table `rbac_user`
--

INSERT INTO `rbac_user` VALUES ('AUDITADMIN','Auditor','test','AUDIT_ADMIN',NULL,NULL,NULL,'N','N',NULL,NULL,'en','2006-06-01','9999-12-31',NULL,NULL,'2006-07-17 11:36:44','test',NULL,NULL);
INSERT INTO `rbac_user` VALUES ('CB_ADMIN','Cookbook Administrator','test','CB_ADMIN',NULL,NULL,NULL,'N','N',NULL,NULL,'en','2006-07-01','9999-12-31',NULL,NULL,'2006-07-17 14:35:58','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_user` VALUES ('CB_VIEWER','Cookbook Viewer','test','CB_VIEWER',NULL,NULL,NULL,'N','N',NULL,NULL,'en','2006-07-01','9999-12-31',NULL,NULL,'2006-07-17 14:38:20','RBACADMIN',NULL,NULL);
INSERT INTO `rbac_user` VALUES ('RBACADMIN','RBAC Administrator','test','RBAC_ADMIN',NULL,NULL,NULL,'N','N',NULL,NULL,'en','2006-06-01','9999-12-31',NULL,NULL,'2006-07-17 09:12:04','test',NULL,NULL);
INSERT INTO `rbac_user` VALUES ('test','Tester Testsson','test','GLOBAL','2006-06-14','15:10:45',1,'Y','N','2006-06-14','15:12:38',NULL,'2005-01-31','9999-12-31',NULL,NULL,'2005-07-31 15:10:45','MBE','2005-11-02 18:05:54','MBE');
INSERT INTO `rbac_user` VALUES ('text_readonly','Readonly Testsson','test','READONLY',NULL,NULL,NULL,'N','N',NULL,NULL,'en','2005-01-01','9999-12-31',NULL,'tester_readonly@marversolutions.com','2006-07-14 16:53:42','test',NULL,NULL);
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

