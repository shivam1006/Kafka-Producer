# Kafka-Producer


By below mentioned steps you can setup kafka in your local and then keep kafka consumer running to read for messages published using kafka producer api 
########Start zookeeper##########

/opt/homebrew/opt/kafka/libexec/bin/zookeeper-server-start.sh /opt/homebrew/opt/kafka/libexec/config/zookeeper.properties


########Start Kafka broker######

/opt/homebrew/opt/kafka/libexec/bin/kafka-server-start.sh /opt/homebrew/opt/kafka/libexec/config/server.properties


#####Create topic - firsttopic######

/opt/homebrew/opt/kafka/libexec/bin/kafka-topics.sh --create --topic first_topic--bootstrap-server localhost:9092 --partitions 1 --replication-factor 1



########Listing topic########

/opt/homebrew/opt/kafka/libexec/bin/kafka-topics.sh --list --bootstrap-server localhost:9092


##########To start a consumer #########

/opt/homebrew/opt/kafka/libexec/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic firsttopic --from-beginning


/opt/homebrew/opt/kafka/libexec/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic firsttopic



/opt/homebrew/opt/kafka/libexec/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic firsttopic --property value.deserializer=org.apache.kafka.connect.json.JsonDeserializer --skip-message-on-error --from-beginning --property print.timestamp=true

