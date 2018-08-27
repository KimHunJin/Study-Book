package dxmnd.com.rightnow.main.info.view

import android.annotation.SuppressLint
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.location.Address
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dxmnd.com.rightnow.R
import dxmnd.com.rightnow.main.info.InfoContract
import dxmnd.com.rightnow.main.info.adapter.InfoRecyclerVIewAdapter
import dxmnd.com.rightnow.main.info.adapter.item.BusInfoItem
import dxmnd.com.rightnow.main.info.presenter.InfoPresenter
import kotlinx.android.synthetic.main.fragment_bus_info.*


class InfoFragment : Fragment(), InfoContract.View {
    override var presenter: InfoContract.Presenter
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    private var p: InfoContract.Presenter? = null

    //    private var presenter: InfoPresenter? = null
    private var adapter: InfoRecyclerVIewAdapter? = null

    companion object {
        fun newInstance(): InfoFragment {
            return InfoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_bus_info, container, false)

    private var address : Address? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.apply {
            adapter = InfoRecyclerVIewAdapter(this)
        }


        p = InfoPresenter(this).apply {
            this.adapterContractModel = adapter
            this.adapterContractView = adapter
            getLocation(context!!)
            address = getLocation()
        }


        rcv_bus_info.adapter = adapter
        rcv_bus_info.setHasFixedSize(true)
        rcv_bus_info.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        addItem()
        mapInit()


    }

    @SuppressLint("CommitTransaction")
    override fun mapInit() {
        val mapView = MapViewFragment()
        address?.let {
            mapView.setLocation(it.latitude, it.longitude)
        }

        val fragmentManager: FragmentManager? = activity?.fragmentManager
        val transaction : FragmentTransaction? = fragmentManager?.beginTransaction()
        transaction?.apply {
            this.add(R.id.layout_bus_info_map, mapView)
            this.commit()
        }
    }

    private fun addItem() {

        val items: ArrayList<BusInfoItem> = arrayListOf(
                BusInfoItem(0, "홍안운수종점", "11-225", false, false, 0),
                BusInfoItem(1, "불암현대아파트", "11-226", true, true, 2),
                BusInfoItem(2, "동아불암아파트", "11-227", false, false, 2),
                BusInfoItem(3, "불암대림아파트", "11-230", true, false, 2),
                BusInfoItem(4, "상계벽산아파트", "11-240", false, true, 2),
                BusInfoItem(5, "몰라", "11-260", false, false, 1)
        )

        p?.apply {
            this.adapterContractModel?.addItems(items)
        }
    }
}