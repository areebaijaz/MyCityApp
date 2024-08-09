package com.example.mycityapp.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.R

@Composable
fun HomeScreen(
    onNextButtonClicked : () -> Unit,
    modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        ) {
        Card(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.resturant), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.resturant),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Card(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.parks), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.Parks),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Card(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.cofeeshops),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.cofee_Shops),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Card(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.malls),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.shopping_malls),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }

        }
        Spacer(modifier = Modifier.height(140.dp))
        Button(onClick = { onNextButtonClicked() },
modifier = Modifier.width(200.dp).align(Alignment.End).padding(10.dp).clip(shape = RectangleShape).height(80.dp)
            ){
                Text(
                    text = "Next",


                    )
            }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyCityAppTheme {
        HomeScreen(
            onNextButtonClicked = {}
        )
    }
}