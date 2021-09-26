import scala.math.BigDecimal.double2bigDecimal

object Aplicacion {

    /*aprox_pi_manuel_jesus.hs*/
    /*En este ejercicio buscamos la aproximación de pi más cercana al valor pasado por parámetro t*/
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

    /*divisible.hs*/
    /*Comprobamos si a es divisible entre b*/
    def divisible(a :Int, b :Int): Boolean = {
        if(a%b == 0){
            true
        }else{
            false
        }

    }

    /*divisores_ricardo.hs - Devolvemos los numeros divisores de n*/
    /*Devuelve todos los divisores del valor pasado por parámetro n*/
    def divisores(n :Int): List[Int] = {
        for(i <- List.range(1,n+1) if n%i == 0)
           yield i
        
    }

    /*euler1.hs*/
    /*Devolvemos la suma de una lista de números, los cuales sean divisores de 3 o 5*/
    def euler1(l :List[Int]): Int = {
        sumaLista(euler1Sel(l))
    }

    def euler1Sel(l :List[Int]): List[Int] = {
        for(i <- l if ((i%3 == 0) || (i%5 == 0))) yield i
    }

    /*euler2.hs y euler2_ricardo.hs*/
    /*Calculamos la sucesión de Fibonacci para el valor n*/
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

    /*euler3.hs*/
    /*Calcula los primos existentes entre 1 y n*/
    def listaPrimos(n :Int): List[Int] = {
        for(i <- List.range(1,n+1) if primo(i))
            yield i
    }

    /*euler3_ricardo.hs*/
    /*Comprobamos si un numero es primo*/
    def primo(n :Int): Boolean = {
        if(divisores(n).size == 2)
            true
        else 
            false
    }

    /*euler4.hs*/
    /*Este fichero esta compuesto de varias funciones. La función _maximo_ que devuelve el valor más grande de una lista de enteros.
    La función _palindromo_ que comprueba si una cadena es palíndroma y por último, _listaPalindromos_ que devuelve todas las palabras
    de una lista que sean palíndromas*/
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

    /*factorial.hs y factorialAliasPatron.hs*/
    /*Calcula el factorial de un número n*/
    def factorial(n :Int): Int = {
        if(n > 0)
            n*factorial(n-1)
        else 
            1
    
    }

    /*firstElement.hs*/
    /*Devuelve el primer elemento de una lista*/
    def fistElement(l :List[Int]): Any = {
        if(l.nonEmpty)
            l.head
        else
            null
    }

    /*funcionLet.hs*/
    /*Devuelve todos los elementos de una lista exceptuando los 2 primeros*/
    def funcionLet(l :List[Any]): Any = {
        if(l.size >= 3)
            l.drop(2)
        else
            null
    }

    /*funcionLet2.hs*/
    /*Devuelve el segundo elemento de una lista*/
    def funcionLet2(l :List[Any]): Any = {
        if(l.size == 3)
            l(2)
        else
            null
    }
    /*funcionLista.hs*/
    /*Devuelve los elementos de una lista en forma de cadena. En función del número de elementos que tenga la lista*/
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

    /*funcionTupla*/
    /*En este ejercicio hacemos uso de las funciones pasadas por parámetros. Para el ejercicio en cuestión, cada una de
    las funciones calculará un valor respecto de _n_. Después, dicha suma será el valor de retorno de la función*/
    def funcionTupla(funcionA :Int => Int, funcionB :Int => Int, n :Int): Int = {
        funcionA(n) + funcionB(n)
    }

    /*funcionTuplaBool.hs*/
    /*Al igual que en el ejercicios anterior, ahora tenemos dos funciones pasadas por parámetro. En esta ocasión, cada una recibira un objeto de tipo Any (que en este caso será a) y devolverá un boolean. Si una de las dos funciones devuelve true la función devolvera dicho valor, en caso contrario devolverá false*/
    def funcionTuplaBool(funcionA :Int => Boolean, funcionB :Int => Boolean, a :Int): Boolean = {
        (funcionA(a) || funcionB(a))
    }

    /*funcion_hash_ricardo.hs*/
    /*Para este ejercicio será necesario realizar dos funciones:
       * funcionHash - Devuelve la suma de valores producto de multiplicar cada valor de la lista l correspondiente con su posición en la lista de primos
       * calculaPrimos - Calcula los números primos existentes entre 0 y n*/
    def funcionHash(l :List[Int]): Int = {
        if(l.size > 0){
            var sum = 0
            val listaPrimos = calculaPrimos(l.size)
            val numberRange = List.range(0, listaPrimos.size)
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


    /*integral.hs y integral_manuel_jesus.hs*/
    /*Con estas funcion podremos calcular el valor de una integral*/
    def integral(funcion :Double => Double, a :Double, b :Double, t :Double): Double = {
        if(b <= a)
            0 
        else if(b < (a+t))
            funcion(a) + (b-a)
        else
            funcion(a) * t + integral(funcion, (a+t), b, t)
    }

    /*lambda.hs*/
    /*En esta función haremos uso de los valores implicitos. De esta forma, el complidor de scala se encargará de buscar el valor que falte de la suma que calculamos en la función*/
    def funcionLambda[A](a :A, b :A)(implicit r: Numeric[A]): A = {
        import r._
        a+b
    }

    /*mapea_y_filtra_ricardo_diaz.hs y solucion_pregunta_map.hs*/
    /*Con la función mapea ejecutaremos una funcion sobre cada valor de una lista y devolveremos una lista con dichos resultados*/
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

    /*miFuncion.hs, muFuncion2.hs y miFuncion2Nicolas.hs*/
    /*Esta función recibirá dos listas de numeros. En la primera tendremos una lista de números, cada valor de esta lista será sumado
    a cada uno de los elementos de la segunda. Finalmente, devolveremos todas las listas generadas. Para hacerlo de una forma sencilla
    usaremos la función _map_ de la clase _List_, que nos permite crear una nueva lista en función de una ya existente especificandole cambios*/
    def miFuncion(sumL :List[Int], numL :List[Int]): List[List[Int]] = {
        if(sumL.size == numL.size){
            for(i <- sumL)
                yield numL.map { j => j + i}
        }else
            List(List())
    }

    /*miXor.hs*/
    /*Implementa una puerta Xor en scala*/
    def miXor(a :Boolean, b :Boolean): Boolean = {
        if(a == b)
            false
        else
            true
    }

    /*predecesor.hs*/
    /*Devuelve el número anterior al valor n pasado por parámetro*/
    def predecesor(n :Int): Int = {
        n - 1
    }

    /*prog1.hs*/
    /*Devuelve true si el numero es positivo y false en caso contrario*/
    def noNegativo(n :Int): Boolean = {
        if(n >= 0)
            true
        else
            false
    }

    /*programaTuplas.hs*/
    /*Devuelve todas las listas que contienen el objeto a*/
    def programaTuplas(l :List[List[Any]], a :Any): List[Any] = {
        for(i <- l if l.contains(a))
            yield i
    }

    /*quitaBlanco.hs y quitaBlando2.hs*/
    /*Elimina todos los espacios presentes en una variable de tipo String*/
    def quitaBlanco(s :String ): String = {
        for(i <- s if i != ' ')
            yield i
    }

    /*secondElem.hs*/
    /*Devuelve el segundo elemento de una lista*/
    def secondElem(l :List[Any]): Any = {
        if(l.size > 1)
            l.apply(1)
        else
            null
    }

    /*soloPrimero.hs*/
    /*La función devuelve el primer elemento de una lista*/
    def soloPrimero(l :List[Any]): Any = {
        l.head
    }

    /*suma.hs*/
    /*Realiza y devuelve la suma de dos números pasados por parámetro*/
    def suma(a :Int, b :Int): Int = {
        a+b
    }

    /*suma3.hs*/
    /*Realiza y devuelve la suma de tres números pasados por parámetro*/
    def suma3(a :Int, b :Int, c :Int): Int = {
        a+b+c
    }

    /*suma_lista.hs*/
    /*Suma todo los elementos de una lista de números*/
    def sumaLista(l :List[Int]): Int = {
        l.sum
    }

    /*traduce.hs*/
    /*Convierte un número en un carácter. Para ello usaremos la función match, que es el equivalente a la función switch
    en otros lenguajes de programación*/
    def traduce(n :Int): String = {
        n match {
            case 1 => "A"
            case 2 => "B"
            case 3 => "C"
            case _ => "X"
        }
    }

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
        println()
        
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
}
