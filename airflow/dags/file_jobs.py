from airflow.decorators import dag, task
from datetime import datetime

@dag(dag_id = "file-job",
     doc_md = "Performs file operations", schedule = None)
def handle_files():

    @task(start_date=datetime(2024,1,1))
    def write_file():
        file = open(r"/out/hello.txt", "w")
        file.write("Hello World!")
        file.close()

    write_file()

handle_files()