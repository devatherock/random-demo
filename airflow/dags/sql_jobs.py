from airflow.decorators import dag, task
from airflow.providers.postgres.hooks.postgres import PostgresHook
from datetime import datetime

@dag(dag_id = "sql-job",
     doc_md = "Database operations against a relational DB", 
     schedule_interval="@once")
def perform_sql_operations():

    @task(start_date=datetime(2024,1,1))
    def read_from_db():
      db_client = PostgresHook(postgres_conn_id="postgres_test")
      data_frame = db_client.get_pandas_df(sql="SELECT * FROM user;")
      print("Users: {}".format(data_frame))

    read_from_db()

perform_sql_operations()