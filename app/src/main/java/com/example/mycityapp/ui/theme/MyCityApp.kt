package com.example.mycityapp.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.Datasource
import com.example.mycityapp.R

enum class MyCityApp(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Resturant(title = R.string.resturant),
    Parks(title = R.string.Parks),
    CofeeShops(title = R.string.cofee_Shops),
    Malls(title = R.string.shopping_malls)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: MyCityApp,
    canNavigationBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(title = {Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
        ){
        Text(text =  stringResource(id = currentScreen.title),
        style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
            

        ) }},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigationBack) {
                IconButton(onClick = { navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }

            }
        }

    )
}

@Composable
fun CityApp(
    navController : NavHostController = rememberNavController(),
            modifier: Modifier = Modifier) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityApp.valueOf(
        backStackEntry?.destination?.route?:MyCityApp.Start.name
    )


Scaffold(
    topBar ={
        AppBar(currentScreen = currentScreen, canNavigationBack =navController.previousBackStackEntry != null
            , navigateUp = { navController.navigateUp() })
    }
) { innerPadding ->
NavHost(navController = navController, startDestination = MyCityApp.Start.name, modifier =
modifier.padding(innerPadding)) {
    composable(route = MyCityApp.Start.name) {
        HomeScreen(
            onNextButtonClicked = {
                navController.navigate(MyCityApp.Resturant.name)
            },
            modifier = Modifier)
    }
    composable(route = MyCityApp.Resturant.name) {
        ResturantScreen(onNextButtonClicked = {
            navController.navigate(MyCityApp.Parks.name)
        })
    }
    composable(MyCityApp.Parks.name) {
        ParkScreen(onNextButtonClicked = {
            navController.navigate(MyCityApp.CofeeShops.name)
        })
    }
    composable(MyCityApp.CofeeShops.name) {
        CofeeShopScreen(onNextButtonClicked ={
            navController.navigate(MyCityApp.Malls.name)
        })
    }
    composable(MyCityApp.Malls.name) {
        MallScreen(onCancelButtonClicked = { cancelApp(navController) })
    }


}

}

}
private fun cancelApp(navController: NavHostController) {
navController.popBackStack(MyCityApp.Start.name, inclusive = false)
}