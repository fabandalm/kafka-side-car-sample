# kafka-side-car-sample

### Create Kafka Consumer API
```
docker build -t fabandalm/kafka-sidecar-python .
```

### Create Kafka Message Reader
```
docker build -t fabandalm/java-kafka-client . 

```

### Deploy the Kafka Sidecar in Kubernetes
```
kubectl apply -f k8s-deployment.yaml
```

### Access to Kafka Consumer API
```
http://localhost:4000/consume
```

### Check K8s Pod Kafka Consumer API Container
```
k logs <pod_id> -c kafka-sidecar
```

### Check K8s Pod Kafka Message Reader Container
```
k logs <pod_id> -c java-app
```

### Kafka Sidecar Design

![kafka sidecar design](/images/kafka-sidecar-design.png)


