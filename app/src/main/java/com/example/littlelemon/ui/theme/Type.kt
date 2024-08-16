package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.learning.littlelemon.ui.theme.LittleLemonColor

val Typography = Typography (
    titleLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.charcoal
    ),
    titleMedium = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
     displayMedium = TextStyle(
        color = LittleLemonColor.green
     ),
     bodyMedium =  TextStyle(
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.green
    ),
     labelMedium =  TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
)
