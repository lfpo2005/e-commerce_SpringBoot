select constraint_name from information_schema.constraint_column_usage where
        table_name = 'usuario_acesso' and column_name = 'acesso_id' and constraint_name <> 'unique_acesso_user';

alter table tb_usuario_acesso drop CONSTRAINT "uk_51533qf8075g59l675rjfuf3s";