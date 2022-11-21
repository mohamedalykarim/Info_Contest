package mohalim.contest.alarm.core.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mohalim.alarm.infocontest.core.data_source.aws.AWSDatabase
import javax.inject.Inject

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import mohalim.alarm.infocontest.core.model.user.User
import mohalim.alarm.infocontest.core.utils.DataState
import java.util.*


class DatabaseRepositoryImp @Inject constructor(
    val data : AWSDatabase
) : DatabaseRepository {
    override fun login(username: String, password: String): Flow<DataState<User>> {
        return flow {
            try {

                val uuid: UUID = UUID.randomUUID()
                val tableName = "users"
                val key = "userId"


                val staticCredentials = StaticCredentialsProvider {
                    accessKeyId = "AKIAQQ4IOTNUBHCBMWPU"
                    secretAccessKey = "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"
                }

                val ddb = DynamoDbClient{
                    region = "us-east-1"
                    credentialsProvider = staticCredentials
                }

                val user = data.getSpecificItem(tableName, key, username)

                Log.d("TAG", "login: "+ user)

            }catch (e : Exception){
                Log.d("TAG", "login: "+ e.message)

                emit(DataState.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }


}