package app.earthcpr.sol.screens.friend

// REST API 통신 후 받아온 데이터를
// 리스트로 뿌려줘야함



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




data class Friend(val name: String, val achievement: String)

@Composable
fun FriendRankingScreen() {
    // 임시 데이터
    val friends = listOf(
        Friend("김신한", "챌린지 달성률 78%"),
        Friend("박지훈", "챌린지 달성률 65%"),
        Friend("이서연", "챌린지 달성률 90%"),
        Friend("정민수", "챌린지 달성률 50%"),
        Friend("최수지", "챌린지 달성률 85%")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "친구 랭킹",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(24.dp)
            )
        }

        // Search Bar
        Spacer(modifier = Modifier.height(8.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))

        // API로 받아올 데이터에 날짜, 시간이 없다면 기존에 준비해둔 함수를 적용할 예정
        Text(
            text = "현재 챌린지 달성 순위 2024년 8월 18일 19시 기준",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Ranking List using LazyColumn
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(friends) { friend ->
                RankingItem(name = friend.name, achievement = friend.achievement)
            }
        }
    }
}

@Composable
fun SearchBar() {  // user_id를 입력하면 친구 추가 요청을 보낼 API 코드 필요 >> 명세서
                    // 방법1 , 추가한 친구의 ID만 보내준다  방법2. FE에서 LIST에 APPEND하고 리스트를 통째로 보낸다.
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(CircleShape)
            .background(Color(0xFFF2F2F2))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    if (text.isEmpty()) {
                        Text(
                            text = "친구를 검색해보세요",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}

@Composable
fun RankingItem(name: String, achievement: String) {    // 친구 순위 보여주는 함수
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Trophy Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = achievement, fontSize = 14.sp, color = Color.Gray)
        }

        Row {
            Button(
                onClick = {  },    // 깨우기 기능  FCM 기능 구현에 따라 삭제 여부 결정
                modifier = Modifier
                    .height(36.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "깨우기", color = Color.White, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {    },   // 삭제버튼 기능 구현을 할 수 있을지 모르기 때문에 일단 보류, REMOVE로 대체 가능
                modifier = Modifier
                    .height(36.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336))
            ) {
                Text(text = "삭제", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFriendRankingScreen() {
    FriendRankingScreen()
}