class Estacionamiento
{
    /*Declaro un companion object ya que tengo una constante PRECIO_HORA*/
    companion object{
        const val PRECIO_HORA_MANIANA = 150
        const val PRECIO_HORA_TARDE = 250
        const val PRECIO_HORA_NOCHE = 300
    }
    /*Total vehiculos es mi SET de vehiculos que representa una lista de los vehiculos que forman parte del estacionamiento*/
    val totalVehiculos: MutableSet<Vehiculo> = mutableSetOf()
    fun buscarVehiculoPorPatente (patente: String): Vehiculo?
    {
        /*Si encuentra un vehiculo con esa patente lo devuelve, caso contrario, devuelve null.*/
        return totalVehiculos.find {it.patente == patente}
    }
    fun estacionarVehiculoEnEstacionamiento (vehiculo: Vehiculo): Unit
    {
        totalVehiculos.add(vehiculo);
        println("El vehiculo de patente: " + vehiculo.patente + "se ha estacionado correctamente");
    }
    fun removerVehiculoEstacionamiento (patente: String): Unit
    {
        var vehiculo: Vehiculo? = buscarVehiculoPorPatente(patente);

        if(vehiculo == null)
        {
            print("No se puede remover al vehiculo del estacionamiento ya que no se encuentre estacionado. ");
        }
        else
        {
            totalVehiculos.remove(vehiculo);
            println("El vehiculo de patente: " + patente + "se ha removido del estacionamiento correctamente");
        }
    }
    fun mostrarVehiculosEstacionados (): Unit
    {
        totalVehiculos.forEach{ it ->
           mostrarUnSoloVehiculo(it);
        }
    }
    fun mostrarUnSoloVehiculo (vehiculo: Vehiculo): Unit
    {
        println("Marca del vehiculo: " + vehiculo.marca);
        println("Color del vehiculo: " + vehiculo.color);
        println("Modelo del vehiculo: " + vehiculo.modelo);
        println("Patente del vehiculo: " + vehiculo.patente);
    }
    fun contarVehiculosEstacionados (): Int
    {
        return totalVehiculos.size;
    }
    fun costoTotalEstacionamiento(horas: Int,horario: String): Int
    {
        var total: Int = 0;

        if(horario.equals("MANIANA"))
        {
            total = horas *  PRECIO_HORA_MANIANA;
        }
        else if(horario.equals("TARDE"))
        {
            total = horas * PRECIO_HORA_TARDE;
        }
        else if(horario.equals("NOCHE"))
        {
            total = horas * PRECIO_HORA_NOCHE;
        }
        return total;
    }
    //Funcion para validar la patente para que el programa sea mas realista
    fun validarPatente(patente: String): Boolean
    {
        val regex = Regex("^[A-Z]{3}\\s\\d{3}$")  // Agregamos \\s para representar un espacio
        return regex.matches(patente)
    }

}
