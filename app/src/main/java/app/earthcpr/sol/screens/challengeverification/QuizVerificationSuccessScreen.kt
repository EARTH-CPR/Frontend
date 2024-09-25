package app.earthcpr.sol.screens.challengeverification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.earthcpr.sol.screens.topbar.TopBar
import app.earthcpr.sol.ui.theme.newFontFamily

//import com.example.ht_practice.challengeScreen.ImageUploadSuccessScreen

@Composable
fun QuizVerificationSuccessScreen(
    navController : NavController
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier.height(44.dp))

        TopBar(title = "챌린지 성공"  ) {

        }

//        Spacer(modifier = Modifier.height(108.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(14.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 58.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // "탬플러를 사용하셨나요?" 텍스트
                Text(
                    text = "퀴즈 챌린지에 성공하셨군요!",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = newFontFamily,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 설명 텍스트
                Text(
                    text = "최고에요! 계속해서 챌린지에 도전하세요!.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        fontFamily = newFontFamily,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // 체크마크 아이콘
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 16.dp),
                    tint = Color(0xFF007AFF)
                )

                // 인증 완료 메시지
                Text(
                    text = "퀴즈 챌린지 인증이 완료되었습니다.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = newFontFamily,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 58.dp)
                )


            }


        }

        Card(
            modifier = Modifier
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF0046FF),
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "챌린지 목록",
                    fontFamily = newFontFamily,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(27.dp))

    }
}



@Preview
@Composable
fun Pasd(){
    QuizVerificationSuccessScreen(navController =  rememberNavController())
}