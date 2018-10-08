package com.dxmnd.mos.mvvm.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dxmnd.mos.mvvm.R
import com.dxmnd.mos.mvvm.databinding.ItemBusBinding
import com.dxmnd.mos.mvvm.service.ServiceModel

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {



    private lateinit var busList: List<ServiceModel.BusArriveInfoModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val binding: ItemBusBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_bus, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(busList[position])
    }

    override fun getItemCount(): Int {
        return if(::busList.isInitialized) busList.size else 0
    }

    fun updateBusList(busList: List<ServiceModel.BusArriveInfoModel>) {
        this.busList = busList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemBusBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = MainViewModel()

        fun bind(bus: ServiceModel.BusArriveInfoModel) {
            viewModel.bind(bus)
            binding.viewModel = viewModel
        }
    }
}