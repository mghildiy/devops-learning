#### kubernetes-learning

Spring app + docker + kubernetes


- https://learnk8s.io/spring-boot-kubernetes-guide
- https://www.youtube.com/watch?v=X48VuDVv0do&ab_channel=TechWorldwithNana
- https://www.katacoda.com/courses/docker
- https://www.katacoda.com/courses/kubernetes

Ingress makes it possible to have a domain name mapped to a service so that client doesn't need to use ip:port in url.
Each service has a name and a port assigned to it(defined in service.yaml)

```
apiVersion: v1
kind: Service
metadata:
  name: mongoexpress-service // service name used by ingress
spec:
  selector:
    app: mongo-express
  type: LoadBalancer
  ports:
    - protocol: TCP
      port: 8081 // service port used by ingresss
      targetPort: 8081
      nodePort: 30000
**

Ingress uses these values to map to a service:
**
apiVersion: networking.k8s.io/v1
kind: Ingress // type of k8s component
metadata:
  name: mongoexpress-ingress
  annotations:
    kubernetes.io/ingress.class: "mongoexpress"
spec:
  rules:
    - host: mongoexpress.com // client uses this as domain name for forming urls
      http:
        paths: // all under this comes after domain name
          - path: /
            backend:
              serviceName: mongoexpress-service // service name from service definition comes here
              servicePort: 8081 // port from service definition comes here
```
