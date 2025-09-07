package com.mexiti.listacomida
import androidx.compose.material3.ExperimentalMaterial3Api


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexiti.listacomida.data.DataSource
import com.mexiti.listacomida.model.Platillo
import com.mexiti.listacomida.ui.theme.ListaComidaTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComidaTheme(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuApp()
                }
            }
        }
    }
}

@Composable
fun MenuApp() {
    MenuCardList(
        platilloList = DataSource().LoadPlatillos(),
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_cubiertos),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 12.dp)
                )
                Text(
                    text = "Pancho Pozoles",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Composable
fun MenuCardList(platilloList: List<Platillo>, modifier: Modifier = Modifier) {
    Scaffold(topBar = { MenuTopBar() }) { inner ->
        LazyColumn(
            modifier = modifier.padding(inner),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(platilloList) { platillo ->
                MenuCard(
                    platillo = platillo,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(16.dp))

            Column {
                Text(
                    text = stringResource(id = platillo.stringResourceId),
                    style = MaterialTheme.typography.headlineSmall,
                    lineHeight = 28.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = platillo.precio,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = platillo.promo,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 18.sp
                    ),
                    color = Color(0xFF2E7D32)
                )


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview() {
    ListaComidaTheme(darkTheme = false, dynamicColor = false) {
        MenuCard(
            platillo = Platillo(
                stringResourceId = R.string.pozole,
                drawableResourceId = R.drawable.pozole,
                precio = "MX $100.0",
                promo = "Ahorra hasta el 30%"
            )
        )
    }
}
