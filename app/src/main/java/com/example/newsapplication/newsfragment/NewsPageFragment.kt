package com.example.newsapplication.newsfragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapplication.R
import com.example.newsapplication.adapter.Adapter
import com.example.newsapplication.databinding.NewsPageFragmentBinding

class NewsPageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var adapter: Adapter
    private val viewModel: NewsPageViewModel by viewModels()
    private lateinit var binding: NewsPageFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsPageFragmentBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }
    private fun init() {
        viewModel.init()
        recyclerViewInit()
        observe()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_bar, menu)
        val menuItem = menu.findItem(R.id.search)
        val view = menuItem.actionView as? SearchView
        view?.isSubmitButtonEnabled = true
    }
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }
    private fun recyclerViewInit() {
        adapter = Adapter()
        binding.recyclerPhotos.adapter = adapter
    }
    private fun observe() {
        viewModel.newsLiveData_.observe(viewLifecycleOwner, {adapter.dataSetter(it.toMutableList())} )
    }
}