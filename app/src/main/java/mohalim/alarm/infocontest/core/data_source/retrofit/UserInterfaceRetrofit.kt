package mohalim.alarm.infocontest.core.data_source.retrofit

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.HTTP
import retrofit2.http.Path
import retrofit2.http.Query

interface UserInterfaceRetrofit {

    @HTTP(method = "GET", path = "{sheetId}/values/A1:H1000", hasBody = false)
    suspend fun getDatabase(@Path("sheetId") sheetId: String, @Query("key") googleApiKey: String): Response<ResponseBody>
}