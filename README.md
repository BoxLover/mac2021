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
        val listaA = (-1 + t / 2 to 1 - t / 2 by t).toList
        val listaB = (-1 + t / 2 to 1 - t / 2 by t).toList
        var n = 0.0
        for(i <- listaA){
            for(j <- listaB){
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
Devolvemos la suma de una lista
```scala
def euler1(l :List[Int]): Int = {
    sumaLista(l)
}
```
### Euler2.hs y eurler2_ricardo.hs
Calculamos la sucesión de Fibonacci para el valor 
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
### 
```scala

```
