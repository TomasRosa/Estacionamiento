package Sistema

import Enum.TipoHorario
import Enum.TipoVehiculo

/**
 Clase padre vehiculo de la cual heredan moto, camioneta y auto. Yo al inicializar el estacionamiento no creo un Vehiculo, si no ya un respectivo , auto mato o camioneta.
 */
open class Vehiculo(
    val marca: String,
    val modelo: String,
    val patente: String,
    val color: String,
    val horaEntrada: Int,
    val horaSalida: Int,
    val tipoVehiculo: TipoVehiculo, //
    val tipoHorario: TipoHorario //
)

