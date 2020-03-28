package com.example.practicalwork10

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger

class MainActivity : AppCompatActivity() {

    var thread1 = Thread ()

    var isStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fibonacci(i: BigInteger): BigInteger {
        if (i < 1.toBigInteger()) return 0.toBigInteger()
        else if (i == 1.toBigInteger()) return 1.toBigInteger()
        else return fibonacci(i - 1.toBigInteger()) + fibonacci(i - 2.toBigInteger())
    }

    fun onClick(view: View) {
        if (inputNumber.text.toString() != "")
        {
            if (thread1.isAlive && !thread1.isInterrupted)
            {
                thread1.interrupt()
                button.text = "Start"
                result.text = "Thread was interrupted"
            }
            else
            {
                thread1 = Thread ( Runnable {
                    run {
                        result.post( Runnable {
                            run {
                                result.text = "Please wait"
                                button.text = "Stop"
                            }
                        })
                        val res = fibonacci(fibonacci(fibonacci(inputNumber.text.toString().toBigInteger()))).toString()
                        result.post( Runnable {
                            run {
                                result.text = res
                                button.text = "Start"
                            }
                        })
                    }
                })
                thread1.start()
                isStarted = true
            }
        }
    }
}
