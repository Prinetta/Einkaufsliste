package de.moco.gelin.view.gelincomposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.moco.gelin.R


@Composable
fun UserPic() {
    Image(
        painter = painterResource(R.drawable.ic_person_grey),
        contentDescription = "User Profil",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10))
    )
}

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
fun ImageProdukt() {
    val image: Painter = painterResource(id = R.drawable.lebensmittel)
    Image(painter = image, contentDescription = "Hier ist das Bild des Angebots")
}

@Preview
@Composable
fun ImageLogoPreview(){
    ImageProdukt()
}

@Composable
fun BackgroundPic() {
    val image: Painter = painterResource(id = R.drawable.background_settings)
    Image(painter = image,contentDescription = "",
    modifier = Modifier.fillMaxSize())
}


