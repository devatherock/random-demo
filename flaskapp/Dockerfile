FROM python:3.7-buster

RUN mkdir -p /home/deployment && chown -R root:root /home/deployment
RUN pip install flask

WORKDIR /home/deployment

COPY app.py ./
