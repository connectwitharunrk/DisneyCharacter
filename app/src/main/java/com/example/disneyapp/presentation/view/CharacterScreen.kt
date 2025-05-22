package com.example.disneyapp.presentation.view

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.disneyapp.presentation.viewmodel.CharacterViewModel

@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel(),
    navController: NavController
) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn {
        items(characters) { character ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val encodedUrl = Uri.encode(character.imageUrl)
                        navController.navigate("characterDetail/$encodedUrl")
                    }
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = character.imageUrl,
                    contentDescription = character.name,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(character.name.toString(), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
