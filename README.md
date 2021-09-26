# Entrega de prácticas - Modelos Avanzados de Computación 2020/21
### Daniel Pérez Rodríguez
_En esta práctica veremos como traducir los ejercicios hechos durante el curso en el lenguaje Haskell, a Scala. El enunciado de la práctica es el sigueinte:_

## Enunciado - Traducir los ejercicios vistos en clase a Scala
Scala es un lenguaje de programación multi paradigma que incluye muchas de las características vistas en este curso de programación funcional básica. Una de los usos principales de Scala en la programación para Apache Spark (https://spark.apache.org/docs/0.9.1/scala-programming-guide.html), un sistema de computación en cluster que permite la gestión de grandes volúmenes de datos (https://es.wikipedia.org/wiki/Apache_Spark).

Los ejercicios a traducir se encuentran en el repositorio siguiente: [mac2021](https://github.com/jcarpio/mac2021)

En la ruta del repositorio, el archivo _aplicacion.scala_ contiene todos los ejercicios que comentaremos a continuación(el título de cada función será el nombre del fichero empleado en los ejercicios originales). Además, si se ejecuta dicho código se verá en ejecución todas las funciones implementadas

## Funciones
### Aprox_pi_manuel_jesus.hs
En este ejercicio buscamos la aproximación de pi más cercana al valor pasado por parámetro t
```scala
def valorPi(t :Double): Double = {
    val lista = (-1 + t / 2 to 1 - t / 2 by t).toList
    var n = 0.0
    for(i <- lista){
        for(j <- lista){
            if(Math.sqrt((i*i + j*j).bigDecimal.doubleValue()) <= 1)
                n += t*t
        }
    }
    n
}
```

### Divisible.hs
Comprobamos si el valor _a_ es divisible entre _b_
```scala
def divisible(a :Int, b :Int): Boolean = {
    if(a%b == 0){
        true
    }else{
        false
    }

}
```
### Divisores_ricardo.hs
Devuelve todos los divisores del valor pasado por parámetro _n_
```scala
def divisores(n :Int): List[Int] = {
    for(i <- List.range(1,n+1) if n%i == 0)
       yield i

}
```


### Euler1.hs
Devolvemos la suma de una lista de números, los cuales sean divisores de 3 o 5
```scala
def euler1(l :List[Int]): Int = {
    sumaLista(euler1Sel(l))
}

def euler1Sel(l :List[Int]): List[Int] = {
    for(i <- l if ((i%3 == 0) || (i%5 == 0))) yield i
}

```
### Euler2.hs y eurler2_ricardo.hs
Calculamos la sucesión de Fibonacci para el valor _n_
```scala
def fibonacci(n :Int): Int = {
    if(n > 2)
        fibonacci(n-1) + fibonacci(n-2)
    else if(n == 2)
        2
    else if(n == 1)
        1
    else if(n == 0)
        0
    else 
        -1
}
```
### Euler3.hs
Calcula los números primos existentes entre el valor 1 y _n_
```scala
def listaPrimos(n :Int): List[Int] = {
    for(i <- List.range(1,n+1) if primo(i))
        yield i
}
```
### Euler3_ricardo.hs
Comprueba si un número es primo
```scala
def primo(n :Int): Boolean = {
    if(divisores(n).size == 2)
        true
    else 
        false
}
```
### Euler4.hs
Este fichero esta compuesto de varias funciones. La función _maximo_ que devuelve el valor más grande de una lista de enteros. La función _palindromo_ que comprueba si una cadena es palíndroma y por último, _listaPalindromos_ que devuelve todas las palabras de una lista que sean palíndromas
```scala
def maximo(l :List[Int]): Any = {
    if(l.size>0)
        l.max
} 

def palindromo(s :String): Boolean = {
    if(s == s.reverse)
        true
    else
        false
}

def listaPalindromos(l :List[String]): List[String] = {
    for(i <- l if palindromo(i))
        yield i
}
```
### Factorial.hs y factorialAliasPatron.hs
Calcula el factorial de un número _n_
```scala
def factorial(n :Int): Int = {
    if(n > 0)
        n*factorial(n-1)
    else 
        1

}
```
### FirstElement.hs
Devuelve el primer elemento de una lista
```scala
def fistElement(l :List[Int]): Any = {
    if(l.nonEmpty)
        l.head
    else
        null
}
```
### FuncionLet.hs
Devuelve todos los elementos de una lista exceptuando los 2 primeros
```scala
def funcionLet(l :List[Any]): Any = {
    if(l.size >= 3)
        l.drop(2)
    else
        null
}
```
### FuncionLet2.hs
Devuelve el segundo elemento de una lista
```scala
def funcionLet2(l :List[Any]): Any = {
    if(l.size == 3)
        l(2)
    else
        null
}
```

### FuncionLista.hs
Devuelve los elementos de una lista en forma de cadena. En función del número de elementos que tenga la lista
```scala
def funcionLista(l :List[Any]): Any = {
    if(l.size > -1 && l.size < 4){
        l.size match{
            case 1 => l(0) 
            case 2 => l(0) + " and " + l(1) 
            case 3 => l(0) + " and " + l(1) + " and " + l(2)
            case _ => "(none)" 
        }
    }else{
        l(0) + " and " + l(1) + " and " + (l.size - 2) + " more"
    }
}
```
### FuncionTupla.hs
En este ejercicio hacemos uso de las funciones pasadas por parámetros. Para el ejercicio en cuestión, cada una de las funciones calculará un valor respecto de _n_. Después, dicha suma será el valor de retorno de la función
```scala
def funcionTupla(funcionA :Int => Int, funcionB :Int => Int, n :Int): Int = {
    funcionA(n) + funcionB(n)
}
```
### FuncionTuplaBool.hs
Al igual que en el ejercicios anterior, ahora tenemos dos funciones pasadas por parámetro. En esta ocasión, cada una recibira un objeto de tipo _Any_ (que en este caso será _a_) y devolverá un boolean. Si una de las dos funciones devuelve _true_ la función devolvera dicho valor, en caso contrario devolverá _false_
```scala
def funcionTupla(funcionA :Any => Boolean, funcionB :Any => Boolean, a :Any): Boolean = {
    (funcionA(a) || funcionB(a))
}
```
### Funcion_hash_ricadro.hs
Para este ejercicio será necesario realizar dos funciones:
* funcionHash - Devuelve la suma de valores producto de multiplicar cada valor de la lista _l_ correspondiente con su posición en la lista de primos
* calculaPrimos - Calcula los números primos existentes entre 0 y _n_
```scala
def funcionHash(l :List[Int]): Int = {
    if(l.size > 0){
        var sum = 0
        val listaPrimos = calculaPrimos(l.size)
        val numberRange = List.range(0, l.size - 1)
        for( i <- numberRange ){
            sum += l(i) * listaPrimos(i)
        }
        sum
    }else
        -1
}

def calculaPrimos(n :Int): List[Int] = {
    var i = 0
    var lista : List[Int] = List()
    while(i < n){
        if(primo(i))
            lista ::= i
    
        i = i+1    
    }
    lista
}
```
### Integral.hs y integral_manuel_jesus.hs
Con estas funcion podremos calcular el valor de una integral
```scala
def integral(funcion :Double => Double, a :Double, b :Double, t :Double): Double = {
    if(b <= a)
        0 
    else if(b < (a+t))
        funcion(a) + (b-a)
    else
        funcion(a) * t + integral(funcion, (a+t), b, t)
}
```
### Lambda.hs
En esta función haremos uso de los valores implicitos. De esta forma, el complidor de scala se encargará de buscar el valor que falte de la suma que calculamos en la función
```scala
def funcionLambda[A](a :A, b :A)(implicit r: Numeric[A]): A = {
    import r._
    a+b
}
```
### Mapea_y_filtra_ricardo_diaz.hs y solucion_pregunta_map.hs
Para este ejercicio será necesario realizar dos funciones:
 * mapea - Ejecuta una función sobre cada valor de una lista y devuelve otra lista con dichos resultados
 * filtra - Ejecuta una función sobre cada valor de una lista y devuelve otra lista con los valores que cumplan la condición de dicha función
```scala
def mapea(funcion :Int => Int, l :List[Int]): List[Int] = {
    if(l.size > 0) {
        funcion(l(0)) :: mapea(funcion, l.drop(1))
    }else
        List()
}

def filtra(funcion :Int => Boolean, l :List[Int]): List[Int] = {
    if(l.size > 0){
        if(funcion(l(0)))
            l(0) :: filtra(funcion, l.drop(1))
        else
            filtra(funcion, l.drop(1))
    
    }else
        List()
}
```
### MiFuncion.hs, miFuncion2.hs y miFuncion2Nicolas.hs
Esta función recibirá dos listas de numeros. En la primera tendremos una lista de números, cada valor de esta lista será sumado a cada uno de los elementos de la segunda. Finalmente, devolveremos todas las listas generadas. Para hacerlo de una forma sencilla usaremos la función _map_ de la clase _List_, que nos permite crear una nueva lista en función de una ya existente especificandole cambios
```scala
def miFuncion(sumL :List[Int], numL :List[Int]): List[List[Int]] = {
    if(sumL.size == numL.size){
        for(i <- sumL)
            yield numL.map { j => j + i}
    }else
        List(List())
}
```
### MiXor.hs
Implementa una puerta Xor en scala
```scala
def miXor(a :Boolean, b :Boolean): Boolean = {
    if(a == b)
        false
    else 
        true
}
```
### Predecesor.hs
Devuelve el número anterior al valor _n_ pasado por parámetro
```scala
def predecesor(n :Int): Int = {
    n - 1
}
```
### Prog1.hs 
Devuelve true si el numero es positivo y false en caso contrario
```scala
def noNegativo(n :Int): Boolean = {
    if(n >= 0)
        true
    else
        false
}
```
### ProgramaTuplas.hs
Devuelve todas las listas que contienen el objeto _a_
```scala
def programaTuplas(l :List[List[Any]], a :Any): List[Any] = {
    for(i <- l if l.contains(a))
        yield i
}
```
### QuitaBlanco.hs y quitaBlanco2.hs
Elimina todos los espacios presentes en una variable de tipo String
```scala
def quitaBlanco(s :String ): String = {
    for(i <- s if i != ' ')
        yield i
}
```
### SecondElem.hs
Devuelve el segundo elemento de una lista
```scala
def secondElem(l :List[Any]): Any = {
    if(l.size > 1)
        l.apply(1)
    else
        null
}
```

### SoloPrimero.hs
La función devuelve el primer elemento de una lista
```scala
def soloPrimero(l :List[Any]): Any = {
    l.head
}
```

### Suma.hs
Realiza y devuelve la suma de dos números pasados por parámetro
```scala
def suma(a :Int, b :Int): Int = {
    a+b
}
```

### Suma3.hs
Realiza y devuelve la suma de tres números pasados por parámetro
```scala
def suma3(a :Int, b :Int, c :Int): Int = {
     a+b+c
}
```

### Suma_lista.hs
Suma todo los elementos de una lista de números
```scala
def sumaLista(l :List[Int]): Int = {
    l.sum
}
```
### Traduce.hs
Convierte un número en un carácter. Para ello usaremos la función match, que es el equivalente a la función switch en otros lenguajes de programación
```scala
def traduce(n :Int): String = {
    n match {
        case 1 => "A"
        case 2 => "B"
        case 3 => "C"
        case _ => "X"
    }
}
```
## Ejecutamos la función main con todas las funciones
```scala
def main(args :Array[String]):Unit = {
/*aprox_pi_manuel_jesus.hs*/
println("VALOR PI----------------")
println("Aproximamos el número pi al 0.001:" + valorPi(0.001))
println()

/*divisible.hs*/
println("DIVISIBLE----------------")
println("Es divisible 4 entre 2?: " + divisible(4,2))
println("Es divisible 6 entre 4?: " + divisible(6,4))
println()

/*divisores_ricardo.hs*/
println("DIVISORES---------------")
println("Divisores de 10: " + divisores(10))
println("Divisores de 15: " + divisores(15))
println("Divisores de 20: " + divisores(20))
println()

/*euler1.hs*/
println("EULER1----------------")
println("Suma de todos los numeros que son divisibles entre 3 o 5 hasta el numero "+
"999: " + euler1(List.range(0,999)))
println()


/*euler2.hs y euler2_ricardo.hs*/
println("FIBONACCI----------------")
println("Sucesión para el número 2: " + fibonacci(2))
println("Sucesión para el número 4: " + fibonacci(4))
println("Sucesión para el número 8: " + fibonacci(8))
println()

/*euler3.hs*/
println("LISTAPRIMOS----------------")
println("Lista de numeros primos entre 0 y 15: " + listaPrimos(15))
println("Lista de numeros primos entre 0 y 300: " + listaPrimos(300))
println()

/*euler3_ricardo.hs*/
println("PRIMO----------------")
println("El numero 10 es primo?: " + primo(10))
println("El numero 13 es primo?: " + primo(13))
println()

/*euler4.hs*/
val numeros = List(2,8,15,16,23,42)
println("NUMERO MAXIMO---------")
println("El numero mas grande de " + numeros + " es: " + maximo(numeros))
val listaPalabras = List("ana","coche","oso","radar","ejemplo","salas")
println("LISTA PALINDROMOS")
println("Devolver de " + listaPalabras + " aquellas que son palindromas: " + listaPalindromos(listaPalabras))
println()

/*factorial.hs y factorialAliasPatron.hs*/
println("FACTORIAL----------------")
println("Factorial de 4: " + factorial(4))
println("Factorial de 10: " + factorial(10))
println()

/*firstElement.hs*/
println("FIRST ELEMENT----------------")
println("El primer elemento de la lista: " + numeros + " es: " + fistElement(numeros))
println()

/*funcionLet.hs*/
println("FUNCION LET----------------")
println("Devolvemos una lista sin los 2 primeros valores de la misma. Lista: "+numeros+" -> "+ funcionLet(numeros))
println()

/*funcionLet2.hs*/
println("FUNCION LET2----------------")
println("Devolvemos el segundo elemento de la lista: "+numeros+" -> "+ funcionLet2(numeros))
println()

/*funcionLista.hs*/
println("FUNCION LISTA----------------")
println("Convertimos la lista: "+numeros+" en texto -> "+ funcionLista(numeros))
println()

/*funcionTupla*/
println("FUNCION TUPLA----------------")
println("Usamos 2 funciones para obtener un nuevo numero. Usamos la funcion factorial y la funcion predecesor: " + funcionTupla(factorial(_),predecesor(_),5))
println()

/*funcionTuplaBool.hs*/
println("FUNCION TUPLA BOOL----------------")
println("Usamos 2 funciones para obtener un boolean. Usamos la funcion primo y la funcion noNegativo: " + funcionTuplaBool(primo(_),noNegativo(_),5))
println()

/*funcion_hash_ricardo.hs*/
println("FUNCION HASH----------------")   
println("A partir de la lista "+numeros+" obtenemos el valor: " + funcionHash(numeros))
println()

/*integral.hs y integral_manuel_jesus.hs*/
def f(n :Double) : Double = { n*n }
println("INTEGRAL----------------")   
println("Calculamos la integral: " + integral(f,0,5,0.5))

/*mapea_y_filtra_ricardo_diaz.hs y solucion_pregunta_map.hs*/
println("MAPEA--------------")
println("Mapeamos la lista " + numeros + " con la funcion predecesor:" + mapea(predecesor(_),numeros))
println()
println("FILTRA--------------")
println("Filtramos la lista " + numeros + " con la funcion primo:" + filtra(primo(_),numeros))
println()

/*miFuncion.hs, muFuncion2.hs y miFuncion2Nicolas.hs*/
val s = List(1,3,5)
val l = List(5,6,8)
println("MI FUNCION----------------")
println("A partir de la lista -> " + s + " y la lista -> " + l + " obtenemos las listas -> " + miFuncion(s,l))
println()

/*miXor.hs*/
println("MIXOR----------------")
println("Para la entrada (true, true) devuelve: " + miXor(true,true))
println("Para la entrada (true, false) devuelve: " + miXor(true,false))
println()

/*predecesor.hs*/
println("PREDECESOR-----------")
println("El predecesor del numero 50 es el número: " + predecesor(50))
println("El predecesor del numero 10 es el número: " + predecesor(10))
println()

/*prog1.hs*/
println("NO NEGATIVO-------------")
println("El numero 4 en positivo?: " + noNegativo(4))
println("El numero -2 es postivo?: " + noNegativo(-2))
println()

/*programaTuplas.hs*/
println("PROGRAMA TUPLAS--------------")
println("Devolvemos las listas que tengan el valor 8 -> " + programaTuplas(List(s,l,numeros),8))
println()

/*quitaBlanco.hs y quitaBlanco2.hs*/
val frase = "Quito las pelotas blancas de la caja"
println("QUITA BLANCO------------")
print("La candena 'Quito las pelotas blancas de la caja' debe aparecer: ")
println(quitaBlanco(frase))
println()

/*secondElem.hs*/
val caracteres = List("A","B","C","E","D","F","G")
val oneElementList = List(1)
println("SECOND ELEM-------------")
println("El segundo elemento de la lista " + numeros + " es: " + secondElem(numeros))
println("El segundo elemento de la lista " + caracteres + " es: " + secondElem(caracteres))
println("El segundo elemento de la lista " + oneElementList + " es: " + secondElem(oneElementList))
println()

/*soloPrimero.hs*/
println("SOLO PRIMERO-------------")
println("El primer elemento de la lista " + numeros + " es: " + soloPrimero(numeros))
println("El primer elemento de la lista " + caracteres + " es: " + soloPrimero(caracteres))
println()

/*suma.hs*/
println("SUMA-----------")
println("La suma 4+5 es igual a " + suma(4,5))
println("La suma 10+3 es igual a " + suma(10,3))
println()

/*suma3.hs*/
println("SUMA3-----------")
println("La suma 4+5+6 es igual a " + suma3(4,5,6))
println("La suma 10+3+9 es igual a " + suma3(10,3,9))
println()

/*suma_lista.hs*/
println("SUMA LISTA----------------")
println("La suma total de la lista " + numeros + " es: " + sumaLista(numeros))
println()

/*traduce.hs*/
println("TRADUCE----------------")
println("El valor 1 se traduce en: " + traduce(1))
println("El valor 3 se traduce en: " + traduce(3))
println("El valor 5 se traduce en: " + traduce(5))
println()
}
```
## Resultados de la ejecución
```
VALOR PI----------------
Aproximamos el número pi al 0.001:3.1416760000852326

DIVISIBLE----------------
Es divisible 4 entre 2?: true
Es divisible 6 entre 4?: false

DIVISORES---------------
Divisores de 10: List(1, 2, 5, 10)
Divisores de 15: List(1, 3, 5, 15)
Divisores de 20: List(1, 2, 4, 5, 10, 20)

EULER1----------------
Suma de todos los numeros que son divisibles entre 3 o 5 hasta el numero 999: 232169

FIBONACCI----------------
Sucesión para el número 2: 2
Sucesión para el número 4: 5
Sucesión para el número 8: 34

LISTAPRIMOS----------------
Lista de numeros primos entre 0 y 15: List(2, 3, 5, 7, 11, 13)
Lista de numeros primos entre 0 y 300: List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293)

PRIMO----------------
El numero 10 es primo?: false
El numero 13 es primo?: true

NUMERO MAXIMO---------
El numero mas grande de List(2, 8, 15, 16, 23, 42) es: 42
LISTA PALINDROMOS
Devolver de List(ana, coche, oso, radar, ejemplo, salas) aquellas que son palindromas: List(ana, oso, radar, salas)

FACTORIAL----------------
Factorial de 4: 24
Factorial de 10: 3628800

FIRST ELEMENT----------------
El primer elemento de la lista: List(2, 8, 15, 16, 23, 42) es: 2

FUNCION LET----------------
Devolvemos una lista sin los 2 primeros valores de la misma. Lista: List(2, 8, 15, 16, 23, 42) -> List(15, 16, 23, 42)

FUNCION LET2----------------
Devolvemos el segundo elemento de la lista: List(2, 8, 15, 16, 23, 42) -> null

FUNCION LISTA----------------
Convertimos la lista: List(2, 8, 15, 16, 23, 42) en texto -> 2 and 8 and 4 more

FUNCION TUPLA----------------
Usamos 2 funciones para obtener un nuevo numero. Usamos la funcion factorial y la funcion predecesor: 124

FUNCION TUPLA BOOL----------------
Usamos 2 funciones para obtener un boolean. Usamos la funcion primo y la funcion noNegativo: true

FUNCION HASH----------------
A partir de la lista List(2, 8, 15, 16, 23, 42) obtenemos el valor: 64

INTEGRAL----------------
Calculamos la integral: 35.625

MAPEA--------------
Mapeamos la lista List(2, 8, 15, 16, 23, 42) con la funcion predecesor:List(1, 7, 14, 15, 22, 41)

FILTRA--------------
Filtramos la lista List(2, 8, 15, 16, 23, 42) con la funcion primo:List(2, 23)

MI FUNCION----------------
A partir de la lista -> List(1, 3, 5) y la lista -> List(5, 6, 8) obtenemos las listas -> List(List(6, 7, 9), List(8, 9, 11), List(10, 11, 13))

MIXOR----------------
Para la entrada (true, true) devuelve: false
Para la entrada (true, false) devuelve: true

PREDECESOR-----------
El predecesor del numero 50 es el número: 49
El predecesor del numero 10 es el número: 9

NO NEGATIVO-------------
El numero 4 en positivo?: true
El numero -2 es postivo?: false
PROGRAMA TUPLAS--------------
Devolvemos las listas que tengan el valor 8 -> List()
QUITA BLANCO------------
La candena 'Quito las pelotas blancas de la caja' debe aparecer: Quitolaspelotasblancasdelacaja

SECOND ELEM-------------
El segundo elemento de la lista List(2, 8, 15, 16, 23, 42) es: 8
El segundo elemento de la lista List(A, B, C, E, D, F, G) es: B
El segundo elemento de la lista List(1) es: null

SOLO PRIMERO-------------
El primer elemento de la lista List(2, 8, 15, 16, 23, 42) es: 2
El primer elemento de la lista List(A, B, C, E, D, F, G) es: A

SUMA-----------
La suma 4+5 es igual a 9
La suma 10+3 es igual a 13

SUMA3-----------
La suma 4+5+6 es igual a 15
La suma 10+3+9 es igual a 22

SUMA LISTA----------------
La suma total de la lista List(2, 8, 15, 16, 23, 42) es: 106

TRADUCE----------------
El valor 1 se traduce en: A
El valor 3 se traduce en: C
El valor 5 se traduce en: X
```
## Conclusiones
Scala es un lenguaje de programación orientado a objetos pero que tambien cuenta con la posibilidad de programar de forma declarativa. Permite ejecutar código Java y es muy sencillo de programar.

## Bibliografía
 * [Playlist con tutoriales de scala en youtube](https://youtube.com/playlist?list=PLTd5ehIj0goOlRPRfwGGu9Bc2ap4bt7wR)
 * [Scala tutorial for java programmers](https://docs.scala-lang.org/tutorials/scala-for-java-programmers.html)
 * [Scala List class](https://alvinalexander.com/scala/list-class-methods-examples-syntax/)
 * [Implicit parameters](https://www.baeldung.com/scala/implicit-parameters)
 * [Implicit parameters youtube](https://youtu.be/yQXx2hrDxVE)
