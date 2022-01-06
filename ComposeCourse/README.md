# Compose Course

Jetpack Compose es el kit de herramientas moderno de Android para compilar IU nativas. Simplifica y acelera el desarrollo de la IU en Android.

To create a view as composable, we need to use the `@Composable` annotation. For example:

```
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

By this way, we can use UI on differents components that makes it very reusable.

## Rows, Columns and Basic Sizing

By default, the views are placed in a stack on top of each other. We can use the `Row` and `Column` to create a vertical or horizontal layout.

Each of them has a `modifier` parameter that allows us to change the size of the view. For example:
- Mofifier.fillMaxSize() will make the view fill the available space.
- Modifier.fillMaxWidth() will make the view fill the available width.
- Modifier.fillMaxHeight() will make the view fill the available height.

If we put arguments in the modifier, it will be applied to the view, for example: 
`Modifier.fillMaxWidth(0.7f)` will make the view fill 70% of the available width.

## Modifiers

Some of the modifiers are:
- Modifier.padding(all = 8.dp)
- `fillMaxHeight(0.5f)`
- `fillMaxWidth(1f)` Para abarcar todo el ancho de la pantalla
- `border()`
- `background(Color.Red)`

There are some widgets that we can use to create views:
- **Text()**
- **`Spacer(modifier = Modifier.height(50.dp))`**


# State on Android Jetpack Compose 

States allow us to change the UI based on the state of the application. For example, when clicking on a button, the UI can change the color of the button, or the text of the button.

Managing the state of the application is very important for the development of the application.

In Android, we can use the `mutableStateOf()` function to create a state. For example:

```
val color = remember {
    mutableStateOf(Color.Yellow)
}
```

The keyword `remember` is used to create a state that will be stored in the memory of the application.
Then, we can call the value from the state by using the `value` property. **`color.value`** will return the current value of the state.

## Textfields, Buttons and Showing snackbars

In Jetpack compose, it is a little bit different from XML to create a view. To use a view as TextField we need to use a **Scaffold** element as a parent.

With the **Scaffold** element, we can create a view that will be used as a parent for the TextField, and use all the design provided by Material Design for Android, as Snackbars, Buttons, TextFields, NavigationDrawer, etc.

To create a Scaffold, we need to use a scaffold state. For example:
**`val scaffoldState = rememberScaffoldState()`**

Then, we can use the `Scaffold()` function to create a Scaffold. For example:

```
val scaffoldState = rememberScaffoldState()

Scaffold(
    modifier = Modifier.fillMaxSize(),
    scaffoldState = scaffoldState
) {
    /**
     * Here we can use all the views provided by Material Design for Android.
     */
}
```

## Lists - Android Jetpack Compose

Jetpack Compose make more easy the way to create lists. While in XML, we need to create a list of items, and then we need to create a layout for each item, create the adapter and then link the views with the adapter, in Jetpack Compose, we can create the design of the list in a single function.

To create list, we can use the `Column()` component and make it scrollable. This component will create a vertical list, it is important to know that use this option when the list is short, otherwise it will be very slow.

```
Column(
    modifier = Modifier.verticalScroll(scrollState)
) {
    for (i in 1..50) {
        Text(
            text = "Item $i",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
    }
}
```

To create a list with many elements, we use the `LazyColumn()` component. This component has better performance when the list is long.

```
LazyColumn {
    itemsIndexed(
        listOf("This", "is", "Jetpack", "Compose", "Full", "Android", "Guide")
    ) { index, item ->
        Text(
            text = "$index $item",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
    }
}
```

Other option to create the list is using the `items(n){}` function to create a list with n elements.

This way we can create a list in Android using Jetpack Compose.