package com.pattadon.sampleapplicationproject.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pattadon.sampleapplicationproject.R
import kotlinx.android.synthetic.main.fragment_layout_menu.*

/**
 * Created by pattadon on 8/18/17.
 */

class LayoutMenuFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): LayoutMenuFragment {
            val layoutMenuFragment = LayoutMenuFragment()
            val args = Bundle()
            layoutMenuFragment.arguments = args
            return layoutMenuFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_layout_menu, container, false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layout_menu_basic_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://pattadon.com/basiclayout"))
            intent.`package` = activity.packageName
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            startActivity(intent)
        }

        layout_menu_support_library_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://pattadon.com/supportlayout"))
            intent.`package` = activity.packageName
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            startActivity(intent)
        }
    }
}
