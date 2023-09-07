package github.preeti5sharon.jokesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import github.preeti5sharon.jokesapp.databinding.RvItemBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class RVViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class JokeDiffer : DiffUtil.ItemCallback<JokeResponseItem>() {
        override fun areItemsTheSame(
            oldItem: JokeResponseItem,
            newItem: JokeResponseItem,
        ): Boolean {
            return newItem.id === oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: JokeResponseItem,
            newItem: JokeResponseItem,
        ): Boolean {
            return newItem.id == oldItem.id
        }
    }

    val jokeAsyncDiffer = AsyncListDiffer(this, JokeDiffer())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return RVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jokeAsyncDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = RvItemBinding.bind(holder.itemView)
        val item = jokeAsyncDiffer.currentList.getOrNull(position)
        binding.setup.text = item?.setup.toString()
        binding.punchline.text = item?.punchline.toString()
    }
}
