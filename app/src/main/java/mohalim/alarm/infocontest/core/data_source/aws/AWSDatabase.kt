package mohalim.alarm.infocontest.core.data_source.aws

import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import aws.sdk.kotlin.services.dynamodb.model.*
import javax.inject.Inject
import kotlin.system.exitProcess

class AWSDatabase @Inject constructor() {

    suspend fun getSpecificItem(tableNameVal: String, keyName: String, keyVal: String) {

        val keyToGet = mutableMapOf<String, AttributeValue>()
        keyToGet[keyName] = AttributeValue.S(keyVal)

        val request = GetItemRequest {
            key = keyToGet
            tableName = tableNameVal
        }

        DynamoDbClient { region = "us-east-1" }.use { ddb ->
            val returnedItem = ddb.getItem(request)
            val numbersMap = returnedItem.item
            numbersMap?.forEach { key1 ->
                println(key1.key)
                println(key1.value)
            }
        }
    }



}