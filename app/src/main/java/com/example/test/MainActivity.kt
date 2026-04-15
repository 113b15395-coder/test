package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrinkOrderApp()
        }
    }
}

@Composable
fun DrinkOrderApp() {

    // 狀態
    var selectedDrink by remember { mutableStateOf("珍珠奶茶") }
    var sugar by remember { mutableStateOf("全糖") }
    var ice by remember { mutableStateOf("正常冰") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 🍹 飲料選擇
        Text(text = "選擇飲料：$selectedDrink")
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            DrinkButton("珍珠奶茶", selectedDrink) { selectedDrink = it }
            DrinkButton("紅茶", selectedDrink) { selectedDrink = it }
            DrinkButton("綠茶", selectedDrink) { selectedDrink = it }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🍬 甜度
        Text(text = "甜度選擇")
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            SelectButton("全糖", sugar, Color(0xFF4CAF50)) { sugar = it }
            SelectButton("半糖", sugar, Color(0xFF4CAF50)) { sugar = it }
            SelectButton("無糖", sugar, Color(0xFF4CAF50)) { sugar = it }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ❄️ 冰塊
        Text(text = "冰塊選擇")
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            SelectButton("正常冰", ice, Color(0xFF2196F3)) { ice = it }
            SelectButton("少冰", ice, Color(0xFF2196F3)) { ice = it }
            SelectButton("去冰", ice, Color(0xFF2196F3)) { ice = it }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ✅ 確認訂單
        Button(onClick = {
            result = "你點的是：$selectedDrink + $sugar + $ice"
        }) {
            Text("確認訂單")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 📋 結果
        Text(text = result)
    }
}

@Composable
fun DrinkButton(name: String, selected: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(name) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (name == selected) Color.Magenta else Color.Gray
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        Text(name)
    }
}

@Composable
fun SelectButton(
    text: String,
    selected: String,
    selectedColor: Color,
    onClick: (String) -> Unit
) {
    Button(
        onClick = { onClick(text) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (text == selected) selectedColor else Color.LightGray
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text)
    }
}