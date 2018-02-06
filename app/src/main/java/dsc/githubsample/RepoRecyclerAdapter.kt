package dsc.githubsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_repo_list.view.*

/**
 * Created by betterclever on 2/4/2018.
 */

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val repoNameTV: TextView = itemView.repositoryNameTextView
    val repoStarsTV: TextView = itemView.starsTextView


}

class RepoRecyclerAdapter : RecyclerView.Adapter<RepoViewHolder>() {

    private var repoList = mutableListOf<String>()

    fun addRepos(repos: List<String>) {
        repoList.addAll(repos)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.repoNameTV.text = repoList[position]
    }

    override fun getItemCount() = repoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo_list, parent, false)
        return RepoViewHolder(view)
    }


}