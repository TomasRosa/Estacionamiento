import kotlin.system.exitProcess

fun main ()
{
    //Inicializo en la variable inmutable estacionamiento la base de datos del estacionamiento. (Autos precargados del estacionamiento)
    val estacionamiento = inicializarBaseDeDatosEstacionamiento();
    ///Menu interactivo para utilizar el programa.
    do
    {
        println("Ingrese (1). Si desea estacionar un vehiculo ingresando sus detalles. ");
        println("Ingrese (2). Si desea quitar un vehiculo ingresando su patente. ");
        println("Ingrese (3). Si desea ver la lista de vehiculos estacionados. ");
        println("Ingrese (4). Si desea buscar un vehiculo por patente e imprimir sus detalles. ");
        println("Ingrese (5). Si desea saber el costo total del estacionamiento.  ");
        println("Ingrese (6). Si desea saber la cantidad total de autos en el estacionamiento.  ");

        val entrada = readLine();

        val scan: Int? = entrada?.toInt();
        if(scan != null)
        {
            when(scan)
            {
                1 ->
                {
                    var patente= "";
                    println("Ingrese el modelo del vehiculo a estacionar. ");
                    val modelo = readLine()?:""
                    println("Ingrese el color del vehiculo a estacionar. ");
                    val color = readLine()?:""
                    println("Ingrese la marca del vehiculo a estacionar. ");
                    val marca = readLine()?:""
                    do
                    {
                        println("Ingrese la patente del vehiculo a estacionar. FORMATO: (NªNªNª AAA)");
                        val inputPatente = readLine()?:""
                        if(!estacionamiento.validarPatente(inputPatente))
                        {
                            print("Ingrese una patente valida");
                        }
                        else
                        {
                            patente = inputPatente;
                        }
                    }while (!estacionamiento.validarPatente(patente))

                    val vehiculo = Vehiculo(marca,modelo,patente,color);
                    estacionamiento.estacionarVehiculoEnEstacionamiento(vehiculo);
                }
                2 ->
                {
                    var patente= "";
                    do
                    {
                        println("Ingrese la patente del vehiculo que desee eliminar del estacionamiento. FORMATO: (AAA NªNªNª).");
                        val inputPatente = readLine()?:""
                        if(!estacionamiento.validarPatente(inputPatente))
                        {
                            println("Ingrese una patente valida");
                        }
                        else
                        {
                            patente = inputPatente;
                            estacionamiento.removerVehiculoEstacionamiento(patente);
                        }
                    }while (!estacionamiento.validarPatente(patente))
                }
                3 ->
                {
                    print("Vehiculos estacionados en el estacionamiento: ");
                    estacionamiento.mostrarVehiculosEstacionados();
                }
                4 ->
                {
                    var patente= "";
                    do
                    {
                        println("Ingrese la patente del vehiculo que desee ver sus detalles. FORMATO: (NªNªNª AAA)");
                        val inputPatente = readLine()?:""
                        if(!estacionamiento.validarPatente(inputPatente))
                        {
                            println("Ingrese una patente valida");
                        }
                        else
                        {
                            patente = inputPatente;
                            val vehiculo: Vehiculo? = estacionamiento.buscarVehiculoPorPatente(patente);
                            if(vehiculo == null)
                            {
                                println("El vehiculo no se encuentra en nuestro estacionamiento. ");
                            }
                            else
                            {
                                estacionamiento.mostrarUnSoloVehiculo(vehiculo);
                            }
                        }
                    }while (!estacionamiento.validarPatente(patente))
                }
                5 ->
                {
                    println("Ingrese el horario en el que usted va a estacionar su auto. (MANIANA-TARDE-NOCHE)");
                    val scan = readLine();
                    scan

                    println("Ingrese la cantidad de horas que va a estacionar su auto. ");
                    val inputHoras = readLine()
                    val horas: Int = inputHoras?.toIntOrNull() ?: 0

                    val totalCosto: Int = estacionamiento.costoTotalEstacionamiento(horas,scan ?: "");

                    println("El costo total de el estacionamiento es de: " + totalCosto);
                }
                6 ->
                {
                    val total = estacionamiento.contarVehiculosEstacionados();
                    println("la cantidad de autos estacionados es de: " + total);
                }
            }
        }
        else
        {
            println("No ha escogido una opcion valida. ");
            exitProcess(1);
        }
        println("Desea seguir realizando operaciones de estacionamiento? s/n");
        val continuar = readLine()
    }while (continuar == "s");

}
fun inicializarBaseDeDatosEstacionamiento (): Estacionamiento
{
    val estacionamiento = Estacionamiento();
    /*Inicializacion de vehiculos*/
    val v1 = Vehiculo("Toyota","Bridgestone","ASD 777", "Rojo");
    val v2 = Vehiculo("Renault","Stupper","GFB 127", "Verde");
    val v3 = Vehiculo("Fiat","Uno","BHJ 374", "Gris");
    val v4 = Vehiculo("Audi","XRASD","PNR 427", "Violeta");
    val v5 = Vehiculo("Mercedes","Benz","LDM 707", "Marron");
    /*Creo la lista de vehiculos*/
    val arrayVehiculos = listOf<Vehiculo>(v1,v2,v3,v4,v5);
    /*Agrego la lista de vehiculos al estacionamiento*/
    estacionamiento.totalVehiculos.addAll(arrayVehiculos);

    return estacionamiento;
}