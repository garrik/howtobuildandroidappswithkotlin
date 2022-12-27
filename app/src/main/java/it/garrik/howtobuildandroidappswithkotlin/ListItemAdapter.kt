package it.garrik.howtobuildandroidappswithkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.garrik.howtobuildandroidappswithkotlin.model.CatUiModel
import it.garrik.howtobuildandroidappswithkotlin.model.ListItemUiModel
import it.garrik.howtobuildandroidappswithkotlin.viewholder.CatViewHolder
import it.garrik.howtobuildandroidappswithkotlin.viewholder.ListItemViewHolder
import it.garrik.howtobuildandroidappswithkotlin.viewholder.TitleViewHolder

private const val VIEW_TYPE_TITLE = 0
private const val VIEW_TYPE_CAT = 1

class ListItemAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ListItemViewHolder>() {
    private val listData = mutableListOf<ListItemUiModel>()

    fun setData(listData: List<ListItemUiModel>) {
        this.listData.clear()
        this.listData.addAll(listData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        VIEW_TYPE_TITLE -> {
            val view = layoutInflater.inflate(R.layout.item_title, parent, false)
            TitleViewHolder(view)
        }
        VIEW_TYPE_CAT -> {
            val view = layoutInflater.inflate(R.layout.item_cat, parent, false)
            CatViewHolder(
                view,
                imageLoader,
                object : CatViewHolder.OnClickListener {
                   override fun onClick(catData: CatUiModel) = onClickListener.onItemClick(catData)
            })
        }
        else -> throw IllegalArgumentException("Unknown view type requested: $viewType")
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

    override fun getItemViewType(position: Int) = when (listData[position]) {
       is ListItemUiModel.Title -> VIEW_TYPE_TITLE
       is ListItemUiModel.Cat -> VIEW_TYPE_CAT
    }

    interface OnClickListener {
        fun onItemClick(catData: CatUiModel)
    }
}
