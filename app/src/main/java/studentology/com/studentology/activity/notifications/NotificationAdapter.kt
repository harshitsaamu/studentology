package studentology.com.studentology.activity.notifications

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_notification.view.*
import studentology.com.studentology.R

class NotificationAdapter(private val context: Context, private val notificationItem: List<NotificationItems>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationAdapter.ViewHolder {
        val notificationView = LayoutInflater.from(context).inflate(R.layout.layout_notification, parent, false)
        return ViewHolder(notificationView)
    }

    override fun getItemCount(): Int {
        return notificationItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(notificationItem[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(data: NotificationItems) {
            itemView.notification_title.text = data.title
            itemView.notification_content.text = data.description
            when (data.bookmarked) {
                "true" -> {
                    itemView.notication_bookmark_icon.setImageResource(R.drawable.ic_bookmark_black_24dp)
                }
                else -> {
                    itemView.notication_bookmark_icon.setImageResource(R.drawable.ic_bookmark_border_black_24dp)
                }
            }
        }
    }

}
