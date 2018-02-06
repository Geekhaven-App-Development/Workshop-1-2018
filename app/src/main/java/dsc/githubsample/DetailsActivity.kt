package dsc.githubsample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)

        var data = intent.getStringExtra("username")

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        val githubService = retrofit.create(GithubService::class.java)

        var call = githubService.fetchUser(data)
        call.enqueue(object : Callback<GithubUser> {

            override fun onFailure(call: Call<GithubUser>?, t: Throwable?) {
                Log.e("error", t.toString())
            }

            override fun onResponse(call: Call<GithubUser>?, response: Response<GithubUser>) {
                if(response.isSuccessful) {
                    val user = response.body()
                    Log.d("user", user.toString())

                    if(user != null) {
                        Picasso.with(this@DetailsActivity)
                                .load(user.avatarUrl)
                                .into(imageView)

                        fullNameTextView.text = user.name
                    }

                }
            }

        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
