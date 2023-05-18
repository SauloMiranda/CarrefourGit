package com.saulofirmo.carrefourgitlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saulofirmo.carrefourgitlist.databinding.RepoListItemBinding
import com.saulofirmo.model.Repo

class RepoListAdapter :
    RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    private val data = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = RepoListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Repo: Repo = data[position]
        holder.bind(Repo)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun replaceAll(item: List<Repo>) {
        data.clear()
        data.addAll(item)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RepoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repo) {
            binding.repoFullName.text = repo.name
            binding.repoDescription.text = repo.description
        }
    }
}
