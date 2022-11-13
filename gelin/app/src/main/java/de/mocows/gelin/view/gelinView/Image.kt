package de.mocows.gelin.view.gelinView

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import de.mocows.gelin.R

@Composable
fun LogoImage(
    modifier: Modifier = Modifier
        .fillMaxWidth(0.5f)
) {
    val image: Painter = painterResource(id = R.drawable.logo_gelin)
    Image(painter = image, contentDescription = "Logo Gelin")
}