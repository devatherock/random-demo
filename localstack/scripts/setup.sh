echo "Hello, World! from container"
awslocal s3 mb s3://my-bucket

awslocal secretsmanager create-secret \
  --name dev/CBusHA/Backend \
  --description "My test secret created with the CLI." \
  --secret-string '{"user":"testuser","password":"testpwd"}'