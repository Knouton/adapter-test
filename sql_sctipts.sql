/*create database postgres
    with owner postgres;*/

create schema herotestkafka;

create table herotestkafka.heroes
(
    id    bigint generated always as identity
        constraint "Hero_pkey"
            primary key,
    name  text not null,
    level smallint
);


create table herotestkafka.skills
(
    id         bigint generated always as identity
        constraint "Skill_pkey"
            primary key,
    hero_id    bigint not null
        constraint skills_fk
            references heroes,
    skill_name text
);


