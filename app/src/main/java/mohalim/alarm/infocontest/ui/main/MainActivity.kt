package mohalim.alarm.infocontest.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amplifyframework.core.Amplify
import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.gson.GsonFactory
import com.google.api.client.util.store.FileDataStoreFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.api.services.sheets.v4.model.ValueRange
import dagger.hilt.android.AndroidEntryPoint
import mohalim.alarm.infocontest.R
import mohalim.alarm.infocontest.databinding.ActivityMainBinding
import mohalim.alarm.infocontest.ui.admin.AdminActivity
import mohalim.alarm.infocontest.ui.login.LoginActivity
import mohalim.alarm.infocontest.ui.quiz.QuizActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val QUIZ_TYPE: String = "quiz_type"
    val viewModel : HomeViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding;

    private val APPLICATION_NAME = "Google Sheets API Java Quickstart"
    private val JSON_FACTORY: JsonFactory = GsonFactory.getDefaultInstance()
    private val TOKENS_DIRECTORY_PATH = "tokens"

    private val SCOPES = listOf(SheetsScopes.SPREADSHEETS_READONLY)
    private val CREDENTIALS_FILE_PATH = "/credentials.json"


    @Throws(IOException::class)
    private fun getCredentials(HTTP_TRANSPORT: NetHttpTransport): Credential? {
        // Load client secrets.
        val `in`: InputStream =
            MainActivity::class.java.getResourceAsStream(CREDENTIALS_FILE_PATH)
                ?: throw FileNotFoundException("Resource not found: $CREDENTIALS_FILE_PATH")
        val clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, InputStreamReader(`in`))

        // Build flow and trigger user authorization request.
        val flow = GoogleAuthorizationCodeFlow.Builder(
            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES
        )
            .setDataStoreFactory(FileDataStoreFactory(File(TOKENS_DIRECTORY_PATH)))
            .setAccessType("offline")
            .build()
        val receiver = LocalServerReceiver.Builder().setPort(8888).build()
        return AuthorizationCodeInstalledApp(flow, receiver).authorize("user")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        clicks()

         val HTTP_TRANSPORT : NetHttpTransport = GoogleNetHttpTransport.newTrustedTransport()
        val spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms"
        val range = "Class Data!A2:E"
        val service = Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
            .setApplicationName(APPLICATION_NAME)
            .build()
        val response: ValueRange = service.spreadsheets().values()[spreadsheetId, range]
            .execute()

        val values = response.getValues()
        if (values == null || values.isEmpty()) {
            println("No data found.")
        } else {
            println("Name, Major")
            for (row in values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row[0], row[4])
            }
        }


    }


    override fun onResume() {
        super.onResume()

        binding.capitalsContainer.isClickable = true
        binding.historyContainer.isClickable = true
        binding.geographyContainer.isClickable = true
        binding.literatureContainer.isClickable = true
        binding.sportsContainer.isClickable = true
        binding.scienceContainer.isClickable = true

        Amplify.Auth.fetchAuthSession(
            {
                if(it.isSignedIn){
                    binding.login.visibility = View.INVISIBLE
                    binding.admin.visibility = View.VISIBLE

                }else{
                    binding.login.visibility = View.VISIBLE
                    binding.admin.visibility = View.INVISIBLE
                }
                Log.d("TAG", "fetchAuthSession: ")


            },{
                Log.d("TAG", "fetchAuthSession: "+it.message)
            })

    }

    private fun clicks() {
        binding.capitalsContainer.setOnClickListener {
            binding.capitalsContainer.isClickable = false
            startTheQuiz(1)
        }

        binding.historyContainer.setOnClickListener {
            binding.historyContainer.isClickable = false
            startTheQuiz(2)
        }

        binding.geographyContainer.setOnClickListener {
            binding.geographyContainer.isClickable = false
            startTheQuiz(3)
        }

        binding.literatureContainer.setOnClickListener {
            binding.literatureContainer.isClickable = false
            startTheQuiz(4)
        }

        binding.sportsContainer.setOnClickListener {
            binding.sportsContainer.isClickable = false
            startTheQuiz(5)
        }

        binding.scienceContainer.setOnClickListener {
            binding.scienceContainer.isClickable = false
            startTheQuiz(6)
        }

        binding.login.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.admin.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity, AdminActivity::class.java)
            startActivity(intent)
        }

    }


    private fun startTheQuiz(type: Int) {
        val intent : Intent = Intent(this@MainActivity, QuizActivity::class.java)
        intent.putExtra(QUIZ_TYPE, type)
        startActivity(intent)

    }


}