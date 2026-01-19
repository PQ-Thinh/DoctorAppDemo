package com.example.doctorappdemo.feature.topdoctors.components

import android.content.res.ColorStateList
import android.widget.RatingBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import android.R as AndroidR


@Composable
fun ComposeRatingBar(
    rating: Float,
    starts:Int=5
) {
    var starsTint = Color(0xffffc160).toArgb()

    AndroidView(
        factory = {context->
            RatingBar(context,null,AndroidR.attr.ratingBarStyleSmall).apply {
                setNumStars(starts)
                setStepSize(0.5f)
                setIsIndicator(true)
                progressTintList= ColorStateList.valueOf(starsTint)
            }
        },
        update = {rb->
           rb.setRating(rating)
        }
    )
}