package com.mrjalal.composeinterviewsample

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen() {
    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            EditNameBottomSheet()
        }
    ) {
        val keyboard = LocalSoftwareKeyboardController.current
        LaunchedEffect(Unit) {
            snapshotFlow { bottomSheetState.currentValue }.collect {
                if (it == ModalBottomSheetValue.Hidden) {
                    keyboard?.hide()
                }
            }
        }

        Scaffold {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .imePadding()
            ) {
                // TODO: Q1: just use item (not items) to show list of countries?
                // implement Q1 here

                // TODO: Q2: how to make list more efficient in this state?
//                items(
//                    StateHolder.listInfo.size
//                ) { index ->
//                    Row(
//                        modifier = Modifier
//                            .fillParentMaxWidth()
//                            .requiredHeight(56.dp),
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = StateHolder.listInfo[index]
//                        )
//                    }
//                }

                // TODO: Q3: make editing country-names happen
//                items(
//                    StateHolder.listInfo.size
//                ) { index ->
//                    Row(
//                        modifier = Modifier
//                            .fillParentMaxWidth()
//                            .requiredHeight(56.dp)
//                            .clickable {
//                                scope.launch {
//                                    bottomSheetState.show()
//                                }
//                            },
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = StateHolder.listInfo[index],
//                        )
//                    }
//                }
            }
        }
    }
}
