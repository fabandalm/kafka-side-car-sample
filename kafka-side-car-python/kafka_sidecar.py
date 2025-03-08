from flask import Flask
from kafka import KafkaConsumer
import requests

app = Flask(__name__)

consumer = KafkaConsumer('test01', bootstrap_servers=['host.docker.internal:9092'],
                         auto_offset_reset='earliest', group_id='your-group')

@app.route('/consume')
def consume_message():
    for message in consumer:
        # Forward message to the main application
        requests.post('http://localhost:8080/process', json={'message': message.value.decode()})
        break
    return "Message forwarded"

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=4000)
