-- rolesテーブル
INSERT INTO roles (role_name) VALUES
  ('ROLE_GENERAL'),
  ('ROLE_ADMIN')
ON CONFLICT (role_id) DO NOTHING;

-- usersテーブル
INSERT INTO users (user_name, password, role_id) VALUES
  ('侍 太郎', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1),
  ('侍 花子', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2),
  ('侍 義勝', 'password', 1),
  ('侍 幸美', 'password', 1),
  ('侍 雅', 'password', 1)
ON CONFLICT (user_id) DO NOTHING;