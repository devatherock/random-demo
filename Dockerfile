FROM apache/airflow:slim-2.7.2-python3.11
ADD airflow/requirements.txt .
RUN pip install -r requirements.txt