package qr.a.rooshen.hwkotlinlesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.StringBuilder
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "hwkotlinlesson3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personList = mutableListOf<Person>()

        for (i in 1..15) {
            val randomName = ListOfNames.values().random().name
            personList.also { Log.d("LOG_TAG", "Заполняю список ") }.apply {add(Person(randomName,generateRandomNumber(i)))}
        }
        personList.also { Log.d("LOG_TAG", "Сортировка ") }.sortBy { it.age }

        personList.forEach{
            Log.d("LOG_TAG", "$it")
        }

        personList.filter { it.age in 10..20 }.forEach{
            Log.d("LOG_TAG", "$it")
        }

        val searchValue = personList.find { it.age == personList.first().age}
        if(searchValue !== null){
            Log.d("LOG_TAG", "Объект найден = $searchValue")
        }else {
            Log.d("LOG_TAG", "Объект с таким значением не найден!")
        }


    }

    private fun generateRandomNumber(Range: Int): Int {
        return Range + (Math.random() * Range).toInt()
    }
}


