package com.pattadon.sampleapplicationproject.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pattadon.sampleapplicationproject.R
import kotlinx.android.synthetic.main.fragment_network_menu.*

/**
 * Created by pattadon on 8/18/17.
 */

class NetworkMenuFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): NetworkMenuFragment {
            val networkFragment = NetworkMenuFragment()
            val args = Bundle()
            networkFragment.arguments = args
            return networkFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_network_menu, container, false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retrofit_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://pattadon.com/samplenetwork"))
            intent.`package` = activity.packageName
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            startActivity(intent)
        }
    }
}
