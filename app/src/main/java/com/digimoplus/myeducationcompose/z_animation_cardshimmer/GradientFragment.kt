package com.digimoplus.myeducationcompose.z_animation_cardshimmer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.digimoplus.myeducationcompose.presentation.components.RecipeCard

class GradientFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val list  = listOf(1,1,1,1,1,1,1)
                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        itemsIndexed(items = list ?: listOf()) { _, recipe ->
                            GradientShimmerCard(
                                modifier = Modifier.padding(8.dp),
                                cardHeight = 200.dp,
                                colors = listOf(
                                    Color.LightGray.copy(alpha = 0.8f),
                                    Color.Gray.copy(alpha = 0.1f),
                                    Color.LightGray.copy(alpha = 0.8f)
                                ),
                            )
                        }
                    }
                }

            }
        }
    }
}