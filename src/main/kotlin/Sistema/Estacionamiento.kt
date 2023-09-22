package Sistema

import Interfaces.CostoEstacionamiento

class Estacionamiento : CostoEstacionamiento
{
    /**
     Total vehiculos es mi SET de vehiculos que representa una lista de los vehiculos que forman parte del estacionamiento
     */
    val totalVehiculos: MutableSet<Vehiculo> = mutableSetOf()

    fun buscarVehiculoPorPatente (patente: String): Vehiculo?
    {
        /**Si encuentra un vehiculo con esa patente lo devuelve, caso contrario, devuelve null.
         Responsabilidad de clase estacionamiento ya que debo buscar en mi lista de vehiculos. (Atributo de clase Sistema.Estacionamiento)
         */
        return totalVehiculos.find {it.patente == patente}
    }
    fun estacionarVehiculoEnEstacionamiento (vehiculo: Vehiculo): Unit
    {
        totalVehiculos.add(vehiculo);
        /**
         Responsabilidad de clase estacionamiento ya que debo agregar el vehiculo a la lista de vehiculos. (Atributo de clase Sistema.Estacionamiento)
         */
        println("El vehiculo de patente: " + vehiculo.patente + "se ha estacionado correctamente");
    }
    fun removerVehiculoEstacionamiento (patente: String): Unit
    {
        var vehiculo: Vehiculo? = buscarVehiculoPorPatente(patente);
        /**
        Responsabilidad de clase estacionamiento ya que debo eliminar el vehiculo de la lista de vehiculos. (Atributo de clase Sistema.Estacionamiento)
         */
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
        /**
        Responsabilidad de clase estacionamiento ya que debo mostrar la lista de vehiculos. (Atributo de clase Sistema.Estacionamiento)
         */
        totalVehiculos.forEach{ it ->
           mostrarUnSoloVehiculo(it);
        }
    }
    fun mostrarUnSoloVehiculo (vehiculo: Vehiculo): Unit
    {  /**
        Funcion auxiliar
        Si hago esta funcion en la clase vehiculo, no tengo como llamarla en la funcion mostrarVehiculosEstacionados
        */
        println("Marca del vehiculo: " + vehiculo.marca);
        println("Color del vehiculo: " + vehiculo.color);
        println("Modelo del vehiculo: " + vehiculo.modelo);
        println("Patente del vehiculo: " + vehiculo.patente);
        println("Hora de entrada del vehiculo: " + vehiculo.horaEntrada);
        println("Hora de salida del vehiculo: " + vehiculo.horaSalida);
        println("Tipo de Sistema.Vehiculo: " + vehiculo.tipoVehiculo);
        println("Tipo de horario: " + vehiculo.tipoHorario);
    }
    fun contarVehiculosEstacionados (): Int
    {
        /**
        Responsabilidad de clase estacionamiento ya que debo contar la cantidad de vehiculos que hay en lista de vehiculos. (Atributo de clase Sistema.Estacionamiento)
         */
        return totalVehiculos.size;
    }
    fun calcularHorasEstacionado(vehiculo: Vehiculo): Int
    {
        return vehiculo.horaSalida - vehiculo.horaEntrada;
    }
    override fun calcularCosto(vehiculo: Vehiculo): Int
    {
        /**
         Interfaz implementada para calcular el costo del vehiculo
         */
        val precioBasePorHora = vehiculo.tipoHorario.precioPorHora;
        val adicionalPorVehiculo = vehiculo.tipoVehiculo.adicional;

        val total = calcularHorasEstacionado(vehiculo) * precioBasePorHora + adicionalPorVehiculo;

        return total;
    }
    fun cerrarCaja () : Int
    {
        var total = 0;

        this.totalVehiculos.forEach{ vehiculo ->  
            total = total + calcularCosto(vehiculo);
        }

        return total;
    }
}
