package com.project.v2.atccorenetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.project.v2.atclib_corenetwork.ATCCoreNetwork
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var coreNetwork = ATCCoreNetwork("https://dummyjson.com/")
            .create(TestAPI::class.java)

        GlobalScope
            .launch {
                val result = coreNetwork.getUsers()
                Log.d(localClassName, "result is $result")
            }
    }
}

interface TestAPI {

    @GET("users")
    suspend fun getUsers(): String

}