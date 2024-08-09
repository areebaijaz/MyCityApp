package com.example.mycityapp.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.Dataofcofeeshops
import com.example.mycityapp.ui.theme.Data.Shops


@Composable
fun CofeeShopScreen(onNextButtonClicked : () -> Unit, modifier: Modifier = Modifier) {
    Scaffold { it ->
        LazyColumn(contentPadding = it) {
            items(Shops) { dataofcofeeshops ->
                CofeeShopsScreenItem(dataofcofeeshops = dataofcofeeshops)
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { onNextButtonClicked() },
                    modifier = modifier.
                    wrapContentWidth(align = Alignment.End)
                        .width(180.dp)
                        .padding(10.dp)
                        .height(40.dp)

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
fun CofeeShopsScreenItem(dataofcofeeshops: Dataofcofeeshops, modifier: Modifier = Modifier) {
    var showDescription by remember  { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 4.dp)
            .fillMaxWidth()
            .height(if(showDescription) 280.dp else 80.dp)
            .clickable { showDescription = !showDescription }

    ) {
        Column {
            CofeeName(name = dataofcofeeshops.shopsname)
            if(showDescription){
            CofeeDescription(des = dataofcofeeshops.descriptioncofee)
                }

        }
    }
}

@Composable
fun CofeeDescription(@StringRes des: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(des),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(16.dp),
        textAlign = TextAlign.Justify

    )
}

@Composable
fun CofeeName(@StringRes name: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(name),
        style = MaterialTheme.typography.headlineSmall,
        modifier = modifier.padding(16.dp),
        fontWeight = FontWeight.SemiBold
    )

}

@Preview(showBackground = true)
@Composable
fun CofeeShopscreenPreview() {
    MyCityAppTheme {
        CofeeShopScreen(onNextButtonClicked = {})
    }
}