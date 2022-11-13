package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import de.mocows.gelin.R

@Composable
fun LogoImage(
    modifier: Modifier = Modifier
        .fillMaxWidth(0.5f)
) {
    val image: Painter = painterResource(id = R.drawable.logo_gelin)
    Image(painter = image, contentDescription = "Logo Gelin")
}