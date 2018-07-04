create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256),
  created_at timestamp without time zone NOT NULL,
  last_modified_at timestamp without time zone NOT NULL
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

CREATE TABLE games
(
    sid bigint NOT NULL PRIMARY KEY,
    address uuid NOT NULL,
    first_user bigint NOT NULL,
    second_user bigint,
    first_user_cards_in_hand integer[],
    second_user_cards_in_hand integer[],
    first_user_card_in_point integer[],
    second_user_card_in_point integer[],
    stack_of_cards integer[],
    yellow integer[],
    blue integer[],
    white integer[],
    green integer[],
    red integer[],
    first_user_score integer NOT NULL,
    second_user_score integer NOT NULL,
    whos_turn bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    last_modified_at timestamp without time zone NOT NULL
);

CREATE TABLE users
(
    sid bigint NOT NULL PRIMARY KEY,
    id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    pwd character varying(255) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    last_modified_at timestamp without time zone NOT NULL
);