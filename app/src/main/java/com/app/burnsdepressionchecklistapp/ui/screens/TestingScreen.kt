package com.app.burnsdepressionchecklistapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.burnsdepressionchecklistapp.R
import com.app.burnsdepressionchecklistapp.ui.components.BurnsDepressionChecklistButton
import com.app.burnsdepressionchecklistapp.ui.components.BurnsDepressionChecklistTopBar

@Composable
fun TestingScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val state = TestingHelper.uiState
    Scaffold(
        topBar = {
            BurnsDepressionChecklistTopBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_close_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        when (state) {
            is TestingScreenUiState.QuestionDisplayed -> {
                val numberOfQuestion = state.numberOfQuestion
                Checklist(numberOfQuestion = numberOfQuestion)
            }
            is TestingScreenUiState.QuestionsEnded -> {
                //TODO: Make ResultScreen
                Toast.makeText(context, "${TestingHelper.total}", Toast.LENGTH_LONG).show()
                navController.popBackStack()
            }
        }
    }
}

@Composable
fun Checklist(numberOfQuestion: Int) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            text = TestingHelper.questions[numberOfQuestion],
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            BurnsDepressionChecklistButton(
                onClick = {
                    TestingHelper.nextQuestion(Answer.NEVER)
                },
                buttonText = "Ни разу"
            )
            BurnsDepressionChecklistButton(
                onClick = {
                    TestingHelper.nextQuestion(Answer.SOMETIMES)
                },
                buttonText = "Иногда"
            )
            BurnsDepressionChecklistButton(
                onClick = {
                    TestingHelper.nextQuestion(Answer.MODERATELY)
                },
                buttonText = "Умеренно"
            )
            BurnsDepressionChecklistButton(
                onClick = {
                    TestingHelper.nextQuestion(Answer.OFTEN)
                },
                buttonText = "Часто"
            )
            BurnsDepressionChecklistButton(
                onClick = {
                    TestingHelper.nextQuestion(Answer.VERY_OFTEN)
                },
                buttonText = "Крайне часто"
            )
        }
    }
}

sealed class TestingScreenUiState {
    class QuestionDisplayed(val numberOfQuestion: Int) : TestingScreenUiState()
    object QuestionsEnded : TestingScreenUiState()
}

enum class Answer(val points: Int) {
    NEVER(0),
    SOMETIMES(1),
    MODERATELY(2),
    OFTEN(3),
    VERY_OFTEN(4)
}

//TODO: Convert to ViewModel
object TestingHelper {
    private var currentQuestion = 0

    val questions = listOf(
        "Вам грустно или вы в плохом настроении",
        "Чувствуете грусть, удручены",
        "Чувствуете желание расплакаться, слезливость",
        "Чувствуете уныние",
        "Испытываете чувтсво безнадежности",
        "Имеете низкую самооценку",
        "Испытываете чувство собственной ничтожности и непригодности",
        "Испытываете чувство вины или стыда",
        "Критикуете или обвиняете самого себя",
        "Испытываете трудности с принятием решений",
        "Чувствуете потерю интереса к членам семьи, друзьям, коллегам",
        "Испытываете одиночество",
        "Проводите меньше времени с семьей или с друзьями",
        "Чувствуете потерю мотивации",
        "Чувствуете потерю интереса к работе или другим занятиям",
        "Избегаете работы и другой деятельности",
        "Ощущаете потерю удовольствия и нехватку удовлетворения от жизни",
        "Чувствуете усталость",
        "Испытываете затруднения со сном или, наоборот, слишком много спите",
        "Имеете сниженный или, наоборот, повышенный аппетит",
        "Замечаете потерю интереса к сексу",
        "Беспокоитесь по поводу своего здоровья",
        "Имеются ли у вас суицидальные мысли?",
        "Хотели бы вы окончить свою жизнь?",
        "Планируете ли вы навредить себе?"
    )
    var uiState: TestingScreenUiState by mutableStateOf(
        TestingScreenUiState.QuestionDisplayed(
            currentQuestion
        )
    )
        private set
    var total = 0
        private set

    fun nextQuestion(answer: Answer) {
        uiState = if (currentQuestion < questions.size) {
            TestingScreenUiState.QuestionDisplayed(++currentQuestion)
        } else {
            TestingScreenUiState.QuestionsEnded
        }
        total += answer.points
    }
}
