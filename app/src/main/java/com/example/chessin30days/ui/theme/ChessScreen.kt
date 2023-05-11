package com.example.chessin30days.ui.theme
import Abril
import Poppins
import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chessin30days.R
import com.example.chessin30days.model.DataSource.openingsRepository.openings
import com.example.chessin30days.model.opening
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChessApp() {
    val darktheme = isSystemInDarkTheme()
    Scaffold(
        topBar = {
            ChessTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 70.dp)) {
            items(openings) {
                ChessItem(opening = it, darktheme)
            }
        }
    }
}
@Composable
fun ChessItem(
    opening: opening,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        val backgroundColor = if (isDarkTheme) Color(0xFF129EAF) else Color(0xFFE6F4EA)
        Column(
            modifier = Modifier
                .background(color = backgroundColor)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(Modifier.padding(5.dp)) {
                ChessInformation(
                    day_number = opening.day_Number,
                    openingName = opening.opening_Name
                )
                Spacer(modifier = Modifier.weight(1f))
                ChessItemButton(expanded = expanded) { expanded = !expanded }
            }
            if (expanded) {
                ChessItemDescription(opening.opening_Des, opening.opening_Image)
            }
        }
    }
}
@Composable
fun ChessTopAppBar() {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(R.drawable.my_project),
            contentDescription = null, modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
                .clip(
                    RoundedCornerShape(100.dp)
                ),
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.app_name),
            fontFamily = Abril,
            fontSize = 35.sp,
        )
    }
}
@Composable
private fun ChessItemButton(
    expanded: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = Color.Black,
            contentDescription = null
        )
    }
}

@Composable
fun ChessItemDescription(
    @StringRes open_DES: Int,
    @DrawableRes open_IMAGE: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Box(modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = open_IMAGE),
                contentDescription = "Opening Image",
                Modifier.size(130.dp)
            )
        }
        Text(
            stringResource(open_DES),
            modifier.padding(top = 8.dp),
            fontFamily = Poppins,
            textAlign = TextAlign.Justify
        )
    }

}

@Composable
fun ChessInformation(
    @StringRes day_number: Int,
    @StringRes openingName: Int
) {

    Column(modifier = Modifier.padding(start = 8.dp)) {
        Text(
            text = stringResource(id = day_number),
            fontFamily = Poppins,
            modifier = Modifier.padding(top = 8.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )

        Divider(
            Modifier
                .width(200.dp)
                .padding(end = 8.dp),
            color = Color.DarkGray
        )
        Text(
            text = stringResource(id = openingName),
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ChessScreeenPreviewMain() {
    ChessApp()
}

