# Jetpack Compose :fire:

> Menos código que va a ser más sencillo y fácil de entender. Se integra muy bien con el universo de jetpack.
> Vistas declarativas

Build better apps faster with Jetpack Compose
[Jetpack Compose](https://developer.android.com/jetpack/compose) is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.

- Cada función, será un componente
- Se tiene vistas previas
- Se integra muy bien con el universo de Jetpack


Se requiere la versión Artic Fox o superior para usar Compose.
1. Se cea una Empty Compose Activity para que el wizard cree todo lo necesario para usar Jetpack Compose
2. Jetpack Compose requiere de la API 21 o superior en Android.

- El contenido se define en la función **`setContent`**
- Cada componente se debe crear con el anotador **`@Composable`**


## Modificadores

Los modificadores son como atributos extras que pueden recibir nuestras funciones, para definir en la vista.
Como paddings, la longitud, elevación, etc.

Algunos de los modificadores son:
- `fillMaxSize()`
- `background(Color.Blue)`
- `fillMaxWidth()`
- `fillMaxHeight()`


## Columnas `Column(){}`

Por defecto, las vistas se colocan una sobre otra. Por eso es necesario tener contenedores que nos permitan organizar la vistas en el layout que estemos definiendo. A través de:
- Filas
- Columnas
- Cajas

Los modificadores, siguen el orden de definición.
Lo primero que se define, es lo primero que se aplica.
Por ejemplo, si hacemos un elemento clickable antes, y luego definimos un padding, ese padding no será clickable.


Los `LazyColumn` funcionan como un RecyclerView, a medida que hacemos scroll se cargan los nuevos componentes.
Un LazyColumn, sólo puede contener **items**.

```js
LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)
) {
    item {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Logo de la company",
            Modifier.fillMaxWidth()
        )
        Text(
            text = "jocode",
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(text = "Camilo", color = Color.White)
        Text(text = "Mosquera", color = Color.White)
    }
}
```


## Filas `Rows(){}`

Las filas nos permiten dibujar las vistas de forma horizontal, una tras otra.

Al Igual que column, se tiene el  **`LazyRow`** que nos permite agregar scroll horizontal a los elementos.

```js
LazyRow(
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxWidth().padding(16.dp)
) {
    item {
        Text(text = "Kotlin", color = Color.White)
        Text(text = "Java", color = Color.White)
        Text(text = "JS", color = Color.White)
        Text(text = "PHP", color = Color.White)
        Text(text = "Python", color = Color.White)
        Text(text = "C++", color = Color.White)
    }
}
```

## Estados (STATES)

Las vistas se recrean, es decir cuando se modifica el valor, la vista de destruye y se recrea nuevamente.
Los estados, serán los valores que se pondrán en nuestra vista que se mantendrán independientemente si se recrea la vista.

Para almacenar estados en compose, podemos usar la palabra reservada **`remember`** para retener la informacion se las variables en compose y  pasarla por parámetro.

Sin embargo, como al rotarse la pantalla se elimima toda la información, para recrearse nuevamente, podremos usar la función **rememberSaveable** para retener la información cuando se gira la pantalla.

```js
var counter by rememberSaveable { mutableStateOf(0) }
```

## Scaffold (TOOLBAR y FAB) 

Este componente nos va a permitir simplificar mucho lo que tiene que ver con activity o fragment.
Es como un molde donde podremos ir colocando los componentes.