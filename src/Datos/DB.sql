create table role
(
  id         bigserial               not null
    constraint role_pkey
    primary key,
  name       varchar(128)            not null,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);

create unique index role_nombre_uindex
  on role (name);

create table "group"
(
  id          bigserial               not null
    constraint grupo_pkey
    primary key,
  name        varchar(128)            not null,
  description varchar(512),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp,
  role_id     bigserial               not null
    constraint fk_group_role
    references role
    on update cascade on delete cascade
);

create unique index grupo_nombre_uindex
  on "group" (name);

create table "user"
(
  id         bigserial               not null
    constraint usuario_pkey
    primary key,
  name       varchar(256),
  email      varchar(128)            not null,
  password   varchar(1024)           not null,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp,
  group_id   bigserial               not null
    constraint fk_user_group
    references "group"
    on update cascade on delete cascade,
  type       integer default 2       not null,
  speciality varchar(256),
  about_me   varchar(1024),
  phone      varchar(15)
);

create unique index usuario_email_uindex
  on "user" (email);

create table schedule
(
  id          bigserial               not null
    constraint schedule_pkey
    primary key,
  description varchar(1024),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp,
  period      varchar(64)
);

create table days
(
  id         bigserial               not null
    constraint days_pkey
    primary key,
  name       varchar(32)             not null,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);

create unique index days_nombre_uindex
  on days (name);

create table type
(
  id          varchar(256)            not null
    constraint type_pkey
    primary key,
  description varchar(256),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table offer
(
  id          bigserial               not null
    constraint offer_pkey
    primary key,
  name        varchar(256),
  description varchar(1024),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp,
  type        varchar(256)            not null
    constraint fk_offer_type
    references type,
  price       double precision
);

create table schedule_detail
(
  id          bigserial               not null
    constraint schedule_detail_pkey
    primary key,
  schedule_id bigserial               not null
    constraint fk_schedule_detail
    references schedule
    on update cascade on delete cascade,
  offer_id    bigserial               not null
    constraint fk_detail_offer
    references offer
    on update cascade on delete cascade,
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table execution_period
(
  id          bigserial               not null
    constraint execution_period_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_offer_execution
    references offer
    on update cascade on delete cascade,
  description varchar(256)            not null,
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp,
  start_date  date
);

create table horario
(
  id                  bigserial               not null
    constraint horario_pkey
    primary key,
  execution_period_id bigserial               not null
    constraint fk_horario_execution
    references execution_period
    on update cascade on delete cascade,
  description         varchar(512),
  created_at          timestamp default now() not null,
  updated_at          timestamp,
  deleted_at          timestamp
);

create table horario_days
(
  id         bigserial               not null
    constraint horario_days_pkey
    primary key,
  horario_id bigserial               not null
    constraint fk_horario
    references horario
    on update cascade on delete cascade,
  days_id    bigserial               not null
    constraint fk_day
    references days
    on update cascade on delete cascade,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);

create table target_people
(
  id          bigserial               not null
    constraint target_people_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_target_people_offer
    references offer
    on update cascade on delete cascade,
  description varchar(1024),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table target_people_detail
(
  id               bigserial               not null
    constraint target_detail_pkey
    primary key,
  target_people_id bigserial               not null
    constraint fk_target_detail
    references target_people
    on update cascade on delete cascade,
  description      varchar(512),
  created_at       timestamp default now() not null,
  updated_at       timestamp,
  deleted_at       timestamp
);

create table objetive
(
  id          bigserial               not null
    constraint objetive_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_objetive_offer
    references offer
    on update cascade on delete cascade,
  description varchar(512),
  created_at  timestamp default now() not null,
  update_at   timestamp,
  deleted_at  timestamp
);



create table objetive_detail
(
  id          bigserial               not null
    constraint objetive_detail_pkey
    primary key,
  objetive_id bigserial               not null
    constraint fk_objetive_detail_objetive
    references objetive
    on update cascade on delete cascade,
  description varchar(1024),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table professional_profile
(
  id          bigserial               not null
    constraint profesional_profile_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_offer_profile
    references offer
    on update cascade on delete cascade,
  description varchar(512),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp               not null
);

create table professional_profile_detail
(
  id                      bigserial               not null
    constraint professional_profile_detail_pkey
    primary key,
  professional_profile_id bigserial               not null
    constraint fk_prof_prof_detail
    references professional_profile
    on update cascade on delete cascade,
  description             varchar(1024),
  created_at              timestamp default now() not null,
  updated_at              timestamp,
  deleted_at              timestamp
);

create table metodology
(
  id          bigserial               not null
    constraint metodology_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_offer_profile
    references offer
    on update cascade on delete cascade,
  description varchar(512),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp               not null
);

create table metodology_detail
(
  id            bigserial               not null
    constraint metodology_detail_pkey
    primary key,
  metodology_id bigserial               not null
    constraint fk_metodoly_detail
    references metodology
    on update cascade on delete cascade,
  description   varchar(1024),
  created_at    timestamp default now() not null,
  updated_at    timestamp,
  deleted_at    timestamp
);

create table cuotas
(
  id          bigserial               not null
    constraint cuotas_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_cuoutas_offer
    references offer
    on update cascade on delete cascade,
  id_parent   bigserial               not null
    constraint fk_parent
    references cuotas
    on update cascade on delete cascade,
  description varchar(1024),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table cuotas_details
(
  id          bigserial                                           not null
    constraint cuotas_detail_pkey
    primary key,
  cuotas_id   bigserial                                           not null
    constraint fk_cuotas_detail
    references cuotas
    on update cascade on delete cascade,
  description varchar(1024),
  created_at  time default ('now' :: text) :: time with time zone not null,
  updated_at  timestamp,
  deleted_at  timestamp
);


create table requirement
(
  id          bigserial               not null
    constraint requirement_pkey
    primary key,
  offer_id    bigserial               not null
    constraint fk_offer_requeriment
    references offer
    on update cascade on delete cascade,
  description varchar(512),
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp               not null
);

create table requeriment_detail
(
  id             bigserial               not null
    constraint requeriment_detail_pkey
    primary key,
  requirement_id bigserial               not null
    constraint fk_requeriment_detail
    references requirement
    on update cascade on delete cascade,
  description    varchar(1024),
  created_at     timestamp default now() not null,
  updated_at     timestamp,
  deleted_at     timestamp
);

create table posgraduante_offer
(
  id              bigserial not null
    constraint posgraduante_offer_pkey
    primary key,
  offer_id        bigserial not null
    constraint fk_offer
    references offer
    on update cascade on delete cascade,
  posgraduante_id bigserial not null
    constraint fk_posgraduante
    references "user"
    on update cascade on delete cascade
);

create table docente_offer
(
  id         bigserial not null
    constraint docente_offer_pkey
    primary key,
  offer_id   bigserial not null
    constraint fk_offer
    references offer
    on update cascade on delete cascade,
  docente_id bigserial not null
    constraint fk_docente
    references "user"
    on update cascade on delete cascade
);

create table administrator_offer
(
  id               bigserial not null
    constraint administrator_offer_pkey
    primary key,
  offer_id         bigserial not null
    constraint fk_offer
    references offer
    on update cascade on delete cascade,
  administrator_id bigserial not null
    constraint fk_administrator
    references "user"
    on update cascade on delete cascade
);

create table resource
(
  id         bigserial               not null
    constraint resource_pkey
    primary key,
  name       varchar(64),
  url        varchar(256),
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp,
  parent     integer,
  visitas    integer
);

create table permission
(
  resource_id bigserial               not null
    constraint fk_resource_permission
    references resource
    on update cascade on delete cascade,
  role_id     bigserial               not null
    constraint fk_role_permision
    references role
    on update cascade on delete cascade,
  id          bigserial               not null
    constraint permission_id_pk
    primary key,
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table venta
(
  id         bigserial               not null
    constraint venta_pkey
    primary key,
  total      double precision        not null,
  user_id    bigserial               not null
    constraint fk_venta_user
    references "user"
    on update cascade on delete cascade,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);


create table pago
(
  id         bigserial               not null
    constraint pago_pkey
    primary key,
  monto      double precision        not null,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp,
  type       varchar(64)             not null
);

create table venta_detail
(
  id         bigserial               not null
    constraint venta_detail_pkey
    primary key,
  date       varchar(64),
  venta_id   bigserial               not null
    constraint fk_detail_venta
    references venta
    on update cascade on delete cascade,
  offer_id   bigserial               not null
    constraint fk_detail_offer
    references offer
    on update cascade on delete cascade,
  pago_id    bigserial               not null
    constraint fk_detail_pago
    references pago
    on update cascade on delete cascade,
  user_id    bigserial               not null
    constraint fk_detail_user
    references "user"
    on update cascade on delete cascade,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);

create table ticket
(
  id         bigserial               not null
    constraint ticket_pkey
    primary key,
  monto      double precision        not null,
  pago_id    bigserial               not null
    constraint fk_ticket_pago
    references pago
    on update cascade on delete cascade,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);

create table deposit
(
  id         bigserial               not null
    constraint deposit_pkey
    primary key,
  monto      double precision        not null,
  pago_id    bigserial               not null
    constraint fk_deposit_pago
    references pago
    on update cascade on delete cascade,
  created_at timestamp default now() not null,
  updated_at timestamp,
  deleted_at timestamp
);

create table reservation
(
  id          bigserial               not null
    constraint reservation_pkey
    primary key,
  date        varchar(32)             not null,
  description varchar(256),
  user_id     bigserial               not null
    constraint fk_user_reserv
    references "user"
    on update cascade on delete cascade,
  offer_id    bigserial               not null
    constraint fk_offer_reserv
    references offer
    on update cascade on delete cascade,
  created_at  timestamp default now() not null,
  updated_at  timestamp,
  deleted_at  timestamp
);

create table usertheme
(
  id                 bigserial                                           not null
    constraint usertheme_pkey
    primary key,
  user_id            bigserial                                           not null
    constraint fk_user_them
    references "user"
    on update cascade on delete cascade,
  header_color       varchar(64),
  brand_header_color varchar(64),
  sidebar_color      varchar(64),
  created_at         time default ('now' :: text) :: time with time zone not null,
  updated_at         time,
  deleted_at         time
);