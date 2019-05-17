package com.nividapps.wingsreadmongo

import com.mongodb._

import com.iteration3.smile.mongo.MongoGateway

object WingsReadMongoGateway extends MongoGateway {

  val getDb: com.mongodb.client.MongoDatabase = {

    val conf:com.iteration3.smile.Conf = com.nividapps.wingsreadmongo.WingsReadMongoObject.conf
    val host:String = conf.getStringMust("host")
    val port:Int = conf.getIntMust("port")
    val dbName:String = conf.getStringMust("dbName")

    val serverAddress = new ServerAddress(host, port)

    val options = new MongoClientOptions.Builder()
      .codecRegistry(com.iteration3.smile.mongo.reader.DataConverter.addCodesForSmileMongoTypes(MongoClient.getDefaultCodecRegistry()))
      .connectionsPerHost(conf.getInt("connectionPerHost").getOrElse(50))
      .socketTimeout(conf.getInt("socketTimeout").getOrElse(60000))
      .connectTimeout(conf.getInt("connectTimeout").getOrElse(10000))
      .build()
      new MongoClient(serverAddress, options).getDatabase(dbName)

  }
}
