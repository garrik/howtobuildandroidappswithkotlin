package it.garrik.howtobuildandroidappswithkotlin.viewholder

import android.view.View
import android.widget.TextView
import it.garrik.howtobuildandroidappswithkotlin.R
import it.garrik.howtobuildandroidappswithkotlin.model.ListItemUiModel

class TitleViewHolder(
    containerView: View
) : ListItemViewHolder(containerView) {
    private val titleView: TextView
        by lazy { containerView.findViewById(R.id.item_title_title) }

    override fun bindData(listItem: ListItemUiModel) {
        require(listItem is ListItemUiModel.Title) {
            "Expected ListItemUiModel.Title"
        }
        titleView.text = listItem.title
    }
}