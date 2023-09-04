package com.curso.android.app.practica.proyectofinal

import android.view.KeyEvent.DispatcherState
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.proyectofinal.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.result.value?.Text
        assertEquals("",value)
    }

    @Test
    fun mainViewModel_CheckIdemValue() =runTest {
        launch{
            viewModel.compareStrings("123","123")
        }
        advanceUntilIdle()
        val value = viewModel.result.value?.Text
        assertEquals("Las cadenas son iguales",value)
    }

    @Test
    fun mainViewModel_CheckDistinctValue() =runTest {
        launch{
            viewModel.compareStrings("123Test","Test123")
        }
        advanceUntilIdle()
        val value = viewModel.result.value?.Text
        assertEquals("Las cadenas son distintas",value)
    }
}