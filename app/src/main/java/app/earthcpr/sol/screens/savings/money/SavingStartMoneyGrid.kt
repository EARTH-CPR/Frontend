package app.earthcpr.sol.screens.savings.money

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import app.earthcpr.sol.R
import app.earthcpr.sol.models.SavingMoney
import app.earthcpr.sol.ui.theme.newFontFamily

@Composable
fun SavingStartMoneyGrid(
    savingStartMoneyList: List<SavingMoney>,
    columns: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val rows = savingStartMoneyList.chunked(columns)
        rows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically // Center alignment vertically
            ) {
                val spacing = (columns - row.size) * 2.dp // Calculate remaining space
                Spacer(modifier = Modifier.width(spacing)) // Apply remaining space
                row.forEach { it ->
                    SavingStartMoney(it)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun SavingStartMoney(param: SavingMoney) {
    Card(
        modifier = Modifier
            .width(125.dp)
            .height(50.dp)
            .padding(3.dp)
            .clickable {
                param.onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(1.dp, color = if (param.isSelected) colorResource(id = R.color.box_border_selected_color) else colorResource(id = R.color.box_border_color)),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = param.money,
                fontFamily = newFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            )

        }
    }
}

