package de.moco.gelin.view.screen.grocerylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import de.moco.gelin.R
import de.moco.gelin.model.groceryEntryService
import de.moco.gelin.model.groceryentry.GroceryEntry
import de.moco.gelin.model.product.ProductCategory
import de.moco.gelin.view.gelincomposable.*
import de.moco.gelin.view.gelincomposable.dataclass.EINKAUFSLISTE
import de.moco.gelin.view.gelincomposable.dataclass.PRODUKTHINZUFUEGEN

// TODO: use grocery entry view model
@Composable
fun GroceryListView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SpacerVerticalXS()
        BudgetView()
        Row(modifier = Modifier.padding(vertical = 10.dp)) {// add groceries
            AddGroceryEntryButton(navController)
        }
        Ueberschrift1(name = stringResource(id = R.string.einkaufsliste))
        CategoryCard(ProductCategory.PRODUCE, stringResource(R.string.produce), R.color.lightgreen)
        CategoryCard(ProductCategory.DAIRY, stringResource(R.string.dairy), R.color.lightyellow)
        CategoryCard(ProductCategory.MEAT, stringResource(R.string.meat), R.color.pastellred)
        CategoryCard(ProductCategory.GRAINS, stringResource(R.string.grains), R.color.pastellred)
        CategoryCard(ProductCategory.BEVERAGE, stringResource(R.string.beverage), R.color.pastellred)
        CategoryCard(ProductCategory.OTHER, stringResource(R.string.other), R.color.pastellred)
    }
}

@Composable
fun BudgetView() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Ueberschrift2(name = stringResource(id = R.string.budget))
        SpacerHorizontalXL()
        Ueberschrift2(name = "[XX,00] €")
        Spacer(Modifier.weight(1f))
        EditBudgetIcon()
    }
}
// TODO: read categoryTitle from category automatically
@Composable
fun CategoryCard(category: ProductCategory, categoryTitle: String, categoryColorId: Int) {
    Card(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .padding(vertical = 6.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(id = categoryColorId))
                .padding(5.dp)

        ) {
            Box(modifier = Modifier.padding(horizontal = 5.dp)) {
                Ueberschrift3(categoryTitle)
            }
            //TODO: show list
            val groceriesInCategory = remember { mutableStateOf(listOf<GroceryEntry>()) }
            groceryEntryService.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (child in dataSnapshot.children) {
                        val groceryEntry = child.getValue(GroceryEntry::class.java)
                        if (groceryEntry is GroceryEntry
                            && groceryEntry !in groceriesInCategory.value
                            && groceryEntry.product.category == category) {
                            groceriesInCategory.value += groceryEntry
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    throw IllegalStateException("Failed with error: ${databaseError.code}")
                }
            })

            for (groceryEntry in groceriesInCategory.value) {
                GroceryEntryItem(groceryEntry, categoryColorId)
            }
        }
    }
}

@Composable
fun EditBudgetIcon(){
    Button(
        colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = R.color.white),
            ),
        onClick = {}) {
        Image(
            painterResource(id = R.drawable.ic_pencil_48),
            contentDescription ="Budget bearbeiten",
            modifier = Modifier
                .size(25.dp, 25.dp)
        )
    }
}
@Composable
fun AddGroceryEntryButton(navController: NavHostController) {
    Button(
        modifier = Modifier
            .fillMaxWidth(1f),
        colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = R.color.darkgreen),
                contentColor =  colorResource(id = R.color.white)
            ),
        onClick = {
            navController.navigate(PRODUKTHINZUFUEGEN) {
                popUpTo(EINKAUFSLISTE){ inclusive = true }
            }
        }){
        Fliesstext(name = stringResource(id = R.string.lebensmittelHinzufuegen))
        SpacerHorizontalXS()
        Image(
            painterResource(id = R.drawable.ic_search_white),
            contentDescription = stringResource(id = R.string.budgetAendern),
            modifier = Modifier
                .size(30.dp, 30.dp))
    }
}
