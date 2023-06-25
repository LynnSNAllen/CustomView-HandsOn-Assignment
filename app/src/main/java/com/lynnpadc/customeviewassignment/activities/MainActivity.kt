package com.lynnpadc.customeviewassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lynnpadc.customeviewassignment.adapter.ProfileImageAdapter
import com.lynnpadc.customeviewassignment.adapter.ProfileImageItemOverlap
import com.lynnpadc.customeviewassignment.adapter.TaskAdapter
import com.lynnpadc.customeviewassignment.databinding.ActivityMainBinding
import com.lynnpadc.customeviewassignment.delegate.ProfileItemDelegate


class MainActivity : AppCompatActivity(), ProfileItemDelegate {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mProfileImageAdapter: ProfileImageAdapter
    private lateinit var mTaskAdapter: TaskAdapter

    private var originalStatusBarColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Removing Status bar color while showing dialog
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setUpRecyclerView()
        setUpListener()
    }

    private fun setUpListener() {
        binding.btnBackMain.setOnClickListener {
            finish()
        }
    }

    private fun setUpRecyclerView() {
        mProfileImageAdapter = ProfileImageAdapter(this)
        binding.rvProfileImage.adapter = mProfileImageAdapter
        binding.rvProfileImage.addItemDecoration(ProfileImageItemOverlap())
        binding.rvProfileImage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        mTaskAdapter = TaskAdapter(this)
        binding.rvTask.adapter = mTaskAdapter
        binding.rvTask.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }


    override fun onTapTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }

    override fun onTapProfileDetail() {
        startActivity(ProfileActivity.newIntent(this))
    }
}