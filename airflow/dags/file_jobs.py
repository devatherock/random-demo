from airflow.decorators import dag, task

@dag(dag_id = "file-job",
     doc_md = "Performs file operations", schedule = None)
def handle_files():

    @task
    def write_file():
        file = open(r"/out/hello.txt", "w")
        file.write("Hello World!")
        file.close()

    write_file()

handle_files()