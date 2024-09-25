package com.blackbirds.jccanvas

import androidx.lifecycle.ViewModel

class ChartsViewModel : ViewModel() {
    val chartData = listOf(
        ChartData(x = "USA", y = 100),
        ChartData(x = "RUS", y = 200),
        ChartData(x = "AUS", y = 60),
        ChartData(x = "IND", y = 300),
        ChartData(x = "ISR", y = 350),
        ChartData(x = "SLK", y = 700),
        ChartData(x = "PAK", y = 50)
    )

    val chartData2 = listOf(
        listOf(
            ChartData(x = "USA", y = 100),
            ChartData(x = "RUS", y = 200),
            ChartData(x = "AUS", y = 60),
            ChartData(x = "IND", y = 300),
            ChartData(x = "ISR", y = 350),
            ChartData(x = "SLK", y = 700),
            ChartData(x = "PAK", y = 50)
        ),

        listOf(
            ChartData(x = "App", y = 120),
            ChartData(x = "Ban", y = 50),
            ChartData(x = "Org", y = 80),
            ChartData(x = "Grp", y = 200),
            ChartData(x = "Pin", y = 300),
            ChartData(x = "Str", y = 400)
        ),

        listOf(
            ChartData(x = "Van", y = 25),
            ChartData(x = "Cho", y = 36),
            ChartData(x = "Str", y = 45),
            ChartData(x = "Min", y = 58),
            ChartData(x = "Cok", y = 69),
            ChartData(x = "But", y = 105),
            ChartData(x = "Roc", y = 11)
        ),

        listOf(
            ChartData(x = "A", y = 25),
            ChartData(x = "B", y = 50),
            ChartData(x = "C", y = 75),
            ChartData(x = "D", y = 100),
            ChartData(x = "E", y = 125),
            ChartData(x = "F", y = 150),
            ChartData(x = "G", y = 175)
        ),

        listOf(
            ChartData(x = "Jan", y = 30),
            ChartData(x = "Feb", y = 45),
            ChartData(x = "Mar", y = 60),
            ChartData(x = "Apr", y = 75),
            ChartData(x = "May", y = 90),
            ChartData(x = "Jun", y = 105),
            ChartData(x = "Jul", y = 120)
        ),

        listOf(
            ChartData(x = "Car", y = 250),
            ChartData(x = "Bik", y = 50),
            ChartData(x = "Bus", y = 750),
            ChartData(x = "Tra", y = 100),
            ChartData(x = "Pla", y = 125),
            ChartData(x = "Boa", y = 150),
            ChartData(x = "Sco", y = 175)
        ),

        listOf(
            ChartData(x = "Red", y = 10),
            ChartData(x = "Gre", y = 20),
            ChartData(x = "Blu", y = 30),
            ChartData(x = "Yel", y = 40),
            ChartData(x = "Pur", y = 50),
            ChartData(x = "Org", y = 60),
            ChartData(x = "Bla", y = 70)
        ),

        listOf(
            ChartData(x = "Dog", y = 71),
            ChartData(x = "Cat", y = 142),
            ChartData(x = "Bir", y = 213),
            ChartData(x = "Fsh", y = 100),
            ChartData(x = "Ham", y = 125),
            ChartData(x = "Rab", y = 150),
            ChartData(x = "Sna", y = 175)
        )
    )
}