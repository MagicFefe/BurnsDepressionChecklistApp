package com.app.burnsdepressionchecklistapp.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.burnsdepressionchecklistapp.R
import com.app.burnsdepressionchecklistapp.presentation.ui.theme.BurnsDepressionChecklistAppTheme


@Composable
fun QuestionnaireTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    navigationIcon: @Composable (BoxScope.() -> Unit)? = null,
) {
    Surface(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Box {
            if (navigationIcon != null) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(72.dp)
                        .padding(4.dp),
                    contentAlignment = Alignment.CenterStart,
                    content = navigationIcon
                )
            }
            Box(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun QuestionnaireTopBar_Preview() {
    BurnsDepressionChecklistAppTheme {
        Scaffold {
            QuestionnaireTopBar(
                title = "Шкала депрессии Бернса",
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun QuestionnaireButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonText: String
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant
        ),
        shape = RoundedCornerShape(100.dp),
        onClick = onClick
    ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}