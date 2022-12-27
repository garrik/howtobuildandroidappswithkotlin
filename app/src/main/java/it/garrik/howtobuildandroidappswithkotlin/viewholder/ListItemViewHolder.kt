package it.garrik.howtobuildandroidappswithkotlin.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import it.garrik.howtobuildandroidappswithkotlin.model.ListItemUiModel

abstract class ListItemViewHolder(
    containerView: View
) : RecyclerView.ViewHolder(containerView) {
    abstract fun bindData(listItem: ListItemUiModel)
}