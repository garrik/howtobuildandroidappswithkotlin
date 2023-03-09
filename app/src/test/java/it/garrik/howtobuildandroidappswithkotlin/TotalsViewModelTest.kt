package it.garrik.howtobuildandroidappswithkotlin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TotalsViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
    private lateinit var totalsViewModel: TotalsViewModel
    
    @Before
    fun setUp() {
        totalsViewModel = TotalsViewModel()
        assertEquals(0, totalsViewModel.getTotal().value)
    }
    @Test
    fun increaseTotal() {
        val total = 5
        for (i in 0 until total) {
            totalsViewModel.increaseTotal()
        }
        assertEquals(5, totalsViewModel.getTotal().value)
    }
}