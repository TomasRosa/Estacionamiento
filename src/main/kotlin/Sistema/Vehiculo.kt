package Sistema

import Enum.TipoHorario
import Enum.TipoVehiculo

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

