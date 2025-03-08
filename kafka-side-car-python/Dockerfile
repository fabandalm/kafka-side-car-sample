FROM python:3.8-slim
WORKDIR /app
COPY . /app
RUN pip install requests kafka-python flask
CMD ["python", "kafka_sidecar.py"]
