package dsc.githubsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_show_repo.*

class ShowRepoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_repo)

        val adapter = RepoRecyclerAdapter()

        val repoList = mutableListOf("ABC", "DEF", "GHI")
        for (i  in 0 until 1000) {
            repoList.add("Repo $i")
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.addRepos(repoList)
        adapter.notifyDataSetChanged()

    }
}
