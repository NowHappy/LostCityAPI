INSERT INTO oauth_client_details(
  client_id,
  resource_ids,
  client_secret,
  scope,
  authorized_grant_types,
  authorities,
  access_token_validity,
  refresh_token_validity,
  additional_information,
  autoapprove
) VALUES (
  'JoyHappyJoyHappy',
  'lostcity_manage_resources',
  '$2a$04$ryE/nuaY206k8M7Qwl4jfOQKXrqi86Kef0MzXlVT85GnqyiIFqLBa',
  /*WEB,APP*/'WEB',
  'password,authorization_code,refresh_token,implicit',
  'NONE',
  14400,
  604800,
  'z8nkScpttEKELc8UwnKjVlwicEVl0TXK',
  'FasooBlock Service',
  timezone('utc'::text, now()),
  timezone('utc'::text, now())
);