package Vehiculos

import Enum.TipoHorario
import Enum.TipoVehiculo
import Sistema.Vehiculo

/**
    Clase hija de Vehiculo, moto.
 */
class Moto(
    marca: String,
    modelo: String,
    patente: String,
    color: String,
    horaEntrada: Int,
    horaSalida: Int,
    tipoVehiculo: TipoVehiculo = TipoVehiculo.MOTO,
    tipoHorario: TipoHorario // Asigna el tipo de vehículo correspondiente
) : Vehiculo(marca, modelo, patente, color, horaEntrada, horaSalida, tipoVehiculo,tipoHorario)

