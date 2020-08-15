package com.androiddevs.newsflash.ui.viewModel

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class HomeFragmentViewModelTest {

    private val homeFragmentViewModel by lazy { HomeFragmentViewModel() }

    @Before
    fun setUp() {

    }

    @Test
    fun `when page is created,default state should be loading`() {
        assertEquals(HomeScreenStates.Loading, homeFragmentViewModel.subscribeToUIState().value)
    }

    @Test
    fun `when page is created, then the top news headlines must be retrieved`() {

    }
}