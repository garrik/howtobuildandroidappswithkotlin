package it.garrik.howtobuildandroidappswithkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class SplitFragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_split_one, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareViewModel()
    }

    private fun prepareViewModel() {
        val totalsViewModel = ViewModelProvider(this).get(TotalsViewModel::class.java)
        updateText(totalsViewModel.total)
        view?.findViewById<Button>(R.id.fragment_split_one_button)?.setOnClickListener {
            updateText(totalsViewModel.increaseTotal())
        }
    }
    private fun updateText(total: Int) {
        view?.findViewById<TextView>(R.id.fragment_split_one_text_view)?.text = getString(R.string.total, total)
    }
}