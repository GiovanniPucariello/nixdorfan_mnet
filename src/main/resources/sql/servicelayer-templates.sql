-- Applications fuer base und default.mod_properties
insert into applications (aid,name,app_id) values(nextval('s_aid'), 'base',nextval('s_app_id'));
insert into applications (aid,name,app_id) values(nextval('s_aid'), 'default',nextval('s_app_id'));

-- Templates fuer base and default.mod_properties
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'name','base','base',1);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'factory','de.bite.framework.factories.impl.DefaultFactory','base',1);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'logging','C:/Project/nixdorfan_dyndns/NetbeansProjects/nixdorfan_gsal/resources/log4j.properties','base',1);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'loggingFilePath','C:/Project/gsal/log/','base',1);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'loggingFile','gsal.log','base',1);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'logging_delay','1000','base',1);


insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'name','default','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'controller','de.bite.framework.controller.impl.DefaultController','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'view','de.bite.framework.view.impl.DefaultView','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'source','de.bite.framework.source.impl.DefaultSource','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'model','de.bite.framework.model.impl.DefaultModel','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'datenbank','de.bite.framework.utilities.db.impl.DatenbankObj','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'xmlhandler','de.verbindungsraum.webbuilder.process.WebbuilderParserHandler','default',2);
insert into template_application (t_a_id,t_a_key,app_value,name,fk_app_id) values (nextval('s_t_aid'),'xmlparser','org.apache.xerces.parsers.SAXParser','default',2);



insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'name','base','base',1);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'factory','de.bite.framework.factories.impl.DefaultFactory','base',1);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'logging','C:/Project/nixdorfan_dyndns/NetbeansProjects/nixdorfan_gsal/resources/log4j.properties','base',1);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'loggingFilePath','C:/Project/gsal/log/','base',1);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'loggingFile','gsal.log','base',1);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'logging_delay','1000','base',1);


insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'name','default','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'controller','de.bite.framework.controller.impl.DefaultController','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'view','de.bite.framework.view.impl.DefaultView','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'source','de.bite.framework.source.impl.DefaultSource','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'model','de.bite.framework.model.impl.DefaultModel','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'datenbank','de.bite.framework.utilities.db.impl.DatenbankObj','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'xmlhandler','de.verbindungsraum.webbuilder.process.WebbuilderParserHandler','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'xmlparser','org.apache.xerces.parsers.SAXParser','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'programms.putty','C:/Project/gsal/ext_progs/PuTTY/putty.exe','default',2);
insert into applications_key_value (akvid,app_key,app_value,name,fk_app_id) values (nextval('s_akvid'),'programms.winscp','C:/Project/gsal/ext_progs/WinSCP/WinSCP.exe','default',2);

