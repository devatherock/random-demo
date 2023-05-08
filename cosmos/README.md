Use the following steps to run the emulator on Linux:

- Retrieve the IP address of your local machine. This step is required when Direct mode setting is configured using Azure Cosmos DB SDKs (.NET, Java).

```
ipaddr="`ifconfig | grep "inet " | grep -Fv 127.0.0.1 | awk '{print $2}' | head -n 1`"
```

- Pull the Docker image from the registry.


```
docker pull mcr.microsoft.com/cosmosdb/linux/azure-cosmos-emulator
```

- Run the Docker image with the following configurations:

```
docker run \
    --publish 8081:8081 \
    --publish 10250-10255:10250-10255 \
    --memory 3g --cpus=4.0 \
    --name=test-linux-emulator \
    --env AZURE_COSMOS_EMULATOR_PARTITION_COUNT=10 \
    --env AZURE_COSMOS_EMULATOR_ENABLE_DATA_PERSISTENCE=true \
    --env AZURE_COSMOS_EMULATOR_IP_ADDRESS_OVERRIDE=$ipaddr \
    --interactive \
    --tty \
    mcr.microsoft.com/cosmosdb/linux/azure-cosmos-emulator
```    

- After the emulator is running, using a different terminal, load the IP address of your local machine into a variable.
 
```
ipaddr="`ifconfig | grep "inet " | grep -Fv 127.0.0.1 | awk '{print $2}' | head -n 1`"
```

- Next, download the certificate for the emulator. Alternatively, the endpoint below which downloads the self-signed emulator certificate, can also be used for signaling when the emulator endpoint is ready to receive requests from another application.

```
curl -k https://$ipaddr:8081/_explorer/emulator.pem > ~/emulatorcert.crt
```

- Copy the CRT file to the folder that contains custom certificates in your Linux distribution. Commonly on Debian distributions, it's located on /usr/local/share/ca-certificates/.

```
cp ~/emulatorcert.crt /usr/local/share/ca-certificates/
```

- Update the TLS/SSL certificates, which will update the /etc/ssl/certs/ folder.

```
update-ca-certificates
```

- For Java-based applications, the certificate must be imported to the Java trusted store.

```
keytool -import -alias emulator_cert -keystore -file ~/emulatorcert.crt -storepass changeit -noprompt
java -ea -Djavax.net.ssl.trustStore=~/cacerts -Djavax.net.ssl.trustStorePassword="changeit" $APPL
```