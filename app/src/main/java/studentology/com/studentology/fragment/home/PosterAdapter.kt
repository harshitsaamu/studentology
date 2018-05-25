package studentology.com.studentology.fragment.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_banner.view.*
import studentology.com.studentology.R

class PosterAdapter(val context: Context, val imageArray:List<String>) : RecyclerView.Adapter<PosterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterAdapter.ViewHolder {
        val posterView = LayoutInflater.from(context).inflate(R.layout.layout_banner, parent, false)
        return ViewHolder(posterView)
    }

    override fun getItemCount(): Int {
        return imageArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(imageArray[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(url: String) {
            Glide.with(context).load(url).into(itemView.banner)
        }
    }

}
