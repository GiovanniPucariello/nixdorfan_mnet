-- nixdorfan bite.framework.servicelayer
-- 12.10.2012


-- create user
create user nixdorfan with superuser password 'bekannt'     -- bekannt ;-)


-- create db
create database gsal_framework encoding='utf-8' owner=nixdorfan;


-- insert db-konstrukt fuer applikationen

drop sequence s_aid, s_akvid, s_app_id, s_t_aid;
drop table applications,applications_key_value,template_application ;
 
CREATE TABLE applications (
    aid          integer NOT NULL,
    name         varchar(100) NOT NULL,
    app_id       integer NOT NULL,
    unique       (name, app_id),
    constraint   applications_pkey PRIMARY KEY (aid),
    constraint   name_fkey unique(name),
    constraint   app_id_fkey unique(app_id)
);

CREATE SEQUENCE s_aid START 1;
CREATE SEQUENCE s_app_id START 1;


-- 
CREATE TABLE applications_key_value (
    akvid          integer NOT NULL,
    name           varchar(100) NOT NULL REFERENCES applications (name),
    app_key        varchar(200) NOT NULL,
    app_value      varchar(4000) NOT NULL,
    fk_app_id      integer NOT NULL REFERENCES applications (app_id),
    constraint   applications_key_value_pkey PRIMARY KEY (akvid)
);

CREATE SEQUENCE s_akvid START 1;
 

CREATE TABLE template_application(
    t_a_id         integer NOT NULL,
    t_a_key        varchar(200) NOT NULL,
    app_value      varchar(4000) NOT NULL,
    name           varchar(100) NOT NULL REFERENCES applications (name),
    fk_app_id      integer NOT NULL  REFERENCES applications (app_id),
    constraint   template_application_pkey PRIMARY KEY (t_a_id)
);

CREATE SEQUENCE s_t_aid START 1;
 