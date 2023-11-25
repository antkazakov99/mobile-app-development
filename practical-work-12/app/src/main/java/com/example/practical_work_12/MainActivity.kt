package com.example.practical_work_12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practical_work_12.ui.theme.Practicalwork12Theme
import controller.SortDirection
import model.entites.BroadcastType
import model.entites.Tariff


class MainActivity : ComponentActivity() {
    private val viewModel: TariffViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practicalwork12Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(viewModel)
                }
            }
        }
    }
}

@Composable
fun Navigation(viewModel: TariffViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "showTariffs") {
        composable("addTariff") {
            AddTariff(viewModel, navController)
        }
        composable("editTariff/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            }
        )) {
            EditTariff(
                viewModel = viewModel,
                navController = navController,
                tariffId = it.arguments!!.getInt("id")
            )
        }
        composable("showTariffs") {
            ShowTariffs(viewModel, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTariff(viewModel: TariffViewModel, navController: NavHostController) {
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var broadcastType by rememberSaveable {
        mutableStateOf(BroadcastType.BASIC)
    }
    var isPublic by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Column {
            Text(text = stringResource(R.string.tariff_name))
            TextField(value = name, onValueChange = { name = it }, Modifier.fillMaxWidth(0.9f))
            Text(text = stringResource(R.string.broadcast_type))
            Column(Modifier.selectableGroup()) {
                Row {
                    RadioButton(
                        selected = broadcastType == BroadcastType.BASIC,
                        onClick = { broadcastType = BroadcastType.BASIC },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.broadcast_type_common), fontSize = 22.sp)
                }
                Row {
                    RadioButton(
                        selected = broadcastType == BroadcastType.HD,
                        onClick = { broadcastType = BroadcastType.HD },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.broadcast_type_hd), fontSize = 22.sp)
                }
            }
            Text(text = stringResource(id = R.string.is_public_tariff))
            Column(Modifier.selectableGroup()) {
                Row {
                    RadioButton(
                        selected = isPublic,
                        onClick = { isPublic = true },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.is_public_true), fontSize = 22.sp)
                }
                Row {
                    RadioButton(
                        selected = !isPublic,
                        onClick = { isPublic = false },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.is_public_false), fontSize = 22.sp)
                }
            }
        }
        Button(onClick = {
            val tariff = Tariff(null, name, broadcastType, isPublic)
            viewModel.add(tariff)
            navController.navigate("showTariffs")
        }) {
            Text(text = stringResource(R.string.add_tariff))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTariff(viewModel: TariffViewModel, navController: NavHostController, tariffId: Int) {
    val tariffs = viewModel.flow.collectAsState()
    val tariff = tariffs.value.first { it.id == tariffId }

    var name by rememberSaveable {
        mutableStateOf(tariff.name)
    }
    var broadcastType by rememberSaveable {
        mutableStateOf(tariff.broadcastType)
    }
    var isPublic by rememberSaveable {
        mutableStateOf(tariff.isPublic)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Column {
            Text(text = stringResource(R.string.tariff_name))
            TextField(value = name, onValueChange = { name = it }, Modifier.fillMaxWidth(0.9f))
            Text(text = stringResource(R.string.broadcast_type))
            Column(Modifier.selectableGroup()) {
                Row {
                    RadioButton(
                        selected = broadcastType == BroadcastType.BASIC,
                        onClick = { broadcastType = BroadcastType.BASIC },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.broadcast_type_common), fontSize = 22.sp)
                }
                Row {
                    RadioButton(
                        selected = broadcastType == BroadcastType.HD,
                        onClick = { broadcastType = BroadcastType.HD },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.broadcast_type_hd), fontSize = 22.sp)
                }
            }
            Text(text = stringResource(R.string.is_public_tariff))
            Column(Modifier.selectableGroup()) {
                Row {
                    RadioButton(
                        selected = isPublic,
                        onClick = { isPublic = true },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.is_public_true), fontSize = 22.sp)
                }
                Row {
                    RadioButton(
                        selected = !isPublic,
                        onClick = { isPublic = false },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(stringResource(R.string.is_public_false), fontSize = 22.sp)
                }
            }
        }
        Button(onClick = {
            tariff.name = name
            tariff.broadcastType = broadcastType
            tariff.isPublic = isPublic
            viewModel.edit(tariff)
            navController.navigate("showTariffs")
        }) {
            Text(text = stringResource(R.string.save_tariff))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTariffs(viewModel: TariffViewModel, navController: NavHostController) {
    var filter by rememberSaveable {
        mutableStateOf("")
    }

    var sortBy by rememberSaveable {
        mutableStateOf(SortDirection.DISABLED)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            TextField(
                value = filter,
                onValueChange = { filter = it },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            IconButton(onClick = {
                sortBy = when (sortBy) {
                    SortDirection.DISABLED -> SortDirection.ASC
                    SortDirection.ASC -> SortDirection.DESC
                    SortDirection.DESC -> SortDirection.DISABLED
                }
            }) {
                Icon(when (sortBy) {
                    SortDirection.DISABLED -> Icons.Default.List
                    SortDirection.ASC -> Icons.Default.KeyboardArrowUp
                    SortDirection.DESC -> Icons.Default.KeyboardArrowDown
                }, stringResource(R.string.sorting))
            }
        }

        Button(onClick = { navController.navigate("addTariff") }) {
            Text(text = stringResource(R.string.add_tariff))
        }

        val tariffState = viewModel.flow.collectAsState()
        var tariffs = tariffState.value.filter {
            filter.isEmpty() || it.name.lowercase().contains(filter.lowercase())
        }
        if (sortBy == SortDirection.ASC) {
            tariffs = tariffs.sortedBy { it.name }
        } else if (sortBy == SortDirection.DESC) {
            tariffs = tariffs.sortedByDescending { it.name }
        }
        LazyColumn(Modifier.fillMaxWidth(0.9f)) {
            items(tariffs, key = { it.id!! }) {
                Row {
                    Column(
                        Modifier
                            .fillMaxWidth(0.7f)
                    ) {
                        Text(text = "${stringResource(R.string.tariff_name)}: ${it.name}")
                        Text(
                            text = "${stringResource(R.string.broadcast_type)}: ${
                                if (it.broadcastType == BroadcastType.BASIC) {
                                    stringResource(R.string.broadcast_type_common)
                                } else (
                                        R.string.broadcast_type_hd
                                        )
                            }"
                        )
                        Text(
                            text = "${stringResource(R.string.is_public_tariff)}: ${
                                if (it.isPublic) {
                                    stringResource(R.string.is_public_true)
                                } else {
                                    stringResource(R.string.is_public_false)
                                }
                            }"
                        )
                    }
                    // / Тип вещания: ${it.broadcastType} / Публичный ${it.isPublic}
                    IconButton(onClick = { navController.navigate("editTariff/${it.id!!}") }) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = stringResource(R.string.edit_tariff)
                        )
                    }
                    IconButton(onClick = { viewModel.delete(it.id!!) }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = stringResource(R.string.delete_tariff)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
