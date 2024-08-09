package com.example.mycityapp.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.Datasource
import com.example.mycityapp.ui.theme.Data.data

@Composable
fun ResturantScreen(onNextButtonClicked: () -> Unit,modifier: Modifier= Modifier) {
    Scaffold { it ->
        LazyColumn(contentPadding = it) {
            items(data) { datasource ->
                ResturantScreenItem(datasource = datasource)
            }
            item {
                    Spacer(modifier = Modifier.height(80.dp))
                    Button(
                        onClick = { onNextButtonClicked() },
                        modifier = modifier.
                        wrapContentWidth(align = Alignment.End)
                            .width(150.dp)
                            .padding(bottom = 46.dp,end = 10.dp,top = 10.dp, start = 10.dp)
                            .height(50.dp)

                    ) {
                        Text(
                            text = "Next",

                            )
                    }
            }

        }
    }
}

@Composable
fun ResturantScreenItem(datasource: Datasource , modifier: Modifier = Modifier) {
    var showDescription by remember  { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 4.dp)
            .fillMaxWidth()
           .height(if (showDescription) 350.dp else 80.dp)
            .clickable { showDescription = !showDescription }
    ) {
        Column() {
            ResturantName(name = datasource.resnames)
            if(showDescription) {

                ResturantDescription(des = datasource.description)
            }
        }
    }
}
@Composable
fun ResturantDescription(@StringRes des: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(des),
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify

    )
}

@Composable
fun ResturantName(@StringRes name: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(name),
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier.padding(16.dp),
        fontWeight = FontWeight.Medium,


    )
}

@Preview(showBackground = true)
@Composable
fun ResturantScreenPreview() {
    MyCityAppTheme {
        ResturantScreen(onNextButtonClicked = {})
    }
}