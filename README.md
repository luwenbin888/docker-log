# docker-log
1) Go to demo-boot, run maven clean package -Dmaven.test.skip=True  
2) Run docker build -t demo-java .  
3) Go to fluentd-docker-image/v1.3/alpine, run docker build -t fluentd .  
4) Install Elasticsearch, run docker run -p 9200:9200 -p 9300:9300 --name esdocker -d -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.5.3  
5) Intall Kibana, run docker run -d --name kibana -p 5601:5601 --link esdocker -e "ELASTICSEARCH_URL=http://esdocker:9200" docker.elastic.co/kibana/kibana:6.5.3  
6) Start fluentd, run docker run -d -p 24224:24224 -p 24224:24224/udp --link esdocker fluentd  
7) Start demo-java, run docker run --log-driver=fluentd -p 8080:8080 demo-java  
8) Go to http://localhost:5601  
