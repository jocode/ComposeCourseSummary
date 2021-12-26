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