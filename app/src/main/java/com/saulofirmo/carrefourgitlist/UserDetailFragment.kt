package com.saulofirmo.carrefourgitlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.saulofirmo.carrefourgitlist.databinding.FragmentUserDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private val viewModel: UserDetailViewModel by viewModels()

    private val args: UserDetailFragmentArgs by navArgs()

    private var _binding: FragmentUserDetailBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RepoListAdapter()
        binding.reposRecyclerView.adapter = adapter

        viewModel.userDetail.observe(viewLifecycleOwner) { user ->
            Picasso.get().load(user.avatarUrl).into(binding.userImageView)
            binding.userNameTextView.text = user.name
            binding.loginIdTextView.text = user.login
            binding.companyTextView.text = user.company
            binding.locationTextView.text = user.location
            binding.linkTextView.text = user.blog
        }

        viewModel.repos.observe(viewLifecycleOwner) { it ->
            adapter.replaceAll(it)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val login = args.userName
            viewModel.getUserDetail(login)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val login = args.userName
            viewModel.getRepos(login)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
