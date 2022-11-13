package de.mocows.gelin.view.gelinView.Dataclasses

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val name: String,
    val contentDescription: String?,
    val icon: ImageVector
)
