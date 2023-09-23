import Enum.TipoHorario
import Enum.TipoVehiculo
import Sistema.Estacionamiento
import Sistema.Vehiculo
import Validaciones.Validacion
import Vehiculos.Auto
import Vehiculos.Camioneta
import Vehiculos.Moto
import kotlin.system.exitProcess

fun main ()
{
    /**
    Inicializo en la variable inmutable estacionamiento la base de datos del estacionamiento. (Autos precargados del estacionamiento)
    Lo hago mediante el uso de Lazy asi se realiza una sola vez y no gasta memoria.
     */
    val estacionamiento by lazy {inicializarBaseDeDatosEstacionamiento()} ;
    val capacidadEstacionamiento = 20;
    val validacion = Validacion()
    /**
       Menu interactivo para utilizar el programa.
     */
    do
    {
        println("Ingrese (1). Si desea estacionar un vehiculo ingresando sus detalles. ");
        println("Ingrese (2). Si desea quitar un vehiculo ingresando su patente. ");
        println("Ingrese (3). Si desea ver la lista de vehiculos estacionados. ");
        println("Ingrese (4). Si desea buscar un vehiculo por patente e imprimir sus detalles. ");
        println("Ingrese (5). Si desea saber el costo total de un determinado vehiculo.  ");
        println("Cuidado, si ingresa esta opcion, el vehiculo sera retirado del estacionamiento. ");
        println("Ingrese (6). Si desea saber la cantidad total de autos en el estacionamiento.  ");
        println("Ingrese (7). Si desea cerrar la caja. Se le informara la recaudacion. ");
        println("TENGA EN CUENTA QUE SI USTED CIERRA LA CAJA SE LE CERRARA EL PROGRAMA. SEÑALA FIN DEL DIA");

        val entrada: String?= readLine();

        if(validacion.esOpcionValida(entrada))
        {
            val opcion = entrada!!.toInt()

            when(opcion)
            {
                1 ->
                {
                    if(estacionamiento.contarVehiculosEstacionados() < capacidadEstacionamiento)
                    {
                        var patente= "";

                        println("Ingrese su tipo de vehiculo AUTO-MOTO-CAMIONETA")
                        val tipoVehiculoInput = readLine() ?: ""

                        val tipoVehiculo = when (tipoVehiculoInput.toUpperCase())
                        {
                            "AUTO" -> TipoVehiculo.AUTO
                            "MOTO" -> TipoVehiculo.MOTO
                            "CAMIONETA" -> TipoVehiculo.CAMIONETA
                            else ->
                            {
                                // En caso de que el tipo de vehículo ingresado no sea válido
                                println("Tipo de vehículo inválido. Se asumirá AUTO.")
                                TipoVehiculo.AUTO
                            }
                        }
                        println("Ingrese el horario. MANIANA-TARDE-NOCHE")
                        val tipoHorarioInput = readLine()?:""
                        val tipoHorario = when (tipoHorarioInput.toUpperCase())
                        {
                            "MANIANA" -> TipoHorario.MANIANA
                            "TARDE" -> TipoHorario.TARDE
                            "NOCHE" -> TipoHorario.NOCHE
                            else ->
                            {
                                print("Tipode horario invalido. Se asumirá MANIANA.")
                                TipoHorario.MANIANA
                            }
                        }
                        println("Ingrese el modelo del vehiculo a estacionar. ");
                        val modelo = readLine()?:""
                        println("Ingrese el color del vehiculo a estacionar. ");
                        val color = readLine()?:""
                        println("Ingrese la marca del vehiculo a estacionar. ");
                        val marca = readLine()?:""
                        do
                        {
                            println("Ingrese la patente del vehiculo a estacionar. FORMATO: (AAA N°N°N°)");
                            val inputPatente = readLine()?:""
                            if(!validacion.validarPatente(inputPatente))
                            {
                                println("Ingrese una patente valida");
                            }
                            else
                            {
                                patente = inputPatente;
                            }
                        }while (!validacion.validarPatente(inputPatente))

                        println("Ingrese la hora de entrada del vehiculo a estacionar. ");
                        val inputHoraEntrada = readLine()?.toInt() ?: 0
                        println("Ingrese la hora de salida del vehiculo a estacionar. ");
                        val inputHoraSalida = readLine()?.toInt() ?: 0

                        val vehiculo = Vehiculo(marca,modelo,patente,color,inputHoraEntrada,inputHoraSalida,tipoVehiculo,tipoHorario);
                        estacionamiento.estacionarVehiculoEnEstacionamiento(vehiculo);
                    }
                    else
                    {
                        println("No podemos estacionar su vehiculo debido a que no hay mas espacio en el estacionamiento :(");
                    }
                }
                2 ->
                {
                    var patente= "";
                    do
                    {
                        println("Ingrese la patente del vehiculo que desee eliminar del estacionamiento. FORMATO: (AAA NªNªNª).");
                        val inputPatente = readLine()?:""
                        if(!validacion.validarPatente(inputPatente))
                        {
                            println("Ingrese una patente valida");
                        }
                        else
                        {
                            patente = inputPatente;
                            estacionamiento.removerVehiculoEstacionamiento(patente);
                        }
                    }while (!validacion.validarPatente(patente))
                }
                3 ->
                {
                    println("Vehiculos estacionados en el estacionamiento: ");
                    estacionamiento.mostrarVehiculosEstacionados();
                }
                4 ->
                {
                    var patente= "";
                    do
                    {
                        println("Ingrese la patente del vehiculo que desee ver sus detalles. FORMATO: (NªNªNª AAA)");
                        val inputPatente = readLine()?:""
                        if(!validacion.validarPatente(inputPatente))
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
                    }while (!validacion.validarPatente(patente))
                }
                5 ->
                {
                    var patente= "";
                    do
                    {
                        println("Ingrese la patente del vehiculo que desee ver su costo total. FORMATO: (NªNªNª AAA)");
                        val inputPatente = readLine()?:""
                        if(!validacion.validarPatente(inputPatente))
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
                                val totalCosto: Int = estacionamiento.calcularCosto(vehiculo);
                                println("El costo total de el estacionamiento es de: " + totalCosto);
                                estacionamiento.removerVehiculoEstacionamiento(patente)
                            }
                        }
                    }while (!validacion.validarPatente(patente))
                }
                6 ->
                {
                    val total = estacionamiento.contarVehiculosEstacionados();
                    println("La cantidad de autos estacionados es de: " + total);
                }
                7 ->
                {
                    /**
                     Func de cerrar caja by lazy para que se haga una vez sola. Mas eficiencia.
                     */
                    val costoTotalCaja by lazy {estacionamiento.cerrarCaja()};
                    println("El cierra de caja es de: $" + costoTotalCaja);
                    exitProcess(1);
                    /**
                     Agrego que cuando se cierre la caja tambien se cierre el programa, para dar realismo.
                     */
                }
            }
        }
        else
        {
            println("No ha escogido una opcion valida. Intente de nuevo ingresando un n° del 1 al 7.");
        }
        println("Desea seguir realizando operaciones de estacionamiento? s/n");
        val continuar = readLine()
    }while (continuar == "s" || !validacion.esOpcionValida(entrada));

}
/**
 * Inicializa la base de datos del estacionamiento.
 *
 * Esta función crea una instancia de [Estacionamiento] e inicializa varios vehículos para el estacionamiento.
 *
 * @return La instancia inicializada de [Estacionamiento].
 */
fun inicializarBaseDeDatosEstacionamiento(): Estacionamiento {
    val estacionamiento = Estacionamiento()

    // Inicialización de vehículos
    val v1 = Camioneta("Toyota", "Bridgestone", "ASD 777", "Rojo", 6, 12, tipoHorario = TipoHorario.MANIANA)
    val v2 = Auto("Renault", "Stupper", "GFB 127", "Verde", 14, 20, tipoHorario = TipoHorario.TARDE)
    val v3 = Moto("Zanella", "Uno", "BHJ 374", "Gris", 16, 24, tipoHorario = TipoHorario.NOCHE)
    val v4 = Auto("Audi", "XRASD", "PNR 427", "Violeta", 10, 13, tipoHorario = TipoHorario.MANIANA)
    val v5 = Camioneta("4X4", "Benz", "LDM 707", "Marron", 14, 23, tipoHorario = TipoHorario.NOCHE)

    // Crear una lista de vehículos
    val arrayVehiculos = listOf<Vehiculo>(v1, v2, v3, v4, v5)

    // Agregar la lista de vehículos al estacionamiento
    estacionamiento.totalVehiculos.addAll(arrayVehiculos)

    return estacionamiento
}
