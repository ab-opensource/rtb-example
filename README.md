
AdBrite Example RTB server
==========================

Launching in Eclipse
-------------------- 

Import rtb-example project into Eclipse and run com.adbrite.rtb.examle.RTBServer class as Java Application. The server will start to respond to http://localhost:8888/rtb.  

Launching using Ant
-------------------

In rtb-example directory launch 

```
ant jar
build/rtb-example.sh
```

Testing
-------

Open http://127.0.0.1:8888/rtb url in the browser. The server will return "OK" string.

To quickly test response bid request response execute following command from the project root directory:

```
curl -q --data @scripts/request.json 'http://127.0.0.1:8888/rtb'
```

Server will respond with PASS response. Parsed bid request will be output in to console.

