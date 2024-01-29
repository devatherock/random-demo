from airflow.decorators import dag, task
from airflow.models import Variable
from datetime import datetime

@dag(dag_id = "hello-world-job",
     doc_md = "Prints hello world", schedule = None)
def say_hello():

    @task(start_date=datetime(2024,1,1))
    def python_print():
        print('Hello World!, from print')

    @task(start_date=datetime(2024,1,1))
    def python_log(**kwargs):
        log = kwargs["ti"].log
        log.info("Hello World!, from log")

    @task(start_date=datetime(2024,1,1))
    def display_variables():
        print("The environment: {}".format(Variable.get("env_name")))
        props = Variable.get(key="props", deserialize_json=True)
        print("Key one: {}".format(props.get("key_one")))
        print("Key two: {}".format(props.get("key_two")))

    python_print() >> python_log() >> display_variables()

say_hello()    