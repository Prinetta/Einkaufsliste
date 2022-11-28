package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
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

@Composable
fun ImageProdukt(
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {
    val image: Painter = painterResource(id = R.drawable.background_green)
    Image(painter = image, contentDescription = "Hier ist das Bild des Angebots")
}

@Preview
@Composable
fun ImageLogoPreview(){
    ImageProdukt()
}
@Preview
@Composable
fun StiftFuerBearbeiten(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.ic_pencil_36),
        contentDescription = "bearbeiten")
}
