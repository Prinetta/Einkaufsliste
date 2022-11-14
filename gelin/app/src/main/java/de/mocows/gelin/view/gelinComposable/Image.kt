package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import de.mocows.gelin.R

@Composable
fun LogoImage(
    modifier: Modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),

) {
    val image: Painter = painterResource(id = R.drawable.ic_logo212)
    Image(painter = image, contentDescription = "Logo Gelin")
}
@Preview
@Composable
fun ImageLogoPreview(){
    LogoImage()
}