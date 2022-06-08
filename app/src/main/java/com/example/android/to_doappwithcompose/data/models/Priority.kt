package com.example.android.to_doappwithcompose.data.models

import com.example.android.to_doappwithcompose.ui.theme.HighPriorityColor
import com.example.android.to_doappwithcompose.ui.theme.LowPriorityColor
import com.example.android.to_doappwithcompose.ui.theme.MediumPriorityColor
import com.example.android.to_doappwithcompose.ui.theme.NonePriorityColor

enum class Priority(val color: androidx.compose.ui.graphics.Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}